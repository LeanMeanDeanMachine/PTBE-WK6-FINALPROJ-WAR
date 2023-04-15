import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/*
this code defines a class Player that represents a player in a card game.
Each Player has a hand of cards, which is stored as a queue.
The class provides methods for adding cards to the hand,
playing cards from the hand, checking if the hand is empty,
adding a collection of cards to the hand, and getting the current size
of the hand.
 */

// This class represents a player in a card game
public class Player {

    // Each player has a hand of cards, represented as a queue
    private Queue<Card> hand;

    // Constructor for the player class, initializes the hand queue
    public Player() {
        hand = new LinkedList<>();
    }

    // Adds a card to the player's hand
    public void receiveCard(Card card) {
        hand.add(card);
    }

    // Plays a card from the player's hand (removes it from the queue)
    public Card playCard() {
        return hand.poll();
    }

    // Checks if the player has any cards left in their hand
    public boolean hasCards() {
        return !hand.isEmpty();
    }

    // Adds a collection of cards to the player's hand
    public void addAllCards(Collection<Card> cards) {
        for (Card card : cards) {
            hand.add(card);
        }
    }

    // Returns the current size of the player's hand
    public int handSize() {
        return hand.size();
    }
}