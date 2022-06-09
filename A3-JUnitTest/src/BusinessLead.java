import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee{
    ArrayList<Accountant> team;

    public BusinessLead(String name) {
        super(name);
        this.baseSalary = 2 * getBaseSalary();
        this.headCount = 10;
        this.team = new ArrayList<Accountant>();
    }

    public boolean hasHeadCount(){
        if (team.size() < this.headCount){
            return true;
        }else {
            return false;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if (this.hasHeadCount()){
            team.add(e);
            e.setManager(this);
            this.bonusBudget += e.getBaseSalary()*1.1;
            supportTeam.setSupportAccountant(e);
            return true;
        }else{
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus){
        for (int i = 0; i < this.team.size(); i++){
            if(team.get(i).getTeamSupported().equals(e.manager) && team.get(i).approveBonus(bonus)){
                e.bonus += bonus;
                team.get(i).bonusBudget -= bonus;
                return true;
            }
        }
        return false;
    }

    public String getTeamStatus(){
        if (team.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
        } else {
            String teamStatus="";
            for (int i=0;i<team.size();i++){
                teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
        }
    }
}
