import java.util.List;

/**
 * Write a description of interface BinaryTreeNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface BinaryTreeNode<E> extends TreeNodeCombine<E>
{
    BinaryTreeNode<E> left();
    
    BinaryTreeNode<E> right();
    
    void setElement(E element);
    
    List<BinaryTreeNode<E>> getChildren();
    
    void setLeft(BinaryTreeNode<E> leftNode);
    
    void setRight(BinaryTreeNode<E> rightNode);
    
    BinaryTreeNode<E> getParent();
    
    void setParent(BinaryTreeNode<E> parentNode);
}
