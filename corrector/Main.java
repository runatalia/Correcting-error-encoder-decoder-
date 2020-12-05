package correcter;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("send.txt"));
             BufferedOutputStream bosEncode = new BufferedOutputStream(new FileOutputStream("encoded.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("received.txt"));
        ) {
            byte[] arrByte;
            ArrayList<Byte> input = new ArrayList();
            try {
                byte data;
                while ((data = (byte) bis.read()) != -1) {  //если символы в буфере  есть,то переносим символы из буфера в лист байтов
                    input.add(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<Byte> inputEncode = new ArrayList<>();
            for (int j = 0; j < input.size(); j++) {     //перевод в биты и задваивание битов для дальнейшей проверки на ошибки
                for (int i = 0; i < 8; i++) {
                    inputEncode.add((byte) (input.get(j) >> (8 - (i + 1)) & 0x0001));
                    inputEncode.add((byte) (input.get(j) >> (8 - (i + 1)) & 0x0001));
                }
            }

            ArrayList<Byte> parity = new ArrayList<>(inputEncode);  //лист четности для дальнейшей проверки какой из битов неверный


            for (int j = 6, i = 0; j < input.size() * 3 * 8 && i < inputEncode.size() - 6; j += 8, i += 6) {    //добавление двух байтов по исключающей или(XOR) 6ти предыдущих
                parity.add(j, (byte) (inputEncode.get(i) ^ inputEncode.get(i + 2) ^ inputEncode.get(i + 4)));
                parity.add(j + 1, parity.get(j));
            }
            while (parity.size() % 8 != 0) {   //добавляем нули,если получился лист не кратный 8ми, то есть не байт
                parity.add((byte) 0);
            }
            parity.set(parity.size() - 2, (byte) (parity.get(parity.size() - 8) ^ parity.get(parity.size() - 6) ^ parity.get(parity.size() - 4))); //меняем последние 2 нуля на биты четности
            parity.set(parity.size() - 1, (parity.get(parity.size() - 2)));

            arrByte = new byte[parity.size()];
            for (int i = 0; i < parity.size(); i++) {
                arrByte[i] = parity.get(i);
            }
            bos.write(arrByte, 0, arrByte.length);


            for (int i = 0; i < inputEncode.size(); i++) {
                System.out.print(inputEncode.get(i));
            }
            System.out.println();

            for (int i = 0; i < parity.size(); i++) {
                System.out.print(parity.get(i));
            }



            ArrayList<Byte> inputError = new ArrayList<>(input);
            Random random = new Random();
            for (int i = 0; i < inputError.size(); i++) {
                int symbolEncrept = random.nextInt(8); //рендомный выбор одного из 8ми битов
                byte a = inputError.get(i);
                a ^= 1 << symbolEncrept;
                inputError.set(i, a);
            }

//System.out.println();
//                    for (int i = 0; i < inputError.size(); i++) {
//                        System.out.print(inputError.get(i)+" ");
//                    }
            arrByte = new byte[inputError.size()];
            for (int i = 0; i < inputError.size(); i++) {
                arrByte[i] = inputError.get(i);
            }
            bosEncode.write(arrByte, 0, arrByte.length);

//                ArrayList<Byte> inputKoder = new ArrayList<>();
//                for (int i = 0; i < input.length; i++) {  //Кодируем сообщение, утроив все символы,чтобы понять какой из символов ошибочен
//                    int j = 0;
//      //              while (j < 3) {
//                        inputKoder.add(input[i]);
//                        j++;
//      //              }
//                }

//for(int i = 0;i<inputKoder.size();i++){
//    writer.write(inputKoder.get(i));
//}
//        ArrayList<Byte> inputKoder = new ArrayList<>();
//            for (int i = 0; i < input.length; i++) {  //Кодируем сообщение, утроив все символы,чтобы понять какой из символов ошибочен
//                int j = 0;
//                while (j < 3) {
//                    inputKoder.add(input[i]);
//                    j++;
//                }
//            }
//                    inputKoderError = new ArrayList<>(inputKoder);
//                    RandomCount randomCount = new RandomCount(inputKoderError, countError);  //Имитируем отправку этого сообщения через плохое
//                    randomCount.random();                                                                         // интернет-соединение (имитируем ошибки).

//
//                    System.out.println();
//                    for (int i = 0; i < inputKoderError.size(); i++) {
//                        System.out.print(inputKoderError.get(i));
//                    }


//
//            RandomCount randomCount = new RandomCount(inputKoderError, countError);
//            randomCount.random(); //Имитируем отправку этого сообщения через плохое
//            // интернет-соединение (имитируем ошибки). Одна ошибка на каждых три символа
//            StringBuilder output = new StringBuilder();
//            for (int i = 0; i < inputKoder.length(); i += 3) { //проверяем каждые три символа
//                if (inputKoderError.charAt(i) == inputKoderError.charAt(i + 1)) {
//                    output.append(inputKoderError.charAt(i));
//                } //ошибка одна на 3 символа
//                else
//                    output.append(inputKoderError.charAt(i + 2)); //если первых два символа не равны,то третий символбудет верным
//
//            }
//            for (char a : input) {
//                System.out.print(a);
//            }
//            System.out.println();
//            for (int i = 0; i < inputKoder.length(); i++) {
//                System.out.print(inputKoder.charAt(i));
//            }
//            System.out.println();
//            for (int i = 0; i < inputKoderError.length(); i++) {
//                System.out.print(inputKoderError.charAt(i));
//            }
//            System.out.println();
//            for (int i = 0; i < output.length(); i++) {
//                System.out.print(output.charAt(i));
//            }

        } catch (IOException e) {
            System.out.println("file not found or it is empty");
        }
    }
}