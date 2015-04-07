public class Dart {
    private double x; 
    private double y;

    public Dart() {
        this.x = Math.random() * (Math.random() > .5 ? +1 : -1);
        this.y = Math.random() * (Math.random() > .5 ? +1 : -1);
    }

    public boolean onBoard() {
        return Math.pow(this.x,2) + Math.pow(this.y,2) <= 1;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }
}
