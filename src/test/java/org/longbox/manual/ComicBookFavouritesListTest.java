package org.longbox.manual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ComicBookFavouritesListTest {
    User user1;
    ComicBook comicBook1;
    ComicBookFavouritesList comicBookFavouritesList;

    @BeforeEach
    public void setUp() {
        user1 = new User();
        user1.setId(1L);
        user1.setUserName("user1");
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setDob(new Date());
        user1.setEmail("john.doe@example.com");
        user1.setPassword("password");
        user1.setCountry("USA");
        user1.setDefaults();


        comicBook1 = new ComicBook();
        comicBook1.setId(1L);
        comicBook1.setSeriesTitle("Series Title");
        comicBook1.setAuthor("Author");
        comicBook1.setArtist("Artist");
        comicBook1.setGenres("Genre1, Genre2");
        comicBook1.setPublisher("Publisher");
        comicBook1.setYearPublished(2022);
    }

    @Test
    public void testConstructor() {
        comicBookFavouritesList = new ComicBookFavouritesList(user1, comicBook1);

        assertEquals(user1, comicBookFavouritesList.getUser());
        assertEquals(comicBook1, comicBookFavouritesList.getComicBook());
    }

    @Test
    public void testDate() {
        comicBookFavouritesList = new ComicBookFavouritesList();
        comicBookFavouritesList.setComicBook(comicBook1);
        comicBookFavouritesList.setUser(user1);
        comicBookFavouritesList.setDateAdded(new Date());

        assertEquals(new Date(), comicBookFavouritesList.getDateAdded());
    }
}
