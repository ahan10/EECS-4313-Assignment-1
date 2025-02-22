package org.longbox.domainobjects.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "star_ratings")
@Getter
@Setter

public class StarRating {

	@EmbeddedId
	private ComicBookListId id = new ComicBookListId();
	
    @Column(name = "rating")
    private int rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("comicBookId")
    @JoinColumn(name = "comic_book_id", insertable = false, updatable = false)
    private ComicBook comicBook;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("userId")
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public StarRating() {
    }

    public long getComicBookId(){
    	return this.comicBook.getId();
    }

    public long getUserId(){
    	return this.user.getId();
    }
}
