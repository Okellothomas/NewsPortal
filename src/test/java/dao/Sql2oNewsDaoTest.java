package dao;

import model.Departments;
import model.News;
import model.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ServiceLoader;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {

    private Sql2oNewsDao sql2oNewsDao;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        String connect = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connect,"","");
        sql2oNewsDao = new Sql2oNewsDao(sql2o);
        connection = sql2o.open();
    }

    @Test
    public void  add_addsNewNews_true(){
        News news = setNewNews();
        int id  = news.getId();
        sql2oNewsDao.addNews(news);
        assertNotEquals(id, news.getId());
    }

    @Test
    public void  get_returnsAllNews_true(){
        News news = setNewNews();
        News news1 = new News("chrome","deadline is today","Developers");
        sql2oNewsDao.addNews(news);
        sql2oNewsDao.addNews(news1);
        assertEquals(2,sql2oNewsDao.getAll().size());
    }

    @Test
    public void existingNewsCanBeFoundById() throws Exception {
        News news = setNewNews();
        sql2oNewsDao.addNews(news);
        News foundNews = sql2oNewsDao.findById(news.getId());
        assertEquals(news, foundNews);
    }

    @Test
    public void deleteByIdDeletesCorrectNews_true() throws Exception {
        News news = setNewNews();
        sql2oNewsDao.addNews(news);
        sql2oNewsDao.deleteById(news.getId());
        assertEquals(0,sql2oNewsDao.getAll().size());
    }

    @Test
    public void clearAllNews() throws Exception {
        News news = setNewNews();
        News news1 = new News("Holidays","deadline is sure","Ok");
        sql2oNewsDao.addNews(news);
        sql2oNewsDao.addNews(news1);
        int sizeOfDao = sql2oNewsDao.getAll().size();
        sql2oNewsDao.clearAll();
        assertTrue(sizeOfDao > 0 && sizeOfDao >sql2oNewsDao.getAll().size());
    }

    // the helper
    public News setNewNews(){
        return new News("promote","deadline is tomorrow","IT");
    }

    @After
    public void closeConn(){
        connection.close();
    }
}