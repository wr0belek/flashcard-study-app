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
    private String name;
    private ArrayList <FlashcardWithPref> cards;
    private int sum = 0;
    private Progress progress;
    private Random rand = new Random();
    public Deck(String name)
    {
        this.name = name;
    }
    public void addFlashcard(Flashcard flashcard)
    {
        sum += flashcard.getWeight();
        cards.add(new FlashcardWithPref(flashcard, sum));
    }
    public void updateProgress(int points)
    {
        this.progress.improve(points);
    }
    public Progress getProgress()
    {
        return this.progress;
    }
    public String getName()
    {
        return this.name;
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
    public Flashcard randOtherFlashcard(Flashcard flashcard)
    {
        Flashcard drawed_flashcard;
        do{
            int n = rand.nextInt(2);
            drawed_flashcard = findFlashcard(n);
        } while(flashcard.equals(drawed_flashcard));
        return drawed_flashcard;
    }
}
