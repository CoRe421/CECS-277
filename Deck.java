import java.util.ArrayList;
import java.util.*;

/**
 * A deck that holds cards.
 * @author Cory Reardon
 * @date 9/12/18
 */
public class Deck {
    private ArrayList<Card> mStorage;

    public Deck() {
        mStorage = new ArrayList<>();
        createDeck('S');
        createDeck('C');
        createDeck('H');
        createDeck('D');
    }

    private void createDeck(char suit) {
        for (int i = 1; i < 14; i++) {
            Card c = new Card(i, suit);
            mStorage.add(c);
        }
    }

    /**
     * Shuffles the deck.
     */
    public void shuffleDeck() {
        Collections.shuffle(mStorage);
    }

    /**
     * Returns the deck as a list of cards.
     * @return The deck as a string.
     */
    public String toString() {
        String deck = "";
        for (int i = 0; i < mStorage.size(); i++) {
            deck += mStorage.get(i) + " ";
        }
        return deck;
    }

    /**
     * Returns the size of the deck.
     * @return The size of the deck as an int.
     */
    public int getSize() {
        return mStorage.size();
    }

    /**
     * Returns the card in the deck at a given index.
     * @param index The index of the card to be returned.
     * @return The card at the given index.
     */
    public Card getCard(int index) {
        return mStorage.get(index);
    }
}
