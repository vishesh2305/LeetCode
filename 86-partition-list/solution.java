// 86. Partition List
// https://leetcode.com/problems/partition-list/
// Difficulty: Medium
// Language:   Java
// Submitted:  2026-09-08 19:45:38
// Runtime:    0 ms (beats 100.00%)
// Memory:     43.7 MB (beats 68.19%)
// Topics:     Linked List, Two Pointers

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);

        ListNode bigDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode big = bigDummy;

        ListNode temp = head;

        while(temp != null){
            if(temp.val >= x){
                big.next = new ListNode(temp.val);
                big = big.next;
            }else{
                small.next = new ListNode(temp.val);
                small = small.next;
            }
            temp = temp.next;
        }
        small.next = bigDummy.next;

        return smallDummy.next;
        
    }
}
