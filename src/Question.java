import java.util.Scanner;
public abstract class Question {
    private Flashcard flashcard;
    private int points;
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
