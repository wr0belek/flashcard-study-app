import java.util.Scanner;
public abstract class Question {
    private Flashcard flashcard;
    public abstract void displayQuestion();
    public Flashcard getFlashcard()
    {
        return this.flashcard;
    }
    public void setFlashcard(Flashcard f)
    {
        this.flashcard = f;
    }
    public boolean checkAnswer(Scanner scanner)
    {
        return this.flashcard.isCorrent(scanner.nextLine());
    }
}
