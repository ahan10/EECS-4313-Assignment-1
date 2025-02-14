package org.longbox.domainobjects.mapper;

import org.longbox.businesslogic.service.ComicBookService;
import org.longbox.config.HibernateUtils;
import org.longbox.domainobjects.dto.StarRating;
import org.longbox.persistence.dao.ComicBookDaoImpl;

import java.util.List;
import java.util.stream.Collectors;

public class StarRatingMapper {
	
	static ComicBookService comicBookService = new ComicBookService(new ComicBookDaoImpl(HibernateUtils.getSessionFactory()));

    public static StarRating toDto(org.longbox.domainobjects.entity.StarRating entity) {
    	StarRating dto = new StarRating();
        dto.setUserId(entity.getUserId());
        dto.setComicBookId(entity.getComicBookId());
        dto.setRating(entity.getRating());
        return dto;
    }

    public static List<StarRating> toDtoList(List<org.longbox.domainobjects.entity.StarRating> entityList) {
        return entityList.stream()
                .map(StarRatingMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public static org.longbox.domainobjects.entity.StarRating toEntity(StarRating dto) {
    	org.longbox.domainobjects.entity.StarRating entity = new org.longbox.domainobjects.entity.StarRating();
        entity.setRating(dto.getRating());
        return entity;
    }
}
