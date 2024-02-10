package list7;

/**
 * Represents two-dimensional vector
 */
public class Vector2D {
    protected double x;
    protected double y;

    /**
     * Initializes vector
     * @param x x coordinate
     * @param y y coordinate
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Adds two vectors
     * @param secondVector vector to add
     * @return result of addition
     */
    public Vector2D add (Vector2D secondVector) {
        double x3 = x + secondVector.x;
        double y3 = y + secondVector.y;
        return new Vector2D (x3, y3);
    }

    /**
     * Adds two vectors
     * @param first first vector to add
     * @param second second vector to add
     * @return result of addition
     * @param <T> type of vector
     */
    public static <T extends Vector2D> T add(T first, Vector2D second) {
        return (T) first.add(second);
    }

    /**
     * Subtracts two vectors
     * @param secondVector vector to subtract
     * @return result of subtraction
     */
    public Vector2D subtract (Vector2D secondVector) {
        double x3 = x - secondVector.x;
        double y3 = y - secondVector.y;
        return new Vector2D(x3, y3);
    }

    /**
     * Subtracts two vectors
     * @param first vector to be subtracted from
     * @param second vector to subtract
     * @return result of subtraction
     * @param <T> type of vector
     */
    public static <T extends Vector2D> T subtract(Vector2D first, Vector2D second) {
        return (T) first.add(second);
    }

    /**
     * multiply vector by number
     * @param a number to multiply by
     * @return result of multiplication
     */
    public Vector2D multiply (double a) {
        double x2 = x * a;
        double y2 = y * a;
        return new Vector2D(x * a, y * a);
    }

    /**
     * multiply vector by number
     * @param first vector to be multiplied
     * @param a number to multiply by
     * @return result of multiplication
     * @param <T> type of vector
     */
    public static <T extends Vector2D> T multiply(Vector2D first, double a) {
        return (T) first.multiply(a);
    }

    /**
     * Returns length of the vector
     * @return length of the vector
     */
    public double length () {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
     * Returns angle between X axis and vector
     * @return angle between X axis and vector
     */
    public double angle () {
        return Math.atan(y/x);
    }

    /**
     * Returns coordinates of vector, from given polar coordinates
     * @param length length of the vector
     * @param angle angle between vector and X axis
     * @return coordinates in form of an array [x, y], where x is first coordinate and y - second
     */
    public static double[] CoordinatesFromPolar(double length, double angle) {
        double[] result = new double[2];
        result[0] = length *  Math.cos(angle);
        result[1] = length * Math.sin(angle);
        return result;
    }

    /**
     * Getter for x field
     * @return x filed
     */
    public double getX() {
        return x;
    }

    /**
     * Setter for x field
     * @param x new x value
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter for y field
     * @return y filed
     */
    public double getY() {
        return y;
    }

    /**
     * Setter for y field
     * @param y new y value
     */
    public void setY(double y) {
        this.y = y;
    }
}

