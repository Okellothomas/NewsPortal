package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    // returns news's title
    @Test
    public void getTitleReturnsCorrectTitle_String() {
        News newsTitle = setNewNews();
        assertEquals("promotion", newsTitle.getTittle());
    }

    // returns news's description
    @Test
    public void getDescriptionReturnsCorrectDescription_String() {
        News newsDescription = setNewNews();
        assertEquals("got promoted today", newsDescription.getDescription());
    }

    // returns news's department
    @Test
    public void getDepartmentReturnsCorrectDepartment_String() {
        News newsDepartment = setNewNews();
        assertEquals("IT", newsDepartment.getDepartmental_title());
    }

    // returns news's id
    @Test
    public void getIdReturnsCorrectId_String() {
        News newsId = setNewNews();
        assertEquals(0, newsId.getId());
    }


    // the helper.
    public News setNewNews(){
        return new News("promotion", "got promoted today", "IT");
    }
}