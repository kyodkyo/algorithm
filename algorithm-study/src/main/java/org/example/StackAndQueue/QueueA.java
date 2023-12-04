package org.example.StackAndQueue;

/**
 * Queue
 * FIFO(First In First Out)의 구조, 데이터를 넣고 빼는 곳의 위치가 서로 다름
 *
 *
 * import java.util.Queue;
 * import java.util.LinkedList;
 * Queue<Integer> q = new LinkedList<>();
 * (T는 반드시 Reference Type)
 *
 *
 * add(x)
 * size()
 * isEmpty()
 * peek()    // 맨 앞의 데이터 반환
 * poll()    // 맨 앞의 데이터 반환 & 데이터 제거
 */

/**
 * Deque
 * 스택과 큐의 장점을 합쳐 놓은 것으로, 앞뒤에서 push/pop이 모두 가능함
 *
 *
 * import java.util.Deque;
 * import java.util.ArrayDeque;
 * Deque<Integer> dq = new ArrayDeque<>();
 *
 *
 * addFirst()
 * addLast()
 * peekFirst()
 * peekLast()
 * pollFirst()
 * pollLast()
 * size()
 * isEmpty()
 */
public class QueueA {
}
