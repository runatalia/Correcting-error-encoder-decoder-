package correcter;

import java.util.Random;
//тест для программы кодер-декодер с исправлением ошибок
//создает ошибки во входном тексте, 1 случайная ошибка на 3 символа.
// Ошибка означает, что символ заменен другим случайным символом. Например,
// символы «abc» могут быть «* bc», «a * c» или «ab *», где * - случайный символ.
// Используются только прописные и строчные английские буквы и цифры
public class RandomCount {
    private StringBuilder inputKoder;
    private int countError;

    public StringBuilder getInputKoder() {
        return inputKoder;
    }

    public void setInputKoder(StringBuilder inputKoder) {
        this.inputKoder = inputKoder;
    }

    public int getCountError() {
        return countError;
    }

    public void setCountError(int countError) {
        this.countError = countError;
    }

    RandomCount(StringBuilder inputKoder, int countError) {
        this.inputKoder = inputKoder;
        this.countError = countError;
    }

    public StringBuilder random() {
        Random random = new Random();
        for (int i = 0; i < inputKoder.length() - 2; i += 3) {
            countError = random.nextInt(3);   //рендомный выбор одного из трех символов
            int countEncrept = random.nextInt(3) + 1; //рендомный выбор одного из вариантов кодирования
            switch (countEncrept) {
                case 1:
                    inputKoder.setCharAt(i + countError, (char) (random.nextInt(10) + 48)); //замена на цифру по юникоду
                    break;
                case 2:
                    inputKoder.setCharAt(i + countError, (char) (random.nextInt(26) + 65)); //замена на строчную букву по юникоду
                    break;
                case 3:
                    inputKoder.setCharAt(i + countError, (char) (random.nextInt(26) + 97)); //замена на прописную букву по юникоду
                    break;
            }
        }
        return this.inputKoder;
    }
}