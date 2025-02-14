package org.longbox.persistence.dao;

import java.util.List;
import org.longbox.domainobjects.dto.StarRating;

public interface StarRatingDao {

	org.longbox.domainobjects.entity.StarRating getStarRatingById(long userId, long comicId);

    public List<StarRating> getStarRatingsByComic(Long comicId);

    void saveStarRating(StarRating StarRatingDTO);

    public List<StarRating> getStarRatingsByUser(Long userId);

}