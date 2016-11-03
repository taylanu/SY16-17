package morsecode;

import java.util.HashMap;

public class MorseCode {
    //here are two arrays, one of English characters and one of their corresponding Morse Code equivalents.
    //english[i] is the English equivalent of code[i] for every index i in the arrays
    public static final String[] english = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "�", "�", "�", "Ch", "�", "�", "�", "�",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            ".", ",", ":", "?", "'", "-", "_", "(", "" + (char) (34), "@", "="};    //char 34 is the quote character
    public static final String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".-.-", ".--.-", ".--.-", "----", "..-..", "--.--", "---.", "..--",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            ".-.-.-", "--..--", "---...", "..--..", ".----.", "-....-", "-..-.", "-.--.-", ".-..-.", ".--.-.", "-...-"};
    static HashMap<String, String> engtocode;
    static HashMap<String, String> codetoeng;

    public MorseCode() {
        engtocode = new HashMap<String, String>();
        codetoeng = new HashMap<String, String>();
        for (int i = 0; i < english.length; i++) {
            engtocode.put(english[i], code[i]);
            codetoeng.put(code[i], english[i]);
        }
    }
    //HashMap<String,String> codetoeng = new HashMap<String,String>();


}
      
