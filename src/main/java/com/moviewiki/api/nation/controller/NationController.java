package com.moviewiki.api.nation.controller;

import com.moviewiki.api.nation.domain.Nation;
import com.moviewiki.api.nation.service.NationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "")
public class NationController {
//
//    @Autowired
//    private NationService nationService;
//
//    @RequestMapping(value = "")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping(value = "findall", method = RequestMethod.GET)
//    public List<Nation> findAll() {
//        return (List<Nation>) nationService.findAll();
//    }
//
//    @PostMapping("/read")
//    public Optional<Nation> findById(@RequestBody Nation param){
//        return nationService.findById(param.getNationId());
//    }

}
