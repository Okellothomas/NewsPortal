package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    // returns user's name
    @Test
    public void getNameReturnsCorrectName_String() {
        Users newUserName = setNewUser();
        assertEquals("Okello", newUserName.getName());
    }

    // returns user's role
    @Test
    public void getRoleReturnsCorrectRole_String() {
        Users newUserRole = setNewUser();
        assertEquals("developer", newUserRole.getRole());
    }

    // returns user's department
    @Test
    public void getdepartmentReturnsCorrectDepartment_int() {
        Users newUserDepartement = setNewUser();
        assertEquals(1, newUserDepartement.getDepartmentId());
    }

    // returns user's position
    @Test
    public void getPositionReturnsCorrectPosition_String() {
        Users newUserPosition = setNewUser();
        assertEquals("Scrum master", newUserPosition.getPosition());
    }

    // returns user's id
    @Test
    public void getIdReturnsCorrectId_int() {
        Users newUserId = setNewUser();
        assertEquals(0, newUserId.getId());
    }

    // the helper.
    public Users setNewUser(){
        return new Users("Okello", "developer", "Scrum master", 1);
    }
}