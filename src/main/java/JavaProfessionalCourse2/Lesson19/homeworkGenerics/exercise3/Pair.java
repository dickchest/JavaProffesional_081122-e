package JavaProfessionalCourse2.Lesson19.homeworkGenerics.exercise3;
/*
3)  Создайте класс Pair с двумя полями - first и second, и реализуйте
    методы getFirst() и getSecond() для доступа к этим полям.
    Используйте Generics для возможности хранения в Pair объектов
    разных типов.
 */
public class Pair <F,S>{
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
