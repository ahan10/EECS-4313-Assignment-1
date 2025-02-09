package org.longbox.LLM_Tests;
import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.ComicBook;
import org.longbox.domainobjects.entity.ComicBookReadingList;
import org.longbox.domainobjects.entity.ComicBookListId;
import org.longbox.domainobjects.entity.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ComicBookReadingListTest {
    @Test
    void testConstructor() {
        User user = new User();
        user.setId(1L);
        ComicBook comicBook = new ComicBook();
        comicBook.setId(2L);

        ComicBookReadingList list = new ComicBookReadingList(user, comicBook);

        assertNotNull(list.getId());
        assertEquals(1L, list.getId().getUserId());
        assertEquals(2L, list.getId().getComicBookId());
        assertNotNull(list.getDateAdded());
    }

    @Test
    void testNullUserAndComicBook() {
        ComicBookReadingList list = new ComicBookReadingList();
        assertNull(list.getUser());
        assertNull(list.getComicBook());
        assertNull(list.getDateAdded());
    }

    @Test
    void testSetters() {
        ComicBookReadingList list = new ComicBookReadingList();
        User user = new User();
        user.setId(5L);
        ComicBook comicBook = new ComicBook();
        comicBook.setId(10L);
        Date date = new Date();

        list.setUser(user);
        list.setComicBook(comicBook);
        list.setDateAdded(date);

        assertEquals(user, list.getUser());
        assertEquals(comicBook, list.getComicBook());
        assertEquals(date, list.getDateAdded());
    }

    @Test
    void testEqualsNullAndDifferentClass() {
        ComicBookReadingList list = new ComicBookReadingList();
        assertNotEquals(null, list);
        assertNotEquals(new Object(), list);
    }

    @Test
    void testEqualsDifferentIds() {
        ComicBookReadingList list1 = new ComicBookReadingList();
        list1.setId(new ComicBookListId(1L, 2L));

        ComicBookReadingList list2 = new ComicBookReadingList();
        list2.setId(new ComicBookListId(2L, 3L));

        assertNotEquals(list1, list2);
    }

    @Test
    void testHashCodeConsistency() {
        ComicBookReadingList list1 = new ComicBookReadingList();
        list1.setId(new ComicBookListId(1L, 2L));

        ComicBookReadingList list2 = new ComicBookReadingList();
        list2.setId(new ComicBookListId(1L, 2L));

        assertEquals(list1.hashCode(), list2.hashCode());

        list2.setId(new ComicBookListId(3L, 4L));
        assertNotEquals(list1.hashCode(), list2.hashCode());
    }

    @Test
    void testToString() {
        ComicBookReadingList list = new ComicBookReadingList();
        list.setId(new ComicBookListId(1L, 1L));

        String expected = "ComicBookReadingList{id=ComicBookListId(userId=1, comicBookId=1)}";
        assertEquals(expected, list.toString());
    }
}