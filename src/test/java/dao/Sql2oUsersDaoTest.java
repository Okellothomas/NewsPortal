package dao;

import model.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oUsersDaoTest {

    private Sql2oUsersDao sql2oUsersDao;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        String connect = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connect,"","");
        sql2oUsersDao = new Sql2oUsersDao(sql2o);
        connection = sql2o.open();
    }

    @Test
    public void  add_addsNewUser_true(){
        Users users = setNewUser();
        int id = users.getId();
        sql2oUsersDao.add(users);
        assertNotEquals(id, users.getId());
    }

    @Test
    public void  get_returnsAllUsers_true(){
        Users users = setNewUser();
        Users users1 = new Users("John","pastor","chaplin",2);
        sql2oUsersDao.add(users);
        sql2oUsersDao.add(users1);;
        assertEquals(2,sql2oUsersDao.getAll().size());
    }


    // the helper
    public Users setNewUser(){
        return new Users("Mark","teacher","head",1);
    }

    @After
    public void closeConn(){
        connection.close();
    }
}