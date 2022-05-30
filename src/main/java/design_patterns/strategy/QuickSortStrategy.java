package design_patterns.strategy;

import java.util.List;

public class QuickSortStrategy implements SortStrategy
{
    @Override
    public List<Integer> sort(List<Integer> list)
    {
        list.sort(Integer::compareTo);
        return list;
    }
}
