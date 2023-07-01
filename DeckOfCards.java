import java.util.Random;
public class DeckOfCards {
    private Card[] cards;
    private int sizeOfTheDeck;
    private final int rankMax;
    private final int suitNumber;
    private Card[] topCard;


    public DeckOfCards(int rankMax, int suitNumber) {
        this.rankMax = rankMax;
        this.suitNumber = suitNumber;
        this.sizeOfTheDeck = rankMax * suitNumber;
        this.cards = new Card[sizeOfTheDeck];

        int insertCards = 0;
        for (int i = 1; i <= rankMax; i++) {
            for (int x = 1; x <= suitNumber; x++) {
                cards[insertCards] = new Card(x, i);
                insertCards++;
            }
        }

    }

    public int getSizeOfTheDeck() {
        return rankMax*suitNumber;
    }
    public int getMinValue() {
        return 1;
    }
    public int getMaxValue() {
        return rankMax*suitNumber;
    }
    //
    public void shuffle() {
        Random random = new Random();

        for (int i = sizeOfTheDeck - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);

            // Swap cards[i] and cards[j]
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
            System.out.print(cards[i] + " ");
        }
    }
    public Card[] dealTopCards(int numCards) {
        Card[] hand = new Card[numCards];

        for (int i = 0; i < numCards; i++) {
            hand[i] = cards[i];
        }

        return hand;
    }
    public Card getTopCard() {
        return cards[0];
    }
    static void printCards(Card[] cards) {
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    public int[] histogram() {

        return null;
    }

    @Override
    public String toString() {
        return String.format("Size %d MinValue %d MaxValue %d TopCard %s",getSizeOfTheDeck(),getMinValue(), getMaxValue(), getTopCard());
    }

}
