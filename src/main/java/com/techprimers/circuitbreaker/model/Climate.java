package com.techprimers.circuitbreaker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Climate {
	int id;
	private String city;
	private String country;
	private String countryCode;
	private String date;
	private double temperatureInFht;
	private String weather;
	private String weatherDesc;
	private double tempFeelsLike;
	private double tempMin;
	private double tempMax;
	private double pressure;
	private double humidity;

}
