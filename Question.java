import java.util.Scanner;
public abstract class Question {
    Flashcard flashcard;
    public abstract void display_question();
    public boolean check_answer(Scanner scanner)
    {
        return flashcard.isCorrent(scanner.nextLine());
    }
}
