public class OpenQuestion extends Question {
    public OpenQuestion(Flashcard f)
    {
        this.setFlashcard(f);
    }
    public void displayQuestion()
    {
        System.out.println(this.getFlashcard().getQuestion() + ":  ");
    }
}
