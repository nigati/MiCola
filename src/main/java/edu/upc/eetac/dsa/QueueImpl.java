package edu.upc.eetac.dsa;

public class QueueImpl<E> implements Queue<E> {
    E[] data;
    private int front, rear, size;

    public QueueImpl(int size) {
        data = (E[]) new Object[size];
        front = rear = 0;
        size = this.size;
    }

    @Override
    public void push(E e) throws FullQueueException {
        if (this.isFull()) throw new FullQueueException();
        this.data[this.rear] = e;
        rear++;
    }


    @Override
    public E pop() throws EmptyQueueException {
        if (this.isEmpty()) throw new EmptyQueueException();

        E ret = this.data[this.front];
        this.data[this.front] = null;
        for (int i = 0; i < rear - 1; i++) {
            data[i] = data[i + 1];
        }
        this.data[this.rear] = null;
        rear--;
        return ret;
    }

    @Override
    public int size() {
        return this.rear;
    }

    // Utility function to check if the queue is empty or not
    public boolean isEmpty() {
        return (size() == 0);
    }
    public boolean isFull() {
        return (size() == data.length);
    }
}