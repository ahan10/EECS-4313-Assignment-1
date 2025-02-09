package org.longbox.LLM_Tests;

import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.ComicBook;
import org.longbox.domainobjects.entity.Comment;
import org.longbox.domainobjects.entity.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {
    @Test
    public void testDefaultConstructor() {
        Comment comment = new Comment();
        assertNotNull(comment);
        assertNull(comment.getMessage());
        assertNull(comment.getCommentDate());
        assertNull(comment.getComicBook());
        assertNull(comment.getUser());
        assertNull(comment.getUserName());
    }

    @Test
    public void testGettersAndSetters() {
        Comment comment = new Comment();
        Date now = new Date();

        comment.setMessage("Nice artwork!");
        comment.setCommentDate(now);

        assertEquals("Nice artwork!", comment.getMessage());
        assertEquals(now, comment.getCommentDate());
    }

    @Test
    public void testGetComicBookId() {
        Comment comment = new Comment();
        ComicBook comicBook = new ComicBook();
        comicBook.setId(100L);
        comment.setComicBook(comicBook);

        assertEquals(100L, comment.getComicBookId());
    }

    @Test
    public void testGetUserId() {
        Comment comment = new Comment();
        User user = new User();
        user.setId(200L);
        comment.setUser(user);

        assertEquals(200L, comment.getUserId());
    }

    @Test
    public void testGetComicBookIdWithNullComicBook() {
        Comment comment = new Comment();
        Exception exception = assertThrows(NullPointerException.class, comment::getComicBookId);
        assertNotNull(exception);
    }

    @Test
    public void testGetUserIdWithNullUser() {
        Comment comment = new Comment();
        Exception exception = assertThrows(NullPointerException.class, comment::getUserId);
        assertNotNull(exception);
    }

    @Test
    public void testSetAndGetId() {
        Comment comment = new Comment();
        comment.setId(42L);
        assertEquals(42L, comment.getId());
    }

    @Test
    public void testSetAndGetUserName() {
        Comment comment = new Comment();
        comment.setUserName("testUser");
        assertEquals("testUser", comment.getUserName());
    }
}