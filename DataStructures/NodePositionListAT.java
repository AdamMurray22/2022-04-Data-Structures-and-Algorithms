
/**
 * Write a description of class NodePositionList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodePositionListAT<E> implements PositionListAT<E>
{
    private int size;
    private DNodeAT<E> header;
    private DNodeAT<E> trailer;

    public NodePositionListAT()
    {
        size = 0;
        header = new DNodeAT<E>(null, null, null);
        trailer = new DNodeAT<E>(header, null, null);
        header.setNext(trailer);
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public DNodeAT<E> first() throws EmptyListException
    {
        if (isEmpty())
        {
            throw new EmptyListException();
        }
        return header.getNext();
    }

    public DNodeAT<E> last() throws EmptyListException
    {
        if (isEmpty())
        {
            throw new EmptyListException();
        }
        return trailer.getPrev();
    }

    public DNodeAT<E> next(PositionAT<E> position) throws InvalidPositionException, BoundaryViolationException
    {
        DNodeAT<E> node = checkPosition(position);
        if (node.getNext() == trailer)
        {
            throw new BoundaryViolationException();
        }
        return node.getNext();
    }

    public DNodeAT<E> prev(PositionAT<E> position) throws InvalidPositionException, BoundaryViolationException
    {
        DNodeAT<E> node = checkPosition(position);
        if (node.getPrev() == header)
        {
            throw new BoundaryViolationException();
        }
        return node.getPrev();
    }

    public void addFirst(E element)
    {
        try
        {
            DNodeAT<E> newNode = new DNodeAT<E>(header, header.getNext(), element);
            header.getNext().setPrev(newNode);
            header.setNext(newNode);
            size++;
        }
        catch (InvalidPositionException ipe)
        {
            ipe.printStackTrace();
        }
    }

    public void addLast(E element)
    {
        try
        {
            addBefore(trailer, element);
        }
        catch (InvalidPositionException ipe)
        {
            ipe.printStackTrace();
        }
    }

    public void addAfter(PositionAT<E> position, E element) throws InvalidPositionException
    {
        DNodeAT<E> node = checkPosition(position);
        DNodeAT<E> newNode = new DNodeAT<E>(node, node.getNext(), element);
        node.getNext().setPrev(newNode);
        node.setNext(newNode);
        size++;
    }

    public void addBefore(PositionAT<E> position, E element) throws InvalidPositionException
    {
        DNodeAT<E> node = checkPosition(position);
        DNodeAT<E> newNode = new DNodeAT<E>(node.getPrev(), node, element);
        node.getPrev().setNext(newNode);
        node.setPrev(newNode);
        size++;
    }

    public E remove(PositionAT<E> position) throws InvalidPositionException
    {   
        DNodeAT<E> node = checkPosition(position);
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        E element = node.element();
        node.setNext(null);
        node.setPrev(null);
        return element;
    }

    public E set(PositionAT<E> position, E element) throws InvalidPositionException
    {
        DNodeAT<E> node = checkPosition(position);
        E oldElement = node.element();
        node.setElement(element);
        return oldElement;
    }

    protected DNodeAT<E> checkPosition(PositionAT<E> p) throws InvalidPositionException {
        if (p == null)
        {
            throw new InvalidPositionException();
        }
        if (p == header) 
        {
            throw new InvalidPositionException();
        }
        DNodeAT<E> temp = (DNodeAT<E>) p;
        return temp;
    }
}
