package lession1.homework

import stuck.ListNode

object Lc021_MergeTwoLists {

    /**
     * 21. 合并两个有序链表
     */
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1 = l1
        var l2 = l2
        var prev = ListNode(-1)
        var cur = prev
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                cur.next = l1
                l1 = l1.next
            } else {
                cur.next = l2
                l2 = l2.next
            }
            cur = cur.next!!
        }
        cur.next = if (null == l1) l2 else l1
        return prev.next
    }
}