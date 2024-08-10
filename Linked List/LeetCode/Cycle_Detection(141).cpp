#include <iostream>

struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};

bool hasCycle(ListNode* head) {
    ListNode* slow = head;
    ListNode* fast = head;
    
    while (fast != nullptr && fast->next != nullptr) {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast) {
            return true;
        }
    }
    return false;
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
}





int main() {

    ListNode* head = new ListNode(1);
    ListNode* current = head;
    for (int i = 2; i <= 9; ++i) {
        current->next = new ListNode(i);
        current = current->next;
    }
    createCycle(head, 4);
    
    if (hasCycle(head)) {
        std::cout << "Cycle detected" << std::endl;
    } else {
        std::cout << "No cycle detected" << std::endl;
    }
    
    return 0;
}
