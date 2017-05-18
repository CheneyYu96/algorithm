/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/18
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode last = head, mid = head;
        for(int i = 0; i < k; i++){
            if(last.next == null){
                last = head;
            }
            else{
                last = last.next;
            }
        }
        while(last.next != null){
            last = last.next;
            mid = mid.next;
        }

        ListNode newHead = mid.next;
        mid.next = null;
        last.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode cur = node;
        for(int i = 2; i <= 10; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        System.out.println(node);
        System.out.println(new RotateList().rotateRight(node, 4));
    }
}
