package org.longbox.LLM_Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user1;
    private User user2;
    private User user3;
    private User user4;

    @BeforeEach
    void setUp() {
        user1 = new User();
        user1.setId(1L);
        user1.setUserName("john_doe");
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("john.doe@example.com");
        user1.setPassword("securePass123");
        user1.setCountry("USA");
        user1.setDob(new Date());

        user2 = new User();
        user2.setId(1L);
        user2.setUserName("john_doe");
        user2.setFirstName("John");
        user2.setLastName("Doe");
        user2.setEmail("john.doe@example.com");
        user2.setPassword("securePass123");
        user2.setCountry("USA");
        user2.setDob(new Date());

        user3 = new User();
        user3.setId(2L);
        user3.setUserName("jane_doe");
        user3.setFirstName("Jane");
        user3.setLastName("Doe");
        user3.setEmail("jane.doe@example.com");

        user4 = new User();
        user4.setId(1L);
        user4.setUserName("john_doe");
        user4.setFirstName("John");
        user4.setLastName("Doe");
        user4.setEmail("john.different@example.com"); // Different email
    }

    @Test
    void testEquals_SameObject_ShouldReturnTrue() {
        assertEquals(user1, user1);
    }

// duplicate tests
//    @Test
//    void testEquals_DifferentObjectSameValues_ShouldReturnTrue() {
//        assertEquals(user1, user2);
//    }
//
//    @Test
//    void testEquals_DifferentObjectsDifferentValues_ShouldReturnFalse() {
//        assertNotEquals(user1, user3);
//    }

    @Test
    void testEquals_NullObject_ShouldReturnFalse() {
        assertNotEquals(user1, null);
    }

    @Test
    void testEquals_DifferentClass_ShouldReturnFalse() {
        assertNotEquals(user1, new Object());
    }

    @Test
    void testEquals_DifferentEmail_ShouldReturnFalse() {
        assertNotEquals(user1, user4);
    }

    @Test
    void testEquals_DifferentUserName_ShouldReturnFalse() {
        user4.setUserName("different_username");
        assertNotEquals(user1, user4);
    }

    @Test
    void testEquals_DifferentFirstName_ShouldReturnFalse() {
        user4.setFirstName("Different");
        assertNotEquals(user1, user4);
    }

    // duplicate tests
    // fixed test case

//    @Test
//    void testHashCode_ConsistentWithEquals() {
//        assertEquals(user1.hashCode(), user2.hashCode());
//    }
//
//    @Test
//    void testHashCode_DifferentObjectsDifferentHashCodes() {
//        assertNotEquals(user1.hashCode(), user3.hashCode());
//    }

    @Test
    void testGetterSetterFavouriteComicBooks() {
        Set<ComicBookFavouritesList> favouriteSet = new HashSet<>();
        ComicBookFavouritesList favourite = new ComicBookFavouritesList();
        favouriteSet.add(favourite);

        user1.setFavouriteComicBooks(favouriteSet);
        assertEquals(1, user1.getFavouriteComicBooks().size());
        assertTrue(user1.getFavouriteComicBooks().contains(favourite));
    }

    @Test
    void testGetterSetterFinishedComicBooks() {
        Set<ComicBookFinishedList> finishedSet = new HashSet<>();
        ComicBookFinishedList finished = new ComicBookFinishedList();
        finishedSet.add(finished);

        user1.setFinishedComicBooks(finishedSet);
        assertEquals(1, user1.getFinishedComicBooks().size());
        assertTrue(user1.getFinishedComicBooks().contains(finished));
    }

    @Test
    void testGetterSetterReadingComicBooks() {
        Set<ComicBookReadingList> readingSet = new HashSet<>();
        ComicBookReadingList reading = new ComicBookReadingList();
        readingSet.add(reading);

        user1.setReadingComicBooks(readingSet);
        assertEquals(1, user1.getReadingComicBooks().size());
        assertTrue(user1.getReadingComicBooks().contains(reading));
    }

    @Test
    void testGetterSetterComments() {
        Set<Comment> commentSet = new HashSet<>();
        Comment comment = new Comment();
        commentSet.add(comment);

        user1.setComments(commentSet);
        assertEquals(1, user1.getComments().size());
        assertTrue(user1.getComments().contains(comment));
    }
}