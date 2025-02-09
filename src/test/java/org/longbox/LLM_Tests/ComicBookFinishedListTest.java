package org.longbox.LLM_Tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.ComicBook;
import org.longbox.domainobjects.entity.ComicBookFinishedList;
import org.longbox.domainobjects.entity.ComicBookListId;
import org.longbox.domainobjects.entity.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ComicBookFinishedListTest {
    private ComicBookFinishedList cbf1, cbf2;
    private User user;
    private ComicBook comicBook;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);

        comicBook = new ComicBook();
        comicBook.setId(1L);

        cbf1 = new ComicBookFinishedList(user, comicBook);
        cbf2 = new ComicBookFinishedList(user, comicBook);
    }

    @Test
    void testConstructorInitialization() {
        assertNotNull(cbf1.getId());
        assertEquals(1L, cbf1.getUser().getId());
        assertEquals(1L, cbf1.getComicBook().getId());
        assertNotNull(cbf1.getDateAdded());
    }

    @Test
    void testGettersAndSetters() {
        cbf1.setDateAdded(new Date(0));
        assertEquals(new Date(0), cbf1.getDateAdded());

        ComicBookListId newId = new ComicBookListId(2L, 3L);
        cbf1.setId(newId);
        assertEquals(newId, cbf1.getId());
    }

    @Test
    void testEqualsWithSameInstance() {
        assertEquals(cbf1, cbf1);
    }

    @Test
    void testEqualsWithNull() {
        assertNotEquals(cbf1, null);
    }

    @Test
    void testEqualsWithDifferentClass() {
        assertNotEquals(cbf1, new Object());
    }

    @Test
    void testEqualsWithDifferentId() {
        ComicBookFinishedList cbfDifferent = new ComicBookFinishedList();
        cbfDifferent.setId(new ComicBookListId(2L, 2L));

        assertNotEquals(cbf1, cbfDifferent);
    }

    @Test
    void testHashCodeConsistency() {
        assertEquals(cbf1.hashCode(), cbf2.hashCode());
    }

    @Test
    void testHashCodeDifference() {
        ComicBookFinishedList cbfDifferent = new ComicBookFinishedList();
        cbfDifferent.setId(new ComicBookListId(2L, 3L));

        assertNotEquals(cbf1.hashCode(), cbfDifferent.hashCode());
    }

    @Test
    void testToString() {
        String expected = "ComicBookFinishedList{id=ComicBookListId(userId=1, comicBookId=1)}";
        assertEquals(expected, cbf1.toString());
    }

    @Test
    void testToStringWithNullId() {
        cbf1.setId(null);
        String expected = "ComicBookFinishedList{id=null}";
        assertEquals(expected, cbf1.toString());
    }
}