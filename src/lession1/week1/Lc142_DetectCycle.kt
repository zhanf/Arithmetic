package lession1.week1

import stuck.ListNode

object Lc142_DetectCycle {

    /**
     * 142. 环形链表 II
     */
    fun detectCycle(head: ListNode?): ListNode? {
        var head = head
        val set = HashSet<ListNode>()
        while (null != head) {
            if (set.contains(head)) {
                return head
            } else {
                set.add(head)
            }
            head = head.next
        }
        return null
    }
}