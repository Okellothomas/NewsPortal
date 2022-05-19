package dao;

import model.Departments;
import model.News;
import model.Users;
import org.h2.engine.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

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

    @Test
    public void existingUsersCanBeFoundById() throws Exception {
        Users users = setNewUser();
        sql2oUsersDao.add(users);
        Users foundUsers = sql2oUsersDao.findById(users.getId());
        assertEquals(users, foundUsers);
    }

    @Test
    public void deleteByIdDeletesCorrectUsers_true() throws Exception {
        Users users = setNewUser();
        sql2oUsersDao.add(users);
        sql2oUsersDao.deleteById(users.getId());
        assertEquals(0,sql2oUsersDao.getAll().size());
    }

    @Test
    public void clearAllUsers() throws Exception {
        Users users = setNewUser();
        Users users1 = new Users("John","developer","senior developer",5);
        sql2oUsersDao.add(users);
        sql2oUsersDao.add(users1);
        int sizeofDao = sql2oUsersDao.getAll().size();
        sql2oUsersDao.clearAll();
        assertTrue(sizeofDao > 0 && sizeofDao >sql2oUsersDao.getAll().size());
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