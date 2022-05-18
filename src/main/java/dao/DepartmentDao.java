package dao;

import model.Departments;
import model.News;
import model.Users;

import java.util.List;

public interface DepartmentDao {
    // CRUD
    //create
    void add(Departments department);

    void addUserToDepartment(Users user, Departments department);
    //read

    List<Departments> getAll();

    Departments findById(int id);

    List<Users> getAllUsersInDepartment(int department_id);

    List<News> getDepartmentNews(int id);
    //update

    //delete
    void clearAll();

    // delete by id.
    void deleteById(int id);

}
