package core;

import java.util.Date;

/**
 *
 * @author Ana Carolina da Rocha Santos Alves
 */
public abstract class WindowItem {
    protected Date creationDate;
    protected String name;
    
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public String getName() {
        return this.name;
    }
    protected abstract void setName(int index);
    
    public abstract double distanceTo(Vector point);
    
    @Override
    public abstract String toString();
}
