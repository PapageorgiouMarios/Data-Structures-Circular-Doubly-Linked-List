# Data-Structures-Circular-Doubly-Linked-List

Circular doubly linked list is one of many complicated data structures.
Basically, it has both the features of a circular linked list and a doubly linked list.
Circular linked list is a list where all nodes connect and form a circle in the end. In other words, the first node and the last node are connected to each other.
Doubly linked list is a list where navigation is possible in both ways compared to a Single linked list.
This means each node is connected to its next and previous(unless it's the head) node

![plot](C:\Users\Admin\Desktop\ΟΠΑ 6ο εξάμηνο)

Now that we understand the concept of what we want to create, let's see the code developed for this specific data structure.
First, we create our own interface with specific methods that we override in our class file
When we run the main class of the file

The program will show a menu which asks us what we wish to do
1) Create circular doubly linked list --> First and foremost, we must have a list to work with it. So, we create one and then put its first Node(head)
2) Add new element --> Creates a new Node and adds it to the list
3) Find element --> Searches a specific value in the list and tells us in which position is found first
4) Show circular doubly linked list stats --> Shows every detail of our list from the head to the tail
5) Remove head (starting node) --> Removes the head of the list and then replaces it with the next Node
6) Exit --> Stop the execution of the program

Note: A Node is a basic unit of data structure. In our case, we want our stored data of each Node to be any Object possible (String, float, double, int, etc.)
      For that we use Java generics (parameterized types).
      In our main method, we use Nodes with String data as an example
