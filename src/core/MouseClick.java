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
        this.setDistance(selectedItem);
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

    public double getDistance() {
        return distance;
    }
    
    private void setDistance(WindowItem item) {
        if (item == null) this.distance = 0;
        else
            this.distance = item.distanceTo(this.center);
    }
    
    public Date getCreationDate() {
        return creationDate;
    }

    public WindowItem getSelectedItem() {
        return selectedItem;
    }
    
    public String printSelectedItem() {
        String item;
        if (getSelectedItem() == null) item = "Nenhum item selecionado";
        else item = getSelectedItem().getName();
        return item;
    }
    
    @Override
    public String toString() {
        
        return String.format("%-32s%-13s%-28s%-10f", getCreationDate(), "(" + getCenter() + ")", 
                printSelectedItem(), getDistance());//.replace(" ", "_");
    }
}
