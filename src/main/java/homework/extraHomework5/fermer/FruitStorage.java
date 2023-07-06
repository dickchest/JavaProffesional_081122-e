package homework.extraHomework5.fermer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitStorage {
    public List<Apple> getAllApples() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red", 100));
        apples.add(new Apple("red", 160));
        apples.add(new Apple("red", 200));
        apples.add(new Apple("green", 200));
        apples.add(new Apple("green", 90));
        apples.add(new Apple("green", 50));
        apples.add(new Apple("yellow", 50));
        apples.add(new Apple("yellow", 170));
        return apples;
    }

    public List<Apple> getAllGreenApples() {
        List<Apple> greenApples = getAllApples().stream()
                .filter(x -> x.getColor().equals("green"))
                .collect(Collectors.toList());
        return greenApples;
    }

    public List<Apple> getAllRedApples() {
        List<Apple> redApples = getAllApples().stream()
                .collect(Collectors.filtering(
                        x -> x.getColor().equals("red"),
                        Collectors.toList()
                ));
        return redApples;
    }

    public List<Apple> findApplesByColor(List<Apple> list, String color) {
        List<Apple> result = list.stream()
                .collect(Collectors.filtering(
                        x -> x.getColor().equals(color),
                        Collectors.toList()
                ));
        return result;
    }

    public List<Apple> findApplesByWeight(List<Apple> list, int weight) {
        List<Apple> result = list.stream()
                .filter(x -> x.getWeight() > weight)
                .collect(Collectors.toList());
        return result;
    }

    public List<Apple> findApples (List<Apple> list, ApplePredicate predicate) {
        List<Apple> result = list.stream()
                .filter(x -> predicate.test(x))
                .collect(Collectors.toList());
        return result;
    }
}
