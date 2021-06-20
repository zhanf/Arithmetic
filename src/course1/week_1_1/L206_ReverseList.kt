package course1.week_1_1

import ListNode

object L206_ReverseList {

    /**
     * 206. 反转链表
     */
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (null != curr) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }

    fun reverseList2(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val curr = reverseList(head.next)
        head.next?.next = head
        head.next = null
        return curr
    }

}