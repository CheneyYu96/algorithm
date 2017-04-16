/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return null;
        }
        ListNode first = new ListNode(l1.val+l2.val);
        boolean extra = false;
        if(first.val>=10){
            first.val %= 10;
            extra = true;
        }
        ListNode now = first;
        while(l1.next!=null || l2.next!=null){
            ListNode newNode = new ListNode(0);
            if(extra){
                newNode.val++;
                extra = false;
            }
            if(l1.next!=null){
                l1 = l1.next;
                newNode.val += l1.val; 
            }
            
            if(l2.next!=null){
                l2 = l2.next;
                newNode.val += l2.val; 
            }
            
            if(newNode.val>=10){
                newNode.val %= 10;
                extra = true;
            }
            now.next = newNode;
            now = newNode;
        }
        if(extra){
            now.next = new ListNode(1);
        }
        return first;
    }
}