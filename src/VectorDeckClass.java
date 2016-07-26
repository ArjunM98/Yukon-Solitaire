
import java.util.*;

 class VectorDeckClass {

     Vector deck = new Vector(0, 1);


     VectorDeckClass() {
    }


     VectorDeckClass(char deckType) {
        if (deckType == 's') // std deck
        {
            for (int i = 0; i < 13; i++) {

                for (int j = 0; j < 4; j++) {

                    CardClass C = new CardClass();
                    C.setFaceValue(i);
                    C.setSuitValue(j);
                    deck.insertElementAt(C, deck.size());

                }

            }

        }
    }

    public void deleteCard(int Pos) {


        if (Pos == 0 || deck.size() == 0) {
            deck.removeElementAt(0);
        } else if (Pos > deck.size()) {
            deck.removeElementAt(0);
        } else {
            deck.removeElementAt(Pos);
        }


    }

     CardClass dealCard(int Pos) {

        if (Pos == 0 && deck.size() == 0) {
            CardClass Card = new CardClass();
            Card.setSuitValue(1);
            Card.setFaceValue(1);
            return Card;
        } else

        {
            CardClass Card = (CardClass) deck.elementAt(Pos);
            deck.removeElementAt(Pos);

            return Card;
        }

    }

    void shuffle() {
        Collections.shuffle(deck);
    }

    CardClass topPile() {
        return (CardClass) deck.firstElement();
    }

    CardClass lastCard() {
        return (CardClass) deck.lastElement();
    }

    CardClass getCard(int index) {
        return (CardClass) (deck.get(index));
    }

    int getSize() {
        return deck.size();
    }

     void addCard(CardClass Card) {
        deck.addElement(Card);
    }

}
