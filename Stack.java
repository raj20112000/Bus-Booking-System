import java.util.Scanner;

public class Stack {
    int top = -1;
    int size;
    //int sta[] = new int[size];
    int sta[];

    Stack(int size)
    {
        this.size=size;
        sta = new int[size];
    }

    boolean isfull(){
        if(top >= sta.length - 1){
            System.out.println("Stack is Overflow");
            return true;
        }
        return false;

    }

    boolean isempty(){
        if(top<0){
            System.out.println("No Values in the Stack");
            return true;
        }
        else{
            return false;

        }
    }

    int peek(){
        if(isempty()){
            System.out.println("Stack is empty no top element");
            return 0;
        }
        else{
            int x = sta[top];
            return x;
        }
    }


    void push(int x){

    if(isfull()){
        System.out.println("Stack is Full");
    }
    else{
        top++;
        sta[top] = x;
        System.out.println(x + " pushed to stack");

    }
}

int pop(){

    if(isempty()){
        System.out.println("Stack is Underflow");
        return 0;
    }
    else{
        int x=sta[top];
        top--;
        //System.out.println(peek() + " Poped out from Stack");
        return x;

    }
}

int Search(int N1) {
    for (int i = 0; i <= top; i++) {
        if (sta[i] == N1) {
            return i;
        }
    }
    return -1;
}

void display() {
    if (isempty()) {
        System.out.println("Stack is empty");
    } else {
        System.out.println("Stack elements are:");
        for (int i = top; i >= 0; i--) {
            System.out.println(sta[i]);
        }
    }
}

    public static void main(String args[]){
        Stack G1 = new Stack(5);

        G1.push(10);
        G1.push(20);
        G1.push(30);
        G1.push(40);
        G1.push(70);
        System.out.println("The Peek Value is : " + G1.peek());
        
        System.out.println(G1.pop() + " Poped out from Stack");
        
        System.out.println("The Peek Value is : " + G1.peek() + " and the top value is : " + G1.top);

        /*Stack s2=new Stack(3);*/
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the Num :");
        int N1 = sc.nextInt();

        Stack A1 = new Stack(5);

        A1.Search(N1);

        int result = G1.Search(N1);
        if (result != -1) {
            System.out.println("Id Found at index: " + result);
        } else {
            System.out.println("Id Not Found");
        }

        G1.display();

        sc.close();




    }
    

}
