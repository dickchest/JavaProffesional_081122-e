package javaProfessionalCourse2.lesson19_generic_optional.homeworkOptional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
8)  Напишите метод, который получает HashMap, и возвращает Optional
    с наибольшим значением, связанным с любым ключом в HashMap.
 */
public class Exerecise8 {
    public static <K, V extends Comparable> Optional<V> getMaxFromMap(Map<K, V> map) {
        return map
                .values()
                .stream()
                .max(Comparable::compareTo);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, Integer> hashMap1 = new HashMap<>();
        hashMap.put("key1", 10);
        hashMap.put("key2", 5);
        hashMap.put("key3", 15);

        Optional<Integer> maxValue = getMaxFromMap(hashMap);
        Optional<Integer> maxValue1 = getMaxFromMap(hashMap1);

        String result = maxValue.isPresent() ? maxValue.get().toString() : "Hashmap is empty";
        System.out.println(result);

        String result1 = maxValue1.isPresent() ? maxValue1.get().toString() : "Hashmap is empty";
        System.out.println(result1);

    }
}
