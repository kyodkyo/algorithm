package org.example.LinkedList;

/**
 * LinkedList<T> list = new LinkedList<>();
 *
 * addFirst(E) / addLast(E)
 * pollFirst() / pollLast() -> 노드 반환 및 제거
 * size()
 * isEmpty()
 * peekFirst() / peekLast() -> 단순 노드 반환
 */

public class DoublyLikedList {

    /**
     * head 앞에 노드 삽입하기
     *
     * function DLL.insert_front(num)
     *  set new_node = node(num)
     *  new_node.next = DLL.head
     *  new_node.prev = null
     *  DLL.head.prev = new_node
     *  DLL.head = new_node
     */

    /**
     * tail 뒤에 노드 삽입하기
     *
     * function DLL.insert_end(num)
     *  set new_node = node(num)
     *  new_node.next = null
     *  new_node.prev = DLL.tail
     *  DLL.tail.next = new_node
     *  DLL.tail = new_node
     */

    /**
     * head 노드 삭제하기
     *
     * function DLL.delete_front()
     *  set result = DLL.head.value
     *  DLL.head.next.prev = null
     *  DLL.head = DLL.head.next
     */

    /**
     * tail 노드 삭제하기
     *
     * function DLL.delete_end()
     *  set result = DLL.tail.value
     *  DLL.tail.prev.next = null
     *  DLL.tail = DLL.tail.prev
     */
}
