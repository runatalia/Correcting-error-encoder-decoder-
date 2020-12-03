package correcter;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;



public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("send.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("received.txt"));
             ){
            ArrayList<Byte> input = new ArrayList();
            try{byte data;
                while ((data = (byte) bis.read()) != -1) {  //если символы в буфере  есть,то переносим символы из буфера в лист байтов
                    input.add(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList <Byte> inputError = new ArrayList<>(input);
                Random random = new Random();
                for (int i = 0; i < inputError.size() ; i ++) {
                    int symbolEncrept = random.nextInt(8); //рендомный выбор одного из 8ми битов
                    byte a = inputError.get(i);
                    a ^= 1 << symbolEncrept;
                    inputError.set(i, a);
                }
//            for (int i = 0; i < input.size(); i++) {
//                System.out.print(input.get(i)+" ");
//            }
//System.out.println();
//                    for (int i = 0; i < inputError.size(); i++) {
//                        System.out.print(inputError.get(i)+" ");
//                    }
                    byte[] a = new byte[inputError.size()];
                    for(int i = 0;i<inputError.size();i++){
                        a[i] = inputError.get(i);
                    }
            bos.write(a, 0, a.length);

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

                 }catch (IOException e){
            System.out.println("file not found or it is empty");
        }
    }
}