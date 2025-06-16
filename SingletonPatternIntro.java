class SingleObject {
    private static SingleObject instance;

    private SingleObject(){

    }

    public static SingleObject getInstance(){
        if(instance == null){
            instance = new SingleObject();
        }
        return instance;
    }
    
    public void ShowMessage(){
        System.out.println("Hello World");
    }
}

public class SingletonPatternIntro{
    public static void main(String args[]){
        SingleObject object = SingleObject.getInstance();
        SingleObject object2 = SingleObject.getInstance();
        object.ShowMessage();
        object2.ShowMessage();
    }
}

