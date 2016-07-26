
import java.awt.*;

class DiamondClass extends SuitClass {


    //Constructor Class
    DiamondClass() {
    }

    // communicator methods
    public void draw(Graphics g) {
        // declare two arrays for X & Y coordinates of Diamond
        int iPointsX[] = new int[4];
        int iPointsY[] = new int[4];

        // calculate points on diamond & store in the arrays
        iPointsX[0] = iCentreX - iWidth / 2;
        iPointsY[0] = iCentreY;
        iPointsX[1] = iCentreX;
        iPointsY[1] = iCentreY - iHeight / 2;
        iPointsX[2] = iCentreX + iWidth / 2;
        iPointsY[2] = iCentreY;
        iPointsX[3] = iCentreX;
        iPointsY[3] = iCentreY + iHeight / 2;

        // draw the diamond using methods available from the Console object (c)
        g.setColor(cColor);
        g.fillPolygon(iPointsX, iPointsY, 4);


    }

}
