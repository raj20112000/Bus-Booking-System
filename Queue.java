public class Queue {
    private static int front, rear, capacity;
    private static int[] queue;

    Queue(int c) {
        capacity = c;
        front = -1;
        rear = -1;
        queue = new int[capacity];
    }

    int peek() {
        if (!isempty()) {
            return queue[front];
        }
        return -1; 
    }

    boolean isfull() {
        return rear == (capacity - 1);
    }

    boolean isempty() {
        return (front == -1 && rear == -1);
    }

    void enqueue(int item) {
        if (isfull()) {
            System.out.println("Queue is Full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            queue[rear] = item;
            System.out.println(item + " is inserted to the Queue");
        }
    }

    void dequeue() {
        if (isempty()) {
            System.out.println("The Queue is Empty");
        } else {
            System.out.println(queue[front] + " is removed from the Queue");
            if (front == rear) {
                front = rear = -1;
            } else {
                front++;
            }
        }
    }

    void display() {
        if (isempty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Queue elements are : ");
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }

    public static void main(String args[]) {
        Queue F1 = new Queue(5);

        F1.enqueue(10);
        F1.enqueue(20);
        F1.enqueue(30);
        F1.enqueue(40);

        System.out.println("The Peek Value is : " + F1.peek());

        F1.display();

        F1.dequeue();
        F1.dequeue();

        F1.display();

        System.out.println("The Peek Value is : " + F1.peek());

        F1.enqueue(50);
        F1.enqueue(60);
        F1.enqueue(70);

        F1.display();




    }
}