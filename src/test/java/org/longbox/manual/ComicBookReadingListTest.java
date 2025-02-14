package org.longbox.manual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.ComicBook;
import org.longbox.domainobjects.entity.ComicBookReadingList;
import org.longbox.domainobjects.entity.User;

import static org.junit.jupiter.api.Assertions.*;

public class ComicBookReadingListTest {
    User user;
    ComicBook comicBook;
    ComicBookReadingList list;
    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(1L);
        comicBook = new ComicBook();
        comicBook.setId(1L);

        list = new ComicBookReadingList(user, comicBook);
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(list, list);
    }

    @Test
    void testEquals_DifferentObject() {
        assertNotEquals(list, new Object());
    }

    @Test
    void testEquals_Null() {
        assertNotEquals(list, null);
    }
}
