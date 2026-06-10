import java.util.ArrayList;
import java.util.Scanner;

public class Session {
    private Deck current_deck;
    private Library library;
    private Scanner scanner;
    public Session(Scanner scanner, Library library)
    {
        this.scanner = scanner;
        this.library = library;
    }
    private ArrayList<Deck> decks = library.getDecks();
    public void showMenu()
    {
        System.out.println("~~~~ Study menu ~~~~");
        System.out.println("1. Practice: Normal challenge");
        System.out.println("2. Practice: Easy challenge");
        System.out.println("3. Add a flashcard");
        System.out.println("0. Save your progress and exit");
    }
    public void showDecks()
    {
        System.out.println("Your practice decks:");
        for(int i = 0; i < decks.size(); i++)
            System.out.println(i + ". " + decks.get(i).getName());
    }
    public void chooseDeck(int index)
    {
        this.current_deck = decks.get(index);
    }
    public void study()
    {
        System.out.println("Choose what you want to practice today.");
        System.out.println("Enter a number from 1 to " + decks.size() + ".");
        chooseDeck(scanner.nextInt());
        System.out.println("We're learning " + current_deck.getName() + "!");

    }
}
