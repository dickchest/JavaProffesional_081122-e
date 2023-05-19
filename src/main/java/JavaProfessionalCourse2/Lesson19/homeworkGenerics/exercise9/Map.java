package JavaProfessionalCourse2.Lesson19.homeworkGenerics.exercise9;

import java.util.ArrayList;
import java.util.List;

/*
9)  Создайте класс Map для хранения пар ключ-значение. Реализуйте методы
    put(), get() и remove(). Используйте Generics для обеспечения
    типобезопасности и возможности хранения в Map объектов разных типов.
 */
public class Map <K,V>{

    private List<Entry<K,V>> entries;

    public Map() {
        entries = new ArrayList<>();
    }

    public void put(K key, V value) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        entries.add(new Entry<>(key, value));
    }

    public V get(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean remove(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                entries.remove(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return entries + "";
    }

    private class Entry  <K,V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
