package etc;

import java.util.Scanner;
import java.util.Stack;

public class Keylogger_5397 {

    public static void main(String[] args) {
        int testCase;
        String input = new String();
        char current;

        Stack<Character> left = new Stack<Character>();
        Stack<Character> right = new Stack<Character>();
        Scanner scanner = new Scanner(System.in);

        testCase = scanner.nextInt();
        while (testCase > 0) {
            input = scanner.nextLine();

            for (int i = 0; i < input.length(); i++) {
                current = input.charAt(i);

                switch (current) {
                    case '<':
                        right.push(left.pop());
                        break;

                    case '>':
                        left.push(right.pop());
                        break;

                    default:
                        left.push(current);
                        break;
                }

            }
            // for(int i=0; i<left.size();i++){
            //     System.out.print(left[i]);
            // }
            // System.out.println();
            testCase--;
        }

    }
}