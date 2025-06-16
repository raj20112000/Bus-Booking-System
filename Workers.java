abstract class Workers {
    String name;
    float salary;
    int worked_hrs_per_day;
    float money_per_hr;

    abstract void calsal(float money_per_hr);
}

class FullTimeEmployee extends Workers {
    FullTimeEmployee(String name) {
        this.name = name;
    }

    void calsal(float money_per_hr) {
        salary = 8 * money_per_hr;
        System.out.println("FullTimeEmployee " + name + "'s salary per day: " + salary);
    }
}

class Contractor extends Workers {
    Contractor(String name) {
        this.name = name;
    }

    void calsal(float money_per_hr) {
        salary = 4 * money_per_hr;
        System.out.println("Contractor " + name + "'s salary per day: " + salary);
    }
}

