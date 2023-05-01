package com.integratedAssessment.cct.controllers;

import com.integratedAssessment.cct.model.Track;
import com.integratedAssessment.cct.services.TrackService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping()
    public ModelAndView getTrackView(@RequestParam(defaultValue = "0") int page) {
        ModelAndView mav = new ModelAndView("chart/tracksView");
        int pageSize = 25;
        int offset = page * pageSize;
        List<Track> tracks = trackService.getTracksByPage(offset, pageSize);
        mav.addObject("tracks", tracks);
        mav.addObject("currentPage", page);
        mav.addObject("hasMorePages", !tracks.isEmpty());
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
