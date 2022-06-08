package design_patterns.iterator;

/**
 * Iterator Design pattern
 * @param <T> collection type
 */
public class MyIterator <T>
{
    MyCollection<T> iterableCollection;
    int position = 0;

    public MyIterator(MyCollection<T> collection)
    {
        this.iterableCollection = collection;
    }

    public boolean hasNext() {
        return position < iterableCollection.size();
    }

    public T next() {
        return iterableCollection.get(position++);
    }
}
