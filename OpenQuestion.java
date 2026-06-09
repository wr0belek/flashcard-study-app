public class OpenQuestion extends Question {
    public OpenQuestion(Flashcard f)
    {
        this.flashcard = f;
    }
    public void display_question()
    {
        System.out.println(this.flashcard.getQuestion() + ":  ");
    }
}
