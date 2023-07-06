package homework.extraHomework5.task1;

import homework.extraHomework5.fermer.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.List;

class FruitStorageTest {
        FruitStorage fruitStorage = new FruitStorage();
        List<Apple> inventory = fruitStorage.getAllApples();


    @Test
    void testGetAllGreenApples() {
        List<Apple> appleList = fruitStorage.getAllGreenApples();
        for (Apple apple : appleList) {
            Assert.assertEquals("green", apple.getColor());
        }
    }

    @Test
    void testGetAllRedApples() {
        List<Apple> redAppleList = fruitStorage.getAllRedApples();
        for (Apple apple : redAppleList) {
            Assert.assertEquals("red", apple.getColor());
        }
    }

    @Test
    void testFindAppleByColor() {
        String color = "red";
        List<Apple> appleTestList = fruitStorage.findApplesByColor(fruitStorage.getAllApples(), color);
        for (Apple apple : appleTestList) {
            Assert.assertEquals(color, apple.getColor());
        }
    }

    @Test
    void testFindAllApplesGreen() {
        String color = "green";
        var appleTestList = fruitStorage.findApples(inventory, new AppleGreenColorPredicate());
        appleTestList.stream()
                .forEach(x -> Assert.assertEquals(color, x.getColor()));
    }

    @Test
    void testFindAllApplesRed() {
        String color = "red";
        var appleTestList = fruitStorage.findApples(inventory, new AppleRedColorPredicate());
        appleTestList.stream()
                .forEach(x -> Assert.assertEquals(color, x.getColor()));
    }

    @Test
    void testFindAllHeavyApples() {
        int weight = 150;
        var appleTestList = fruitStorage.findApples(inventory, new AppleHeavyWeightPredicate());
        appleTestList.stream()
                .forEach(x -> Assert.assertTrue(x.getWeight() > weight));
    }

    @Test
    void testFindAllLightApples() {
        int weight = 150;
        var appleTestList = fruitStorage.findApples(inventory, new AppleLightWeightPredicate());
        appleTestList.stream()
                .forEach(x -> Assert.assertTrue(x.getWeight() < weight));
    }
}