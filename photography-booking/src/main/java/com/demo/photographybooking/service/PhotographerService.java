package com.demo.photographybooking.service;

import com.demo.photographybooking.entity.Photographers;

import java.util.List;

public interface PhotographerService {
    public List<Photographers> fetchAllPhotographers();

    public Photographers fetchById(String id);
}
