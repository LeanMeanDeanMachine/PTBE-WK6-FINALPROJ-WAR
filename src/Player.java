import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Player {
    private Queue<Card> hand;

    public Player() {
        hand = new LinkedList<>();
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        return hand.poll();
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public void addAllCards(Collection<Card> cards) {
        for (Card card : cards) {
            hand.add(card);
        }
    }

    public int handSize() {
        return hand.size();
    }
}