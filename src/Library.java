import java.util.ArrayList;
public class Library
{
    private ArrayList<Deck> decks;
    public ArrayList<Deck> getDecks()
    {
        return this.decks;
    }
    public void addDeck(String name)
    {
        Deck new_deck = new Deck(name);
        decks.add(new_deck);
    }
}