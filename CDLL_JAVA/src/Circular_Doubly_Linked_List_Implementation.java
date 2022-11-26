import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
-Circular doubly linked list is one of many complicated data structures.
Basically, it has both the features of a circular linked list and a doubly linked list.
-Circular linked list is a list where all nodes connect and form a circle in the end. In other words, the first node and the last node are connected to each other.
-Doubly linked list is a list where navigation is possible in both ways compared to a Single linked list.
This means each node is connected to its next and previous(unless it's the head) node

Now that we understand the concept of what we want to create, let's see the code developed for this specific data structure.

First, we create our own interface with specific methods that we override in our class file
When we run the main class of the file:
-The program will show a menu which asks us what we wish to do

         1. Create circular doubly linked list --> First and foremost, we must have a list to work with it. So, we create one and then put its first Node(head)
         2. Add new element --> Creates a new Node and adds it to the list
         3. Find element --> Searches a specific value in the list and tells us in which position is found first
         4. Show circular doubly linked list stats --> Shows every detail of our list from the head to the tail
         5. Remove head (starting node) --> Removes the head of the list and then replaces it with the next Node
         6. Exit --> Stop the execution of the program

Note: A Node is a basic unit of data structure. In our case, we want our stored data of each Node to be any Object possible (String, float, double, int, etc.)
      For that we use Java generics (parameterized types).
      In our main method, we use Nodes with String data as an example
*/
public class Circular_Doubly_Linked_List_Implementation<T> implements Circular_Doubly_Linked_List<T>
{
    static class Node<T>
    {
        T data;
        Node<T> next;
        Node<T> previous;
        Node(T data)
        {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
    int size;
    Node<T> head;
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(T item)
    {

        Node<T> temp = new Node<>(item);

        if (isEmpty())
        {
            this.head = temp;
        }
        else if(!isEmpty() && this.head.next == null && this.head.previous == null)
        {
            this.head.next = temp;
            this.head.previous = temp;

            temp.previous = this.head;
            temp.next = this.head;

        }
        else if(!isEmpty() && this.head.next != null && this.head.previous != null)
        {
            temp.next = this.head;
            temp.previous = this.head.previous;
            this.head.previous.next = temp;
            this.head.previous = temp;

        }

        size++;
    }

    @Override
    public T get() throws NoSuchElementException {

        T deletedItem = null;

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (!isEmpty() && this.head.next == null && this.head.previous == null) {
            deletedItem = this.head.data;
            this.head = null;
        }

        else if(!isEmpty() && this.head.next != null && this.head.previous != null)
        {
            deletedItem = this.head.data;

            this.head.next.previous = this.head.previous;
            this.head.previous.next = this.head.next;
            this.head = this.head.next;

        }

        size--;
        return deletedItem;

    }

    @Override
    public T peek() throws NoSuchElementException
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        return this.head.data;
    }

    @Override
    public void printList(PrintStream stream) {

        Node<T> current = head;
        int counter = 0;

        while(counter < size)
        {
            System.out.print(current.data + " ");
            current = current.next;
            counter++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int search(T data)
    {
        Node<T> current = head;

        int counter = 0;

        while(counter < size)
        {
            if(current.data.equals(data))
            {
                return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }

    @Override
    public void show_stats()
    {
        Node<T> current = head;

        System.out.println("Head (Node number 1): " + current.data);

        if(head.next != null)
        {
            System.out.println("Next Node: " + current.next.data);
            System.out.println("Previous (Tail/ last Node): " + current.previous.data);

            current = head.next;
            int counter = 1;

            while(counter < size)
            {

                System.out.println("Node number " + (counter + 1) + ": " + current.data);
                System.out.println("Next Node: " + current.next.data);
                System.out.println("Previous Node: " + current.previous.data);

                current = current.next;
                counter++;
            }
        }


    }

    public static void main(String[] args)
    {

     Scanner menu_choice = new Scanner(System.in);
     String choice_1 = " ";

     Circular_Doubly_Linked_List_Implementation<String> cd = new Circular_Doubly_Linked_List_Implementation<>();

     while(!choice_1.contentEquals("6"))
     {
         if(!cd.isEmpty())
         {
             System.out.print("\n");
             System.out.print("YOUR QUEUE: ");
             cd.printList(System.out);
             System.out.print("\n");

         }

         System.out.print("\n");
         System.out.println("------------------MENU----------------------");
         System.out.println("1. Create circular doubly linked list");
         System.out.println("2. Add new element");
         System.out.println("3. Find element");
         System.out.println("4. Show circular doubly linked list stats");
         System.out.println("5. Remove head (starting node)");
         System.out.println("6. Exit");
         System.out.println("--------------------------------------------");


         System.out.print("Enter choice from menu: ");
         choice_1 = menu_choice.nextLine();

         switch (choice_1)
         {
             case "1":

                 Scanner selection = new Scanner(System.in);
                 System.out.print("Are you sure you want to create a new list?: ");
                 String create_new = selection.nextLine();

                 if((create_new.contentEquals("Yes") || create_new.contentEquals("yes")))
                 {
                     cd = new Circular_Doubly_Linked_List_Implementation<>();

                     Scanner new_data_input = new Scanner(System.in);
                     System.out.print("Enter new data: ");
                     String new_data = new_data_input.nextLine();

                     cd.put(new_data);
                     System.out.println("Head (starting Node) " + new_data + " created successfully!");

                 }
                 break;

             case "2":

                 if(!cd.isEmpty())
                 {
                     System.out.print("Your queue so far: ");
                     cd.printList(System.out);
                     System.out.print("Size of current queue: " + cd.size());
                     System.out.print("\n");

                     Scanner new_data_input = new Scanner(System.in);
                     System.out.print("Enter new data: ");
                     String new_data = new_data_input.nextLine();
                     cd.put(new_data);
                     System.out.println("New Node with data " + new_data + " added to the end!");

                 }
                 else
                 {
                     System.out.print("The queue is empty. You need to create it first.");
                 }

                 break;

             case "3":

                 if(cd.isEmpty())
                 {
                     System.out.print("The queue is empty. You need to create it first.");
                 }
                 else
                 {
                     Scanner new_search_input = new Scanner(System.in);
                     System.out.print("Search node: ");
                     String new_data = new_search_input.nextLine();

                     int result = -1;

                     if(!cd.isEmpty())
                     {
                         result = cd.search(new_data);
                     }

                     if(result < 0)
                     {
                         System.out.println("Node with value "+ new_data + " doesn't exist");
                     }
                     else
                     {
                         System.out.println("Node with value " + new_data + " found at position " + result);
                     }
                 }
                 break;

             case "4":

                 if(cd.isEmpty())
                 {
                     System.out.println("The queue is empty!");
                 }
                 else
                 {
                     cd.show_stats();
                 }

                 break;

             case "5":

                 if(cd.isEmpty())
                 {
                     System.out.println("The queue is empty!");
                 }
                 else
                 {
                     String taken_head = cd.get();
                     System.out.println("Head with value " + taken_head  + " removed and replaced with " + cd.peek());
                 }

                 break;

             case "6":
                 System.exit(-1);
                 break;
         }
     }
    }
}
