#include <iostream>
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

    void insertLast(int value) {
        Node* newnode = new Node();
        newnode->data = value;
        newnode->next = nullptr;
        if (head == nullptr) {
            head = newnode;
        } else {
            Node* current = head;
            while (current->next != nullptr) {
                current = current->next;
            }
            current->next = newnode;
        }
    }

    void print() {
        if (head == nullptr) {
            cout << "Linked List is Empty" << "\n";
            return;
        }
        Node* currentnode = head;
        while (currentnode != nullptr) {
            cout << currentnode->data << "->";
            currentnode = currentnode->next;
        }
        cout << "Null\n";
    }

    Node* getHead() {
        return head;
    }
    
    void setHead(Node* newHead) {
        head = newHead;
    }
};

LinkedList* mergeTwoLists(LinkedList* list1, LinkedList* list2) {
    Node* current1 = list1->getHead();
    Node* current2 = list2->getHead();
    LinkedList* list3 = new LinkedList();
    
    while (current1 != nullptr && current2 != nullptr) {
        if (current1->data < current2->data) {
            list3->insertLast(current1->data);
            current1 = current1->next;
        } else {
            list3->insertLast(current2->data);
            current2 = current2->next;
        }
    }
    
    while (current1 != nullptr) {
        list3->insertLast(current1->data);
        current1 = current1->next;
    }
    
    while (current2 != nullptr) {
        list3->insertLast(current2->data);
        current2 = current2->next;
    }
    
    return list3;
}

int main() {
    LinkedList* list1 = new LinkedList();
    list1->insertLast(1);
    list1->insertLast(3);
    list1->insertLast(5);

    LinkedList* list2 = new LinkedList();
    list2->insertLast(2);
    list2->insertLast(4);
    list2->insertLast(6);

    LinkedList* mergedList = mergeTwoLists(list1, list2);
    mergedList->print();

    return 0;
}
