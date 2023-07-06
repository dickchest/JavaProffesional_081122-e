package homework.extraHomework5.fermer;

public class AppleRedColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor());
    }
}
