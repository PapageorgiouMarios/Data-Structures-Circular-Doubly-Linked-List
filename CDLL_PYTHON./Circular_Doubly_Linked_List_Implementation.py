from Circular_Double_Linked_List import *


class Node(Generic[T]):
    def __init__(self, data: T):
        self.data = data
        self.next = None
        self.previous = None


class CircularDoubleLinkedListImplementation(Generic[T]):

    def __init__(self):
        self.size = 0
        self.head = None

    def isEmpty(self) -> bool:
        return self.size == 0

    def put(self, item: T) -> None:
        temp = Node(item)
        if self.isEmpty():
            self.head = temp
        elif not (self.isEmpty()) and self.head.next is None and self.head.previous is None:
            self.head.next = temp
            self.head.previous = temp
            temp.previous = self.head
            temp.next = self.head
        elif not (self.isEmpty()) and self.head.next is not None and self.head.previous is not None:
            temp.next = self.head
            temp.previous = self.head.previous
            self.head.previous.next = temp
            self.head.previous = temp
        self.size += 1

    def get(self) -> T:
        deletedItem = None
        if self.isEmpty():
            print("There is no Node remove")
            return None
        elif not (self.isEmpty()) and self.head.next is None and self.head.previous is None:
            deletedItem = self.head.data
            self.head = None
        elif not (self.isEmpty()) and self.head.next is not None and self.head.previous is not None:
            deletedItem = self.head.data

            self.head.next.previous = self.head.previous
            self.head.previous.next = self.head.next
            self.head = self.head.next
        self.size -= 1
        return deletedItem

    def peek(self) -> T:
        if self.isEmpty():
            print("There is no Node remove")
            return None
        return self.head.data

    def printList(self) -> None:
        current = self.head
        counter = 0
        queueText = ""
        while counter < self.size:
            queueText += str(current.data) + " "
            current = current.next
            counter += 1
        print(queueText)

    def sizeOf(self) -> int:
        return self.size

    def search(self, item: T) -> int:
        current = self.head
        counter = 0
        while counter < self.size:
            if current.data == item:
                return counter
            current = current.next
            counter += 1
        return -1

    def show_stats(self) -> None:
        current = self.head
        print("Head (Node number 1): " + current.data)
        if self.head.next is not None:
            print("Next Node: " + current.next.data)
            print("Previous (Tail/ last Node): " + current.previous.data)
            current = self.head.next
            counter = 1
            while counter < self.size:
                print("Node number " + str(counter + 1) + ": " + current.data)
                print("Next Node: " + current.next.data)
                print("Previous Node: " + current.previous.data)
                current = current.next
                counter += 1
