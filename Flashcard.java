public class Flashcard
{
    String question;
    String answer;
    int weight;
    Flashcard(String q, String a, int w)
    {
        this.question = q;
        this.answer = a;
        this.setWeight(w);
    }
    public String toString() 
    {
        return question + " - " + answer + "(" + weight + ")";
    }
    public int getWeight()
    {
        return this.weight;
    }
    public void setWeight(int w)
    {
        if(1 <= w && w <= 5)
            this.weight = w;
        else
        {
            this.weight = 1;
            System.out.println("Weight must be between 1 and 5. Setting weight to 1.");
        }
    }
    public Boolean isCorrent(String users_answer)
    {
        return users_answer == answer;
    }
}