import java.util.List;

/**
 * Write a description of class LinkedBinarySearchTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedBinarySearchTree<K,V> extends LinkedBinaryTree<Entry<K,V>> implements BinarySearchTree<K,V>
{
    private int size;
    
    public LinkedBinarySearchTree()
    {
        super(new ArrayListBinaryTreeNode(null,null,null,null));
        size = 0;
    }
    
    public V put(K key,V value)
    {
        BinaryTreeNode<Entry<K,V>> node = treeSearch(key, root);
        if (isInternal(node))
        {
            V oldValue = node.element().getValue();
            node.setElement(new PriorityQueueEntry<K,V>(key, value));
            return oldValue;
        }
        insertAtExternal(node, new PriorityQueueEntry<K,V>(key, value));
        return null;
    }
    
    public V get(K key)
    {
        BinaryTreeNode<Entry<K,V>> node = treeSearch(key, root);
        if (isInternal(node))
        {
            return node.element().getValue();
        }
        return null;
    }
    
    private BinaryTreeNode<Entry<K,V>> treeSearch(K key, BinaryTreeNode<Entry<K,V>> entry)
    {
        if (isExternal(entry))
        {
            return entry;
        }
        if (key.hashCode() < entry.element().getKey().hashCode())
        {
            return treeSearch(key, entry.left());
        }
        else if (key.hashCode() > entry.element().getKey().hashCode())
        {
            return treeSearch(key, entry.right());
        }
        else
        {
            return entry;
        }
    }
    
    public V remove(K key)
    {
        BinaryTreeNode<Entry<K,V>> nodeWithKeyToRemove = treeSearch(key, root);
        if (nodeWithKeyToRemove == null)
        {
            return null;
        }
        V value = nodeWithKeyToRemove.element().getValue();
        if (isExternal(nodeWithKeyToRemove.left()) || isExternal(nodeWithKeyToRemove.right()))
        {
            removeExternal(nodeWithKeyToRemove);
            return value;
        }
        BinaryTreeNode<Entry<K,V>> replaceNode = getNextNodeInOrder(nodeWithKeyToRemove);
        nodeWithKeyToRemove.setElement(replaceNode.element());
        removeExternal(replaceNode);
        return value;
    }
    
    public BinaryTreeNode<Entry<K,V>> getNextNodeInOrder(BinaryTreeNode<Entry<K,V>> node)
    {
        List<BinaryTreeNode<Entry<K,V>>> inOrder =  inTraversal();
        BinaryTreeNode<Entry<K,V>> replaceNode;
        for (int i = 0; i < size - 1; i++)
        {
            if (inOrder.get(i) == node)
            {
                return inOrder.get(i + 1);
            }
        }
        return null;
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    private void insertAtExternal(BinaryTreeNode<Entry<K,V>> externalNode, Entry<K,V> entry)
    {
        if (isInternal(externalNode))
        {
            throw new IllegalArgumentException();
        }
        externalNode.setElement(entry);
        BinaryTreeNode<Entry<K,V>> newLeftExternalNode = new ArrayListBinaryTreeNode<>(null, externalNode, null, null);
        externalNode.setLeft(newLeftExternalNode);
        BinaryTreeNode<Entry<K,V>> newRightExternalNode = new ArrayListBinaryTreeNode<>(null, externalNode, null, null);
        externalNode.setLeft(newRightExternalNode);
        size++;
    }
    
    private void removeExternal(BinaryTreeNode<Entry<K,V>> externalNode)
    {
        if (!isExternal(externalNode))
        {
            throw new IllegalArgumentException();
        }
        BinaryTreeNode<Entry<K,V>> nodeToRemove = externalNode.getParent();
        if (nodeToRemove.left() == externalNode)
        {
            nodeToRemove.getParent().setRight(nodeToRemove.right());
            nodeToRemove.right().setParent(nodeToRemove.getParent());
        }
        else
        {
            nodeToRemove.getParent().setLeft(nodeToRemove.left());
            nodeToRemove.left().setParent(nodeToRemove.getParent());
        }
        size--;
    }
}
