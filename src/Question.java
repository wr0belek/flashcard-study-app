import java.util.Scanner;
public abstract class Question {
    protected Flashcard flashcard;
    public abstract void displayQuestion();
    public boolean checkAnswer(Scanner scanner)
    {
        return flashcard.isCorrent(scanner.nextLine());
    }
}
