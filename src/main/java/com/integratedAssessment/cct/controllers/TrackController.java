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

    //returns hot100 main trackList page
    //READ & SORT
    @GetMapping()
    public ModelAndView getTrackView(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "popularity") String sortField) {
        ModelAndView mav = new ModelAndView("musicChart/tracksView");
        int pageSize = 100;
        int offset = page * pageSize;
        List<Track> tracks = trackService.getSortedTrackListBy_Param(offset, pageSize, sortField, Sort.Direction.DESC);
        mav.addObject("tracks", tracks);
        mav.addObject("currentPage", page);
        mav.addObject("hasMorePages", !tracks.isEmpty());
        mav.addObject("sortField", sortField);

        return mav;
    }
    //UPDATE
    @GetMapping("/edit/{id}")
    public ModelAndView getOneSong(
            @PathVariable ObjectId id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "track_name") String sortField) {
        ModelAndView mav = new ModelAndView("musicChart/editTrack");
        Track foundTrack = trackService.findOne(id);
        if (foundTrack != null) {
            mav.addObject("track", foundTrack);
            mav.addObject("page", page);
            mav.addObject("sortField", sortField);
        } else {
            System.out.println("Error !!! @GETMAPPING (/edit/{id}) in TrackController Class");
        }
        return mav;
    }

    @PostMapping("/editTrack")
    public ModelAndView editTrack(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "track_name") String sortField,
            Track track)  {
        trackService.saveUpdatedTrack(track);

        ModelAndView mav = new ModelAndView("redirect:/tracks");
        mav.addObject("page", page);
        mav.addObject("sortField", sortField);
        return mav;
    }
    //DELETE
    @PostMapping ("/{id}")
    public ModelAndView deleteTrack(
            @PathVariable ObjectId id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "popularity") String sortField) {
        trackService.deleteTrack(id);
        System.out.println("deleted track with id " + id + "\n" +
                "page " + page + " sort " + sortField);
        ModelAndView mav = new ModelAndView("redirect:/tracks");
        mav.addObject("page", page);
        mav.addObject("sortField", sortField);
        return mav;
    }
}
