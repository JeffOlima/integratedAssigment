package com.integratedAssessment.cct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
@Data
//@Data takes care of getters/setters and toString() methods
// annotation for creating our constructor that takes all fields ass arguments
@AllArgsConstructor
//this annotation is for creating constructor without args
@NoArgsConstructor
public class Track {
    @Id
    private ObjectId id;
    private String track_id;
    private String artists;
    private String album_name;
    private String track_name;
    private int popularity;
    private int duration_ms;
    private Boolean explicit;
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