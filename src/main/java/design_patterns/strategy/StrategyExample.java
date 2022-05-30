package design_patterns.strategy;

import java.util.Arrays;
import java.util.List;

public class StrategyExample
{
    public static List<Integer> sortList(SortStrategy sortStrategy, List<Integer> list) {
        return sortStrategy.sort(list);
    }

    public static void main(String[] args)
    {
        System.out.println(sortList(new QuickSortStrategy(), Arrays.asList(2, 1, 3)));
        System.out.println(sortList(new BubbleSortStrategy(), Arrays.asList(2, 1, 3)));
    }
}
