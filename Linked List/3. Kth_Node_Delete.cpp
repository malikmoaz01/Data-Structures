#include<iostream>
using namespace std ;
struct Node 
{
	int data ;
	Node* next;
};
class LinkedList
{
	private:
		Node* head ;
	public:
		LinkedList() { head = nullptr; };
	void InsertFirst(int data)
	{
        Node* newnode = new Node();
        newnode->data = data;
        newnode->next = head;
        head = newnode;
	}
	void print()
	{
		
		Node* current = head ;
		if(head ==  nullptr)
		{
			cout<<"LL is empty\n";
			return;
		}
		while (current != nullptr)
		{
			cout<<current->data<<" -> ";
			current =  current->next;
		}
	}
	
void delete_specificKnode_at_start(int k)
{
    if (head == nullptr || k <= 0)
    {
        cout << "Nothing to do with it ";
        return;
    }
    if (k == 1)
    {
        Node* temp = head;
        head = head->next;
        delete temp;
        return;
    }

    int count = 1;
    Node* current = head;
    while (current != nullptr && count < k - 1)
    {
        current = current->next;
        count++;
    }

    if (current == nullptr || current->next == nullptr)
    {
        cout << "Position out of range\n";
        return;
    }

    Node* temp = current->next;
    current->next = temp->next;
    delete temp;
}
	
};
int main()
{
	LinkedList list ;
	list.InsertFirst(10);
	list.InsertFirst(20);
	list.InsertFirst(30);
	list.InsertFirst(40);
	list.print();
	cout<<"\n";
	list.delete_specificKnode_at_start(3);
	list.print();
}