package leetcodepractice;

public class ListNodeTestSumReverse2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3,new ListNode(8, new ListNode(9)))));

        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNodeTestSumReverse2 a1 = new ListNodeTestSumReverse2();
        a1.addTwoNumbers(l1,l2);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        recursiveDrill(l1, l2);
        return sum;
    }

    ListNode sum = null;
    ListNode currNodesum = null;
    int remaining = 0;
    public void recursiveDrill(ListNode l1, ListNode l2 ) {
        while((l1.next!=null && l2.next != null) ||  (l1.next==null && l2.next != null) || (l2.next==null && l1.next != null)) {
            l1 = l1.next!=null ? l1.next : new ListNode(0);
            l2 = l2.next!=null ? l2.next : new ListNode(0);
            recursiveDrill(l1, l2);
        }
        int sumVal = l1.val + l2.val + remaining;
        remaining =  sumVal/10;
        if(sum == null) {
            sum = new ListNode(sumVal % 10);
            currNodesum = sum.next;
        } else {
            currNodesum.next = new ListNode(sumVal % 10);
            currNodesum = currNodesum.next;
        }
    }
}
