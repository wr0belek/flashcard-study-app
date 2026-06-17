package questions;
import model.Flashcard;

public class ChoiceQuestion extends Question{
    private Flashcard impostor;
    private int order;
    public ChoiceQuestion(Flashcard f, Flashcard i, int o)
    {
        this.setFlashcard(f);
        this.impostor = i;
        setOrder(o);
        setPoints(1);
    }
    public void setOrder(int o)
    {
        if(o == 0 || o == 1)
            this.order = o;
        else 
            this.order = 0;
    }
    public void displayQuestion()
    {
        System.out.println(this.getFlashcard().getQuestion() + ":  ");
        if(order == 1)
        {
            System.out.println("a) " + this.flashcard.getAnswer());
            System.out.println("b) " + this.impostor.getAnswer());
        }
        else
        {
            System.out.println("a) " + this.impostor.getAnswer());
            System.out.println("b) " + this.flashcard.getAnswer());
        }
    }
}