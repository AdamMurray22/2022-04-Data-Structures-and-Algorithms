import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class MergeSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MergeSort<E>
{
    public List<E> mergeSort(List<E> elements)
    {
        if (elements == null ||elements.size() <= 1)
        {
            return elements;
        }
        Pair<List<E>> parts = partition(elements, elements.size() / 2);
        List<E> elems1 = mergeSort(parts.getE1());
        List<E> elems2 = mergeSort(parts.getE2());
        return merge(elems1, elems2);
    }
    
    private Pair<List<E>> partition(List<E> elements, int newSize)
    {
        List<E> elems1 = new ArrayList<>(newSize);
        List<E> elems2 = new ArrayList<>(newSize);
        for (int i = 0; i < elements.size(); i++)
        {
            if (i < newSize)
            {
                elems1.add(elements.get(i));
            }
            else
            {
                elems2.add(elements.get(i));
            }
        }
        return new Pair<List<E>>(elems1, elems2);
    }
    
    private List<E> merge(List<E> elems1, List<E> elems2)
    {
        int newSize = elems1.size() + elems2.size();
        List<E> mergedList = new ArrayList<>(newSize);
        for (int i = 0; i < newSize; i++)
        {
            if (elems1.size() == 0)
            {
                mergedList.add(elems2.remove(0));
            }
            if (elems2.size() == 0 || elems1.get(0).hashCode() < elems2.get(0).hashCode())
            {
                mergedList.add(elems1.remove(0));
            }
            else
            {
                mergedList.add(elems2.remove(0));
            }
        }
        return mergedList;
    }
}
