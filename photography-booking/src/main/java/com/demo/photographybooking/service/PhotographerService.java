package com.demo.photographybooking.service;

import com.demo.photographybooking.entity.Photographer;

import java.util.List;

public interface PhotographerService {
    List<Photographer> fetchAllPhotographers();

    Photographer fetchById(String id);
    List<Photographer> fetchByName(String name);

    Photographer fetchByEmail(String email);

}
