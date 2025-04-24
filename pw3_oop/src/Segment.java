// Exercise 1.8 - Segment class
/**
 * Class representing a segment between two points.
 */
class Segment {
    private Point p1;
    private Point p2;

    // Exercise 1.8a - Getters and setters
    /**
     * Gets the first endpoint of the segment.
     * @return Point p1
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Sets the first endpoint of the segment.
     * @param p1 Point to set
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * Gets the second endpoint of the segment.
     * @return Point p2
     */
    public Point getP2() {
        return p2;
    }

    /**
     * Sets the second endpoint of the segment.
     * @param p2 Point to set
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    // Exercise 1.8b - Constructor for segment
    /**
     * Constructs a Segment with two endpoints.
     * @param p1 First point
     * @param p2 Second point
     */
    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // Exercise 1.9 - Segment length
    /**
     * Calculates the length of the segment using the distance between the endpoints.
     * @return Length of the segment
     */
    public float length() {
        // Yes, this method delegates the distance calculation to the Point class,
        // promoting code reuse and clarity.
        return p1.distance(p2);
    }

    @Override
    public String toString() {
        return "Segment[" + p1 + " to " + p2 + "]";
    }
}