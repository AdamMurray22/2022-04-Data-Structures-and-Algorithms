
/**
 * Write a description of class BinaryTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface BinaryTree<E> extends TreeAT<E>
{
    BinaryTreeNode<E> root();
    
    BinaryTreeNode<E> left(PositionAT<E> v);
    
    BinaryTreeNode<E> right(PositionAT<E> v);
    
    boolean hasLeft(PositionAT<E> v);
    
    boolean hasRight(PositionAT<E> v);
}
