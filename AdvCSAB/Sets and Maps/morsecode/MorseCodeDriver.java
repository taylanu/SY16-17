package morsecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static morsecode.MorseCode.codetoeng;
import static morsecode.MorseCode.engtocode;
//import java.util.Scanner.*;

//import static morsecode.MorseCode.decode;
//import static morsecode.MorseCode.encode;

public class MorseCodeDriver {
    public static void main(String[] arg) throws IOException {
        System.out.println("Welcome to the Morse Box \n You can choose to encode (e) or decode (d) messages....");
        Scanner input = new Scanner(System.in);
        String ans = input.next();
        if (ans.equals("e")) {
            System.out.println("I found a file in English: 'english.txt'. Reading in....");
            encode("english.txt");
            System.out.println("Here is your message decoded");
            System.out.println();
        } else if (ans.equals("d")) {
            System.out.println("I found a file in Morse Code: 'code.txt'. Reading in....");
            decode("code.txt");
            System.out.println("Here is your message decoded");
            System.out.println();
        } else {
            System.out.println("Invalid response, exiting program.");
        }
    }

    public static String[] encode(String filenm) throws IOException {
        //ile file = ;
        Scanner input = new Scanner(new FileReader(new File(filenm)));
        String linein = null;
        input.nextLine();
        String[] encoded = new String[linein.length()];

        while (input.hasNextLine()) {
            linein = input.nextLine();
            encoded = new String[linein.length()];
            //linein.split(" ");
            //encoded = new String[linein.length()];//string array of linein length.
            for (int i = 0; i < linein.length(); i++) {
                encoded[i] = engtocode.get("" + linein.charAt(i));//asks map for the value at the key given by the read in string.
                //encoded.concat(input.read(i));
            }
        }

        //input.read


//        for (int i = 0; i < english; i++) {//hardcoded for time being
//            engtocode.get();//asks map for the value at the key given by the read in string.
//            //encoded.concat(input.read(i));
//        }

        return encoded;
    }

    public static String[] decode(String filenm) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader(new File(filenm)));
        String linein = null;
        String[] decoded = new String[linein.length()];
        while (input.hasNextLine()) {
            linein = input.nextLine();
            decoded = new String[linein.length()];
            //String[] decoded;

            for (int i = 0; i < linein.length(); i++) {
                decoded[i] = codetoeng.get("" + linein.charAt(i));//asks map for the value at the key given by the read in string.
                //encoded.concat(input.read(i));
            }

        }
        return decoded;
    }
}
      
