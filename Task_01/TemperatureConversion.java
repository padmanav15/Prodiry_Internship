package com.jsp.Task_01;

import java.util.Scanner;

public class TemperatureConversion {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter temperature in celsius");
		double celsius=scn.nextDouble();
		
		double fahrenheit = celsiusToFahrenheit(celsius);
		
        double kelvin = celsiusToKelvin(celsius);
        
        System.out.println("Temperature in Fahrenheit is:" +fahrenheit+ " F");
        System.out.println("Temperature in Kelvin is:" +kelvin+ " K");
        scn.close();
	}
	public static double celsiusToFahrenheit(double celsius)
	{
		return (celsius * 9/5) + 32;
	}
	public static double celsiusToKelvin(double celsius)
	{
		return celsius + 273.15;
	}
}
