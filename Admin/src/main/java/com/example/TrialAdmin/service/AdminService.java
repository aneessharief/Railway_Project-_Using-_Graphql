package com.example.TrialAdmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.TrialAdmin.model.TrainDetails;
import com.example.TrialAdmin.repo.AdminRepository;

@Service
public class AdminService implements GraphQLQueryResolver, GraphQLMutationResolver {
	@Autowired
	private AdminRepository adminRepository;

	public List<TrainDetails> getAllDetails() {
		return adminRepository.findAll();
	}
	
	 public TrainDetails getDetailsByTrainNo(Integer trainNo){
	        return adminRepository.findById(trainNo).get();
	    }

	public TrainDetails updatetrainName(int trainNo, String trainName, String startStation, String destStation,
			String arrivalTime,String deptTime, String duration, int noOfSeats,
			int firstClassACFare, int twoTierAcFare, int threeTierAcFare, int sleeperFare) {
		TrainDetails td = adminRepository.findById(trainNo).get();
		td.setTrainName(trainName);
		td.setStartStation(startStation);
		adminRepository.save(td);
		return td;

	}

	public TrainDetails deleteTrain(Integer trainNo) {
		TrainDetails td = adminRepository.findById(trainNo).get();
		adminRepository.delete(td);
		return td;

	}

	public TrainDetails addTrain(int trainNo, String trainName, String startStation, String destStation,
			String arrivalTime,String deptTime, String duration, int noOfSeats,
			int firstClassACFare, int twoTierAcFare, int threeTierAcFare, int sleeperFare) {
		TrainDetails td = new TrainDetails();
		td.setTrainNo(trainNo);
		td.setTrainName(trainName);
		td.setStartStation(startStation);
		td.setDestStation(destStation);
		td.setArrivalTime(arrivalTime);
		td.setDeptTime(deptTime);
		td.setNoOfSeats(noOfSeats);
		td.setDuration(duration);
		td.setFirstClassACFare(firstClassACFare);
		td.setTwoTierAcFare(twoTierAcFare);
		td.setThreeTierAcFare(threeTierAcFare);
		td.setSleeperFare(sleeperFare);
		adminRepository.save(td);
		return td;

	}
}
