package lession4.week1;

import stuck.ListNodeJava;

import java.util.*;

/**
 * 23. 合并K个升序链表
 */
public class Lc023_MergeKLists {

    /**
     * 分治法，分解成合并两链表问题
     *
     * @param lists
     * @return
     */
    public ListNodeJava mergeKLists(ListNodeJava[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    public ListNodeJava mergeList(ListNodeJava[] lists, int start, int end) {
        //边界条件
        if (start > end) return null;
        // start == end 会导致 stackOverFlow
        if (start == end) return lists[start];
        int mid = (start + end) / 2;
        return mergeTwoNode(mergeList(lists, start, mid), mergeList(lists, mid + 1, end));
    }

    public ListNodeJava mergeTwoNode(ListNodeJava nodeA, ListNodeJava nodeB) {
        if (null == nodeA) return nodeB;
        if (null == nodeB) return nodeA;
        ListNodeJava head = new ListNodeJava(-1, null);
        ListNodeJava tail = head;
        while (null != nodeA && null != nodeB) {
            if (nodeA.val < nodeB.val) {
                tail = nodeA;
                nodeA = nodeA.next;
            } else {
                tail.next = nodeB;
                nodeB = nodeB.next;
            }
            tail = tail.next;
        }
        tail.next = (null == nodeA) ? nodeB : nodeA;
        return head.next;
    }

    /**
     * 最大堆，放在优先队列里
     *
     * @param lists
     * @return
     */
    public ListNodeJava mergeKLists2(ListNodeJava[] lists) {
        if (null == lists || lists.length == 0) return null;
        Comparator comparator = new Comparator<Node>() {

            @Override
            public int compare(Node a, Node b) {
                return a.key - b.key;
            }
        };
        PriorityQueue<Node> queue = new PriorityQueue<Node>(comparator);
        for (ListNodeJava node : lists) {
            if (null != node) {
                queue.offer(new Node(node.val, node));
            }
        }
        ListNodeJava head = new ListNodeJava(-1);
        ListNodeJava tail = head;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            tail.next = node.listNode;
            ListNodeJava next = node.listNode.next;
            if (null != next) {
                queue.add(new Node(next.val, next));
            }
            tail = tail.next;
        }
        return head.next;
    }

    public static class Node {
        int key;
        ListNodeJava listNode;

        public Node(int key, ListNodeJava listNode) {
            this.key = key;
            this.listNode = listNode;
        }
    }


    /**
     * 最小堆
     */
    public static class BinaryHeap {

        private List<Node> heap = new ArrayList<>();

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        //非线程安全类型,可空
        public void push(Node t) {
            heap.add(t);
            //重新排序
            heapifyUp(heap.size() - 1);
        }

        private void heapifyUp(int index) {
            while (index > 0) {
                int fa = (index - 1) / 2;
                if (heap.get(index).key < heap.get(fa).key) {//最小堆
                    Collections.swap(heap, index, fa);
                    index = fa;
                } else break;
            }
        }

        public Node pop() {
            Node ans = heap.get(0);
            //末尾交换到头部，然后删除末尾
            Collections.swap(heap, 0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            //重新排序
            heapifyDown(0);
            return ans;
        }

        private void heapifyDown(int index) {
            int child = index * 2 + 1;
            while (child < heap.size()) {
                int otherChild = index * 2 + 2;
                if (otherChild < heap.size() && heap.get(child).key > heap.get(otherChild).key) {
                    child = otherChild;
                }
                if (heap.get(index).key > heap.get(child).key) {
                    //小根堆
                    Collections.swap(heap, index, child);
                    index = child;
                    child = index * 2 + 1;
                } else break;
            }
        }
    }
}
