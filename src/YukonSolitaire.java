import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class YukonSolitaire extends Applet implements ActionListener, MouseListener, MouseMotionListener {

    private Graphics g;
    private boolean readyToPlay = false;
    boolean OKtoMove = false;
    private int moves = 0;
    private int pileLocation = 12;
    private int hoverPileLocation = 12;
    private Color backColor = new Color(0, 115, 50);

    //Card Variables
    private Piles[] pile;
    private MobilePile mobilePile;
    private VectorDeckClass deck;
    private CardClass card;
    private CardClass card1;



    public void init() {
        g = getGraphics();
        addMouseListener(this);
        addMouseMotionListener(this);

        //CardStuff
        pile = new Piles[11];
        card = new CardClass();
        card1 = new CardClass ();
        mobilePile = new MobilePile();
        deck = new VectorDeckClass('s');
        deck.shuffle();

        //First Pile
        pile[0] = new Piles();
        pile [0].addCard(deck.dealCard(0));

        //Second Pile
        pile[1] = new Piles();
        //Flipped Card
        card = deck.dealCard(0);
        card.setFaceUp(2);
        pile[1].addCard(card);
        //5 Un-flipped Cards
        for (int i = 0; i < 5; i++) {
            card = deck.dealCard(0);
            pile[1].addCard(card);
        }

        //Third Pile
        pile[2] = new Piles();
        //Flipped Card
        for (int i = 0; i < 2; i++) {
            card = deck.dealCard(0);
            card.setFaceUp(2);
            pile[2].addCard(card);
        }
        //5 Un-flipped Cards
        for (int i = 0; i < 5; i++) {
            card = deck.dealCard(0);
            pile[2].addCard(card);
        }

        //Fourth Pile
        pile[3] = new Piles();
        //Flipped Card
        for (int i = 0; i < 3; i++) {
            card = deck.dealCard(0);
            card.setFaceUp(2);
            pile[3].addCard(card);
        }
        //5 Un-flipped Cards
        for (int i = 0; i < 5; i++) {
            card = deck.dealCard(0);
            pile[3].addCard(card);
        }

        //Fifth Pile
        pile[4] = new Piles();
        //Flipped Card
        for (int i = 0; i < 4; i++) {
            card = deck.dealCard(0);
            card.setFaceUp(2);
            pile[4].addCard(card);
        }
        //5 Un-flipped Cards
        for (int i = 0; i < 5; i++) {
            card = deck.dealCard(0);
            pile[4].addCard(card);
        }

        //Sixth Pile
        pile[5] = new Piles();
        //Flipped Card
        for (int i = 0; i < 5; i++) {
            card = deck.dealCard(0);
            card.setFaceUp(2);
            pile[5].addCard(card);
        }
        //5 Un-flipped Cards
        for (int i = 0; i < 5; i++) {
            card = deck.dealCard(0);
            pile[5].addCard(card);
        }

        //Seventh Pile
        pile[6] = new Piles();
        //Flipped Card
        for (int i = 0; i < 6; i++) {
            card = deck.dealCard(0);
            card.setFaceUp(2);
            pile[6].addCard(card);
        }
        //5 Un-flipped Cards
        for (int i = 0; i < 5; i++) {
            card = deck.dealCard(0);
            pile[6].addCard(card);
        }

        //Top Piles
        //First Pile
        card1 = new CardClass ();
        pile[7] = new Piles();
        card1.setSuitValue(0);
        card1.setFaceValue(0);
        card1.setFaceUp(3);
        pile[7].addCard(card1);

        card1 = new CardClass ();
        pile[8] = new Piles();
        card1.setSuitValue(1);
        card1.setFaceValue(0);
        card1.setFaceUp(3);
        pile[8].addCard(card1);

        card1 = new CardClass ();
        pile[9] = new Piles();
        card1.setSuitValue(2);
        card1.setFaceValue(0);
        card1.setFaceUp(3);
        pile[9].addCard(card1);

        card1 = new CardClass ();
        pile[10] = new Piles();
        card1.setSuitValue(3);
        card1.setFaceValue(0);
        card1.setFaceUp(3);
        pile[10].addCard(card1);

    } // init method

    public void actionPerformed(ActionEvent e) {

    }


    public void mouseClicked(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {
    }


    public void mouseExited(MouseEvent e) {
    }


    public void mouseMoved(MouseEvent e) {
    }


    public void mousePressed(MouseEvent e) {

        for (int i = 0; i < 7; i++) {
            if (pile[i].whichPile(e.getX(), e.getY())) {
                pileLocation = i;
                OKtoMove = true;
                pile[pileLocation].transferToMobilePile(e.getY(), mobilePile);

            }
        }


    }

    public void mouseReleased(MouseEvent e) {

        OKtoMove = false;

        if (mobilePile.getSize() != 0) {

            for (int i = 0; i < 7; i++) {
                if (pile[i].whichHoverPile(e.getX(), e.getY())) {
                    hoverPileLocation = i;
                    break;
                }
            }

            if (hoverPileLocation < 7) {
                if (pile[hoverPileLocation].checkLegality(mobilePile)) {
                    mobilePile.transferBack(pile[hoverPileLocation]);
                    hoverPileLocation = 12;
                    if (pile [pileLocation].lastCard().getFaceUp() == 2){
                        pile [pileLocation].flipFliipedCard();
                    }

                } else {
                    mobilePile.transferBack(pile[pileLocation]);
                    hoverPileLocation = 12;
                }
            }

            for (int i = 7; i < 11; i++) {
                if (pile[i].whichTopPile(e.getX(), e.getY())) {
                    hoverPileLocation = i;
                    break;
                }
            }

            if (hoverPileLocation >= 7 && hoverPileLocation < 11){
                if (pile [hoverPileLocation].checkLegalityTopPile(mobilePile)){
                    mobilePile.transferBack(pile [hoverPileLocation]);
                    hoverPileLocation = 12;
                }
                else {
                    mobilePile.transferBack(pile[pileLocation]);
                    hoverPileLocation = 12;
                }
            }

            else {
                mobilePile.transferBack(pile[pileLocation]);
                hoverPileLocation = 12;

            }
        }

        repaint();

    }

    public void mouseDragged(MouseEvent e) {
        if (OKtoMove) {
            mobilePile.setMobilePileLocation(e.getX(), e.getY());
        }
        repaint();
    }

    public void paint(Graphics g) {

        setBackground(backColor);

        if (moves == 0) {
            for (int j = 0; j < 7; j++) {
                pile[j].setPileLocation(100 + (j * 100), 120);
                pile[j].drawPile(g);
            }

            int count = 0;
            for (int j = 7; j < 11; j++) {
                pile[j].setTopPileLocation(850, 120 + (count * 110));
                pile[j].drawTopPile(g);
                count +=1;
            }

            moves = moves + 1;
            readyToPlay = true;
        } else if (readyToPlay) {
            for (int j = 0; j < 7; j++) {
                pile[j].setPileLocation(100 + (j * 100), 120);
                pile[j].drawPile(g);
            }

            int count = 0;
            for (int j = 7; j < 11; j++) {
                pile[j].setTopPileLocation(850, 120 + (count * 110));
                pile[j].drawTopPile(g);
                count +=1;
            }

            mobilePile.drawMobilePile(g);

        } else if (OKtoMove) {
            for (int j = 0; j < 7; j++) {
                pile[j].setPileLocation(100 + (j * 100), 120);
                pile[j].drawPile(g);
            }

            int count = 0;
            for (int j = 7; j < 11; j++) {
                pile[j].setTopPileLocation(850, 120 + (count * 110));
                pile[j].drawTopPile(g);
                count +=1;
            }

            mobilePile.drawMobilePile(g);

        }


        // Place the body of the drawing method here
    } // paint method


    public void update(Graphics g) {
        Image offScreenImage = createImage(getWidth(), getHeight());

        Graphics offScreenG = offScreenImage.getGraphics();

        offScreenG.setColor(getBackground());
        offScreenG.fillRect(getX(), getY(), getWidth(), getHeight());
        offScreenG.setColor(getForeground());

        paint(offScreenG);

        g.drawImage(offScreenImage, getX(), getY(), this);
    }

}

