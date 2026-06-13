public class OpenQuestion extends Question {
    public OpenQuestion(Flashcard f)
    {
        this.setFlashcard(f);
        this.setPoints(2);
    }
    public void displayQuestion()
    {
        System.out.println(this.getFlashcard().getQuestion() + ":  ");
    }
}
