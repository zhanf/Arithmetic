package lession1.week1

import stuck.ListNode

object Lc025_ReverseKGroup {

    /**
     * 25. K 个一组翻转链表
     */
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var head = head
        var protect = ListNode(0, head)
        //上一组尾结点
        var last = protect
        while (null != head) {
            //获取当前尾结点
            val end = getEnd(head, k)
            if (null == end) break
            //记录当前尾结点的下一个头结点
            val nextGroupHead = end.next
            //反转当前链接，反转后end为头结点，head为尾结点
            reverseList(head, end)
            //上一组尾结点指向当前头结点
            last?.next = end
            //当前尾结点指向下一组头结点
            head.next = nextGroupHead

            last = head
            head = nextGroupHead
        }
        return protect.next
    }

    private fun getEnd(head: ListNode?, k: Int): ListNode? {
        var k = k
        var head = head
        while (null != head) {
            k--
            if (k == 0) break
            head = head.next
        }
        return head
    }

    private fun reverseList(head: ListNode?, end: ListNode?) {
        if (head == end) return
        var last = head
        var head = head?.next
        while (head != end) {
            var nextHead = head?.next
            head?.next = last
            last = head
            head = nextHead
        }
        end?.next = last
    }
}