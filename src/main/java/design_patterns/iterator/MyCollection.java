package design_patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class MyCollection <T>
{
    List<T> elements = new ArrayList<>();

    MyIterator<T> iterator() {
        return new MyIterator<>(this);
    };

    public void add(T element) {
        elements.add(element);
    }

    public void remove(T element) {
        elements.remove(element);
    }

    public int size() {
        return elements.size();
    }

    public T get(int index) {
        return elements.get(index);
    }
}
