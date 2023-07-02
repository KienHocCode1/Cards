import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
public class DeckOfCards {
    private Card[] cards;
    private int sizeOfTheDeck;
    private final int rankMax;
    private final int suitNumber;
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
        }
        for (Card card : cards) {
            System.out.print(card + " ");
        }
    }
    public Card[] dealTopCards(int numCards) {
        Card[] hand = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            hand[i] = cards[i];
        }
        for (Card card : hand) {
            System.out.print(card + " ");
        }
        return hand;
    }
    public Card getTopCard() {
        return cards[0];
    }
    public int[] histogram(int shuffle100000) {
        int big = 1;
        int small = 0;

        // Sort the cards in ascending order based on their values
        Arrays.sort(cards, Comparator.comparingInt(Card::getValue));

        // Add the values of the three smallest cards
        for (int i = 0; i < shuffle100000; i++) {
            small += cards[i].getValue();
        }

        // Add the values of the three biggest cards
        for (int i = sizeOfTheDeck - 1; i >= sizeOfTheDeck - shuffle100000; i--) {
            big += cards[i].getValue();
        }
        int math = big - small;
        System.out.println(math);
        int[] histogramArray = new int[math+1];

        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int sum = random.nextInt(math+1);
            histogramArray[sum]++;
        }

        for (int i = small; i < big; i++) {
            System.out.println(i + ": " + histogramArray[i-small]);
        }

        return histogramArray;
    }

    public int getTotalValue() {
        int big = 0;
        int small = 0;

        // Sort the cards in ascending order based on their values
        Arrays.sort(cards, Comparator.comparingInt(Card::getValue));

        // Add the values of the three smallest cards
        for (int i = 0; i < 3; i++) {
            small += cards[i].getValue();
        }

        // Add the values of the three biggest cards
        for (int i = sizeOfTheDeck - 1; i >= sizeOfTheDeck - 3; i--) {
            big += cards[i].getValue();
        }
        int math = big - small;
        System.out.println(math);
        return math;
    }
    public void print(){
        for (Card card : cards) {
            System.out.print(card + " ");
        }
    }

    @Override
    public String toString() {
        return String.format("Size %d MinValue %d MaxValue %d TopCard %s", getSizeOfTheDeck(), getMinValue(), getMaxValue(), getTopCard());
    }

}
