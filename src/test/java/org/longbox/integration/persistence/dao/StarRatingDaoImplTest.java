package org.longbox.integration.persistence.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.longbox.config.HibernateUtils;
import org.longbox.domainobjects.dto.StarRating;
import org.longbox.persistence.dao.StarRatingDaoImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

public class StarRatingDaoImplTest {

    StarRatingDaoImpl starRatingDaoImpl;

    @BeforeEach
    void setup() {
        starRatingDaoImpl = new StarRatingDaoImpl(HibernateUtils.getSessionFactory());
    }

    @Test
	void test_getStarRatingsByComic_1() {
		List<StarRating> actualList = starRatingDaoImpl.getStarRatingsByComic(1L);
		int actual = actualList.size();
		assertEquals(2, actual);
	}
    
    @Test
   	void test_getStarRatingsByComic_2() {
   		List<StarRating> actualList = starRatingDaoImpl.getStarRatingsByComic(2L);
   		int actual = actualList.size();
   		assertEquals(2, actual);
   	}
    
    @Test
   	void test_getStarRatingsByComic_3() {
   		List<StarRating> actualList = starRatingDaoImpl.getStarRatingsByComic(3L);
   		int actual = actualList.size();
   		assertEquals(2, actual);
   	}
    
    @Test
    void test_ratingNotFound() {
        org.longbox.domainobjects.entity.StarRating starRating = starRatingDaoImpl.getStarRatingById(101L,100L);
        assertEquals(null,starRating);
    }
    
    @Test
    void test_saveStarRating() {
    	StarRating addStarRating = new StarRating();
    	addStarRating.setUserId(1);
    	addStarRating.setComicBookId(1);
    	addStarRating.setRating(5);
    	starRatingDaoImpl.saveStarRating(addStarRating);
    	assertEquals(starRatingDaoImpl.getStarRatingById(1, 1).getRating(), 5);
    }
    
    @Test
    void test_getStarRatingbyId_1() {
    	org.longbox.domainobjects.entity.StarRating actualStarRating = starRatingDaoImpl.getStarRatingById(1L, 1L);
    	assertEquals(actualStarRating.getRating(), 5);
    }

    @Test
    void test_getStarRatingbyId_2() {
    	org.longbox.domainobjects.entity.StarRating actualStarRating = starRatingDaoImpl.getStarRatingById(3L, 1L);
    	assertNull(actualStarRating);
    }

    @Test
    void test_getStarRatingbyId_3() {
    	org.longbox.domainobjects.entity.StarRating actualStarRating = starRatingDaoImpl.getStarRatingById(25L, 2L);
    	assertEquals(actualStarRating.getRating(), 5);
    }
}
