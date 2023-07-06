package homework.extraHomework5.fermer;

public class AppleLightWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() < 150;
    }
}
