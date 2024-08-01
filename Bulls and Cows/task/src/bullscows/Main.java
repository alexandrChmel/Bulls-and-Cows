package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // ---- Generating secret code ---
        int secretL = 0;
        int secretCharL = 0;
        while(true){
            System.out.println("Please, enter the secret code's length:");
                String s = scanner.nextLine();
                if (s.matches("\\d+")){
                    secretL = Integer.parseInt(s);
                    if (secretL == 0){
                        System.out.println("Error: code's length can't be zero");
                        break;
                    }
                } else{
                    System.out.println("Error: " + s + " isn't a valid number.");
                    break;
                }
            System.out.println("Input the number of possible symbols in the code:");
            s = scanner.nextLine();
            if (s.matches("\\d+")){
                secretCharL = Integer.parseInt(s);
                if (secretCharL < secretL){
                    System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n", secretL, secretCharL);
                    break;
                } else if (secretL > 36 || secretCharL > 36 ) {
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    break;
                }
            } else{
                System.out.println("Error: " + s + " isn't a valid number.");
                break;
            }

            String secret = generating(secretL, secretCharL);
            System.out.println("Okay, let's start a game!");
            // ---- Guessing code ----
            boolean stop = false;
            int turn = 1;
            while (!stop){
                System.out.printf("Turn %d:\n", turn);
                if (bullCow(secret)){
                    stop = true;
                }
                turn++;
            }
            break;
        }
    }
    public static String generating(int secretL, int secretCharL){
        Scanner scanner = new Scanner(System.in);

        String secret;
        secret = random(secretL, secretCharL);

        return secret;
    }
    public static String random(int secretL, int secretChars){
        StringBuilder sb = new StringBuilder();
        StringBuilder stars = new StringBuilder();
        Random random = new Random();
        String abcd = "0123456789abcdefghijklmnopqrstuvwxyz";
        // -------------- making secret code ------
        for (int i = 0; i < secretL; i++){
            boolean stop = false;
            while (!stop){
                String temp = String.valueOf(abcd.charAt(random.nextInt(secretChars)));
                if (!String.valueOf(sb).contains(temp)){
                    sb.append(temp);
                    stop = true;
                }
            }
        }

        System.out.println(sb.toString());
        for (int i = 0; i < secretL; i++){
            stars.append("*");
        }

        System.out.printf("The secret is prepared: %s (0-9, a-%s).\n", stars, abcd.charAt(secretChars - 1));
        return sb.toString();
    }
    public static boolean bullCow(String secret){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        int cow = 0;
        int bull = 0;
        boolean[] arr = new boolean[secret.length()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = false;
        }
        for (int i = 0; i < secret.length(); i++){
            if (arr[i] == false){
                if (secret.charAt(i) == input.charAt(i)){
                    bull++;
                    arr[i] = true;
                }
            }
        }

        for (int i = 0; i < secret.length(); i++){
            for (int j = 0; j < 0; j++){
                if (arr[i] == false){
                    if (input.charAt(i) == secret.charAt(j)){
                        bull++;
                        arr[j] = true;
                    }
                }
            }
        }

        if (bull == secret.length()) {
            System.out.printf("Grade: %d bulls\n", bull);
            System.out.println("Congratulations! You guessed the secret code.");
            return true;
        }

        if (cow != 0 && bull != 0){
            System.out.printf("Grade: %d bull(s) and %d cow(s)\n", bull, cow);

        } else if (cow != 0) {
            System.out.printf("Grade: %d cow(s)\n", cow);
        } else if (bull != 0) {
            System.out.printf("Grade: %d bull(s)\n", bull);
        } else{
            System.out.println("Grade: None");
        }
        return false;
    }
}
