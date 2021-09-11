package com.moviewiki.api.directorFilmography.controller;

import com.moviewiki.api.directorFilmography.domain.DirectorFilmography;
import com.moviewiki.api.directorFilmography.service.DirectorFilmographyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DirectorFilmographyController {
//
    @Autowired
    private DirectorFilmographyServiceImpl directorFilmographyServiceImpl;

    @GetMapping("/directorfilmography/read/director")
    public String readDirector() {
        return "readDirector";
    }

    @PostMapping("/directorfilmography/read/director")
    public String readDirectorId(DirectorFilmography directorFilmography, Model model) {
        List<DirectorFilmography> directorList = directorFilmographyServiceImpl.findDirectorFilmographyByDirector(directorFilmography.getDirector());
        model.addAttribute("directors", directorList);
        return "readDirector";
    }

}
