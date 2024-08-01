import java.util.Scanner;

class EvenUpperCase {

    public static String upperEvenLetters(String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++){
            if (i % 2 == 0){
                sb.append(message.toUpperCase().charAt(i));
            } else{
                sb.append(message.toLowerCase().charAt(i));
            }
        }
        return sb.toString();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        System.out.println(upperEvenLetters(message));
    }
}