package com.demo.photographybooking.service.impl;

import com.demo.photographybooking.entity.Photographer;
import com.demo.photographybooking.repository.PhotographersRepository;
import com.demo.photographybooking.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PhotographersServiceImpl implements PhotographerService {

    @Autowired
    PhotographersRepository photographersRepository;

    @Override
    public List<Photographer> fetchAllPhotographers() {
        List<Photographer> response = new ArrayList<>();

        try {
            List<Photographer> list = photographersRepository.fetchAllPhotographers();

            if (!list.isEmpty()) {
                response.addAll(list);
            }

        } catch (Exception e) {
            System.out.println("Error get all photographers: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Photographer fetchById(String id) {
        Photographer response = new Photographer();

        try {
            Photographer photographer = photographersRepository.fetchById(id);

            if (Objects.nonNull(photographer)) {
                response = photographer;
            }

        } catch (Exception e) {
            System.out.println("Error get photographers: " + id);
        }

        return response;
    }

    @Override
    public List<Photographer> fetchByName(String name) {
        List<Photographer> response = new ArrayList<>();

        try {
            List<Photographer> list = photographersRepository.fetchByName(name);

            if (!list.isEmpty()) {
                response.addAll(list);
            }

        } catch (Exception e) {
            System.out.println("Error get photographers by name: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Photographer fetchByEmail(String email) {
        Photographer response = new Photographer();

        try {
            Photographer photographers = photographersRepository.fetchByEmail(email);

            if (Objects.nonNull(photographers)) {
                response = photographers;
            }

        } catch (Exception e) {
            System.out.println("Error get photographers by email: " + e.getMessage());
        }

        return response;
    }


}
