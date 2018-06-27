package core;

/**
 *
 * @author Ana Carolina da Rocha Santos Alves
 */
public class Region extends WindowItem{
    private Vector topLeft, bottomRight;
    
    public Region (Vector topLeft, Vector bottomRight, int index) {
        if (topLeft.moreThan(bottomRight)) {
            Vector temp = topLeft;
            topLeft = bottomRight;
            bottomRight = temp;
        }
        this.setTopLeft(topLeft);
        this.setBottomRight(bottomRight);
        this.setName(index);
    }
    
    public Vector getTopLeft() {
        return topLeft;
    }

    private void setTopLeft(Vector topLeft) {
        if (topLeft.getX() < 0 || topLeft.getY() < 0 ||
            topLeft.getX() > 499 || topLeft.getY() > 499)
            throw new IllegalArgumentException("Os valores devem ser entre 0 e 499.");
        this.topLeft = topLeft;
    }

    public Vector getBottomRight() {
        return bottomRight;
    }

    private void setBottomRight(Vector bottomRight) {
        if (bottomRight.getX() < 0 || bottomRight.getY() < 0 ||
            bottomRight.getX() > 499 || bottomRight.getY() > 499)
            throw new IllegalArgumentException("Os valores devem ser entre 0 e 499.");
        this.bottomRight = bottomRight;
    }
    
    public boolean contains (Vector point) {
        return (point.getX() >= topLeft.getX() &&
                point.getX() <= bottomRight.getX() &&
                point.getY() >= topLeft.getY() &&
                point.getY() <= bottomRight.getY());
    }
           
    protected void setName(int index) {
        this.name = "Região " + (char)(65 + index);
    }
    
    public double distanceTo(Vector point) {
        if (contains(point)) return 0;
        else
            return (topLeft.distanceTo(point));
    }
    
    @Override
    public String toString() {
        return getName() + " (" + getTopLeft() + "), (" + getBottomRight() + ")";
    }
}
