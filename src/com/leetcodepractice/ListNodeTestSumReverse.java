package leetcodepractice;

import java.math.BigInteger;

public class ListNodeTestSumReverse {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNodeTestSumReverse a1 = new ListNodeTestSumReverse();
        a1.addTwoNumbers(l1,l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer num1Str1 = getNumber(l1);
        Integer num1Str2 = getNumber(l2);
        Integer sum = num1Str1 + num1Str2;
        return generateLinkNode(sum);
    }

    public Integer getNumber(ListNode l1) {
        String str = "";
        while(l1 != null) {
            str = String.valueOf(l1.val)+str;
            l1 = l1.next;
        }
        return Integer.valueOf(str);
    }

    public ListNode generateLinkNode(Integer sum) {
        int count = String.valueOf(sum).length();
        ListNode result = null;
        ListNode currentPointNode = null;
        while(count!=0) {
            Integer remaining = sum % 10;
            sum = sum / 10;
            count --;
            if (result == null) {
                result = new ListNode(remaining);
                currentPointNode = result;
            } else {
                currentPointNode.next = new ListNode(remaining);
                currentPointNode = currentPointNode.next;
            }
        }
        return result;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
