#include<bits/stdc++.h>
using namespace std ;
#define size 100
int arr[size];
int item;
int top=-1;
int stackCount=0;

//push operation
void push(int stack[],int item)
{
	 if(top==(size-1))
	 cout << "Stack Overflow \n";
	 else
	 {
	 top=top+1;
	 stack[top]=item;
	 stackCount++;
	 }
}
//pop operation
int pop(int stack[])
{
	 int itemTop;
	 if(top==-1)
	 cout << "Stack Underflow..." << endl ;
	 else
	 {
	 itemTop=stack[top];
	 top=top-1;
	 stackCount--;
	 cout << "Pop item is " << itemTop << endl ;
	 }
	 return itemTop;
}


//display
void display(int stack[])
{
 if(top==-1)
 cout << "Stack Empty" << endl;
 else
 {
 cout << "******************" << endl;
 for(int i=top; i>=0; i--)
 {
 cout << stack[i] << endl;
 }
 cout << "*******************" << endl;
 }

}
//Clear Function
void clear()
{
	top = -1;
}
//Empty Function
bool isempty()	 
		 
		 {
		 	if(top == -1)
		 	
		 		return true ;
			else
				return false;
		 }
//Stack Full Function
void stackfull()
{
	if(top == size)
	{
		cout<<"Stack is Full\n\n";
	}
	else
	{
		cout<<"Stack is Not Full\n\n";
	}
}
//Top Function 
int Top()
	{
		if(top == -1)
		{
			cout<<"No element in array ";
		}
		return arr[top];
	}

int main()
{
	int ch;
	do{
		 cout <<"\n\tStack Program Menu\n\n";
		 cout <<"\t1. Push an Element.\n\n";
		 cout <<"\t2. Pop an Element.\n\n";
		 cout <<"\t3. Clear Stack.\n\n";
		 cout <<"\t4. To check Stack is Empty.\n\n";
		 cout <<"\t5. To Check Stack is Full.\n\n";
		 cout <<"\t6. To check Element Which is at top.\n\n";
		 cout <<"\t7. Display Stack.\n\n";
		 cout <<"\t8. Exit\n\n";
		 cout <<"Enter your Choice:";
		 cin >> ch;
		switch(ch)
		 {
		 case 1:
		 cout << "Enter an element:";
		 cin >> item;
		 push(arr,item);
		 break;
		 case 2:
		 item=pop(arr);
		 cout << "Element poped " << item << endl;
		 break;
		 case 3:
		 clear();
		 cout << "\n\nStack Has BeeN Cleared \n";
		 break;
		 case 4:
		 if(isempty())
		 {
		 	cout<<"\nStack is Empty\n";
		 }
		 else
		 {
		 	cout<<"\nStack is Not Empty\n";
		 }
		 break;
		 case 5:
		 	stackfull();
		 	break;
		 case 6:
		 Top();
		 cout<<"Element on Top is : "<<arr[top]<<endl;
		 break;
		 case 7:
		 display(arr);
		 break;
		 case 8:
		 exit(0);
		 default:
		 cout << "Invalid Choice...";
		 break;
}
}
		 while(ch!=8);
		 return 0;
}