package dao;

import model.Departments;
import model.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUsersDao implements UsersDao {

    private Sql2o sql2o;

    public Sql2oUsersDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Users user) {

        String query = "INSERT INTO mentors (name,role,position,departmentId) values(:name, :role, :position, :departmentId)";

        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(query, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        }catch (Sql2oException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public List<Departments> getAllUserDepartments(int user_id) {
        return null;
    }

    @Override
    public Users findById(int id) {
        return null;
    }

    @Override
    public void clearAll() {

    }
}
