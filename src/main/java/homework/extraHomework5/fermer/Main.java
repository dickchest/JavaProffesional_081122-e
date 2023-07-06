package homework.extraHomework5.fermer;

public class Main {
    public static void main(String[] args) {
        FruitStorage fruitStorage = new FruitStorage();
        var list = fruitStorage.getAllApples();
        System.out.println(fruitStorage.getAllGreenApples());
        System.out.println(fruitStorage.getAllRedApples());
        System.out.println(fruitStorage.findApplesByColor(list, "green"));
        System.out.println(fruitStorage.findApples(list, new AppleGreenColorPredicate()));
        System.out.println(fruitStorage.findApples(list, new AppleRedColorPredicate()));
        System.out.println(fruitStorage.findApples(list, new AppleHeavyWeightPredicate()));
        System.out.println(fruitStorage.findApples(list, new AppleLightWeightPredicate()));


    }
}
