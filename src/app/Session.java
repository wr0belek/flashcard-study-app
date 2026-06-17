package app;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import questions.*;
import model.*;

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
        System.out.println("3. Practice: Random challenge");
        System.out.println("4. Add a flashcard");
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
        current_deck.setRand(rand);
        decks.set(index, current_deck);
    }
    private int numberFromInput()
    {
        try{
            return Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e)
        {
            return -1;
        }
    }
    private void displayResult(Question question, Flashcard flashcard)
    {
        if(question.checkAnswer(scanner))
        {
            System.out.println("Correct!");
            current_deck.updateProgress(question.getPoints());
        }
        else
            System.out.println("Oops! The correct answer is " + flashcard.getAnswer());
    }
    public void askOpenQuestion()
    {
        Flashcard flashcard = current_deck.randFlashcard();
        Question question = new OpenQuestion(flashcard);
        question.displayQuestion();
        this.displayResult(question, flashcard);
    }
    public void askChoiceQuestion()
    {
        Flashcard main_flashcard = current_deck.randFlashcard();
        int order = rand.nextInt(2);
        Question question = new ChoiceQuestion(main_flashcard, current_deck.randOtherFlashcard(main_flashcard), order);
        question.displayQuestion();
        this.displayResult(question, main_flashcard);
    }
    public void askRandomQuestion()
    {
        int r = rand.nextInt(2);
        Flashcard flashcard = current_deck.randFlashcard();
        Question question;
        if(r == 1)
            question = new OpenQuestion(flashcard);
        else 
            question = new ChoiceQuestion(flashcard, current_deck.randOtherFlashcard(flashcard), rand.nextInt(2));
        question.displayQuestion();
        this.displayResult(question, flashcard);
    }
    public void addFlashcard()
    {
        System.out.println("First, enter the word in your native language (front of the card).");
        String question = this.scanner.nextLine();
        System.out.println("Now enter the translation (back of the card).");
        String answer = this.scanner.nextLine();
        int weight;
        System.out.println("How often should this word be asked on a scale of 1 to 5? (1 - least frequently, 5 - most frequently)");
        do{
            weight = numberFromInput();
            if(weight < 1 || weight > 5)
                System.out.println("The value is not between 1 and 5. Enter a number again (1-5).");
        }while(weight < 1 || weight > 5);
        current_deck.addFlashcard(new Flashcard(question, answer, weight));
    }
    public int action(int deck_index)
    {
        int action_type  = numberFromInput();
        switch (action_type) {
            case 0:
                decks.set(deck_index, current_deck);
                library.setDecks(decks);
                FileStorage.saveToFile(library);
                System.out.println("Press enter to exit.");
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
                if(current_deck.getDeckSize() < 2)
                {
                    System.out.println("You don't have enough cards. Add a flashcard first.");
                    System.out.println("Press enter to continue.");
                }
                else 
                    this.askRandomQuestion();
                scanner.nextLine();
                break;
            case 4:
                this.addFlashcard();
                System.out.println("Flashcard added. Press enter to continue.");
                scanner.nextLine();
                break;
            default:
                System.out.println("Incorrect input. Press enter to continue.");
                scanner.nextLine();
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
    public int start()
    {
        int chosen = -1;
        while(chosen == -1)
        {
            System.out.println("Choose what you want to practice today.");
            showDecks();
            System.out.println("Enter a number from 1 to " + (decks.size() + 1) + ".");
            chosen = numberFromInput();
            if(chosen == -1)
            {
                System.out.println("Incorrect input.");
                scanner.nextLine();
            }
            cleanScreen();
        }
        if(chosen == decks.size() + 1)
            this.addNewDeck();
        chooseDeck(chosen - 1);
        return chosen - 1;
    }
    public void study()
    {
        int deck_index = start();
        System.out.println("We're learning " + current_deck.getName() + "!");
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        int action_type;
        do{
            this.showMenu();
            action_type = this.action(deck_index);
        }while (action_type != 0);
        cleanScreen();
        System.out.println("~~~~ Goodbye! ~~~~\n");
    }
}
