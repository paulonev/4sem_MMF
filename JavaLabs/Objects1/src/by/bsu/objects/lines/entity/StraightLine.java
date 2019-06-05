package by.bsu.objects.lines.entity;

public class StraightLine{
    private int coefA;
    private int coefB;
    private int coefC;

    public StraightLine(int coefA, int coefB, int coefC) {
        this.coefA = coefA;
        this.coefB = coefB;
        this.coefC = coefC;
    }

    public int getCoefA() {
        return coefA;
    }

    public void setCoefA(int coefA) {
        this.coefA = coefA;
    }

    public int getCoefB() {
        return coefB;
    }

    public void setCoefB(int coefB) {
        this.coefB = coefB;
    }

    public int getCoefC() {
        return coefC;
    }

    public void setCoefC(int coefC) {
        this.coefC = coefC;
    }

    @Override
    public String toString() {
        String result = getBlock(this.coefA, "x", true);
        result = result.concat(getBlock(this.coefB, "y", this.coefA == 0));
        result = result.concat(getBlock(this.coefC, "", this.coefA == 0 && this.coefB == 0));
        return result.concat(" = 0");
    }

    private String getBlock(int number, String prefix, boolean first) {
        String result = "";
        if (number != 0) {
            if (first) {
                result = String.format("%d%s", number, prefix);
            } else {
                String sign = number < 0 ? "-" : "+";
                result = String.format(" %s %d%s", sign, Math.abs(number), prefix);
            }
        }
        return result;
    }


    /** If A = 0 then x = const, it means that line is parallel to Oy
     * @return  No intersections or coordinates of intersection point
     */
    public String getPointIntersectionWithX() {
        if(coefA == 0) return "No intersection";
        return String.format("{%.2f, 0}", (double) -this.coefC / (double) this.coefA);
    }


    /** If B = 0 then y = const, it means that line is parallel to Ox
     * @return  No intersections or coordinates of intersection point
     */
    public String getPointIntersectionWithY() {
        if(coefB == 0) return "No intersection";
        return String.format("{0, %.2f}", (double) -this.coefC / (double) this.coefB);
    }

    /**Theory of analytical geometry says that
     * 2 lines are parallel if this expression is true
     * A(1)/A(2) = B(1)/B(2) != C(1)/C(2)
     * @param line  second line
     * @return  true - if parallel, false - otherwise
     */
    public boolean areParallel(StraightLine line) {
        //A(1)B(2) - A(2)B(1) = 0
        if(this.coefC == line.coefC && this.coefC == 0)
            return (this.coefA*line.coefB == line.coefA*this.coefB);
        else {
            return (this.coefA * line.coefB == line.coefA * this.coefB &&
                    (this.coefB * line.coefC != line.coefB * this.coefC ||
                            this.coefA * line.coefC != line.coefA * this.coefC));
        }
    }

    /**This method defines whether lines are the same or not
     * Coefficients should be proportional A(1)/A(2) = B(1)/B(2) = C(1)/C(2)
     * @param line  second line
     * @return  true - if the same, false - otherwise
     */
    public boolean areEqual(StraightLine line) {
        //A(1)B(2) - A(2)B(1) = 0 AND B(1)C(2)-B(2)C(1) = 0
        return (this.coefA*line.coefB - line.coefA*this.coefB == 0 &&
                this.coefB*line.coefC - line.coefB*this.coefC == 0 &&
                this.coefA*line.coefC - line.coefA*this.coefC == 0);
    }

    /**This function calculates coordinates of intersection point of 2 lines
     *
     * @param line  second line
     * @return      infinitely many, none, {x,y}
     */
    public String getLinesIntersection(StraightLine line) {
        String result = null;
        if (line != null) {
            if (areEqual(line)) {
                result = "Lines are the same. Infinitely many common points.";
            } else if (areParallel(line)) {
                result = "Lines are parallel.";
            } else {
                //x = [B(1)C(2) - B(2)C(1)]/[A(1)B(2)-A(2)B(1)]
                //y = [A(2)C(1) - A(1)C(2)]/[A(1)B(2)-A(2)B(1)]
                double x = (this.coefB*line.coefC - line.coefB*this.coefC) / (double)(this.coefA * line.coefB - line.coefA * this.coefB);
                double y = (line.coefA * this.coefC - this.coefA * line.coefC) / (double) (this.coefA * line.coefB - line.coefA * this.coefB);
                result = String.format("Intersection point: {%.2f, %.2f};", x, y);
            }
        }
        return result;
    }

}
