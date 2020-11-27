package correcter;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countError = 0;
        StringBuilder inputKoderError;

        char[] input = sc.nextLine().toCharArray(); //Принимаем сообщение, которое хочет отправить пользователь.
        StringBuilder inputKoder = new StringBuilder(new ErrorSearch().errorSearch(input));  //утраиваем символы для проверки ошибок
        inputKoderError = new StringBuilder(inputKoder);  //сообщение с ошибкой
        RandomCount randomCount = new RandomCount(inputKoderError, countError);
        randomCount.random(); //Имитируем отправку этого сообщения через плохое
                                      // интернет-соединение (имитируем ошибки). Одна ошибка на каждых три символа
        StringBuilder output = new StringBuilder(new OutputDekoder().outputDekoder(inputKoder.length(), inputKoderError)); //исправленное сообщение

        for (char a : input) {
            System.out.print(a);
        }
        System.out.println();
        for (int i = 0; i < inputKoder.length(); i++) {
            System.out.print(inputKoder.charAt(i));
        }
        System.out.println();
        for (int i = 0; i < inputKoderError.length(); i++) {
            System.out.print(inputKoderError.charAt(i));
        }
        System.out.println();
        for (int i = 0; i < output.length(); i++) {
            System.out.print(output.charAt(i));
        }

    }
}
