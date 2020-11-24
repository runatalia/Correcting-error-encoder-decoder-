package correcter;

import java.util.Random;

public class RandomCount {
    private char[] strArray;
    private int count;

    RandomCount(char[] strArray, int count) {
        this.strArray = strArray;
        this.count = count;
    }

    public char[] random() {
        Random random = new Random();
        for (int i = 0; i < strArray.length - 2; i += 3) {
            count = random.nextInt(3);   //рендомный выбор одного из трех символов
            int countEncrept = random.nextInt(3) + 1; //рендомный выбор одного из вариантов кодирования
            switch (countEncrept) {
                case 1:
                    strArray[i + count] = (char) (random.nextInt(10) + 48); //замена на цифру по юникоду
                    break;
                case 2:
                    strArray[i + count] = (char) (random.nextInt(26) + 65); //замена на строчную букву по юникоду
                    break;
                case 3:
                    strArray[i + count] = (char) (random.nextInt(26) + 97); //замена на прописную букву по юникоду
                    break;
            }
        }
        return this.strArray;
    }
}