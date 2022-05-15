package model;

import java.util.Objects;

public class News {

    private  String tittle;
    private String description;
    private String departmental_title;
    int id;

    public News(String tittle, String description, String departmental_title) {
        this.tittle = tittle;
        this.description = description;
        this.departmental_title = departmental_title;
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmental_title() {
        return departmental_title;
    }

    public void setDepartmental_title(String departmental_title) {
        this.departmental_title = departmental_title;
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
        News news = (News) o;
        return id == news.id &&
                Objects.equals(tittle, news.tittle) &&
                Objects.equals(description, news.description) &&
                Objects.equals(departmental_title, news.departmental_title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tittle, description, departmental_title, id);
    }
}
