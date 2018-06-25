package core;

import java.util.Date;

/**
 *
 * @author Ana Carolina da Rocha Santos Alves
 */
public class MouseClick {
    private Vector center;
    private Date creationDate;
    private WindowItem selectedItem;
    private double distance;

    public MouseClick(Vector center, WindowItem selectedItem) {
        this.setCenter(center);
        this.selectedItem = selectedItem;
        this.distance = this.selectedItem.distanceTo(this.center);
        this.creationDate = new Date();
    }

    public Vector getCenter() {
        return center;
    }

    private void setCenter(Vector center) {
        if (center.getX() < 0 || center.getY() < 0 ||
            center.getX() > 499 || center.getY() > 499)
            throw new IllegalArgumentException("Os valores devem ser entre 0 e 499.");
        this.center = center;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public WindowItem getSelectedItem() {
        return selectedItem;
    }

    public double getDistance() {
        return distance;
    }
    
    @Override
    public String toString() {
        return getCreationDate() + " " + getCenter() + " " + 
                getSelectedItem().getName() + " " + getDistance();
    }
}
