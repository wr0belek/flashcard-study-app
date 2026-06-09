
public class ChoiceQuestion extends Question{
    Flashcard impostor;
    int order;
    public ChoiceQuestion(Flashcard f, Flashcard i, int o)
    {
        this.flashcard = f;
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
    public void display_question()
    {
        System.out.println(this.flashcard.getQuestion() + ":  ");
        if(order == 1)
        {
            System.out.println("a) " + flashcard.getAnswer());
            System.out.println("a) " + impostor.getAnswer());
        }
        else
        {
            System.out.println("a) " + impostor.getAnswer());
            System.out.println("a) " + flashcard.getAnswer());
        }
    }
}