import java.util.Scanner;
public abstract class Question {
    private Flashcard flashcard;
    public abstract void displayQuestion();
    public boolean checkAnswer(Scanner scanner)
    {
        return this.flashcard.isCorrent(scanner.nextLine());
    }
}
