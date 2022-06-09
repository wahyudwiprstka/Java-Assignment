public class TechnicalEmployee extends Employee {
    int checkIns;
    public TechnicalEmployee(String name){
        super(name, 75000);
        checkIns = 0;
    }

    public String employeeStatus(){
        return this.getEmployeeID() + " " + this.getName() + " has " + this.checkIns + " successful check ins";
    }
}
