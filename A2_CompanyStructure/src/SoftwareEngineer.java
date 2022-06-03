public class SoftwareEngineer extends TechnicalEmployee{
    private boolean codeAccess;

    public SoftwareEngineer(String name) {
        super(name);
        setCodeAccess(true);
        checkIns = 0;
    }

    public boolean getCodeAccess(){
        return codeAccess;
    }

    public void setCodeAccess(boolean access){
        codeAccess = access;
    }

    public int getSuccessfulCheckIns(){
        return checkIns;
    }

    public boolean checkInCode(){
        TechnicalLead tl = (TechnicalLead) this.getManager();
        if (tl.approveCheckIn(this)){
            this.checkIns++;
            return true;
        }else{
            codeAccess = false;
            return false;
        }
    }
}
