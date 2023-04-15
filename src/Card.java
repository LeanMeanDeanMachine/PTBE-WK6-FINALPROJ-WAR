/*
this code defines a class Card that represents a standard playing card.
Each Card has a suit (club, diamond, heart, or spade) and a rank
(2-10, Jack, Queen, King, or Ace). The class provides getters and setters
for the suit and rank of the card. The toString() method is overridden to
return a user-readable string representation of the card, for example,
"Ace of Spades". The toString() method uses two arrays, ranks and suits,
to map the integer rank and the Suit enum value to a string representation
of the rank and suit
 */

// This class represents a standard playing card
public class Card {

    // Each card has a suit (club, diamond, heart, spade) and a rank (2-10, Jack, Queen, King, Ace)
    private Suit suit;
    private int rank;

    // Constructor for a card object, initializes a new card with a suit and rank
    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getters and setters for suit and rank

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    // Override the toString method to return a user-readable string representation of the card
    // For example, "Ace of Spades"
    @Override
    public String toString() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        // The rank of the card is used to index the ranks array, and the suit of the card is used to index the suits array
        return ranks[rank - 2] + " of " + suits[suit.ordinal()];
    }
}