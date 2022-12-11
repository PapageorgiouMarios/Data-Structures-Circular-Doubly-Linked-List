#pragma once
#include <exception>
#include <iostream>
//Unlike Java, we can't just throw NoSuchElementException(), so we create our own exception
using namespace std; 

class NoSuchElementException : public exception  //this class inherits from std::exception class
{
public:

	virtual const char* what() const throw()
	{
		return "Executable failed: NoSuchElementException occured";
	}

};

