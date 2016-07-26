
abstract class SuitClass extends ShapeClass{

    public void setWidth (int iNewWidth)
    {
        iHeight = (5 * iNewWidth) / 4;
        iWidth = iNewWidth;
    }

    public void setHeight (int iNewHeight)
    {
        iHeight = iNewHeight;
        iWidth = (4 * iNewHeight) / 5;
    }
}
