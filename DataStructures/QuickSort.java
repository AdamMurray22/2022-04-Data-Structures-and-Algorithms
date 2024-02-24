import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class QuickSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuickSort<E>
{
    public int[] sort(int[] elements)
    {
        return inPlace(elements, 0, elements.length - 2, elements.length - 1);
    }
    
    public List<E> partition(List<E> elements, int pivot)
    {
        if (elements.size() <= 1)
        {
            return elements;
        }
        List<E> elemsLess = new ArrayList<E>();
        List<E> elemsEqual = new ArrayList<E>();
        List<E> elemsGreater = new ArrayList<E>();
        E pivotElem = elements.remove(pivot);
        elemsEqual.add(pivotElem);
        while (elements.size() > 0)
        {
            E nextElem = elements.remove(0);
            if (nextElem.hashCode() < pivotElem.hashCode())
            {
                elemsLess.add(nextElem);
            }
            else if(nextElem.hashCode() > pivotElem.hashCode())
            {
                elemsGreater.add(nextElem);
            }
            else
            {
                elemsEqual.add(nextElem);
            }
        }
        elements = partition(elemsLess, 0);
        elements.addAll(elemsEqual);
        elements.addAll(partition(elemsGreater, 0));
        return elements; 
    }
    
    public int[] inPlace(int[] elems, int min, int max, int pivot)
    {
        if (max - min <= 1)
        {
            return elems;
        }
        int pivotValue = elems[pivot];
        int L = min;
        int R = max;
        while (L < R)
        {
            while (L <= R && pivotValue < elems[L])
            {
                L++;
            }
            while (L < R && pivotValue > elems[R])
            {
                R--;
            }
            if (L < R)
            {
                int temp = elems[L];
                elems[L] = elems[R];
                elems[R] = temp;
            }
        }
        elems[pivot] = elems[L];
        elems[L] = pivotValue;
        if (L < 2)
        {
            L = 2;
        }
        elems = inPlace(elems, min, L - 2, L - 1);
        elems = inPlace(elems, R, max, pivot);
        return elems;
    }
}
