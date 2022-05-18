package dao;

import model.News;

import java.util.List;

public interface NewsDao {
    // CRUD

    //create

    void addNews(News news);

    //read
    List<News> getAll();

    News findById(int id);

    //update

    //delete by id
    void deleteById();

    // delete all news instances.
    void clearAll();
}
