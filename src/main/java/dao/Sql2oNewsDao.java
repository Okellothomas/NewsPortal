package dao;

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

    @Override
    public void addNews(News news) {

        String query = "INSERT INTO mentors (tittle,description,departmental_title) values(:tittle, :description, :departmental_title)";

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
        return null;
    }

    @Override
    public News findById(int id) {
        return null;
    }

    @Override
    public void deleteById() {

    }

    @Override
    public void clearAll() {

    }
}
