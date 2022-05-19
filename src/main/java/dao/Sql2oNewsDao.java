package dao;

import model.Departments;
import model.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{

    private Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNews(News news) {

        String query = "INSERT INTO news (tittle,description,departmental_title) values(:tittle, :description, :departmental_title)";

        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        }catch (Sql2oException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<News> getAll() {
        getDrivers();
        String sql = "SELECT * FROM news";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public void deleteById(int id) {
        getDrivers();
        String sql = "DELETE FROM news WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void clearAll() {
        getDrivers();
        String sql = "DELETE from news";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }
}
