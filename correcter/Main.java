package correcter;

import java.util.Random;
import java.util.Scanner;

//тест для программы кодер-декодер с исправлением ошибок
//создает ошибки во входном тексте, 1 случайная ошибка на 3 символа.
// Ошибка означает, что символ заменен другим случайным символом. Например,
// символы «abc» могут быть «* bc», «a * c» или «ab *», где * - случайный символ.
// Используются только прописные и строчные английские буквы и цифры
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        char[] strArray = sc.nextLine().toCharArray();
        RandomCount randomCount = new RandomCount(strArray, count);
        strArray = randomCount.random();
        for (char a : strArray) {
            System.out.print(a);
        }

    }
}
