package JavaProfessionalCourse2.Lesson19.Generics.Generics2;

public class BoxUtil {
    BoxUniversal<Paper> boxForPaper = new BoxUniversal<>(new Paper());

    BoxUniversal<Plastic> boxForPlastic = new BoxUniversal<>(new Plastic());

    BoxTwoCell<Paper, Plastic> bigBox1 = new BoxTwoCell<>();
    BoxTwoCell<Plastic, Glass> bigBox2 = new BoxTwoCell<>();
}
