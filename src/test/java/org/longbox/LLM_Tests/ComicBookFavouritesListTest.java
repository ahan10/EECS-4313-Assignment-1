package org.longbox.LLM_Tests;

import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.ComicBookFavouritesList;
import org.longbox.domainobjects.entity.ComicBookListId;

import static org.junit.jupiter.api.Assertions.*;

class ComicBookFavouritesListTest {
    @Test
    void testEqualsSameObject() {
        ComicBookFavouritesList cbf = new ComicBookFavouritesList();
        assertEquals(cbf, cbf, "An object should be equal to itself.");
    }

    @Test
    void testEqualsNull() {
        ComicBookFavouritesList cbf = new ComicBookFavouritesList();
        assertNotEquals(cbf, null, "An object should not be equal to null.");
    }

    @Test
    void testEqualsDifferentClass() {
        ComicBookFavouritesList cbf = new ComicBookFavouritesList();
        assertNotEquals(cbf, new Object(), "An object should not be equal to an instance of another class.");
    }

    @Test
    void testEqualsDifferentIds() {
        ComicBookFavouritesList cbf1 = new ComicBookFavouritesList();
        cbf1.setId(new ComicBookListId(1L, 1L));

        ComicBookFavouritesList cbf2 = new ComicBookFavouritesList();
        cbf2.setId(new ComicBookListId(2L, 2L));

        assertNotEquals(cbf1, cbf2, "Objects with different IDs should not be equal.");
    }

    @Test
    void testEqualsOneNullId() {
        ComicBookFavouritesList cbf1 = new ComicBookFavouritesList();
        cbf1.setId(new ComicBookListId(1L, 1L));

        ComicBookFavouritesList cbf2 = new ComicBookFavouritesList();
        cbf2.setId(null);

        assertNotEquals(cbf1, cbf2, "An object with a null ID should not be equal to an object with a non-null ID.");
    }

    @Test
    void testEqualsBothNullIds() {
        ComicBookFavouritesList cbf1 = new ComicBookFavouritesList();
        cbf1.setId(null);

        ComicBookFavouritesList cbf2 = new ComicBookFavouritesList();
        cbf2.setId(null);

        assertEquals(cbf1, cbf2, "Two objects with null IDs should be equal.");
    }

    @Test
    void testHashCodeSameId() {
        ComicBookFavouritesList cbf1 = new ComicBookFavouritesList();
        cbf1.setId(new ComicBookListId(1L, 1L));

        ComicBookFavouritesList cbf2 = new ComicBookFavouritesList();
        cbf2.setId(new ComicBookListId(1L, 1L));

        assertEquals(cbf1.hashCode(), cbf2.hashCode(), "Objects with the same ID should have the same hashCode.");
    }

    @Test
    void testHashCodeDifferentId() {
        ComicBookFavouritesList cbf1 = new ComicBookFavouritesList();
        cbf1.setId(new ComicBookListId(1L, 1L));

        ComicBookFavouritesList cbf2 = new ComicBookFavouritesList();
        cbf2.setId(new ComicBookListId(2L, 2L));

        assertNotEquals(cbf1.hashCode(), cbf2.hashCode(), "Objects with different IDs should have different hashCodes.");
    }
}