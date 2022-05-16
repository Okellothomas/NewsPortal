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

    @Override
    public void add(Departments department) {

        String query = "INSERT INTO mentors (name,description,number_of_employees) values(:name, :description, :number_of_employees)";

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
        return null;
    }

    @Override
    public Departments findById(int id) {
        return null;
    }

    @Override
    public List<Users> getAllUsersInDepartment(int department_id) {
        return null;
    }

    @Override
    public List<News> getDepartmentNews(int id) {
        return null;
    }

    @Override
    public void clearAll() {

    }
}
