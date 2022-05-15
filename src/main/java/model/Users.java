package model;

import java.util.Objects;

public class Users {

    private String name;
    private String role;
    private String position;
    private int departmentId;
    private int id;

    public Users(String name, String role, String position, int departmentId) {
        this.name = name;
        this.role = role;
        this.position = position;
        this.departmentId = departmentId;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return departmentId == users.departmentId &&
                id == users.id &&
                Objects.equals(name, users.name) &&
                Objects.equals(role, users.role) &&
                Objects.equals(position, users.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role, position, departmentId, id);
    }
}
