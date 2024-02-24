
/**
 * Write a description of class Heap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedHeap<K,V> extends CompleteLinkedBinaryTree<Entry<K,V>> implements PriorityQueueAT<K,V>
{
    public Entry<K,V> insert(K key, V value) throws InvalidKeyException
    {
        if (key == null)
        {
            throw new InvalidKeyException();
        }
        Entry<K,V> newEntry = new PriorityQueueEntry<K,V>(key, value);
        HeapStackNode<Entry<K,V>> newNode = add(newEntry);
        Comparator comparator = new IntComparator();
        while (newNode.getParent() != null && comparator.compare(key, newNode.getParent().element().getKey()) < 0 )
        {
            HeapStackNode<Entry<K,V>> oldParent = newNode.getParent();
            swap(newNode, oldParent);
            newNode = oldParent;
        }
        return newEntry;
    }

    public Entry<K,V> removeMin() throws EmptyPriorityQueueException
    {
        if (size == 0)
        {
            throw new EmptyPriorityQueueException();
        }
        Entry<K,V> minEntry = root.element();
        if (size == 1)
        {
            remove();
            return minEntry;
        }
        swap(root, lastNodeStack.topNode());
        remove();
        Comparator comparator = new IntComparator();
        HeapStackNode<Entry<K,V>> node = root;
        while ((node.left() != null && comparator.compare(node.element().getKey(), node.left().element().getKey()) > 0) || (node.right() != null && comparator.compare(node.element().getKey(), node.right().element().getKey()) > 0))
        {
            HeapStackNode<Entry<K,V>> child;
            if (node.right() != null)
            {
                if (node.left() != null && comparator.compare(node.left().element().getKey(), node.right().element().getKey()) < 0)
                {
                    child = node.left();
                }
                else
                {
                    child = node.right();
                }
            }
            else
            {
                 child = node.left();
            }
            swap(child, node);
            node = child;
        }
        return minEntry;
    }

    private void swap(HeapStackNode<Entry<K,V>> node1, HeapStackNode<Entry<K,V>> node2)
    {
        Entry<K,V> temp = node1.element();
        node1.setElement(node2.element());
        node2.setElement(temp);
    }

    public Entry<K,V> min()throws EmptyPriorityQueueException
    {
        if (size == 0)
        {
            throw new EmptyPriorityQueueException();
        }
        return root.element();
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
}
