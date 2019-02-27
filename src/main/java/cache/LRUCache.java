package cache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description LRU淘汰算法（链表实现，线程安全）
 * @Author lilong
 * @Date 2019-02-27 18:50
 */
public class LRUCache<E> {

    // 双向链表，用于缓存数据
    static class Node<E> {
        E item;

        Node<E> pre;
        Node<E> next;

        Node(E x) {
            item = x;
        }
    }

    // 缓存容量
    private final int capacity;
    private final AtomicInteger count = new AtomicInteger();

    private Node<E> head; //头结点
    private Node<E> tail; //尾节点

    public LRUCache() {
        this(Integer.MAX_VALUE);
    }

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        tail = head = new Node<E>(null);
    }

    public synchronized void put(E e) {
        // 缓存已满，淘汰尾节点
        if (count.get() == capacity) {
            removeLast();
        }

        // 然后将新节点插入到头部
        insertHead(e);
    }

    /**
     * 删除链表最后一个元素
     */
    private void removeLast() {
        if (count.get() == 0) {
            return;
        }

        // 只有一个节点的删除
        if (count.get() == 1) {
            tail = head = new Node<>(null);
        } else {
            // 将末尾节点的前一个节点作为新的尾节点
            tail = tail.pre;
            tail.next = null;
        }
        count.getAndDecrement();
    }

    /**
     * 将新元素插入链表头部
     * @param e
     */
    private void insertHead(E e) {
        Node<E> newNode = new Node<>(e);
        insertHead(newNode);
    }

    private void insertHead(Node<E> newNode) {
        if (count.get() == 0) {
            head.next = newNode;
            newNode.pre = head;

            tail = newNode;
        } else {
            Node<E> tmp = head.next;
            head.next = newNode;
            newNode.pre = head;

            tmp.pre = newNode;
            newNode.next = tmp;
        }

        count.getAndIncrement();
    }

    public synchronized E get(E e) {
        if (count.get() == 0) {
            return null;
        }

        Node<E> tmp = head;
        while (tmp != null && tmp.next != null) {
            tmp = tmp.next;
            if (e.equals(tmp.item)) {
                E e1 = tmp.item;
                // 将该元素提到开头处
                moveToHead(tmp);
                return e1;
            }
        }
        return null;
    }

    /**
     * 将元素移到首位
     * @param node
     */
    private void moveToHead(Node<E> node) {
        if (node.pre == head) {
            return;
        }

        // 先删除该元素
        if (node == tail) {
            removeLast();
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        //然后插入首部
        insertHead(node);
    }

    // 打印缓存中的所有元素
    @Override
    public String toString() {
        List<E> list = new ArrayList<>();

        if (count.get() == 0) {
            return "Empty";
        }

        Node<E> tmp = head;
        while (tmp != null && tmp.next != null) {
            list.add(tmp.next.item);
            tmp = tmp.next;
        }
        return list.toString();
    }
}
