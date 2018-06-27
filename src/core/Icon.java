package core;

/**
 *
 * @author Ana Carolina da Rocha Santos Alves
 */
public class Icon extends WindowItem{
    private Vector center;
    
    public Icon (Vector center, int index) {
        this.setCenter(center);
        this.setName(index);
    }

    public Vector getCenter() {
        return center;
    }

    private void setCenter(Vector center) {
        double size = Window.getInstance().getIconSize()/2;
        if (center.getX() < size || center.getY() < size ||
            center.getX() > 499 - size || center.getY() > 499 - size)
            throw new IllegalArgumentException("Os valores devem ser entre " + size
                                                + " e " + (499 - size) + ".");
        this.center = center;
    }
       
    protected void setName(int index) {
        this.name = "Ícone " + (1 + index);
    }
    
    public double distanceTo(Vector point) {
        return (center.distanceTo(point));
    }
        
    @Override
    public String toString() {
        return getName() + " (" + center + ")";
    }
}
