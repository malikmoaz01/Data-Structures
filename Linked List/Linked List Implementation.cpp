#include<iostream>
using namespace std;
class node
{
	public:
		int data;
		node* next;
		node(int val)
		{
			data = val;
			next = NULL;
		}
};
//Insert At Beginning

void InsertAtHead(node* &head , int val)
{

	node* n = new node(val);
	n->next = head;
	head = n;
};
//Insert At Middle
void InsertAtMedium(node* head  , int val)
{

	node *n = new node(val);
	node *slow = head;
	node *fast = head;
	if(slow == NULL)
	{
		head = n;
		return;
	}
	if (slow->next == NULL)
	{
		slow->next = n;
		return;
	}
	while (fast->next != NULL && fast->next->next != NULL)
	
	{
		fast = fast->next->next;
		slow = slow->next;
	}
	
	n->next = slow->next;
	slow->next = n;
	
}


//Insert At Last
void InsertAtTail(node* &head , int val)
{
	node* n = new node(val);
	if(head == NULL)
	{
		head = n;
		return;
	}
	
	node* temp = head;
	while(temp->next != NULL)
	{
		temp = temp->next;
	}
	temp->next = n;
	
};


//Display Nodes

void display(node* head)
{
	node* temp = head;
	while(temp != NULL)
	{
		cout<<temp->data<<"->";
		temp = temp->next;
	}
}


//No of Counts Find in Linked lIST 
int NoofCounts(node* head)
{
	int count = 0;
	node* temp = head;
	while(temp != NULL)
	{
		count++;
		temp = temp->next;
	}
	return count;
};


//Find Node At middle
int findAtMiddle(node* head)
{
	int c = 0;
	
	if(head == NULL)
	{
		return -1;
	}
	
	node* middle = head;
	while(head)
	{
		if(c%2 != 0)
		{
			middle = middle->next;
		}
		c++;
		head = head->next;
	}
	return middle->data;
}

//Reverse Node <><><> Iterative Way

node* reverse(node* &head)
{
 	node* previous = NULL;
 	node* current = head;
 	node* nextptr;
 	
 	while(current != NULL)
 	{
 		nextptr = current->next;
 		current->next = previous;
 		previous = current;
 	        current = nextptr;
	 }
	 
	 return previous;
}

//Reverse K Nodes
node* reverseknodes(node* &head , int k)
{
 	node* previous = NULL;
 	node* current = head;
 	node* nextptr;
 	int count = 0;
 	while(current != NULL && count < k) 
 	{
 		nextptr = current->next;
 		current->next = previous;
 		previous = current;
 	    current = nextptr;
 	    count++;
	 }
	  if(nextptr != NULL)
	 head->next = reverseknodes(nextptr,k);
	 return previous;
}



//Find Node
bool findnode(node* head , int val)
{
	node* temp = head;
	
	 if(head == NULL)
	 {
	 	return 0;
	 }
	 while(temp != NULL)
	 {
	 	if(temp->data == val)
	 	
		 {
		 
	 	return true;
	 	
		}
		
		temp = temp->next;
		
	 }
	 
	 return false;
}

//Delete At Start
void deleteHead(node* &head)
{
	node* deleteheadnode = head ;
	head = head->next;
	delete deleteheadnode;
}
//Delete At Middle 
void deleteatmiddle(node* &head)
{
	 // Base cases 
    if(head == NULL)
    {
    	return ;
	}
    if (head->next == NULL) 
    { 
        delete head; 
        return; 
    } 
    
    node* slow = head;
    node* fast = head; 
  
    
    node* prev; 
    while (fast != NULL && fast->next != NULL) 
    { 
        fast = fast->next->next; 
        prev = slow; 
        slow = slow->next; 
    } 
     //Delete the middle node 
    prev->next = slow->next; 
    delete slow; 
    
}


//Delete At The End
void deleteEnd(node* head , int val)
{
	if(head == NULL)
	{
		return;
	}
	
	
	if(head->next == NULL)
	{
		deleteHead(head);
		return;
	}
	
	node* temp = head;
	while(temp->next->data != val)
	{
		temp = temp->next;
	}
	node* newnode = temp->next;
	temp->next = temp->next->next;
	delete newnode;
}

int main()
{
	node* head = NULL;
	InsertAtHead(head , 1);
	InsertAtTail(head , 2);
	InsertAtTail(head , 3);
	InsertAtTail(head , 5);
	InsertAtMedium(head , 60);
	display(head);
	int c = NoofCounts(head);
	cout<<"\n\nNo of Counts are : "<<c<<"\n\n";
	cout<<"The Middle Element in Node is "<<findAtMiddle(head)<<"\n"; 
	deleteatmiddle(head);
	display(head);
		
}
