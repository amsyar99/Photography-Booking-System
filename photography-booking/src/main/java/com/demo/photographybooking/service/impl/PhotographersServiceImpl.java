package com.demo.photographybooking.service.impl;

import com.demo.photographybooking.entity.Photographers;
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
    public List<Photographers> fetchAllPhotographers() {
        List<Photographers> response = new ArrayList<>();

        try {
            List<Photographers> list = photographersRepository.fetchAll();

            if (!list.isEmpty()) {
                response.addAll(list);
            }

        } catch (Exception e) {
            System.out.println("Error get all photographers: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Photographers fetchById(String id) {
        Photographers response = new Photographers();

        try {
            Photographers photographers = photographersRepository.fetchById(id);

            if (Objects.nonNull(photographers)) {
                response = photographers;
            }

        } catch (Exception e) {
            System.out.println("Error get photographers: " + id);
        }

        return response;
    }


}
