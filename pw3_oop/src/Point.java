// Exercise 1 – First class: Point and Segment

/**
 * Class representing a 2D Point in Euclidean space.
 */
public class Point {
    // Exercise 1.1 - Private attributes x and y
    private float x;
    private float y;

    // Exercise 1.2 - Constructor to initialize x and y
    /**
     * Constructs a Point object with coordinates (x, y).
     * 
     * @param x The x-coordinate
     * @param y The y-coordinate
     */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Exercise 1.3 - Getters and Setters
    /**
     * Gets the x-coordinate.
     * @return x value
     */
    public float getX() {
        return x;
    }

    /**
     * Sets the x-coordinate.
     * @param x New x value
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate.
     * @return y value
     */
    public float getY() {
        return y;
    }

    /**
     * Sets the y-coordinate.
     * @param y New y value
     */
    public void setY(float y) {
        this.y = y;
    }

    // Exercise 1.4 - Distance from origin
    /**
     * Calculates the distance from this point to the origin (0, 0).
     * @return Euclidean distance from origin
     */
    public float distance() {
        return (float)Math.sqrt(x * x + y * y);
    }

    // Exercise 1.5 - Distance to another point
    /**
     * Calculates the Euclidean distance to another point.
     * @param point The other Point
     * @return Distance between this point and the given point
     */
    public float distance(Point point) {
        float dx = this.x - point.x;
        float dy = this.y - point.y;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }

    /*
     * Answer to Exercise 1.5a:
     * Yes, the method distance() is overloaded because we have two methods with the same name but different parameters.
     * 
     * Answer to Exercise 1.5b:
     * Overloading means defining multiple methods with the same name but different parameters in the same class.
     * Overriding means redefining a method inherited from a superclass in a subclass with the same signature.
     */

    // Exercise 1.6 - Translate point
    /**
     * Translates this point by (dx, dy).
     * @param dx Displacement along x-axis
     * @param dy Displacement along y-axis
     */
    public void translate(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    // Exercise 1.7 - Barycenter
    /**
     * Calculates the barycenter (center of mass) of an array of points.
     * This should be static because it doesn't depend on any particular instance of Point.
     * 
     * @param points Array of Point objects
     * @return The barycenter as a new Point
     */
    public static Point barycenter(Point[] points) {
        if (points == null || points.length == 0) {
            return new Point(0, 0); // default if no points provided
        }
        float sumX = 0;
        float sumY = 0;
        for (Point p : points) {
            sumX += p.getX();
            sumY += p.getY();
        }
        return new Point(sumX / points.length, sumY / points.length);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}



