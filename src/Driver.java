import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TextTwist tt;
        String[] twists;
        String text;
        int count;
        int score;

        System.out.println("Enter the text you want to twist: ");
        text = in.nextLine();

        System.out.println("Enter the number of twists you have: ");
        count = in.nextInt();

        twists = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter twist #" + (i + 1) + ": ");
            twists[i] = in.nextLine();
        }
    }
}
