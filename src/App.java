import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player1 = new Player();
        Player player2 = new Player();

        String war = "WAR!!";
        String border = new String(new char[war.length()]).replace("\0", "*");

        // Deal cards to players
        while (!deck.isEmpty()) {
            player1.receiveCard(deck.drawCard());
            player2.receiveCard(deck.drawCard());
        }

        // Game loop
        int round = 1; // Tally to keep track of round number

        //int drawCount;
        //int maxDraws = 3; // Limit the number of draws during a war

        /*
        ^ Was having memory leak issues, issue resolved
         */


        while (player1.hasCards() && player2.hasCards()) {
            List<Card> cardsInPlay = new ArrayList<>();
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();
            cardsInPlay.add(card1);
            cardsInPlay.add(card2);

            System.out.println("Round " + round + ":");
            System.out.println("--> Player 1 plays: " + card1);
            System.out.println("--> Player 2 plays: " + card2);
            System.out.println(" ");    //Peace of Mind

            while (card1.getRank() == card2.getRank()) {
                System.out.println(" ");    //Peace of Mind
                System.out.println("                " + border);
                System.out.println("                " + war);
                System.out.println("                " + border);
                System.out.println(" ");    //Peace of Mind

                if (!player1.hasCards() || !player2.hasCards()) {
                    break;
                }
                // Each player adds three face-down cards to the war
                for (int i = 0; i < 3 && player1.hasCards() && player2.hasCards(); i++) {
                    cardsInPlay.add(player1.playCard());
                    cardsInPlay.add(player2.playCard());

                }
                // Both players play a new face-up card
                if (player1.hasCards()) {
                    card1 = player1.playCard();
                    cardsInPlay.add(card1);
                    System.out.println(" -> Player 1 plays: " + card1);
                }
                if (player2.hasCards()) {
                    card2 = player2.playCard();
                    cardsInPlay.add(card2);
                    System.out.println(" -> Player 2 plays: " + card2);
                    System.out.println(" ");    //Peace of Mind
                }
                if (!player1.hasCards() || !player2.hasCards()) {
                    break;
                }
            }

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
            System.out.println(" ");    //Peace of Mind
            System.out.println("||-- Player 1 has " + player1.handSize() + " cards --||");
            System.out.println("||-- Player 2 has " + player2.handSize() + " cards --||");
            System.out.println(" ");    //Peace of Mind
            System.out.println("-----------");
            System.out.println(" ");    //Peace of Mind

            round++; // Increment the round counter
        }

        // Display the winner
        if (player1.hasCards()) {
            System.out.println(" ");    //Peace of Mind
            System.out.println(" ");    //Peace of Mind
            System.out.println("         [[******************]]");
            System.out.println("         [[  Player 1 wins!  ]]");
            System.out.println("         [[******************]]");
        } else {
            System.out.println(" ");    //Peace of Mind
            System.out.println(" ");    //Peace of Mind
            System.out.println("         [[******************]]");
            System.out.println("         [[  Player 2 wins!  ]]");
            System.out.println("         [[******************]]");
            System.out.println(" ");    //Peace of Mind
            System.out.println(" ");    //Peace of Mind
        }
    }
}

