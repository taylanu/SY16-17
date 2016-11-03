package ReverseAutoHangman;

import java.util.Scanner;

/**
 * Created by taylanu on 11/3/2016.
 */
public class ReverseAutoHangman {
    static MyStack wordstack = new MyStack();

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Player1: Please enter a word you would like Player 2 to Guess");
        String hangword = input.next();
        boolean wordguessed = false;

        int pointcount = hangword.length();
        int pointscored = 0;
        String builtstring = "";
        for (int j = 0; j < hangword.length(); j++)
            wordstack.push(hangword.charAt(j)); // puts the word chosen into the stack.
        while (!wordguessed) {
            System.out.println("Player2: Please guess the last unknown letter");
            if (input.next() == wordstack.peek()) {
                System.out.println("Correct! +" + pointcount);
                pointscored += wordstack.size();
                pointcount -= 1;
                builtstring.concat((String) wordstack.pop());
                System.out.println(builtstring);
            }
            if (hangword == builtstring) {
                System.out.println("Congrats!");
            }
        }
        //System.out.print("The First Word is " + wordstack.pop() + ".");
    }

}
