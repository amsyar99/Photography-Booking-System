package com.demo.photographybooking.controller;

import com.demo.photographybooking.entity.Photographer;
import com.demo.photographybooking.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PhotographerController {

    @Autowired
    PhotographerService photographerService;

    @GetMapping("/getPhotographers")
    public List<Photographer> getAllPhotographers() {
        return photographerService.fetchAllPhotographers();
    }

    @PostMapping("/getPhotographersById")
    public Photographer getPhotographersById(@RequestBody Map<String, String> requestParams) {
        String id = requestParams.get("id");
        return photographerService.fetchById(id);
    }
}
