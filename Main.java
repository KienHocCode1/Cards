import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many rank: ");
        int rank = input.nextInt();

        System.out.print("How many suit: ");
        int suit = input.nextInt();

        DeckOfCards deck = new DeckOfCards(rank, suit);
        System.out.print(deck);
        System.out.println(" ");
        deck.print();
        deck.getTotalValue();
        boolean Flag = true;
        while (Flag) {
            System.out.println("");
            System.out.println("1=shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit");

            int choice = input.nextInt();
            if (choice == 1) {
                deck.shuffle();
                System.out.println("Cards are shuffled.");
                System.out.println("");
                System.out.println(deck);

            } else if (choice == 2) {
                System.out.println("How many cards? ");
                int deal1HandCards = input.nextInt();
                deck.dealTopCards(deal1HandCards);

            } else if (choice == 3) {
                System.out.println("How many cards? ");
                int shuffle100000 = input.nextInt();
                deck.histogram(shuffle100000);

            }else {
                System.out.println("Bye!");
                Flag = false;
            }
        }
    }
}
