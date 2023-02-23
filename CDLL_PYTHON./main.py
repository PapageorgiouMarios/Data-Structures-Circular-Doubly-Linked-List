from Circular_Doubly_Linked_List_Implementation import *

choice1 = ""

cd = CircularDoubleLinkedListImplementation[int]()

while choice1 != 6:
    if not cd.isEmpty():
        print("YOUR QUEUE: ")
        cd.printList()

    print("------------------MENU----------------------")
    print("1. Create circular doubly linked list")
    print("2. Add new element")
    print("3. Find element")
    print("4. Show circular doubly linked list stats")
    print("5. Remove head (starting node)")
    print("6. Exit")
    print("--------------------------------------------")

    choice1 = input("Enter choice from menu: ")

    if choice1 == "1":
        createNew = input("Are you sure you want to create a new list?: ")

        if createNew == "Yes" or createNew == "yes":
            cd = CircularDoubleLinkedListImplementation()
            new_data = input("Enter new data: ")
            cd.put(new_data)
            print("Head (starting Node) " + str(new_data) + " created successfully!")

    if choice1 == "2":
        if not cd.isEmpty():
            print("Your queue so far: ")
            cd.printList()
            print("Size of current queue: " + str(cd.sizeOf()))
            new_data_input = input("Enter new data: ")
            cd.put(new_data_input)
            print("New Node with data " + str(new_data_input) + " added to the end!")
        else:
            print("The queue is empty. You need to create it first.")

    if choice1 == "3":
        if cd.isEmpty():
            print("The queue is empty. You need to create it first.")
        else:
            new_search_input = input("Search node: ")
            result = -1
            if not cd.isEmpty():
                result = cd.search(new_search_input)
            if result < 0:
                print("Node with value " + str(new_search_input) + " doesn't exist")
            else:
                print("Node with value " + str(new_search_input) + " found at position " + str(result))

    if choice1 == "4":
        if cd.isEmpty():
            print("The queue is empty!")
        else:
            cd.show_stats()
    if choice1 == "5":
        if cd.isEmpty():
            print("The queue is empty!")
        else:
            taken_head = cd.get()
            print("Head with value " + str(taken_head) + " removed and replaced with " + str(cd.peek()))
    if choice1 == "6":
        exit(-1)




