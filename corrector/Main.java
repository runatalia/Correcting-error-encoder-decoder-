package correcter;

import java.io.*;
import java.util.*;


public class Main {
    static int count = 0; //вспомогательная переменная

    public static void main(String[] args) throws IOException {
        //   File file = new File("send.txt");
        try (
                //         BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                //   OutputStreamWriter bosEncode = new OutputStreamWriter(new FileOutputStream("encoded.txt"), "utf-8");//из-за кодировок и перевода из бит в байт неверный вывод в файл
                //    OutputStreamWriter bosError = new OutputStreamWriter(new FileOutputStream("received.txt"), "utf-8");//из-за кодировок и перевода из бит в байт неверный вывод в файл
                BufferedOutputStream bosDecoded = new BufferedOutputStream(new FileOutputStream("decoded.txt"));
        ) {
            //           List<Byte> input = new ArrayList();
//            byte[] input = new byte[(int) file.length()*8]; // массив входящих данных ввиде битов
//            try {bis.read(input);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                byte data;
//                while ((data = (byte) bis.read()) != -1) {  //если символы в буфере  есть,то переносим символы из буфера в лист байтов
//                    input.add(data);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


            //send.txt:

            //encoded.txt
//            List<Byte> inputEncode = new ArrayList<>();
//            for (int j = 0; j < input.length; j++) {     //перевод в биты и задваивание битов для дальнейшей проверки на ошибки
//                for (int i = 0; i < 8; i++) {
//                    inputEncode.add((byte) (input[j] >> (8 - (i + 1)) & 0x0001));
//                    inputEncode.add((byte) (input[j] >> (8 - (i + 1)) & 0x0001));
//                }
//            }

//            List<Byte> parity = new LinkedList<>(inputEncode);  //лист четности для дальнейшей проверки какой из битов неверный
//            for (int j = 6, i = 0; j < input.length * 3 * 8 && i < inputEncode.size() - 6; j += 8, i += 6) {    //добавление двух байтов по исключающей или(XOR) 6ти предыдущих
//                parity.add(j, (byte) (inputEncode.get(i) ^ inputEncode.get(i + 2) ^ inputEncode.get(i + 4)));
//                parity.add(j + 1, parity.get(j));
//            }
//
//            while (parity.size() % 8 != 0) {   //добавляем нули для кратности 8(полноценные байты)
//                parity.add((byte) 0);
//            }
//            parity.set(parity.size() - 2, (byte) (parity.get(parity.size() - 8) ^ parity.get(parity.size() - 6) ^ parity.get(parity.size() - 4))); //меняем последние 2 нуля на биты четности
//            parity.set(parity.size() - 1, (parity.get(parity.size() - 2)));


            //inputError
//            ArrayList<Byte> inputError = new ArrayList<>(parity);
//            Random random = new Random();
//            for (int i = 0; i < inputError.size(); i += 8) {
//                int symbolEncrept = random.nextInt(8); //рендомный выбор одного из 8ми битов
//                if (inputError.get(i + symbolEncrept) == 1) {
//                    inputError.set(i + symbolEncrept, (byte) 0);
//                } else {
//                    inputError.set(i + symbolEncrept, (byte) 1);
//                }
//            }


//            //decoded.txt
//            ArrayList<Byte> decodedArray = new ArrayList<>(inputError);
//            int index[] = new int[inputError.size() / 4];   //индексы,где ошибки
//            for (int i = 0, j = 0; i < inputError.size(); i += 2) {
//                if (inputError.get(i) != inputError.get(i + 1)) {
//                    index[j] = i;
//                    j++;
//                }
//            }

//            byte mark;
//            for (int i = 0, k = 0; i < inputError.size() && k < index.length; i += 8, k++) {
//                mark = 0;
//                for (int j = 0; j < 8; j += 2) {
//                    if (j + i != index[k]) {
//                        mark ^= inputError.get(i + j);
//                    }
//                }
//                decodedArray.set(index[k], mark);
//                decodedArray.set(index[k] + 1, mark);
//
//            }
//
//
//            List<Byte> decodedArrayRIGHT = new ArrayList<>();
//            for (int i = 0; i < decodedArray.size(); i += 8) {
//                for (int j = 0; j < 6; j += 2) {
//                    decodedArrayRIGHT.add(decodedArray.get(i + j));
//                }
//
//            }
//            for (int i = 0; i < decodedArrayRIGHT.size() - input.length * 8; i++) {   //убираем оставшиеся лишние нули и приводим к исходному размеру
//                decodedArrayRIGHT.remove(decodedArrayRIGHT.size() - 1);
//            }


            Scanner scanner = new Scanner(System.in);
            String mode = scanner.next();
            switch (mode) {
                case "encode":
                    encode();
                    break;
                case "send":
                    send();
                    break;
                case "decode":
                    decode();
                    break;
                default:
                    System.out.print("Error inputting");
            }
//            if (mode.equals("encode")) {
//                encode();}
//                for (int i = 0; i < parity.size(); i++) {
//
//                    bosEncode.write((parity.get(i).byteValue() + ""));
//                }
//            } else if (mode.equals("encode")) {
//                for (int i = 0; i < inputError.size(); i++) {
//                    bosError.write(inputError.get(i) + "");
//                }
//            } else if (mode.equals("decode")) {
//
//                String decodedStringRIGHT = "";
//                for (int i = 0; i < decodedArrayRIGHT.size(); i += 8) {  //перевод 8ки битов в стринг и перевод в int десятичную для записи в файл
//                    decodedStringRIGHT = "";
//                    for (int j = 0; j < 8; j++) {
//                        decodedStringRIGHT += decodedArrayRIGHT.get(i + j);
//                    }
//                    bosDecoded.write((byte) Integer.parseInt(decodedStringRIGHT, 2));}}


        } catch (IOException e) {
            System.out.println("file not found or it is empty");
        }
    }

    public static void encode() {
        File file = new File("send.txt");
        try (InputStream encodeInputStream = new BufferedInputStream(new FileInputStream(file));
             OutputStream encodeOutputStream = new BufferedOutputStream(new FileOutputStream("encoded.txt"));//из-за кодировок и перевода из бит в байт неверный вывод в файл
        ) {
            byte[] input = new byte[(int) file.length()]; // массив входящих данных ввиде битов
            try {
                encodeInputStream.read(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] inputBit = new byte[input.length * 8];

            for (int j = 0; j < input.length; j++) {     //перевод в биты
                for (int i = 0; i < 8; i++) {
                    inputBit[count] = (byte) (input[j] >> (8 - (i + 1)) & 0x0001);
                    count++;
                }
            }
            System.out.println("inputBit: ");
            for (int i = 0; i < inputBit.length; i++) {
                System.out.print(inputBit[i]);
            }
            try {
                encodeOutputStream.write(parity(inputBit));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.out.println("chek file \"send\"");
            System.out.print(e.getStackTrace());
        }
    }

    public static byte[] parity(byte[] inputBit) {
        byte[] parity = new byte[inputBit.length * 2];
        count = 0;
        for (int i = 0; i < inputBit.length; i += 4, count += 8) {
            parity[count + 0] = (byte) (inputBit[0 + i] ^ inputBit[1 + i] ^ inputBit[3 + i]);
            parity[count + 1] = (byte) (inputBit[0 + i] ^ inputBit[2 + i] ^ inputBit[3 + i]);
            parity[count + 2] = inputBit[0 + i];
            parity[count + 3] = (byte) (inputBit[1 + i] ^ inputBit[2 + i] ^ inputBit[3 + i]);
            parity[count + 4] = (inputBit[1 + i]);
            parity[count + 5] = (inputBit[2 + i]);
            parity[count + 6] = inputBit[3 + i];
            parity[count + 7] = 0;
        }

        System.out.println("parity: ");
        for (int i = 0; i < parity.length; i++) {
            System.out.print(parity[i]);
        }
        System.out.println();
        return parity;
    }


    public static void send() {
        File file = new File("encoded.txt");
        try (InputStream sendInputStream = new BufferedInputStream(new FileInputStream(file));
             OutputStream sendOutputStream = new BufferedOutputStream(new FileOutputStream("received.txt"))) {
            byte[] input = new byte[(int) file.length()]; // массив входящих данных ввиде битов
            try {
                sendInputStream.read(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] inputError = input.clone();
            Random random = new Random();
            for (int i = 0; i < input.length; i += 8) {
                int symbolEncrept = random.nextInt(8); //рендомный выбор одного из 8ми битов
                if (inputError[i + symbolEncrept] == 1) {
                    inputError[i + symbolEncrept] = 0;
                } else {
                    inputError[i + symbolEncrept] = 1;
                }
            }
            System.out.println("inputError: ");
            for (int i = 0; i < inputError.length; i++) {
                System.out.print(inputError[i]);
            }
            try {
                sendOutputStream.write(parity(inputError));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.print(e.getStackTrace());
        }
    }

    public static void decode(){
        File file = new File("received.txt");
        try (InputStream receivedInputStream = new BufferedInputStream(new FileInputStream(file));
             OutputStream receivedOutputStream = new BufferedOutputStream(new FileOutputStream("decoded.txt"))
        ) {
            byte[] input = new byte[(int) file.length()]; // массив входящих данных ввиде битов
            try {
                receivedInputStream.read(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] inputСorrect = new byte[input.length];






    } catch (IOException e) {
        System.out.print(e.getStackTrace());
    }

}}