package JavaProfessionalCourse2.Lesson19.Generics.Generics5;

public class PairInteger {
    private Integer x;
    private Integer y;

    public PairInteger(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "PairInteger{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
