import javax.smartcardio.Card;
import java.awt.*;

class MobilePile {

    private VectorDeckClass mobilePile = new VectorDeckClass();
    private int x = 150;
    private int y = 150;

    CardClass topPile() {
        return (CardClass) mobilePile.topPile();
    }

    CardClass lastCard() {
        return (CardClass) mobilePile.lastCard();
    }

    //Adding Card to mobile pile
    void addCard(CardClass card) {
        mobilePile.addCard(card);
    }

    //Removing Cards from Mobile Pile
    void transferBack(Piles pile) {
        int size = mobilePile.getSize();

        for (int i = 0; i < size; i++) {
            pile.addCard(mobilePile.dealCard(0));
        }


    }

    //Size of Mobile Pile
    int getSize() {
        return mobilePile.getSize();
    }


    //setting Location of cards in mobile pile
    void setMobilePileLocation(int x, int y) {
        CardClass Card;

        for (int i = 0; i < mobilePile.getSize(); i++) {
            if (mobilePile.getSize() != 0) {
                Card = mobilePile.getCard(i);
                Card.setCenter(x, y);
                y = y + 35;
            } else {
                break;
            }
        }
    }

    //Drawing Mobile Pile
    void drawMobilePile(Graphics g) {
        CardClass Card;

        for (int i = 0; i < mobilePile.getSize(); i++) {
            if (mobilePile.getSize() != 0) {
                Card = mobilePile.getCard(i);
                Card.draw(g);
            } else {
                break;
            }

        }
    }
}
