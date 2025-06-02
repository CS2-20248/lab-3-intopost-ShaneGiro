package rit.stu;

import rit.cs.Node;
import rit.cs.Queue;

/**
 * A queue implementation that uses a Node to represent the structure.
 *
 * @param <T> The type of data the queue will hold
 * @author RIT CS
 * @author Shane Girolamo, seg8061@rit.edu
 */
public class QueueNode<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    /**
     * Create an empty queue. Initializes head and tail to null.
     */
    public QueueNode() {
        this.head = null;
        this.tail = null;
    }

    @Override
    /**
     * Return (without removing) the element at the back of the queue.
     * @rit.pre  the queue isn't empty
     * @throws  AssertionError if the queue is empty
     * @return the data at the back of the queue
     */
    public T back() {
        assert !empty();
        return this.tail.getData();
    }

    @Override
    /**
     * Remove and return the element at the front of the queue.
     * @rit.pre  the queue isn't empty
     * @throws  AssertionError if the queue is empty
     * @return the data removed from the front
     */
    public T dequeue() {
        assert !empty();
        T element = this.head.getData();
        this.head = this.head.getNext();
        if(empty()) {
            this.tail = null;
        }
        return element;
    }

    @Override
    /**
     * Check whether the queue is empty.
     * @return true if the queue has no elements; false otherwise
     */
    public boolean empty() {
        return this.head == null;
    }

    @Override
    /**
     * Add a new element to the back of the queue.
     * @param element the element to add
     */
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element, null);
        if(empty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    @Override
    /**
     * Return (without removing) the element at the front of the queue.
     * @rit.pre  the queue isn't empty
     * @throws  AssertionError if the queue is empty
     * @return the data at the front of the queue
     */
    public T front() {
        assert !empty();
        return this.head.getData();
    }
}
