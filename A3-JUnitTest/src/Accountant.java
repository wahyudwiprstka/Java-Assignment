import java.util.ArrayList;

public class Accountant extends BusinessEmployee{
    public TechnicalLead supportedTeam;
    public Accountant(String name){
        super(name);
        bonusBudget = 0;
    }
    public TechnicalLead getTeamSupported(){
        return supportedTeam;
    }
    public void supportTeam(TechnicalLead lead){
        this.supportedTeam = lead;
        for (int i = 0; i < lead.team.size(); i++){
            this.bonusBudget += lead.team.get(i).getBaseSalary() * 0.1;
        }
    }
    public boolean approveBonus(double bonus){
        if (bonus < bonusBudget){
            return true;
        }else{
            return false;
        }
    }

    public String employeeStatus(){
        return super.employeeStatus() + " is supporting " + this.getTeamSupported();
    }
}
