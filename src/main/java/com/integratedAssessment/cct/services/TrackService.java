package com.integratedAssessment.cct.services;

import com.integratedAssessment.cct.model.Track;
import com.integratedAssessment.cct.repository.TrackRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    //reference of the repository
    // (autowired instantiates the class for us, so we don't need initialize this instance)
    @Autowired
    private TrackRepository trackRepository;

    //db access method
    public List<Track> allTracks() {
        //findAll() described in the Mongo Repository Class and it returns a list of the datatype that we
        //defined in the TrackRepository class
        return trackRepository.findAll();
    }
    // returns List<Track> sorted by the one of the field that we pass as a parameter
    public List<Track> getSortedTrackListBy_Param(int offset, int limit, String field, Sort.Direction direction) {
        return trackRepository.findAll(PageRequest.of(offset, limit, Sort.by(direction, field))).getContent();
    }


    public Track findOne(ObjectId id) {
        Optional<Track> foundTrack = trackRepository.findById(id);
        return foundTrack.orElse(null);
    }
}
