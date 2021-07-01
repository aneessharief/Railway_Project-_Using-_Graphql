package com.example.User.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "trainDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainDetails {

	@Id
	private int trainNo;
	private String trainName;
	private String startStation;
	private String destStation;
	private String arrivalTime;
	private String deptTime;
	private String duration;
	private int noOfSeats;
	private int firstClassACFare;
	private int twoTierAcFare;
	private int threeTierAcFare;
	private int sleeperFare;
	
}