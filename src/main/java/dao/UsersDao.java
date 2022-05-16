package dao;

import model.Departments;
import model.Users;

import java.util.List;

public interface UsersDao {
    //CRUD

    //create new user

    void  add(Users user);

    //read

    List<Users> getAll();
    List<Departments> getAllUserDepartments(int user_id);
    Users findById(int id);

    //update

    //delete

    void clearAll();
}
