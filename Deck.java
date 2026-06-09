import java.util.ArrayList;

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
    public void addFlashcard(Flashcard flashcard)
    {
        sum += flashcard.getWeight();
        cards.add(new FlashcardWithPref(flashcard, sum));
    }
    public void updateProgress(int points)
    {
        this.progress.improve(points);
    }
}
