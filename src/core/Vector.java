package core;

import java.lang.Math;

/**
 *
 * @author Ana Carolina da Rocha Santos Alves
 */
public class Vector implements Comparable<Vector> {
    private int x, y;
    
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean lessThan (Vector other) {
        return (this.compareTo(other) < 0);
    }
    
    public boolean equals (Vector other) {
        return (this.compareTo(other) == 0);
    }
    
    public boolean moreThan (Vector other) {
        return (this.compareTo(other) > 0);
    }
    
    @Override
    public int compareTo(Vector other) {
        if (this.getX() < other.getX() ||
            (this.getX() == other.getX() && this.getY() < other.getY()))
            return -1;
        else if (this.getX() == other.getX() &&
                 this.getY() == other.getY())
            return 0;
        else
            return 1;
    }
    
    @Override
    public String toString() {
        return getX() + "," + getY();
    }
    
    public static double distance (Vector vector1, Vector vector2) {
        double x = vector2.getX() - vector1.getX();
        x = Math.pow(x, 2);
        double y = vector2.getY() - vector1.getY();
        y = Math.pow(y, 2);
        double result = x + y;
        return Math.sqrt(result);
    }
}
