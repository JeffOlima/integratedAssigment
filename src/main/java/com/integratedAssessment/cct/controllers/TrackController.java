package com.integratedAssessment.cct.controllers;

import com.integratedAssessment.cct.model.Track;
import com.integratedAssessment.cct.services.TrackService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping()
    public ModelAndView getTrackView(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(required = false, defaultValue = "popularity")String sortField) {
        ModelAndView mav = new ModelAndView("chart/tracksView");
        int pageSize = 25;
        int track_place = 0;
        int offset = page * pageSize;
        List<Track> tracks = trackService.getSortedTracksBy_Popularity(offset, pageSize, sortField, Sort.Direction.DESC);
        mav.addObject("tracks", tracks);
        mav.addObject("currentPage", page);
        mav.addObject("hasMorePages", !tracks.isEmpty());
        mav.addObject("track_place", track_place);
        mav.addObject("sortField", sortField);
        mav.addObject("danceabilitySort", "danceability".equals(sortField)); // add this line
        mav.addObject("popularitySort", "popularity".equals(sortField)); // add this line
        return mav;
    }


    @GetMapping("/{id}")
    public ModelAndView getOneSong(@PathVariable ObjectId id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("tracksView");
        mav.addObject("track", trackService.findOne(id));
        return mav;
    }

}
