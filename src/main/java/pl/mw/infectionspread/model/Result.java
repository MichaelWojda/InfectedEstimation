package pl.mw.infectionspread.model;

public class Result {

    private double intercept;
    private double slope;
    private int estimatedValue;

    public Result(double intercept, double slope, int estimatedValue) {
        this.intercept = intercept;
        this.slope = slope;
        this.estimatedValue = estimatedValue;
    }

    public double getIntercept() {
        return intercept;
    }

    public void setIntercept(double intercept) {
        this.intercept = intercept;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public double getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(int estimatedValue) {
        this.estimatedValue = estimatedValue;
    }
}
