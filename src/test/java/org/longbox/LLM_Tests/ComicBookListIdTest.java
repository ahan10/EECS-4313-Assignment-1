package org.longbox.LLM_Tests;

import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.ComicBookListId;

import static org.junit.jupiter.api.Assertions.*;

class ComicBookListIdTest {
    @Test
    void testEquals_SameObject() {
        ComicBookListId id1 = new ComicBookListId(1L, 2L);
        assertTrue(id1.equals(id1)); // Self-check
    }

    @Test
    void testEquals_NullObject() {
        ComicBookListId id1 = new ComicBookListId(1L, 2L);
        assertFalse(id1.equals(null)); // Should not be equal to null
    }

    @Test
    void testEquals_DifferentClass() {
        ComicBookListId id1 = new ComicBookListId(1L, 2L);
        String differentClass = "Some String";
        assertFalse(id1.equals(differentClass)); // Different type should return false
    }

    @Test
    void testEquals_DifferentValues() {
        ComicBookListId id1 = new ComicBookListId(1L, 2L);
        ComicBookListId id2 = new ComicBookListId(3L, 4L);
        assertFalse(id1.equals(id2)); // Different values should not be equal
    }

    @Test
    void testEquals_SameValues() {
        ComicBookListId id1 = new ComicBookListId(1L, 2L);
        ComicBookListId id2 = new ComicBookListId(1L, 2L);
        assertTrue(id1.equals(id2)); // Same values should be equal
    }

    @Test
    void testEquals_DifferentUserId() {
        ComicBookListId id1 = new ComicBookListId(1L, 2L);
        ComicBookListId id2 = new ComicBookListId(3L, 2L);
        assertFalse(id1.equals(id2)); // Different userId should not be equal
    }

    @Test
    void testEquals_DifferentComicBookId() {
        ComicBookListId id1 = new ComicBookListId(1L, 2L);
        ComicBookListId id2 = new ComicBookListId(1L, 3L);
        assertFalse(id1.equals(id2)); // Different comicBookId should not be equal
    }

    @Test
    void testEquals_NullUserId() {
        ComicBookListId id1 = new ComicBookListId(null, 2L);
        ComicBookListId id2 = new ComicBookListId(1L, 2L);
        assertFalse(id1.equals(id2));
    }

    @Test
    void testEquals_NullComicBookId() {
        ComicBookListId id1 = new ComicBookListId(1L, null);
        ComicBookListId id2 = new ComicBookListId(1L, 2L);
        assertFalse(id1.equals(id2));
    }

    @Test
    void testEquals_BothNullIds() {
        ComicBookListId id1 = new ComicBookListId(null, null);
        ComicBookListId id2 = new ComicBookListId(null, null);
        assertTrue(id1.equals(id2));
    }

    @Test
    void testHashCode_SameValues() {
        ComicBookListId id1 = new ComicBookListId(1L, 2L);
        ComicBookListId id2 = new ComicBookListId(1L, 2L);
        assertEquals(id1.hashCode(), id2.hashCode()); // Same values should have same hashcode
    }

    @Test
    void testHashCode_DifferentValues() {
        ComicBookListId id1 = new ComicBookListId(1L, 2L);
        ComicBookListId id2 = new ComicBookListId(3L, 4L);
        assertNotEquals(id1.hashCode(), id2.hashCode()); // Different values should have different hashcode
    }

    @Test
    void testHashCode_NullUserId() {
        ComicBookListId id1 = new ComicBookListId(null, 2L);
        ComicBookListId id2 = new ComicBookListId(null, 2L);
        assertEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void testHashCode_NullComicBookId() {
        ComicBookListId id1 = new ComicBookListId(1L, null);
        ComicBookListId id2 = new ComicBookListId(1L, null);
        assertEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void testSetUserId() {
        ComicBookListId id = new ComicBookListId();
        id.setUserId(5L);
        assertEquals(5L, id.getUserId()); // Ensure setter works
    }

    @Test
    void testSetComicBookId() {
        ComicBookListId id = new ComicBookListId();
        id.setComicBookId(10L);
        assertEquals(10L, id.getComicBookId()); // Ensure setter works
    }
}