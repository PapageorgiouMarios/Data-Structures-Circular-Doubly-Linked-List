#include "cdll.h"
#include <iostream>

using namespace std;

int main(int argc, char** argv)
{
	Circular_Double_Linked_List<string>* cdll = new Circular_Double_Linked_List<string>;

	int choice_1 = -1;

	while (choice_1 != 6)
	{
		if (!cdll->isEmpty())
		{
			cout << endl;
			cout << "Your queue: ";
			cdll->print_list();
			cout << endl;
		}
		cout << endl;
		cout << "------------------MENU----------------------" << endl;
		cout << "1. Create circular doubly linked list" << endl;
		cout << "2. Add new element" << endl;
		cout << "3. Find element" << endl;
		cout << "4. Show circular doubly linked list stats" << endl;
		cout << "5. Remove head (starting node)" << endl;
		cout << "6. Exit" << endl;
		cout << "--------------------------------------------" << endl;

		cout << "Enter choice from menu: ";

		cin >> choice_1;

		switch (choice_1)
		{
		case 1:
		{

			string choice_2;
			cout << "Are you sure you want to create a new list?: ";
			cin >> choice_2;

			if (choice_2 == "Yes" || choice_2 == "yes")
			{
				cdll = new Circular_Double_Linked_List<string>;

				string new_data_input;
				cout << "Enter new data: ";
				cin >> new_data_input;

				cdll->put(new_data_input);
				cout << "Head (starting Node) " << new_data_input << " created successfully!" << endl;
			}
			break;
		}

		case 2:
		{

			if (!cdll->isEmpty())
			{
				cout << "Your queue so far: ";
				cdll->print_list();
				cout << endl;
				cout << "Size of current queue : " << cdll->size_of_list() << endl;

				string new_data_input_2;

				cout << "Enter new data: ";
				cin >> new_data_input_2;

				cdll->put(new_data_input_2);
				cout << "New Node with data " << new_data_input_2 << " added to the end!" << endl;

			}
			else
			{
				cout << "The queue is empty. You need to create it first." << endl;
			}
			break;
		}
		case 3:
		{
			if (cdll->isEmpty()) 
			{
				cout << "The queue is empty. You need to create it first." << endl;
			}
			else
			{
				string new_search_input;
				cout << "Search node: ";
				cin >> new_search_input;

				int result = -1;

				if(!cdll->isEmpty())
				{
					result = cdll->search(new_search_input);
				}

				if(result < 0)
				{
					cout << "Node with value " << new_search_input << " doesn't exist" << endl;
				}
				else
				{
					cout << "Node with value " << new_search_input << " found at position " << result << endl;
				}
			}
			break;

		case 4: 
		{
			if(cdll->isEmpty())
			{
				cout << "The queue is empty!" << endl;
			}
			else 
			{
				cdll->show_stats();
			}

			break;
		}
		case 5:
		{
			if(cdll->isEmpty())
			{
				cout << "The queue is empty!" << endl;
			}
			else if(!cdll->isEmpty() && cdll->head->next == nullptr && cdll->head->previous == nullptr)
			{
				string taken_head = cdll->get();
				cout << "Head with value " << taken_head << " removed and list becomes empty" << endl;
			}
			else
			{
				string taken_head = cdll->get();
				cout << "Head with value " << taken_head << " removed and replaced with " << cdll->peek() << endl;
			}

			break;
		}
		case 6:
		{
			exit(0);
			break;
		}
		}
		}
	}
}