package org.longbox.businesslogic.service;

import java.text.DecimalFormat;
import java.util.List;
import org.longbox.domainobjects.dto.StarRating;
import org.longbox.persistence.dao.StarRatingDao;

public class StarRatingService {

	StarRatingDao starRatingDao;

	public StarRatingService(StarRatingDao starRatingDao) {
		this.starRatingDao = starRatingDao;
	}

	public String getAvgStarRatingsByComic(Long comicId) {
		if (starRatingDao.getStarRatingsByComic(comicId).isEmpty()) {
			return "0";
		}
		
		else {
			DecimalFormat df = new DecimalFormat("#.#");
	        df.setRoundingMode(java.math.RoundingMode.HALF_UP);

			float runningSum = 0;
			List<StarRating> ratings = starRatingDao.getStarRatingsByComic(comicId);
			
			for (StarRating rating : ratings) {
				runningSum += rating.getRating();
			}
			
			String roundedNumber = df.format(runningSum/ratings.size());
			return roundedNumber;
		}
	}

	public void saveStarRating(StarRating starRatingDto) {
		starRatingDao.saveStarRating(starRatingDto);
	}
	
	public String getStarRatingByID(long userId, Long comicId) {
		if (starRatingDao.getStarRatingById(userId, comicId) != null) {
			return Integer.toString(starRatingDao.getStarRatingById(userId, comicId).getRating());
		}
		else {
			return "Not rated";
		}
	}
}
