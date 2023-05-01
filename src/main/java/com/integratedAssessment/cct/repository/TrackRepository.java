package com.integratedAssessment.cct.repository;

import com.integratedAssessment.cct.model.Track;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* Spring Data MongoDB library - provides a set of methods for performing CRUD operations on a MongoDB database
 *   specifies the Track entity class and the type of ObjectId
 * (Helps to perform CRUD operations)
 * */
@Repository
public interface TrackRepository extends MongoRepository<Track, ObjectId> {
    public List<Track> findAll();
}
