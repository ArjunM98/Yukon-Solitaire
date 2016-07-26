
import java.awt.*;

abstract class ShapeClass

{
    // Global Variables
    public int iWidth = 80;
    public int iHeight = 100;
    public int iCentreX = 100;
    public int iCentreY = 100;
    public Color cColor = Color.red;

    // Comincator Methods
    public void setWidth(int iNewWidth) {
        iWidth = iNewWidth;
    }


    public void setHeight(int iNewHeight) {
        iHeight = iNewHeight;
    }


    public void setCenter(int iNewCentreX, int iNewCentreY) {
        iCentreX = iNewCentreX;
        iCentreY = iNewCentreY;
    }


    public void setColor(Color cNewColor) {

        cColor = cNewColor;
    }


    public int getWidth() {
        return iWidth;
    }


    public int getHeight() {
        return iHeight;
    }


    public int getCenterX() {
        return iCentreX;
    }


    public int getCenterY() {
        return iCentreY;
    }


    public Color getColor() {
        return cColor;
    }


    //Deferred Draw

    public abstract void draw(Graphics g);

    public void erase(Graphics g) {
        Color cOldColor = getColor();
        setColor(Color.white);
        draw(g);
        setColor(cOldColor);
    }

    //Delay
    public void delay(int iDelayTime) {
        long lFinalTime = System.currentTimeMillis() + iDelayTime;
        do {
        }
        while (lFinalTime >= System.currentTimeMillis());
    }
}



