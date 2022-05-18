package dao;

import model.Departments;
import model.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {

    private Sql2oDepartmentDao sql2oDepartmentDao;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        String connect = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connect,"","");
        sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        connection = sql2o.open();
    }

    @Test
    public void  add_addsNewDepartments_true(){
        Departments departments  = setNewDepartment();
        int id = departments.getId();
        sql2oDepartmentDao.add(departments);
        assertNotEquals(id,departments.getId());
    }

    @Test
    public void  get_returnsAllDepartments_true(){
        Departments departments = setNewDepartment();
        Departments departments1 = new Departments("Marketing", "our it winning team",33);
        sql2oDepartmentDao.add(departments);
        sql2oDepartmentDao.add(departments1);
        assertEquals(2, sql2oDepartmentDao.getAll().size());
    }

    // the helper
    public Departments setNewDepartment(){
        return new Departments("IT", "our it department",12);
    }

    @After
    public void closeConn(){
        connection.close();
    }
}