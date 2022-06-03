import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee{
    ArrayList <SoftwareEngineer> team;
    int headCount;
    public TechnicalLead(String name){
        super(name);
        this.baseSalary = super.getBaseSalary()*1.3;
        headCount = 4;
        team = new ArrayList<SoftwareEngineer>();
    }

    public boolean hasHeadCount(){
        if (team.size() < headCount){
            return true;
        }else{
            return false;
        }
    }

    public boolean addReport(SoftwareEngineer e){
        if (hasHeadCount()){
            team.add(e);
            e.setManager(this);
            return true;
        }else{
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        if (e.getManager().equals(this) && e.getCodeAccess()){
            return true;
        }else{
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus){
        BusinessLead businessLead = (BusinessLead) getSupportAccountant().getManager();
        if (businessLead.approveBonus(e, bonus)){
            return true;
        } else {
            return false;
        }
    }

    public String getTeamStatus(){
        String teamStatus = "";
        if (team.size() == 0){
            return employeeStatus() + " and no direct reports yet";
        }else{
            for (int i = 0; i < team.size(); i++){
                teamStatus += team.get(i).employeeStatus() + "\n";
            }
            return employeeStatus() + " and is managing: \n" + teamStatus;
        }
    }
}
