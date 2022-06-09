import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void setCodeAccessTest(){
        SoftwareEngineer se = new SoftwareEngineer("Wahyu Dwi Prastika");
        se.setCodeAccess(false);
        assertTrue();
    }
}