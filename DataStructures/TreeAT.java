import java.util.Iterator;
import java.util.List;

/**
 * Write a description of class TreeAT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface TreeAT<E>
{
    TreeNodeCombine<E> root();
    
    TreeNodeCombine<E> parent(PositionAT v) throws RootException;
    
    List children(PositionAT v); // gives the nodes
    
    boolean isExternal(PositionAT v);
    
    boolean isInternal(PositionAT v);
    
    boolean isRoot(PositionAT v);
    
    int size();
    
    boolean isEmpty();
    
    List iterator(); // gives elements
    
    List position(); // gives nodes
    
    E replace(PositionAT v, E element);
}
