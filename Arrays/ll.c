struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    dummy->val = 0;
    dummy->next = NULL;
    struct ListNode* current = dummy;
    int carry = 0;
    while (l1 != NULL || l2 != NULL || carry != 0) {
        int x = (l1 != NULL) ? l1->val : 0;
        int y = (l2 != NULL) ? l2->val : 0;

        int sum = x + y + carry;
        carry = sum / 10;

        struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
        newNode->val = sum % 10;
        newNode->next = NULL;

        current->next = newNode;
        current = newNode;

        if (l1 != NULL) l1 = l1->next;
        if (l2 != NULL) l2 = l2->next;
    }

    return dummy->next;


====================
    class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 0) return "";
        
        int n = encodedText.length();
        int cols = n / rows;
        
        char[][] mat = new char[rows][cols];
        int idx = 0;
        
        // fill matrix row-wise
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = encodedText.charAt(idx++);
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        // traverse diagonals
        for (int j = 0; j < cols; j++) {
            int r = 0, c = j;
            while (r < rows && c < cols) {
                res.append(mat[r][c]);
                r++;
                c++;
            }
        }
        
        // remove trailing spaces
        int end = res.length() - 1;
        while (end >= 0 && res.charAt(end) == ' ') {
            end--;
        }
        
        return res.substring(0, end + 1);
    }
}
