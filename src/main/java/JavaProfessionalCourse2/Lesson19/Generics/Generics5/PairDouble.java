package JavaProfessionalCourse2.Lesson19.Generics.Generics5;

public class PairDouble {
    private Double x;
    private Double y;

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public PairDouble(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "PairInteger{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
