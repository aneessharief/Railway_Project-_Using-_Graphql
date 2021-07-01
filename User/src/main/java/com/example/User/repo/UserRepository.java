package com.example.User.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.User.model.TrainDetails;
@Repository
public interface UserRepository extends MongoRepository<TrainDetails, Integer> {

}
