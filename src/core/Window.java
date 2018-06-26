package core;

import java.util.ArrayList;
/**
 *
 * @author Ana Carolina da Rocha Santos Alves
 */
public class Window {
    private static Window instance = null;
    ArrayList<Region> regions = new ArrayList();
    int regionIndex = 0;
    ArrayList<Icon> icons = new ArrayList();
    int iconIndex = 0;
    ArrayList<MouseClick> clicks = new ArrayList();
    private double iconSize;
    
    private Window(){}
    
    public static Window getInstance() {
        if (instance == null)
            instance = new Window();
        return instance;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public ArrayList<Icon> getIcons() {
        return icons;
    }

    public ArrayList<MouseClick> getClicks() {
        return clicks;
    }
    
    public double getIconSize() {
        return iconSize;
    }

    public void setIconSize(double iconSize) {
        if (iconSize < 0 || iconSize == 0)
            throw new IllegalArgumentException("O tamanho dos ícones não pode "
                                               + "ser menor ou igual a zero.");
        this.iconSize = iconSize;
    }
    
    public Region addRegion(int x1, int y1, int x2, int y2) {
        Region region = new Region(new Vector(x1, y1), new Vector(x2, y2), regionIndex);
        regions.add(region);
        ++regionIndex;
        return region;
    }
    
    public void removeRegion(Region region) {
        regions.remove(region);
    }
    
    public Icon addIcon(int x, int y) {
        Icon icon = new Icon(new Vector(x,y), iconIndex);
        icons.add(icon);
        ++iconIndex;
        return icon;
    }
    
    public void removeIcon(Icon icon) {
        icons.remove(icon);
    }
    
    public MouseClick addClick(int x, int y) {
        Vector point = new Vector(x, y);
        WindowItem selectedItem = selectItem(point);
        MouseClick click = new MouseClick(point, selectedItem);
        clicks.add(click);
        return click;
    }
        
    private WindowItem selectItem (Vector point) {
        
        WindowItem item = selectRegion(point);
        
        if (item == null)
            item = selectIcon(point);
        
        if (item == null)
            throw new IllegalArgumentException ("Nenhum item selecionado.");
        return item;
    }
    
    private WindowItem selectRegion(Vector point) {
        for (int i = regions.size() - 1; i >= 0; --i) {
            if (regions.get(i).contains(point))
                return regions.get(i);
        }
        return null;
    }
    
    private WindowItem selectIcon(Vector point) {
        if (icons.isEmpty())
            return null;
        
        Icon icon = icons.get(0);
        double minDistance = icon.distanceTo(point);
        double currDistance;
        for (int i = 0; i < icons.size(); ++i) {
            currDistance = icons.get(i).distanceTo(point);
            if (currDistance < minDistance && isVisible(icons.get(i))) {
                minDistance = currDistance;
                icon = icons.get(i);
            }
        }
        return icon;
    }
    
    private boolean isVisible(Icon icon) {
        for (Region region : regions) {
            if (region.contains(icon.getCenter()))
                return false;
                
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        String string = "";
        for (MouseClick click : clicks) {
            string += click + "\n";
        }
        return string;
    }
    
}
