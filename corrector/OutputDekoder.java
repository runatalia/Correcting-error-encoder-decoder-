package correcter;

public class OutputDekoder {
    private static StringBuilder output = new StringBuilder();
    public static StringBuilder getOutput() {
        return output;
    }

    public static void setOutput(StringBuilder output) {
        OutputDekoder.output = output;
    }

    public StringBuilder outputDekoder(int length, StringBuilder inputKoderError){
        for (int i = 0; i < length; i += 3) { //проверяем каждые три символа
            if(inputKoderError.charAt(i) == inputKoderError.charAt(i+1)){
                output.append(inputKoderError.charAt(i)) ; } //ошибка одна на 3 символа
            else output.append(inputKoderError.charAt(i + 2)); //если первых два символа не равны,то третий символбудет верным

        }
    return output;}

}
