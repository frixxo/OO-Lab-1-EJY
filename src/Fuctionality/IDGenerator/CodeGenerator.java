package Fuctionality.IDGenerator;

import java.util.List;
import java.util.Random;

public class CodeGenerator {
    public enum CodeStyle{
        NUMBER, LETTER, MIXED
    }

    private static List<String> codes;
    private static Random random = new Random();
    private CodeStyle codeStyle;

    public CodeGenerator(){ setCodeStyle(CodeStyle.NUMBER); }
    public CodeGenerator(CodeStyle codeStyle){ setCodeStyle(codeStyle); }

    public void setCodeStyle(CodeStyle codeStyle){ this.codeStyle = codeStyle; }

    public String generate(int length){
        String str;
        while (true) {
            switch (codeStyle) {
                case NUMBER:
                    str = generateNumber(length);
                    break;
                case LETTER:
                    str = generateLetter(length);
                    break;
                case MIXED:
                    str = generateMixed(length);
                    break;
                default:
                    str = "";
            }

            if (!checkIfCodeTaken(str)) { break;}
        }

        return str;
    }

    private String generateNumber(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            sb.append(getRandomNumber());
        } return sb.toString();
    }

    private String generateLetter(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            sb.append(getRandomLetter());
        } return sb.toString();
    }

    private String generateMixed(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            sb.append(getRandom());
        } return sb.toString();
    }

    private boolean checkIfCodeTaken(String code){
        for (String s : codes) {
            if (s.equals(code)) {
                return true;
            }
        }
        return false;
    }

    private char getRandom(){ return (random.nextInt(1) == 0) ? getRandomLetter() : getRandomNumber(); }
    private char getRandomLetter(){ return (char)(random.nextInt(26) + 65); }
    private char getRandomNumber(){ return (char)(random.nextInt(10)); }
}
