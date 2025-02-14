package org.longbox.manual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.StarRating;
import org.longbox.domainobjects.entity.ComicBook;
import org.longbox.domainobjects.entity.ComicBookListId;
import org.longbox.domainobjects.entity.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StarRatingTests {
    StarRating starRating1;
    User user, user1;
    ComicBook comicBook1;

    @BeforeEach
    void init() {

        user = new User();
        user.setId(1L);
        user.setUserName("user1");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setDob(new Date());
        user.setEmail("email@domain.com");
        user.setPassword("Always_Scheming");
        user.setCountry("USA");
        user.setDefaults();

        user1 = new User();
        user1.setId(2L);
        user1.setUserName("user1");
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setDob(new Date());
        user1.setEmail("email@domain.com");
        user1.setPassword("Always_Scheming");
        user1.setCountry("USA");
        user1.setDefaults();

        comicBook1 = new ComicBook();
        comicBook1.setId(1L);
        comicBook1.setSeriesTitle("Zot!");
        comicBook1.setAuthor("Scott McCloud");
        comicBook1.setArtist("Scott McCloud");
        comicBook1.setGenres("Superhero, Superpower, Adventure, Science Fiction, Futuristic, Romance, Drama");
        comicBook1.setDescription("Description");
        comicBook1.setNumberOfIssues(36);
        comicBook1.setPublisher("Eclipse");
        comicBook1.setYearPublished(1984);

        starRating1 = new StarRating();
        starRating1.setId(new ComicBookListId(1L, 1L));
        starRating1.setUser(user);
        starRating1.setComicBook(comicBook1);
        starRating1.setRating(5);
    }

    @Test
    void test_constructor_1(){
        assertEquals(5, starRating1.getRating());
        assertEquals(1L, starRating1.getUserId());
        assertEquals(1L, starRating1.getComicBookId());
    }

    @Test
    public void testGetters() {
        // Create a UserDto object
        User userDto = new User();
        userDto.setId(1L);

        // Create a ComicBookDto object
        ComicBook comicBookDto = new ComicBook();
        comicBookDto.setId(1L);

        // Test the constructor

        StarRating starRatingDto = new StarRating();
        ComicBookListId cbId = new ComicBookListId(1L, 1L);
        starRatingDto.setId(cbId);
        starRatingDto.setUser(userDto);
        starRatingDto.setComicBook(comicBookDto);

        // Verify that the StarRatingDto object is initialized correctly
        assertEquals(1L, starRatingDto.getUserId());
        assertEquals(1L, starRatingDto.getComicBookId());
        assertEquals(userDto, starRatingDto.getUser());
        assertEquals(comicBookDto, starRatingDto.getComicBook());
        assertEquals(cbId, starRatingDto.getId());
    }

}
