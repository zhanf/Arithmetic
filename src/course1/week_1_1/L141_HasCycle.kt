package course1.week_1_1

import ListNode

object L141_HasCycle {

    /**
     * 141. 环形链表
     */
    fun hasCycle(head: ListNode?): Boolean {
        if (null == head || null == head.next) return false
        var slow = head
        var fast: ListNode? = head?.next
        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next?.next
            if (null == fast) return false
        }
        return true
    }
}