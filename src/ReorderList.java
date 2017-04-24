import java.util.ArrayList;
import java.util.List;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/24
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null || head.next.next==null){
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

    public void spaceForTime(ListNode head){
        if(head==null||head.next==null || head.next.next==null){
            return;
        }
        List<ListNode> nodes = new ArrayList<>();
        ListNode next = head;
        while (next != null){
            nodes.add(next);
            next = head.next;
            head.next = null;
            head = next;
        }
        int len = nodes.size() -1 ;
        head = nodes.get(0);
        head.next = nodes.get(len);
        head = head.next;
        for(int i = 1; i <= (len-1)/2; i++){
            head.next = nodes.get(i);
            head = head.next;
            head.next = nodes.get(len-i);
            head = head.next;
        }

        if(len%2==0){
            head.next = nodes.get(len/2);
        }
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode cur = h;
        for(int i = 2; i <= 7; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode first = h;
        new ReorderList().spaceForTime(first);
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
