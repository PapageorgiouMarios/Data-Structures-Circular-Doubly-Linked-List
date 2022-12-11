#pragma once

template <typename T>
class Node
{
public:
	T data; // Each Node carry a value of any type we choose. In our main method we use Node with std::string data
	Node* next; // Pointer of the Node that follows after the current Node
	Node* previous; // Pointer of the Node that comes before the current Node

	Node(); // Default constructor
	Node(T new_data); // Custom constructor where data are instantly put to the Node
	~Node(); // Destructor 
 
};
/*
Since we have template data we can't just put all methods to a node.cpp file
It is better to just inline our methods
*/

template<typename T>
inline Node<T>::Node()
{
}

template<typename T>
inline Node<T>::Node(T new_data)
{
	this->data = new_data;
	this->next = nullptr; 
	this->previous = nullptr;
}

template<typename T>
inline Node<T>::~Node()
{
}
