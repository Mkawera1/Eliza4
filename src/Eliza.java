import java.util.Scanner;

public class Eliza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        boolean toQuit = true;
String elizaSays = "";
        System.out.println("Good day. What is your problem? ");

        do{
            System.out.print("Enter your response here or Q to quit: ");
            input = sc.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                toQuit = false;
            }

            elizaSays = input;
            System.out.println(elizaSays);

        } while(toQuit);
    }
}
