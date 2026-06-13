import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Session {
    private Deck current_deck;
    private Library library;
    private Scanner scanner;
    private Random rand;
    private ArrayList<Deck> decks;
    public Session(Scanner scanner, Library library, Random rand)
    {
        this.scanner = scanner;
        this.library = library;
        this.rand = rand;
        this.decks = library.getDecks();
    }
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
            System.out.println((i+1) + ". " + decks.get(i).getName());
        System.out.println((decks.size() + 1) + ". Add a new deck");
    }
    public void chooseDeck(int index)
    {
        this.current_deck = decks.get(index);
    }
    public void askOpenQuestion()
    {
        Flashcard flashcard = current_deck.randFlashcard();
        Question question = new OpenQuestion(flashcard);
        question.displayQuestion();
        if(question.checkAnswer(scanner))
        {
            System.out.println("Correct!");
            current_deck.updateProgress(question.getPoints());
        }
        else
            System.out.println("Oops! The correct answer is " + flashcard.getAnswer());
    }
    public void askChoiceQuestion()
    {
        Flashcard main_flashcard = current_deck.randFlashcard();
        int order = rand.nextInt(2);
        Question question = new ChoiceQuestion(main_flashcard, current_deck.randOtherFlashcard(main_flashcard), order);
        question.displayQuestion();
        if(question.checkAnswer(scanner))
        {
            System.out.println("Correct!");
            current_deck.updateProgress(question.getPoints());
        }
        else
            System.out.println("Oops! The correct answer is " + main_flashcard.getAnswer());
    }
    public void addFlashcard()
    {
        System.out.println("First, enter the word in your language (front of the card).");
        String question = this.scanner.nextLine();
        System.out.println("Now enter the translation (back of the card).");
        String answer = this.scanner.nextLine();
        int weight;
        System.out.println("How often should this word be asked? (1 - least frequently, 5 - most frequently)");
        do{
            weight = Integer.parseInt(this.scanner.nextLine());
            if(weight < 1 || weight > 5)
                System.out.println("The value is not between 1 and 5. Enter a number again (1-5).");
        }while(weight < 1 || weight > 5);
        current_deck.addFlashcard(new Flashcard(question, answer, weight));
    }
    public int action()
    {
        int action_type = Integer.parseInt(this.scanner.nextLine());
        switch (action_type) {
            case 0:
                FileStorage.saveToFile(library);
                scanner.nextLine();
                break;
            case 1:
                if(current_deck.getDeckSize() < 1)
                {
                    System.out.println("You don't have enough cards. Add a flashcard first.");
                    System.out.println("Press enter to continue.");
                }
                else
                    this.askOpenQuestion();
                scanner.nextLine();
                break;
            case 2:
                if(current_deck.getDeckSize() < 2)
                {
                    System.out.println("You don't have enough cards. Add a flashcard first.");
                    System.out.println("Press enter to continue.");
                }
                else 
                    this.askChoiceQuestion();
                scanner.nextLine();
                break;
            case 3:
                this.addFlashcard();
            default:
                break;
        }
        return action_type;
    }
    public void addNewDeck()
    {
        System.out.println("Name the deck.");
        library.addDeck(this.scanner.nextLine());
        this.decks = library.getDecks();
        System.out.println("Number of decks: " + decks.size());
    }
    public void study()
    {
        System.out.println("Choose what you want to practice today.");
        showDecks();
        System.out.println("Enter a number from 1 to " + (decks.size() + 1) + ".");
        int chosen = Integer.parseInt(this.scanner.nextLine());
        if(chosen == decks.size() + 1)
            this.addNewDeck();
        chooseDeck(chosen - 1);
        System.out.println("We're learning " + current_deck.getName() + "!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        int action_type;
        do{
            this.showMenu();
            action_type = this.action();
        }while (action_type != 0);
        cleanScreen();
        System.out.println("~~~~ Goodbye! ~~~~");
    }
}
