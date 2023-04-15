import java.util.ArrayList;
import java.util.Collections;

/*
This code defines a class Deck that represents a deck of cards.
Each Deck is represented as an ArrayList of Card objects.
The class provides methods for shuffling the deck,
drawing a card from the top of the deck, and checking if the deck is empty.
The constructor for the Deck class initializes a new deck with
all 52 cards (2-10, Jack, Queen, King, and Ace) of each suit
(clubs, diamonds, hearts, and spades) and shuffles them.
The shuffle() method shuffles the deck by randomly changing the order
of the cards in the ArrayList. The drawCard() method removes and returns
the top card from the deck (the first card in the ArrayList).
The isEmpty() method returns true if the deck is empty (has no cards left),
and false otherwise.
 */

// This class represents a deck of cards
public class Deck {

    // Each deck is represented as an ArrayList of Cards
    private ArrayList<Card> cards;

    // Constructor for the deck class, initializes a new deck with all 52 cards and shuffles them
    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int rank = 2; rank <= 14; rank++) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffle(); // Shuffle the deck after it is created
    }

    // Shuffle the deck by randomly changing the order of the cards in the ArrayList
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Removes and returns the top card from the deck
    public Card drawCard() {
        return cards.remove(0);
    }

    // Returns true if the deck is empty, false otherwise
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}