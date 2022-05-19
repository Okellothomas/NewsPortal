import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUsersDao;
import model.Departments;
import model.News;
import model.Users;
import org.sql2o.Sql2o;
import com.google.gson.Gson;


import static  spark.Spark.*;

public class App {
    public static void main(String[] args) {



//        String connect = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connect,"","");

        String connect = "jdbc:postgresql://ec2-54-172-175-251.compute-1.amazonaws.com:5432/d19tsrp5ts9arv";
        Sql2o sql2o = new Sql2o(connect,"acutsmyrvfxroj","f6f2568b1bedb19e5723424cd139ea089f13b9effb3756dcc39ca0ba0196a631");

        Sql2oDepartmentDao sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao(sql2o);
        Sql2oUsersDao sql2oUsersDao = new Sql2oUsersDao(sql2o);
        sql2o.open();

        // create a new user.

        post("users/new","application/json", (request, response) -> {
            Gson gson = new Gson();
            Users users = gson.fromJson(request.body(), Users.class);
            sql2oUsersDao.add(users);
            response.status(201);
            return gson.toJson(users);
        });

        // get all the users
        get("/users","application/json", (request, response) -> {
            Gson gson = new Gson();
            return gson.toJson(sql2oUsersDao.getAll());
        });

        // get user by id.
        get("/users/:id","application/json", (request, response) -> {
            Gson gson = new Gson();
            int usersId = Integer.parseInt(request.params("id"));
            Users findUser = sql2oUsersDao.findById(usersId);
            return gson.toJson(findUser);
        });

        // create a new department.
        post("/departments/new","application/json", (request, response) -> {
            Gson gson = new Gson();
            Departments departments = gson.fromJson(request.body(), Departments.class);
            sql2oDepartmentDao.add(departments);
            response.status(201);
            return gson.toJson(departments);
        });

        //get all the departments.
        get("/departments","application/json", (request, response) -> {
            Gson gson = new Gson();
            return gson.toJson(sql2oDepartmentDao.getAll());
        });

        // get departments by id.
        get("/departments/:id","application/json", (request, response) -> {
            Gson gson = new Gson();
            int id = Integer.parseInt(request.params("id"));
            Departments departments = sql2oDepartmentDao.findById(id);
            return gson.toJson(departments);
        });

        // delete departments by id
        delete("/departments/:id","application/json", (request, response) -> {
            Gson gson = new Gson();
            int id = Integer.parseInt(request.params("id"));
            Departments departments = sql2oDepartmentDao.findById(id);
            sql2oDepartmentDao.deleteById(id);
            return gson.toJson(departments);
        });

        // create news blog.
        post("/news/new","application/json", (request, response) -> {
            Gson gson = new Gson();
            News news = gson.fromJson(request.body(), News.class);
            sql2oNewsDao.addNews(news);
            response.status(201);
            return gson.toJson(news);
        });


        // get all the news blogs.
        get("/news","application/json", (request, response) -> {
            Gson gson = new Gson();
            return gson.toJson(sql2oNewsDao.getAll());
        });


        // get news blog by id.
        get("/news/:id","application/json", (request, response) -> {
            Gson gson = new Gson();
            int id = Integer.parseInt(request.params("id"));
            News news = sql2oNewsDao.findById(id);
            return gson.toJson(news);
        });


        // delete  new blog by id.
        get("news/:id","application/json", (request, response) -> {
            Gson gson = new Gson();
            int id = Integer.parseInt(request.params("id"));
            News news = sql2oNewsDao.findById(id);
            sql2oNewsDao.deleteById(id);
            return gson.toJson(news);
        });

        // delete  new blog by id.
        get("news/:id","application/json", (request, response) -> {
            Gson gson = new Gson();
            int id = Integer.parseInt(request.params("id"));
            News news = sql2oNewsDao.findById(id);
            sql2oNewsDao.deleteById(id);
            return gson.toJson(news);
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
