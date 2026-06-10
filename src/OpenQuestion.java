public class OpenQuestion extends Question {
    public OpenQuestion(Flashcard f)
    {
        this.flashcard = f;
    }
    public void displayQuestion()
    {
        System.out.println(this.flashcard.getQuestion() + ":  ");
    }
}
