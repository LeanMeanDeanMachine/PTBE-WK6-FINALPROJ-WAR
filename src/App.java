import java.util.ArrayList;
import java.util.List;

/*
This code defines the main application
class `App` that runs the card game. It creates a new `Deck` of cards,
two `Player` objects, and deals cards to each player until the deck is empty.
The main loop of the game continues until either player runs out of cards.
In each round of the game, each player plays a card face-up,
and if the cards have the same rank, a war ensues. During a war,
each player plays three face-down cards and one face-up card,
and the player with the higher face-up card wins all the cards in play.
The game continues until one player has all the cards, and the winner is
displayed at the end of the game.
The code also includes some comments and print statements for readability
and debugging.
 */


// This is the main application class that runs the card game
public class App {

    // The main method is the entry point of the application
    public static void main(String[] args) {

        // Create a new deck of cards and two players
        Deck deck = new Deck();
        Player player1 = new Player();
        Player player2 = new Player();

        String war = "WAR!!";
        String border = new String(new char[war.length()]).replace("\0", "*");

        // Deal cards to players until the deck is empty
        while (!deck.isEmpty()) {
            player1.receiveCard(deck.drawCard());
            player2.receiveCard(deck.drawCard());
        }

        // Game loop
        int round = 1; // Keep track of the round number

        while (player1.hasCards() && player2.hasCards()) {

            // Create a list to hold the cards in play
            List<Card> cardsInPlay = new ArrayList<>();

            // Each player plays a card face-up
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            // Add the cards to the list of cards in play
            cardsInPlay.add(card1);
            cardsInPlay.add(card2);

            // Display the cards that were played
            System.out.println("Round " + round + ":");
            System.out.println("--> Player 1 plays: " + card1);
            System.out.println("--> Player 2 plays: " + card2);
            System.out.println(" "); // Add some space for readability

            // If the cards have the same rank, it's WAR!
            while (card1.getRank() == card2.getRank()) {

                System.out.println(" ");    // Add some space for readability
                System.out.println("              " + border);
                System.out.println("              " + war);
                System.out.println("              " + border);
                System.out.println(" ");    // Add some space for readability

                // If either player runs out of cards during a war, break the loop
                if (!player1.hasCards() || !player2.hasCards()) {
                    break;
                }

                // Each player plays three face-down cards and one face-up card
                for (int i = 0; i < 3 && player1.hasCards() && player2.hasCards(); i++) {
                    cardsInPlay.add(player1.playCard());
                    cardsInPlay.add(player2.playCard());
                }

                // Display the new face-up cards
                if (player1.hasCards()) {
                    card1 = player1.playCard();
                    cardsInPlay.add(card1);
                    System.out.println(" -> Player 1 plays: " + card1);
                }

                if (player2.hasCards()) {
                    card2 = player2.playCard();
                    cardsInPlay.add(card2);
                    System.out.println(" -> Player 2 plays: " + card2);
                    System.out.println(" "); // Add some space for readability
                }

                // If either player runs out of cards during a war, break the loop
                if (!player1.hasCards() || !player2.hasCards()) {
                    break;
                }
            }

            // If either player runs out of cards, break the loop
            if (!player1.hasCards() || !player2.hasCards()) {
                break;
            }

            // The player with the higher face-up card wins all cards in play
            if (card1.getRank() > card2.getRank()) {
                player1.addAllCards(cardsInPlay);
                System.out.println("||**************************||");
                System.out.println("|| Player 1 wins this round ||");
                System.out.println("||**************************||");
            } else {
                player2.addAllCards(cardsInPlay);
                System.out.println("||**************************||");
                System.out.println("|| Player 2 wins this round ||");
                System.out.println("||**************************||");
            }

            // Display the number of cards in each player's hand
            System.out.println(" "); // Add some space for readability
            System.out.println("||-- Player 1 has " + player1.handSize() + " cards --||");
            System.out.println("||-- Player 2 has " + player2.handSize() + " cards --||");
            System.out.println(" "); // Add some space for readability
            System.out.println("------------------------------");
            System.out.println(" "); // Add some space for readability

            // Increment the round counter
            round++;
        }

        // Display the winner of the game
        if (player1.hasCards()) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("      [[******************]]");
            System.out.println("      [[  Player 1 wins!  ]]");
            System.out.println("      [[******************]]");
            System.out.println(" ");
            System.out.println(" ");
        } else {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("      [[******************]]");
            System.out.println("      [[  Player 2 wins!  ]]");
            System.out.println("      [[******************]]");
            System.out.println(" ");
            System.out.println(" ");
        }
    }
}