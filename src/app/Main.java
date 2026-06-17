import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Welcome to my flashcard study app!");
        Scanner scanner = new Scanner(System.in);
        Library library = FileStorage.readFromFile();
        Random rand = new Random();
        Session study_session = new Session(scanner, library, rand);
        study_session.study();
    }
}
