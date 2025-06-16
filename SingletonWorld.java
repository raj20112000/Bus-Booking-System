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
        System.out.println("There is one world in this universe. It is 123 billion acres in size,It has 7 continents and about 8 billion people are living in this world");
    }
}

public class SingletonWorld{
    public static void main(String args[]){
        SingleObject object = SingleObject.getInstance();
        SingleObject object2 = SingleObject.getInstance();
        object.ShowMessage();
        object2.ShowMessage();
    }
}

