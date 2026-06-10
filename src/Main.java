import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Welcome to my flashcard study app!");
        Scanner scanner = new Scanner(System.in);
        Session study_session = new Session(scanner);
    }
}
