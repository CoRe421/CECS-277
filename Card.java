/**
 * A Card that has a suit and a rank.
 * @author Cory Reardon
 * @date 9/12/18
 */
public class Card {
    private char mSuit;
    private int mRank;

    public Card(int rank, char suit) {
        mSuit = suit;
        mRank = rank;
    }

    /**
     * Gets the rank of the card.
     * @return The rank of the card as an int.
     */
    public int getRank() {
        return mRank;
    }

    /**
     * Rreturns the card as a string to print.
     * @return The card as a string.
     */
    public String toString() {
        if (mRank == 11) {
            return 'J' + Character.toString(mSuit);
        }
        else if (mRank == 12) {
            return 'Q' + Character.toString(mSuit);
        }
        else if (mRank == 13) {
            return 'K' + Character.toString(mSuit);
        }
        return Integer.toString(mRank) + Character.toString(mSuit);
    }
}
