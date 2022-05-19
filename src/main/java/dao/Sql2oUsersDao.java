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

    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Users user) {

        String query = "INSERT INTO users (name,role,position,departmentId) values(:name, :role, :position, :departmentId)";

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
    public List<Users> usersNews(int new_id) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        getDrivers();
        String sql = "DELETE FROM users WHERE id = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e) {
            System.out.println(e);
        }
    }

    @Override
    public void clearAll() {

    }
}
