
/**
 * Write a description of interface CompleteBinaryTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface CompleteBinaryTree<E> extends BinaryTree<E>
{
    public BinaryTreeNode<E> add(E element);
    public E remove();
}
