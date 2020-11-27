package correcter;

public class ErrorSearch {

    static private StringBuilder inputKoder = new StringBuilder();
    public static StringBuilder getInputKoder() {
        return inputKoder;
    }
    public static void setInputKoder(StringBuilder inputKoder) {
        ErrorSearch.inputKoder = inputKoder;
    }
    public StringBuilder errorSearch(char[] input ){

        for(int i = 0; i < input.length; i++) {  //кодирование сообщение, утроив все символы,чтобы в
                                                 // дальнейшем понять какой из символов после его передачи будет ошибочен
            int j = 0;
            while (j < 3) {
                inputKoder.append(input[i]);
                j++;
            }
        }
    return inputKoder;}
}
