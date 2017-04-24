/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/24
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head.next==null || head.next.next==null){
            return;
        }
        ListNode last = head;
        ListNode next = head;

        if(last.next!=null){
            last = last.next;
        }
        while(last.next!=null){
            last = last.next;
            next = next.next;
        }

        ListNode second = head.next;
        next.next = null;
        last.next = second;
        head.next = last;
        reorderList(second);
    }
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode cur = h;
        for(int i = 2; i < 5; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        new ReorderList().reorderList(h);
        while (h!=null){
            System.out.print(h.val);
            h = h.next;
        }
    }


}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
}
