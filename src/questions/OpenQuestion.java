package questions;
import model.Flashcard;

public class OpenQuestion extends Question {
    public OpenQuestion(Flashcard f)
    {
        this.setFlashcard(f);
        this.setPoints(3);
    }
    public void displayQuestion()
    {
        System.out.println(this.getFlashcard().getQuestion() + ":  ");
    }
}
