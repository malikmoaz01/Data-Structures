#include <iostream>
using namespace std;

struct ListNode 
{
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

int LengthCycle(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    
    while (fast != nullptr && fast->next != nullptr) {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast) {
            ListNode* temp = slow;
            int length = 0;
            do {
                temp = temp->next;
                length++;
            } while (temp != slow);
            return length;
        }
    }
    return -1; // No cycle
}

ListNode* FindCycleStart(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    
    while (fast != nullptr && fast->next != nullptr) {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast) {
        	
            slow = head;  
            while (slow != fast) {
                slow = slow->next;  
                fast = fast->next;  
            }
            return slow; 
        }
    }
    return nullptr; 
}

void createCycle(ListNode* head, int pos) 
{
    if (head == nullptr) return;
    
    ListNode* tail = head;
    ListNode* cycleNode = nullptr;
    int index = 1;
    
    while (tail->next != nullptr) {
        if (index == pos) {
            cycleNode = tail;
        }
        tail = tail->next;
        index++;
    }
    if (cycleNode != nullptr) {
        tail->next = cycleNode;
    }
}

int main() {
    ListNode* head = new ListNode(1);
    ListNode* current = head;
    for (int i = 2; i <= 9; ++i) {
        current->next = new ListNode(i);
        current = current->next;
    }
    createCycle(head, 4);
    cout << "Length of Cycle is: " << LengthCycle(head) << "\n";
    
    ListNode* cycleStart = FindCycleStart(head);
    if (cycleStart) {
        cout << "Cycle starts at node with value: " << cycleStart->val << "\n";
    } else {
        cout << "No cycle detected.\n";
    }
    
    return 0;
}
