package dao;

import model.Departments;
import model.News;
import model.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {

    private Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
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
    public void add(Departments department) {

        String query = "INSERT INTO departments (name,description,number_of_employees) values(:name, :description, :number_of_employees)";

        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        }catch (Sql2oException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addUserToDepartment(Users user, Departments department) {

    }

    @Override
    public List<Departments> getAll() {
        getDrivers();
        String sql = "SELECT * FROM departments";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public Departments findById(int id) {
        getDrivers();
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }
    }

    @Override
    public List<Users> getAllUsersInDepartment(int department_id) {
        getDrivers();
        String sql = "SELECT * FROM users WHERE id = :id";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public List<News> getDepartmentNews(int id) {
        getDrivers();
        String sql = "SELECT * FROM news";
        try (Connection connection = sql2o.open()){
            return connection.createQuery(sql)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void clearAll() {
        getDrivers();
        String sql = "DELETE from departments";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(int id) {
        getDrivers();
        String sql = "DELETE FROM departments WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }
}
