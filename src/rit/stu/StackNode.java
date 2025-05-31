package rit.stu;

import rit.cs.Stack;
import rit.cs.Node;

/**
 * A stack implementation that uses a Node to represent the structure.
 *
 * @param <T> The type of data the stack will hold
 * @author RIT CS
 * @author Shane Girolamo, seg8061@rit.edu
 */
public class StackNode<T> implements Stack<T> {
    /** The underlying implementation of the top is a Node<T> */
    private Node<T> top;

    /**
     * Create an empty StackNode. Initializes the internal top to null.
     */
    public StackNode() {
        this.top = null;
    }

    /**
     * Determine whether this stack is empty.
     * @return true if the stack contains no elements, false otherwise
     */
    @Override
    public boolean empty() {
        return this.top == null;
    }

    /**
     * Remove and return the element at the top of the stack.
     * @rit.pre  !empty()
     * @throws  AssertionError if the stack is empty
     * @return the data stored at the top of the stack
     */
    @Override
    public T pop() {
        assert !empty();
        T data = this.top.getData();
        this.top = this.top.getNext();
        return data;
    }

    /**
     * Push a new element onto the top of the stack.
     * @param  element  the element to be pushed onto the stack
     */
    @Override
    public void push(T element) {
        this.top = new Node<>(element, this.top);
    }

    /**
     * Return (without removing) the element at the top of the stack.
     * @rit.pre  !empty()
     * @throws  AssertionError if the stack is empty
     * @return the data stored at the top of the stack
     */
    @Override
    public T top() {
        assert !empty();
        return this.top.getData();
    }
}
