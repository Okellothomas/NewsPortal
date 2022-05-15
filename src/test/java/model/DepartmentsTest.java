package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    // returns department's id
    @Test
    public void getIdReturnsCorrectId_int() {
        Departments departmentsId = setNewDepartment();
        assertEquals(0, departmentsId.getId());
    }

    // returns department's name
    @Test
    public void getNameReturnsCorrectName_String() {
        Departments departmentsName = setNewDepartment();
        assertEquals("IT", departmentsName.getName());
    }

    // returns department's id
    @Test
    public void getDescriptionReturnsCorrectDescription_String() {
        Departments departmentsDesc = setNewDepartment();
        assertEquals("all IT employers", departmentsDesc.getDescription());
    }

    // returns department's id
    @Test
    public void getNoReturnsCorrectNo_int() {
        Departments departmentsNo_em = setNewDepartment();
        assertEquals(12, departmentsNo_em.getNumber_of_employees());
    }

    // the helper.
    public Departments setNewDepartment(){
        return new Departments("IT", "all IT employers", 12);
    }
}