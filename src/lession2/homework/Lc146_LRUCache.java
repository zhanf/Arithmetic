package lession2.homework;

import java.util.HashMap;

public class Lc146_LRUCache {

    /**
     * 146. LRU 缓存机制
     * 1.构建双端链表结构
     * 2.LRUCache 初始化头部尾部节点
     * 3.map 保存 key,value 为 Node
     * 4.get put 时候从 map 获取
     * 5.get 获取到之后对链表重排序，获取不到返回 -1；
     * 6.put 获取到之后对链表重排序，获取不到则构建节点插入到链表中，重新排序。
     * 7.put 插入链表前判断越界，删除尾部节点
     */
    class LRUCache {
        private Node head;
        private Node tail;
        private int capacity;
        private HashMap<Integer, Node> map = new HashMap();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (null == node) {
                return -1;
            }
            accessOrder(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (null == node) {
                node = new Node(key, value);
                if (map.size() >= capacity) {
                    deleteTail();
                }
                insertNode(node);
            } else {
                node.value = value;
                accessOrder(node);
            }
            map.put(key, node);
        }

        private void accessOrder(Node node) {
            if (null == node) return;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
        }

        private void insertNode(Node node) {
            if (null == node) return;
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
        }

        private void deleteTail() {
            Node temp = tail.pre;
            temp.pre.next = tail;
            tail.pre = temp.pre;
            map.remove(temp.key);
            temp = null;
        }

        public class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.value = value;
                this.key = key;
            }
        }
    }
}
