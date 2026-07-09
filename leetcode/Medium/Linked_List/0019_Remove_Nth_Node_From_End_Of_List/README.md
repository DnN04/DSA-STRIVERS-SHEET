# Remove Nth Node From End of List

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Linked List](https://img.shields.io/badge/Topic-Linked List-blue?style=flat-square)](https://leetcode.com/tag/linked-list/) [![Topic: Two Pointers](https://img.shields.io/badge/Topic-Two Pointers-blue?style=flat-square)](https://leetcode.com/tag/two-pointers/)

- **LeetCode Link**: [https://leetcode.com/problems/remove-nth-node-from-end-of-list/](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
- **Problem ID**: 19
- **Language**: Java

## Solution Design

### Method Explanation
- *We solve this problem by leveraging standard data structures or algorithms suitable for the problem constraints.*
- *Make sure to update this section with notes on your implementation approaches.*

### Complexity Analysis
- **Time Complexity**: \(O(N)\) (where \(N\) is the number of elements)
- **Space Complexity**: \(O(1)\) auxiliary space

## Solution Code

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Handle single node list
        if (head.next == null) return null;
        
        ListNode ptr = head;
        ListNode temp = head;
        
        // Move ptr forward n times to create the gap
        int i = 1;
        while (i <= n) {
            ptr = ptr.next; 
            i++;
        }
        
        // If ptr becomes null, we need to remove the head
        if (ptr == null) return head.next;
        
        // Move both until ptr reaches the last node
        while (ptr.next != null) {
            ptr = ptr.next;
            temp = temp.next;
        } 
        
        // Skip the nth node from the end
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        
        return head;
    }
}
```
