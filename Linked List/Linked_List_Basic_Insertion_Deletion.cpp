#include<iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

class LinkedList {
private:
    Node* head;
public:
    LinkedList() {
        head = nullptr;
    }


	// Insert At First 

    void insertFirst(int data) 
	
	{
        Node* newnode = new Node();
        newnode->data = data;
        newnode->next = head;
        head = newnode;
    }
	
	// Insert At Last 
	
	void insertLast(int data)
	{
		Node* newnode = new Node();
		newnode->data = data;
		newnode->next = nullptr;
	   if(head == nullptr)
		{
			head = newnode;
			return ;
		}
		Node* lastnode = head ;
		while(lastnode->next != nullptr)
		{
			lastnode = lastnode->next;
		}
		lastnode->next = newnode;
	}
	
	// Insert At any position 
	
	void insertatanyposition(int value , int position)
	
	{
		Node* newnode = new Node();
		newnode->data =  value ;
		if(position < 1)
		{
			cout<<"Position should not be in negative \n";
			return ;
		}
		if(position == 1)
		{
			newnode->next = head ;
			head = newnode;
			return ;
		}
		
		Node* current =  head ;
		int count = 1;
		while(current != nullptr && count < position - 1 )
		{
			current = current->next;
			count++;
		}
		if(current == nullptr)
		{
			cout<<"Out of Bound \n";
			return ;
		}
		newnode->next = current->next;
		current->next = newnode ;
		
	}
	
	// Print Linked List 
	
	void print()
	{
		if(head == nullptr)
		{
			cout<<"Linked List is Empty"<<"\n";
			return ;
		}
		Node* currentnode = head ;
		while(currentnode != nullptr)
		{
			cout<<currentnode->data<<"->";
			currentnode = currentnode->next;
		}
		cout<<"Null\n";
	}
	
	// Delete First Node Of Linked List 
	
	void deleteFirst()
	{
		if(head == nullptr)
		{
			cout<<"List is Empty";
			return;
		}
		head = head->next; 
	}
	
	// Delete Last Node of Linked List 
	
	void deleteLast()
	{
		if(head == nullptr)
		{
			cout<<"List is Empty";
			return;
		}
		if(head->next == nullptr)
		{
			delete head ;
			head->next = nullptr ;
			return ;
		}
		Node* current = head ;
		while(current->next->next != nullptr)
		{
			current = current->next;
		}
		delete current->next;
		current->next = nullptr;
	}
	
	
	// Delete At any position 
	
	void deleteatanyposition(int position) 
	
	{
    
	if (head == nullptr) {
        cout << "LL is empty\n";
        return;
    }

    if (position < 1) {
        cout << "Position must be positive\n";
        return;
    }

    if (position == 1) {
        Node* temp = head;
        head = head->next;
        delete temp;
        return;
    }

    Node* current = head;
    int count = 1;
    while (current != nullptr && count < position - 1) {
        current = current->next;
        count++;
    }

    if (current == nullptr || current->next == nullptr) {
        cout << "Position is out of Bound\n";
        return;
    }

    Node* temp = current->next;
    current->next = current->next->next;
    delete temp;
}


	// Search Index of Linked List Nodes 
	
	void searchIndex(int number) 
	
	{
        Node* current = head ;
        int index = 0;
        while(current != nullptr)
        {
            if(current->data == number)
            {
                cout<<"Index of "<<number <<" is "<<index<<"\n";
                return;
            }
            current = current->next ;
            index++;
        }
        cout << number << " not found in the list." << endl;
    }
	

	
};

int main() {
    LinkedList list;
    list.insertFirst(10);
//    list.insertFirst(20);
//    list.insertFirst(30);
    list.insertLast(40);
//    list.insertFirst(13);
	list.insertatanyposition(3,2);
//    list.deleteFirst();
//    list.deleteLast();
//    list.searchIndex(10);
	list.deleteatanyposition(2);
    list.print();
    return 0;
}