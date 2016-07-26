import java.awt.*;

class Piles {

    VectorDeckClass pile = new VectorDeckClass();
    private int x = 150;
    private int y = 150;

    //Adding Cards
    void addCard(CardClass card) {
        pile.addCard(card);
    }

    //Getting Card
    CardClass getCard(int index) {
        return pile.getCard(index);
    }

    CardClass topPile() {
        return (CardClass) pile.topPile();
    }

    CardClass lastCard() {
        return (CardClass) pile.lastCard();
    }

    //delete card
    public void deleteCard(int Pos) {


        if (Pos == 0 || pile.getSize() == 0) {
            pile.deleteCard(0);
        } else if (Pos > pile.getSize()) {
            pile.deleteCard(0);
        } else {
            pile.deleteCard(Pos);
        }


    }

    //Setting Location
    void setPileLocation(int x, int y) {
        CardClass Card = new CardClass();

        for (int i = 0; i < pile.getSize(); i++) {
            if (pile.getSize() != 0) {
                Card = pile.getCard(i);
                Card.setCenter(x, y);
                y = y + 35;
            } else {
                break;
            }
        }
    }

    void setTopPileLocation (int x, int y) {
       if (pile.getSize() != 0) {
           CardClass Card = new CardClass();
           Card = pile.lastCard();
           Card.setCenter(x, y);
       }
    }

    //Drawing Pile
    void drawPile(Graphics g) {
        CardClass Card;

        for (int i = 0; i < pile.getSize(); i++) {
            if (pile.getSize() != 0) {
                Card = pile.getCard(i);
                Card.draw(g);
            } else {
                break;
            }

        }


    }

    //Draw Top Pile
    void drawTopPile(Graphics g) {
        CardClass card = new CardClass();

        card = pile.lastCard();
        card.draw(g);

    }

    //Which pile did you click on
    boolean whichPile(int x, int y) {

        int xLowBounds = pile.topPile().getCenterX() - pile.topPile().getWidth();
        int xHighBounds = pile.lastCard().getCenterX();

        int yLowBounds = pile.topPile().getCenterY() - pile.topPile().getHeight();
        int yHighBounds = pile.lastCard().getCenterY();

        if (x > xLowBounds && x < xHighBounds && y > yLowBounds && y < yHighBounds) {
            return true;
        } else {
            return false;
        }


    }

    //Which HoverPile
    boolean whichHoverPile(int x, int y) {

        if (pile.getSize() != 0) {

            int xLowBounds = (pile.topPile().getCenterX() - pile.topPile().getWidth()) - 10;
            int xHighBounds = (pile.lastCard().getCenterX()) + 10;

            int yLowBounds = pile.topPile().getCenterY() - pile.topPile().getHeight();

            if (x > xLowBounds && x < xHighBounds && y > yLowBounds) {
                return true;
            } else {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    //which top Pile
    boolean whichTopPile (int x, int y){

        int xLowBounds = (pile.lastCard().getCenterX() - pile.lastCard().getWidth()) - 5;
        int xHighBounds = (pile.lastCard().getCenterX()) + 5;


        int yLowBounds = (pile.lastCard().getCenterY() - pile.lastCard().getHeight()) - 5;
        int yHighBounds = (pile.lastCard().getCenterY()) + 5;


        if (x > xLowBounds && x < xHighBounds && y > yLowBounds && y < yHighBounds) {
            return true;
        } else {
            return false;
        }
    }

    //Which card did you click on
    int whichCard(int y) {
        int yLowBounds = pile.lastCard().getCenterY() - pile.lastCard().getHeight();
        int CardToTransfer = pile.getSize() - 1;

        for (int i = 0; i < pile.getSize() + 1; i++) {
            if (y < yLowBounds) {
                CardToTransfer -= 1;
                yLowBounds -= 35;
            } else {
                break;
            }
        }
        //System.out.print(CardToTransfer);
        return CardToTransfer;
    }

    //Transfers cards to MobileDeck
    void transferToMobilePile(int y, MobilePile mobilePile) {
        CardClass card;
        int pos = whichCard(y);
        int size = pile.getSize();

        if (checkFlipCard(y)) {
            for (int i = pos; i < size; i++) {
                card = pile.getCard(pos);
                pile.deleteCard(pos);
                mobilePile.addCard(card);
            }
        }

        //if (pile.getSize() == 0) {
        //    card = new CardClass();
        //    card.setSuitValue(0);
        //    card.setFaceValue(0);
        //    card.setFaceUp(4);
        //    pile.addCard(card);
        //}

    }

    //Checks

    //Check if card is flipped
    boolean checkFlipCard(int y) {
        CardClass card;
        int pos = whichCard(y);

        card = pile.getCard(pos);
        if (card.getFaceUp() == 1) {
            return true;
        } else {
            return false;
        }

    }

    //Flip Flipped Card
    void flipFliipedCard (){
        if (pile.lastCard().getFaceUp() == 2) {
           pile.lastCard().setFaceUp(1);
        }
    }

    //Check Color
    boolean colorCheck(MobilePile mobilePile) {
        CardClass card;
        CardClass card1;

        card = pile.lastCard();
        card1 = mobilePile.topPile();

        if (card.getSuitValue() == 0 && card1.getSuitValue() == 1 || card.getSuitValue() == 1 && card1.getSuitValue() == 0 || card.getSuitValue() == 2 && card1.getSuitValue() == 3 || card.getSuitValue() == 3 && card1.getSuitValue() == 2 || card.getSuitValue() == 2 && card1.getSuitValue() == 1 || card.getSuitValue() == 1 && card1.getSuitValue() == 2 || card.getSuitValue() == 3 && card1.getSuitValue() == 0 || card.getSuitValue() == 0 && card1.getSuitValue() == 3) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkLegality(MobilePile mobilePile) {
        CardClass card;
        CardClass card1;

        card = pile.lastCard();
        card1 = mobilePile.topPile();

        if (colorCheck(mobilePile)) {
            if (card1.getFaceValue() == card.getFaceValue() - 1) {
                return true;
            } else if (card.getFaceUp() == 4 && card1.getFaceValue() == 12){
                return true;
            }
            else {
                return false;
            }
        }

        else if (card.getFaceUp() == 4 && card1.getFaceValue() == 12){
            return true;
        }

        else {
            return false;
        }
    }

    boolean checkLegalityTopPile (MobilePile mobilePile){
        CardClass card;
        CardClass card1;

        card = pile.lastCard();
        card1 = mobilePile.topPile();

        if (mobilePile.getSize() == 1) {
            if (pile.getSize() == 1 && card.getSuitValue() == card1.getSuitValue() && card.getFaceValue() == card1.getFaceValue()) {
                return true;
            } else if (pile.getSize() >= 2 && card.getSuitValue() == card1.getSuitValue() && card.getFaceValue() + 1 == card1.getFaceValue()) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }

    }


}
