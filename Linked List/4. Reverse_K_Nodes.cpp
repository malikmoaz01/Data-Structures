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
	
	
    void k_reverse(int k)
    {
        if (head == nullptr || k <= 1) 
            return;

        Node* prev = nullptr;
        Node* current = head;
        Node* next = nullptr;
        int count = 0;


        while (current != nullptr && count < k)
        {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Now 'prev' is the new head of the reversed part
        // 'current' points to the (k+1)th node
        // Recursively reverse the remaining list starting from 'current'
        
        if (next != nullptr)
        {
	        head->next = current; // Connect the original head to the next k reversed nodes
	        head = prev; // 'prev' is the new head after reversal
	        k_reverse(k); // Continue reversing the rest of the list
        }
        else
        {
            head = prev; // If 'next' is nullptr, 'prev' is the last node of the list
        }
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
	
}