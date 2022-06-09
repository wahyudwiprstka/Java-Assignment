import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCase {
    Accountant a = new Accountant("Wahyu");
    TechnicalLead tl = new TechnicalLead("Prastika");
    SoftwareEngineer se1 = new SoftwareEngineer("Ujang");
    BusinessLead bl = new BusinessLead("Otong");

    @Test
    void canCheckIn1(){
        se1.setCodeAccess(false);
        tl.addReport(se1);
        assertFalse(tl.approveCheckIn(se1));
    }
    @Test
    void canCheckIn2(){
        se1.setCodeAccess(true);
        tl.addReport(se1);
        assertTrue(tl.approveCheckIn(se1));
    }
    @Test
    void canApproveBonus1(){
        tl.addReport(se1);
        a.supportTeam(tl);
        assertFalse(a.approveBonus(20000000));
    }

    @Test
    void canApproveBonus2(){
        tl.addReport(se1);
        a.supportTeam(tl);
        assertTrue(a.approveBonus(1000));
    }

    @Test
    void canGetBonus1(){
        tl.addReport(se1);
        a.supportTeam(tl);
        bl.addReport(a, a.getTeamSupported());
        assertFalse(tl.requestBonus(se1, 20000000));
    }

    @Test
    void canGetBonus2(){
        tl.addReport(se1);
        a.supportTeam(tl);
        bl.addReport(a, a.getTeamSupported());
        assertTrue(tl.requestBonus(se1, 1000));
    }
}