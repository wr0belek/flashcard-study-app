import java.util.ArrayList;
import java.util.Random;

class FlashcardWithPref
{
    Flashcard flashcard;
    int prefix_sum;
    FlashcardWithPref(Flashcard f, int p)
    {
        flashcard = f;
        prefix_sum = p;
    }
}

public class Deck {
    ArrayList <FlashcardWithPref> cards;
    int sum = 0;
    Progress progress;
    Random rand = new Random();
    public void addFlashcard(Flashcard flashcard)
    {
        sum += flashcard.getWeight();
        cards.add(new FlashcardWithPref(flashcard, sum));
    }
    public void updateProgress(int points)
    {
        this.progress.improve(points);
    }
    private Flashcard findFlashcard(int index)
    {
        int beg = 0, end = this.cards.size(), mid;
        while(beg < end - 1)
        {
            mid = (beg + end) >> 1;
            if(this.cards.get(mid).prefix_sum >= index)
                beg = mid;
            else 
                end = mid;
        }
        return this.cards.get(beg).flashcard;
    }
    public Flashcard randFlashcard()
    {
        int n = rand.nextInt(2);
        return findFlashcard(n);
    }
}
