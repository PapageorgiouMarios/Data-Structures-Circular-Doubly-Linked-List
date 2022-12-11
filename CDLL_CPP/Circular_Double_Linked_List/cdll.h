#pragma once
#include "my_exception.h"
#include <iostream>
#include "node.h"

//Circular Double Linked List "interface"
template <typename T>
struct Circular_Double_Linked_List
{
	bool isEmpty(); //checks if the list has no Nodes inside
	void put(T item); //creates a new Node with value item and makes it the new Tail of the list
	T get(); //removes the head of the list and resets the list's nodes properly
	T peek(); //returns the value of the first Node(head) of the list
	void print_list(); //prints all Nodes' values inside the list
	int size_of_list(); //returns the number of Nodes in the list
	int search(T data); //returns the first position where the Node with the given value exists, if it exists
	void show_stats(); //shows all Nodes' next and previous Nodes in order

	int size;
	Node<T>* head;
};

template <typename T>
inline bool Circular_Double_Linked_List<T>::isEmpty()
{
	return (size == 0);
}

template <typename T>
inline void Circular_Double_Linked_List<T>::put(T item)
{
	Node<T> * temp = new Node<T>(item);

	if(this->isEmpty())
	{
		this->head = temp;
	}
	else if(!this->isEmpty() && this->head->next == nullptr && this->head->previous == nullptr) 
	{
		this->head->next = temp;
		this->head->previous = temp;

		temp->previous = this->head;
		temp->next = this->head;
	}
	else if(!this->isEmpty() && this->head->next != nullptr && this->head->previous != nullptr)
	{
		temp->next = this->head;
		temp->previous = this->head->previous;
		this->head->previous->next = temp;
		this->head->previous = temp;
	}
	this->size++;
}

template <typename T>
inline T Circular_Double_Linked_List<T>::get()
{
	T  deletedItem;

	if(this->isEmpty()) 
	{
		throw NoSuchElementException();
	}
	else if(!this->isEmpty() && this->head->next == nullptr && this->head->previous == nullptr) 
	{
		deletedItem = this->head->data;
		this->head = nullptr;
	}
	else if (!this->isEmpty() && this->head->next != nullptr && this->head->previous != nullptr) 
	{
		deletedItem = this->head->data;

		this->head->next->previous = this->head->previous;

		this->head->previous->next = this->head->next;

		this->head = this->head->next;
	}

	this->size--;
	return deletedItem;
}

template <typename T>
inline T Circular_Double_Linked_List<T>::peek()
{
	if (this->isEmpty())
	{
		throw NoSuchElementException();
	}

	return this->head->data;
}

template <typename T>
inline void Circular_Double_Linked_List<T>::print_list()
{
	Node<T>* current = this->head;
	int counter = 0;

	while (counter < size) 
	{
		cout << current->data << " ";
		current = current->next;
		counter++;
	}
}


template <typename T>
inline int Circular_Double_Linked_List<T>::size_of_list()
{
	return this->size;
}

template <typename T>
inline int Circular_Double_Linked_List<T>::search(T data)
{
	Node<T> * current = this->head;

	int counter = 0;

	while(counter < this->size)
	{
		if (current->data == data) 
		{
			return counter;
		}
		current = current->next;
		counter++;
	}
	return -1;
}

template <typename T>
inline void Circular_Double_Linked_List<T>::show_stats()
{
	Node<T> * current = this->head;

	cout << "Head (Node number 1): " << current->data << endl;

	if (this->head->next != nullptr) 
	{
		cout << "Next Node: " << current->next->data << endl;
		cout << "Previous (Tail/ last Node): " << current->previous->data << endl;

		current = this->head->next;
		int counter = 1;

		while(counter < this->size)
		{
			cout << "Node number " << counter + 1 << ":" << current->data << endl;
			cout << "Next Node: " << current->next->data << endl;
			cout << "Previous: " << current->previous->data << endl;

			current = current->next;
			counter++;
		}
	}
}


 


 
