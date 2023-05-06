package com.integratedAssessment.cct.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@Document(collection = "songs")
//@Data takes care of getters/setters and toString() methods
@Data
// annotation for creating our constructor that takes all fields ass arguments
@AllArgsConstructor
//this annotation is for creating constructor without args
@NoArgsConstructor
public class Track {
    @Id
    private ObjectId id;
    private String track_id;
    @Column(name = "artists")
    @Size(min=3, max = 100, message = "The Artist field needs to contain at least 3 characters")
    @NotBlank(message =" Artist field cannot be empty")
    private String artists;
    @Column(name = "album_name")
    @Size(min=3, max = 100, message = "The Album name field needs to contain at least 3 characters")
    @NotBlank(message =" Album name field cannot be empty")
    private String album_name;
    @Column(name = "track_name")
    @Size(min=3, max = 100, message = "The Track name field needs to contain at least 3 characters")
    @NotBlank(message =" Track name field cannot be empty")
    private String track_name;
    @Column(name = "popularity")
    @NotBlank(message =" Popularity field cannot be empty")
    @Min(value=0, message="must be equal or greater than 0")
    @Max(value=100, message="must be equal or less than 100")
    private int popularity;
    private int duration_ms;
    private Boolean explicit;
    @Column(name = "danceability")
    @NotBlank(message =" Danceability field cannot be empty")
    @DecimalMin(value = "0.1", inclusive = true)
    @DecimalMax(value = "0.9", inclusive = true)
    private double danceability;
    private double energy;
    private int key;
    private double loudness;
    private int mode;
    private double speechiness;
    private double acousticness;
    private double intrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private int time_signature;
    private String track_genre;
//    @DocumentReference
//    private List<Comment> commentsIds;
}