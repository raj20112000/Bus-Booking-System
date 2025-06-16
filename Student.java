
class Student
{
    // Attributes of student
    int id;
    String name;
    String course;

    // behaviours - methods

    public static void main(String args[])
    {
        // Create Objects
        Student st01 = new Student();
        //assign value to st01 object's attributes
        st01.id = 1001; 
        st01.name = "Raj";
        st01.course = "HNDIT";

        System.out.println("st01 id is " + st01.id);
        System.out.print("st01 name is " + st01.name + "\n");
        System.out.println(st01.course);



    }




}