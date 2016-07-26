
import java.awt.*;

class CardClass extends ShapeClass {


    // Global Variables
    private int SuitValue = 1;
    private int FaceValue = 1;
    private int faceup = 1;


    //Comunicator Methods
    public void setWidth(int ipWidth) {
        iHeight = (10 * ipWidth) / 7;
        iWidth = ipWidth;
    }


    public void setHeight(int ipHeight) {
        iHeight = ipHeight;
        iWidth = (7 * ipHeight) / 10;
    }


    void setFaceValue(int ipfaceValue) {
        FaceValue = ipfaceValue;
    }

    public int getFaceValue() {
        return FaceValue;
    }

    void setSuitValue(int ipsuitValue) {
        SuitValue = ipsuitValue;
    }


    public int getSuitValue() {
        return SuitValue;
    }


    public void setFaceUp(int ipFaceUp) {
        faceup = ipFaceUp;
    }

    public int getFaceUp() {
        return faceup;
    }


    public void draw(Graphics g) {
        if (faceup == 1) {

            g.setColor(Color.white);
            g.fillRect(iCentreX - iWidth, iCentreY - iHeight, iWidth, iHeight);
            g.setColor(Color.black);
            g.drawRect(iCentreX - iWidth, iCentreY - iHeight, iWidth, iHeight);

            String DisplayFace[] = new String[]
                    {
                            "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
                    };

            ClubClass C1 = new ClubClass();
            DiamondClass D1 = new DiamondClass();
            HeartClass H1 = new HeartClass();
            SpadeClass S1 = new SpadeClass();

            if (SuitValue == 0) {
                S1.setCenter(iCentreX - (iWidth / 2), iCentreY - (iHeight / 2));
                S1.setHeight(iHeight / 4);
                S1.setColor(Color.black);
                S1.draw(g);
            } else if (SuitValue == 1) {
                H1.setCenter(iCentreX - (iWidth / 2), iCentreY - (iHeight / 2));
                H1.setHeight(iHeight / 4);
                H1.setColor(Color.red);
                H1.draw(g);
            } else if (SuitValue == 2) {
                C1.setCenter(iCentreX - (iWidth / 2), iCentreY - (iHeight / 2));
                C1.setHeight(iHeight / 4);
                C1.setColor(Color.black);
                C1.draw(g);
            } else if (SuitValue == 3) {
                D1.setCenter(iCentreX - (iWidth / 2), iCentreY - (iHeight / 2));
                D1.setHeight(iHeight / 4);
                D1.setColor(Color.red);
                D1.draw(g);
            }

            Font f1 = new Font("SanSerif", Font.PLAIN, (iHeight / 5));
            if (SuitValue == 0 || SuitValue == 2) {
                g.setColor(Color.black);
            } else {
                g.setColor(Color.red);
            }
            g.setFont(f1);
            g.drawString(DisplayFace[FaceValue], iCentreX - iWidth + (iWidth / 7), iCentreY - iHeight + (iHeight / 4));
        }
        else if (faceup == 2) {
            g.setColor(Color.green);
            g.fillRect(iCentreX - iWidth, iCentreY - iHeight, iWidth, iHeight);
            g.setColor(Color.black);
            g.drawRect(iCentreX - iWidth, iCentreY - iHeight, iWidth, iHeight);
        }
        else if (faceup == 3) {

            ClubClass C1 = new ClubClass();
            DiamondClass D1 = new DiamondClass();
            HeartClass H1 = new HeartClass();
            SpadeClass S1 = new SpadeClass();

            if (SuitValue == 0) {
                S1.setCenter(iCentreX - (iWidth / 2), iCentreY - (iHeight / 2));
                S1.setHeight(iHeight / 4);
                S1.setColor(Color.black);
                S1.draw(g);
            } else if (SuitValue == 1) {
                H1.setCenter(iCentreX - (iWidth / 2), iCentreY - (iHeight / 2));
                H1.setHeight(iHeight / 4);
                H1.setColor(Color.red);
                H1.draw(g);
            } else if (SuitValue == 2) {
                C1.setCenter(iCentreX - (iWidth / 2), iCentreY - (iHeight / 2));
                C1.setHeight(iHeight / 4);
                C1.setColor(Color.black);
                C1.draw(g);
            } else if (SuitValue == 3) {
                D1.setCenter(iCentreX - (iWidth / 2), iCentreY - (iHeight / 2));
                D1.setHeight(iHeight / 4);
                D1.setColor(Color.red);
                D1.draw(g);
            }

            g.setColor(Color.black);
            g.drawRect(iCentreX - iWidth, iCentreY - iHeight, iWidth, iHeight);

        }
        else if (faceup == 4){
            Color backColor = new Color(0, 115, 50);
            g.setColor (Color.red);
            g.drawRect(iCentreX - iWidth, iCentreY - iHeight, iWidth, iHeight);
        }

    }

    public void erase(Graphics g) {
        Color cOldColor = getColor();
        g.setColor(Color.white);
        g.fillRect(iCentreX - iWidth, iCentreY - iHeight, iWidth, iHeight);
        g.setColor(cOldColor);
    }

}
