package com.railwaymanagementsystem.service;

import com.railwaymanagementsystem.model.Train;
import com.railwaymanagementsystem.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> searchTrains(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }

    public Train getTrainById(Long id) {
        return trainRepository.findById(id).orElse(null);
    }
}
