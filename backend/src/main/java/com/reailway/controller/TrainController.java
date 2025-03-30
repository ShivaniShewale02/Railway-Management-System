package com.railwaymanagementsystem.controller;

import com.railwaymanagementsystem.model.Train;
import com.railwaymanagementsystem.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/search")
    public String searchTrains(@RequestParam String source, @RequestParam String destination, Model model) {
        List<Train> trains = trainService.searchTrains(source, destination);
        model.addAttribute("trains", trains);
        return "train-search"; // Thymeleaf template
    }

    @GetMapping("/book/{id}")
    public String bookTicket(@PathVariable Long id, Model model) {
        Train train = trainService.getTrainById(id);
        model.addAttribute("train", train);
        return "book-ticket"; // Thymeleaf template
    }
}


