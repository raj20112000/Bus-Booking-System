public class DynamicQueue {
    class QNode {
        int key;
        QNode next;

        public QNode(int key) {
            this.key = key;
            this.next = null;
        }
    }

    class Queue {
        QNode front, rear;

        public Queue() {
            this.front = this.rear = null;
        }

        void enqueue(int key) {
            QNode temp = new QNode(key);

            if (this.rear == null && this.front == null) {
                this.front = this.rear = temp;
            }

            this.rear.next = temp;
            this.rear = temp;
            System.out.println(key + " Inserted");
        }

        void dequeue() {
            if (this.front == null)
                System.out.println("Queue is empty, can't delete");

            else {
                int key = this.front.key; 
                //QNode temp = this.front;
                this.front = this.front.next;

                if (this.front == null)
                    this.rear = null;
                System.out.println(key + " Deleted");
            }
        }

        void search(int data) {
            QNode current = this.front;
            boolean found = false;

            while (current != null) {
                if (current.key == data) {
                    found = true;
                    break;
                }
                current = current.next;
            }

            if (found)
                System.out.println(data + " Found in the queue");
            else
                System.out.println(data + " Not found in the queue");
        }
    }

    public static void main(String args[]) {
        DynamicQueue dynamicQueue = new DynamicQueue(); 
        Queue F1 = dynamicQueue.new Queue(); 

        F1.enqueue(10);
        F1.enqueue(20);
        F1.enqueue(30);
        F1.enqueue(40);

        F1.search(10);
        F1.search(50);

        F1.dequeue();
        F1.dequeue();



    }
}
