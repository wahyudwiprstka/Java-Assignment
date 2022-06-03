public abstract class Employee {
    private String name;
    public double baseSalary;
    public static int count = 0;
    public int employeeID;
    public double bonus;
    public double bonusBudget;
    public Employee manager;
    public int headCount = 0;
    public Accountant supportAccountant;
    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        this.employeeID = ++count;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public String getName(){
        return name;
    }

    public int getEmployeeID(){
        return employeeID;
    }

    public void setManager(Employee manager){
        this.manager = manager;
    }

    public Employee getManager(){
        return this.manager;
    }

    public boolean equals(Employee other){
        if(other.getEmployeeID() == this.getEmployeeID()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return getEmployeeID() + " " + getName();
    }

    public abstract String employeeStatus();
    public Accountant getSupportAccountant(){
        return supportAccountant;
    }
    public void setSupportAccountant(Accountant a){
        supportAccountant = a;
    }
}
