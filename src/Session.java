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
    private void cleanScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void showMenu()
    {
        this.cleanScreen();
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
    public void askOpenQuestion()
    {
        // to implement
    }
    public void askChoiceQuestion()
    {
        // to implement
    }
    public void addFlashcard()
    {
        // to implement
    }
    public int action()
    {
        int action_type = scanner.nextInt();
        switch (action_type) {
            case 0:
                FileStorage.saveToFile(library);
                break;
            case 1:
                this.askOpenQuestion();
                break;
            case 2:
                this.askChoiceQuestion();
                break;
            case 3:
                this.addFlashcard();
            default:
                break;
        }
        return action_type;
    }
    public void study()
    {
        System.out.println("Choose what you want to practice today.");
        System.out.println("Enter a number from 1 to " + decks.size() + ".");
        chooseDeck(scanner.nextInt());
        System.out.println("We're learning " + current_deck.getName() + "!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        this.showMenu();
        int action_type;
        do{
            action_type = this.action();
        }while (action_type != 0);
    }
}
