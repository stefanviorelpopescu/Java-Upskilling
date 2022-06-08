package design_patterns.iterator;

public class IteratorExample
{
    public static void main(String[] args)
    {
        MyCollection<String> fruits = new MyCollection<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Strawberry");

        MyIterator<String> fruitIterator = fruits.iterator();

        while(fruitIterator.hasNext()) {
            String fruit = fruitIterator.next();
            System.out.println(fruit);
        }
    }
}
