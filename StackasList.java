import java.util.Scanner;

public class StackasList {
    static class StackNode{ // To represent a node
        int data; //To store data

        StackNode next; //To store the address of the next node 

        StackNode (int data){
            this.data = data; //data = data
        }
    }
    StackNode head;

    boolean isempty(){
        if(head == null){
            return true;
        }
        else{
            return false;
        }
    
    }

    void push(int stackdata){
        StackNode newnode = new StackNode(stackdata); //new node creation

        if(isempty()){ //head is null
            head = newnode;
        }
        else{ //head is not null
            StackNode temp = head; //temporary poniter/link created to store 1st node address
            head = newnode;
            newnode.next = temp;

            //newnode.next = head;
            //head = newnode;
        }
        System.out.println(stackdata + " iS pushed to the Stack");

    }

void pop(){
    if(isempty()){
        System.out.println("Stack is Empty can't Pop");
    }
    else{
        int popped = head.data; //deleting the top element
        head = head.next;
        System.out.println(popped + " is successfully popped from the Stack");
    }
}

    void display(){
        if(isempty()){
            System.out.println("Stack is empty. no elements");
        }
        else{
            StackNode temp = head;
            while(temp != null){
                System.out.println(temp.data);

                temp = temp.next;
            }
        }
    }

void search(int N1){
    int counter = 1;
    StackNode temp = head;
    while(temp != null){
        if(temp.data == N1){
            System.out.println("Data found at " + counter + " from head");
        }
        else{
            System.out.println("Data Not Found");
        }
        counter ++;

    }
}
    public static void main(String args[]){
        StackasList F1 = new StackasList();

        F1.push(10);
        F1.push(20);
        F1.push(30);
        F1.push(40);

        F1.display();
        F1.pop();

        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int N1 = sc.nextInt();
        F1.search(N1);

        sc.close();

    }
}
