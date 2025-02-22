package org.longbox.persistence.stubdatabase;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.longbox.domainobjects.dto.StarRating;
import org.longbox.domainobjects.mapper.StarRatingMapper;
import org.longbox.persistence.dao.StarRatingDao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class StarRatingStubDb implements StarRatingDao, JsonConvertor{
	 private List<StarRating> starRatingsStubData = new ArrayList<>();
	    private final String ABSOLUTE_FILE_PATH = "src/main/resources/StarRatingStubDb.json";

	    @Override
	    public org.longbox.domainobjects.entity.StarRating getStarRatingById(long userID, long comicID) {
	    	for(StarRating s : starRatingsStubData) {
	    		if (s.getComicBookId() == comicID && s.getUserId() == userID) {
	    			return StarRatingMapper.toEntity(s);
	    		}
	    	}
			return null;
	    }

	    @Override
	    public List<StarRating> getStarRatingsByComic(Long comicID) {
	        List<StarRating> StarRatingList = new ArrayList<>();
	        for(StarRating s: starRatingsStubData) {
	            if(s.getComicBookId() == comicID){
	                StarRatingList.add(s);
	            }
	        }
	        return StarRatingList;
	    }

	    @Override
	    public void saveStarRating(StarRating StarRatingDTO) {
	    	boolean flag = false;
	    	for(StarRating s: starRatingsStubData) {
	    		if (s.getComicBookId() == StarRatingDTO.getComicBookId() && s.getUserId() == StarRatingDTO.getUserId()) {
	    			s.setRating(StarRatingDTO.getRating());
	    			flag = true;
	    		}
	    	}
	    	if (flag == false) {
	    		starRatingsStubData.add(StarRatingDTO);
	    	}
	    }

	    @Override
	    public List<StarRating> getStarRatingsByUser(Long userID) {
	        List<StarRating> StarRatingList = new ArrayList<>();
	        for(StarRating s: starRatingsStubData){
	            if(s.getUserId() == userID){
	                StarRatingList.add(s);
	            }
	        }
	        return StarRatingList;
	    }

	    public void loadJsonToArrayList(){
	        starRatingsStubData = deserializeStubData(ABSOLUTE_FILE_PATH);
	    }

	    @Override
	    public void serializeStubData() {
	        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	        String json = gson.toJson(starRatingsStubData);
	        try (PrintStream out = new PrintStream(new FileOutputStream(ABSOLUTE_FILE_PATH))) {
	            out.print(json);
	        } catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    @Override
	    public List<StarRating> deserializeStubData(String filepath) {
	        Type listType = new TypeToken<ArrayList<StarRating>>(){}.getType();
	        JsonReader reader = null;

	        try {
	            reader = new JsonReader(new FileReader(filepath));
	        }
	        catch (FileNotFoundException e) {
	            throw new RuntimeException(e);
	        }
	        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	        return gson.fromJson(reader, listType);
	    }
}
