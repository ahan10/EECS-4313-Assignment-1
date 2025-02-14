package org.longbox.unit.domainobjects.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.dto.StarRating;
import org.longbox.domainobjects.entity.ComicBook;
import org.longbox.domainobjects.entity.User;
import org.longbox.domainobjects.mapper.StarRatingMapper;

public class StarRatingMapperTest {
	@Test
    public void testToDto() {
        // Create a StarRating entity
        org.longbox.domainobjects.entity.StarRating starRating = new org.longbox.domainobjects.entity.StarRating();
        starRating.setUser(new User());
        starRating.getUser().setId(1L);
        starRating.setComicBook(new ComicBook());
        starRating.getComicBook().setId(1L);
        starRating.setRating(5);

        // Map the StarRating entity to a StarRatingDto
        StarRating starRatingDto = StarRatingMapper.toDto(starRating);

        // Verify that the mapping is correct
        assertNotNull(starRatingDto);
        assertEquals(1L, starRatingDto.getUserId());
        assertEquals(1L, starRatingDto.getComicBookId());
    }

	@Test
	public void testToDtoList() {
		List<org.longbox.domainobjects.entity.StarRating> starRatingList = new ArrayList<>();
		for (int i = 0; i <= 3; i++) {
			org.longbox.domainobjects.entity.StarRating starRating = new org.longbox.domainobjects.entity.StarRating();
			starRating.setUser(new User());
			starRating.getUser().setId((long) i);
			starRating.setComicBook(new ComicBook());
			starRating.getComicBook().setId((long) i);
			starRating.setRating(i);
			starRatingList.add(starRating);
		}
		
		List<StarRating> starRatingDtoList = StarRatingMapper.toDtoList(starRatingList);
		
        for (int i = 0; i < 3; i++) {
            assertEquals((long) (i), starRatingDtoList.get(i).getUserId());
            assertEquals((long) (i), starRatingDtoList.get(i).getComicBookId());
            assertEquals((i), starRatingDtoList.get(i).getRating());
        }
	}
	
	@Test
	public void testToEntity() {
		StarRating starRatingDto = new StarRating();
		starRatingDto.setRating(5);
		
		org.longbox.domainobjects.entity.StarRating starRating = StarRatingMapper.toEntity(starRatingDto);
		
		assertEquals(5, starRating.getRating());
	}
}
