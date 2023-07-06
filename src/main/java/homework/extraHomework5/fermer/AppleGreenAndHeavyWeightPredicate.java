package homework.extraHomework5.fermer;

public class AppleGreenAndHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
