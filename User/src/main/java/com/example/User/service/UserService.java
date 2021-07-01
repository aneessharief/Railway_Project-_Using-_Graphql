package com.example.User.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.User.model.TrainDetails;
import com.example.User.repo.UserRepository;



@Service
public class UserService implements GraphQLQueryResolver {
	
	@Autowired
	 private UserRepository userRepo;
	
	
	public List<TrainDetails> getAllDetails(){
        return userRepo.findAll();
    }
	
	 public TrainDetails getDetailsByTrainNo(Integer trainNo){
	        return userRepo.findById(trainNo).get();
	    }
	 
	 public List<TrainDetails> getTrainDetailsByStartStation(String startStation,String destStation ){
		 List<TrainDetails> detList=userRepo.findAll();
			List<TrainDetails> req=new ArrayList<TrainDetails>();
			for(TrainDetails tr:detList)
			{
				String stat=tr.getStartStation();
				String dest=tr.getDestStation();
				if(stat.equals(startStation) && dest.equals(destStation))
				{
					req.add(tr);
				}
			}
			return req;
	    }


}
