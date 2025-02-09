package org.longbox.LLM_Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.longbox.businesslogic.UserSession;
import org.longbox.businesslogic.utils.ComicBookSearchUtils;
import org.longbox.domainobjects.dto.ComicBookDto;
import org.longbox.domainobjects.dto.UserDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComicBookSearchUtilsTest {

    ComicBookDto comicBook1;
    ComicBookDto comicBook2;
    ComicBookDto comicBook3;
    ComicBookDto comicBook4;
    ComicBookDto comicBook5;
    ComicBookDto comicBook6;
    ComicBookDto comicBook7;
    ComicBookDto comicBook8;
    List<ComicBookDto> comicBookDtoList;
    UserDto u1DTO;
    UserSession userSession;

    @BeforeEach
    public void setup() {

        comicBookDtoList = new ArrayList<>();

        comicBook1 = new ComicBookDto();
        comicBook1.setSeriesTitle("Zot!");
        comicBook1.setAuthor("Scott McCloud");
        comicBook1.setArtist("Scott McCloud");
        comicBook1.setGenres(new String[] {"Superhero", "Superpower", "Adventure", "Science Fiction", "Futuristic", "Romance", "Drama"});
        comicBook1.setDescription("Description");
        comicBook1.setNumberOfIssues(36);
        comicBook1.setPublisher("Eclipse");
        comicBook1.setYearPublished(1984);
        comicBookDtoList.add(comicBook1);

        comicBook2 = new ComicBookDto();
        comicBook2.setSeriesTitle("Sanctuary");
        comicBook2.setAuthor("Sho Fumimura");
        comicBook2.setArtist("Ryoichi Ikegami");
        comicBook2.setGenres(new String[] {"Political", "Crime", "Thriller", "Manga"});
        comicBook2.setDescription("Description");
        comicBook2.setNumberOfIssues(108);
        comicBook2.setPublisher("Viz");
        comicBook2.setYearPublished(1990);
        comicBookDtoList.add(comicBook2);

        comicBook3 = new ComicBookDto();
        comicBook3.setSeriesTitle("Nexus (1981)");
        comicBook3.setAuthor("Mike Baron");
        comicBook3.setArtist("Steve Rude");
        comicBook3.setGenres(new String[] {"Superhero", "Planetary Romance", "Superpower", "Science Fiction", "Adventure", "Fantasy"});
        comicBook3.setDescription("Description");
        comicBook3.setNumberOfIssues(3);
        comicBook3.setPublisher("Capital");
        comicBook3.setYearPublished(1981);
        comicBookDtoList.add(comicBook3);

        comicBook4 = new ComicBookDto();
        comicBook4.setSeriesTitle("The Maxx");
        comicBook4.setAuthor("Sam Keith");
        comicBook4.setArtist("Sam Keith");
        comicBook4.setGenres(new String[] {"Fantasy", "Drama", "Comedy", "Superhero"});
        comicBook4.setDescription("Description");
        comicBook4.setNumberOfIssues(35);
        comicBook4.setPublisher("Image");
        comicBook4.setYearPublished(1993);
        comicBookDtoList.add(comicBook4);

        comicBook5 = new ComicBookDto();
        comicBook5.setSeriesTitle("");
        comicBook5.setAuthor("Scott McCloud");
        comicBook5.setArtist("Scott McCloud");
        comicBook5.setGenres(new String[] {"Superhero", "Superpower", "Adventure", "Science Fiction", "Futuristic", "Romance", "Drama"});
        comicBook5.setDescription("Description");
        comicBook5.setNumberOfIssues(36);
        comicBook5.setPublisher("Eclipse");
        comicBook5.setYearPublished(1984);
        comicBookDtoList.add(comicBook5);

        comicBook6 = new ComicBookDto();
        comicBook6.setSeriesTitle(null);
        comicBook6.setAuthor("Sho Fumimura");
        comicBook6.setArtist("Ryoichi Ikegami");
        comicBook6.setGenres(new String[] {"Political", "Crime", "Thriller", "Manga"});
        comicBook6.setDescription("Description");
        comicBook6.setNumberOfIssues(108);
        comicBook6.setPublisher("Viz");
        comicBook6.setYearPublished(1990);
        comicBookDtoList.add(comicBook6);

        comicBook7 = new ComicBookDto();
        comicBook7.setSeriesTitle("Nexus (1981)");
        comicBook7.setAuthor("Mike Baron");
        comicBook7.setArtist("Steve Rude");
        comicBook7.setGenres(new String[] {"Superhero", "Planetary Romance", "Superpower", "Science Fiction", "Adventure", "Fantasy"});
        comicBook7.setDescription("Description");
        comicBook7.setNumberOfIssues(3);
        comicBook7.setPublisher("Capital");
        comicBook7.setYearPublished(1981);
        comicBookDtoList.add(comicBook7);

        comicBook8 = new ComicBookDto();
        comicBook8.setSeriesTitle("The Maxx");
        comicBook8.setAuthor("Sam Keith");
        comicBook8.setArtist("Sam Keith");
        comicBook8.setGenres(new String[]{"Fantasy", "Drama", "Comedy", "Superhero"});
        comicBook8.setDescription("Description");
        comicBook8.setNumberOfIssues(35);
        comicBook8.setPublisher("Image");
        comicBook8.setYearPublished(1993);
        comicBookDtoList.add(comicBook8);

        u1DTO = new UserDto();
        u1DTO.setUserName("Always_Scheming");
        u1DTO.setFirstName("John");
        u1DTO.setLastName("Smith");
        u1DTO.setDob(new Date());
        u1DTO.setEmail("email@domain.com");
        u1DTO.setPassword("Always_Scheming");
        u1DTO.setCountry("USA");
        u1DTO.setDefaults();

        userSession = UserSession.getInstance(u1DTO);
    }

    @Test
    public void comicBookSearchByPublisherCaseInsensitive() {
        List<ComicBookDto> expected = new ArrayList<>();
        expected.add(comicBook1);
        expected.add(comicBook5);
        List<ComicBookDto> actual = ComicBookSearchUtils.searchComicBookByPublisher(comicBookDtoList, "eclipse");
        assertEquals(expected, actual, "Case insensitive search by publisher");
    }

    @Test
    public void comicBookSearchByPublisherNoMatch() {
        List<ComicBookDto> expected = new ArrayList<>();
        List<ComicBookDto> actual = ComicBookSearchUtils.searchComicBookByPublisher(comicBookDtoList, "nonexistent publisher");
        assertEquals(expected, actual, "Search by publisher with no matches");
    }

    @Test
    public void comicBookSearchByYearMatch() {
        List<ComicBookDto> expected = new ArrayList<>();
        expected.add(comicBook4);
        expected.add(comicBook8);
        List<ComicBookDto> actual = ComicBookSearchUtils.searchComicBookByYear(comicBookDtoList, "1993");
        assertEquals(expected, actual, "Search by year should return correct comics");
    }

    @Test
    public void comicBookSearchByYearNoMatch() {
        List<ComicBookDto> expected = new ArrayList<>();
        List<ComicBookDto> actual = ComicBookSearchUtils.searchComicBookByYear(comicBookDtoList, "2050");
        assertEquals(expected, actual, "Search by year should return empty list if no match");
    }


    @Test
    public void comicBookSearchByGenreCaseInsensitive() {
        List<ComicBookDto> expected = new ArrayList<>();
        expected.add(comicBook1);
        expected.add(comicBook3);
        expected.add(comicBook5);
        expected.add(comicBook7);
        List<ComicBookDto> actual = ComicBookSearchUtils.searchComicBookByGenre(comicBookDtoList, "science fiction"); // Ensure it's lowercase to match toUpperCase() conversion
        assertEquals(expected, actual, "Case insensitive search by genre should return correct results");
    }

    @Test
    public void comicBookSearchByGenreWithSpecialCharacters() {
        List<ComicBookDto> expected = new ArrayList<>();
        expected.add(comicBook2);
        expected.add(comicBook6);
        List<ComicBookDto> actual = ComicBookSearchUtils.searchComicBookByGenre(comicBookDtoList, "Crime"); // Remove special characters to match regex replacement
        assertEquals(expected, actual, "Genre search should ignore special characters and return the correct results");
    }

}