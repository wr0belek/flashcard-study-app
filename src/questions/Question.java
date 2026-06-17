package questions;
import java.util.Scanner;
import model.Flashcard;

public abstract class Question {
    protected Flashcard flashcard;
    protected int points;
    public abstract void displayQuestion();
    public Flashcard getFlashcard()
    {
        return this.flashcard;
    }
    public void setFlashcard(Flashcard f)
    {
        this.flashcard = f;
    }
    public int getPoints()
    {
        return this.points;
    }
    protected void setPoints(int number)
    {
        this.points = number;
    }
    public boolean checkAnswer(Scanner scanner)
    {
        return this.flashcard.isCorrent(scanner.nextLine());
    }
}
