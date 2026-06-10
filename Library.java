import java.util.ArrayList;
public class Library
{
    ArrayList<Deck> decks;
    public void add_deck(String name)
    {
        Deck new_deck = new Deck(name);
        decks.add(new_deck);
    }
}