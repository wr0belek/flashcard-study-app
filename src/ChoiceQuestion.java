
public class ChoiceQuestion extends Question{
    private Flashcard impostor;
    private int order;
    public ChoiceQuestion(Flashcard f, Flashcard i, int o)
    {
        this.setFlashcard(f);
        this.impostor = i;
        setOrder(o);
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
            System.out.println("a) " + this.getFlashcard().getAnswer());
            System.out.println("a) " + impostor.getAnswer());
        }
        else
        {
            System.out.println("a) " + impostor.getAnswer());
            System.out.println("a) " + this.getFlashcard().getAnswer());
        }
    }
}