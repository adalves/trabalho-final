package core.pkg;

import java.util.Date;

/**
 *
 * @author Ana Carolina da Rocha Santos Alves
 */
public class Region extends WindowItem{
    private Vector supEsq, infDir;
    
    public Region (Vector supEsq, Vector infDir, int index) {
        if (supEsq.moreThan(infDir)) {
            Vector temp = supEsq;
            supEsq = infDir;
            infDir = temp;
        }
        this.setSupEsq(supEsq);
        this.setInfDir(infDir);
        this.creationDate = new Date();
        this.setName(index);
    }
    
    public Vector getSupEsq() {
        return supEsq;
    }

    private void setSupEsq(Vector supEsq) {
        if (supEsq.getX() < 0 || supEsq.getY() < 0 ||
            supEsq.getX() > 499 || supEsq.getY() > 499)
            throw new IllegalArgumentException("Os valores devem ser entre 0 e 499.");
        this.supEsq = supEsq;
    }

    public Vector getInfDir() {
        return infDir;
    }

    private void setInfDir(Vector infDir) {
        if (infDir.getX() < 0 || infDir.getY() < 0 ||
            infDir.getX() > 499 || infDir.getY() > 499)
            throw new IllegalArgumentException("Os valores devem ser entre 0 e 499.");
        this.infDir = infDir;
    }
    
    public boolean contains (Vector point) {
        return (point.getX() >= supEsq.getX() &&
                point.getX() <= infDir.getX() &&
                point.getY() >= supEsq.getY() &&
                point.getY() <= infDir.getY());
    }
           
    protected void setName(int index) {
        this.name = "Região " + (char)(65 + index);
    }
    
    public double distanceTo(Vector point) {
        if (contains(point)) return 0;
        else
            return (Vector.distance(supEsq, point));
    }
    
    @Override
    public String toString() {
        return "Região {(" + getSupEsq() + "), (" + getInfDir() + ")}, criada em " + getCreationDate();
    }
}
