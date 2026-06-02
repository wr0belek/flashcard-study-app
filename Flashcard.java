public class Flashcard
{
    String question;
    String answer;
    int weight;
    Flashcard(String q, String a, int w)
    {
        this.question = q;
        this.answer = a;
        this.weight = w;
    }
    public String toString() 
    {
        return question + " - " + answer + "(" + weight + ")";
    }
    public Boolean isCorrent(String users_answer)
    {
        return users_answer == answer;
    }
}