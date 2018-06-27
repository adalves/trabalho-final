package core;

import java.util.ArrayList;
/**
 *
 * @author Ana Carolina da Rocha Santos Alves
 */
public class Window {
    private static Window instance = null;
    private ArrayList<Region> regions = new ArrayList();
    private int regionIndex = 0;
    private ArrayList<Icon> icons = new ArrayList();
    private int iconIndex = 0;
    private ArrayList<MouseClick> clicks = new ArrayList();
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
    
    public String printRegions() {
        if (regions.isEmpty()) return "Nenhuma região registrada.\n\n";
        String str = "Regiões: \n\n";
        for (Region region : regions) {
            str += region + "\n";
        }
        return str + "\n\n";
    }

    public ArrayList<Icon> getIcons() {
        return icons;
    }

    public String printIcons() {
        if (icons.isEmpty()) return "Nenhum ícone registrado.\n\n";
        String str = "Ícones: \n\n";
        for (Icon icon : icons) {
            str += icon + "\n";
        }
        return str + "\n\n";
    }
    
    public ArrayList<MouseClick> getClicks() {
        return clicks;
    }
    
    public double getIconSize() {
        return iconSize;
    }

    public void setIconSize(double iconSize) {
        if (iconSize <= 0 || iconSize >= 499)
            throw new IllegalArgumentException("O valor deve ser maior que 0 e menor que 499.");
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
        if (clicks.isEmpty()) return "Nenhum clique registrado.";
        String string = String.format("%-10s%-23s%-15s%-25s%-10s\n\n", " ", "Data/Hora", "Clique", "Item selecionado", "Distância");
        for (MouseClick click : clicks) {
            string += click + "\n";
        }
        return string;
    }
    
}
