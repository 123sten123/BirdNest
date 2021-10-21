package ru.birdnest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.birdnest.model.Bird;
import ru.birdnest.service.BidrNestService;
import ru.birdnest.service.MinIoService;

import java.io.IOException;

@RestController
public class BirdController {


    @Autowired
    public MinIoService minIoService;

    /**
     * Контроллер для добавления птицы
     * @param bird модель птицы
     */
    @PostMapping(value = "/name")
    public void addBird(Bird bird){
        System.out.println("ADD");
    }

    @PutMapping(value = "/update")
    public void updateBird(){
        // TODO: 14.08.2021 Добавить БД
        System.out.println("UPDATE");
    }

    @PutMapping(value = "/getBirds")
    public void getBirds(){
        // TODO: 14.08.2021 Добавить БД
        System.out.println("Birds");
    }

    @GetMapping(value = "/test")
    public void test(){
        byte test[] = new byte[]{1, -127};
        try{
            minIoService.storeFile("1", test);
        }catch (Exception e){
           e.printStackTrace();
        }

    }
}
