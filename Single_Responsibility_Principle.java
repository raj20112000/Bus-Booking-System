class report{
    void generateReport(){
        System.out.println("Report Generated");
        
    }
}

class file{
    void saveToFile(){
        System.out.println("File Saved");

    }
}

public class Single_Responsibility_Principle{
    public static void main(String args[]){
        report r = new report();
        file f = new file();
    
    
        r.generateReport();
        f.saveToFile();
    
    }
}