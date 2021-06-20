package course1.week_1_1

import ListNode

object L142_DetectCycle {

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