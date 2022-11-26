import java.io.PrintStream;
import java.util.NoSuchElementException;

public interface Circular_Doubly_Linked_List<T>
{
    /**
     * @return true if the list is empty
     */
    public boolean isEmpty();

    /**
     * insert a T item to the list
     */
    public void put(T item);

    /**
     * remove and return the oldest item(head) of the list
     * @return oldest item of the list
     * @throws NoSuchElementException if the list is empty
     */
    public T get() throws NoSuchElementException;

    /**
     * return without removing the oldest item(head) of the list
     * @return oldest item of the list
     * @throws NoSuchElementException if the list is empty
     */
    public T peek() throws NoSuchElementException;

    /**
     * print the elements of the list, starting from the oldest
     * item(head), to the print stream given as argument. For example, to
     * print the elements to the
     * standard output, pass System.out as parameter. E.g.,
     * printList(System.out);
     */
    public void printList(PrintStream stream);

    /**
     * return the size of the list, 0 if it is empty
     * @return number of elements in the list
     */
    public int size();

    /**
     * return the position of the node which contains the input data
     * @return -1 if the queue doesn't find given data
     */
    public int search(T data);

    /**
     * prints all Nodes and for each one its data, its next and its previous Nodes
     */
    public void show_stats();

}
