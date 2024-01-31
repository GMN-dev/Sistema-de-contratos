package entities;
import java.time.LocalDate; 

import java.time.format.DateTimeFormatter;

public class HourContract {
	
	private LocalDate date;
	private Double valuePerHour;
	private Integer hours;
	
	//Método construtor
	public HourContract(String date, Double valuePerHour, Integer hours) {
		this.setDate(date);
		this.setValuePerHour(valuePerHour);
		this.setHours(hours);
	} 
	
	//Getters and Setters
	public LocalDate getDate() {
		return date;
	}
	public void setDate(String date) {
		LocalDate dateFormatted = this.DateConverterStringToLocalDate(date);
		this.date = dateFormatted;	
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours){
		this.hours = hours;
	}
	
	
	//Methods
	public Double totalValue() {
		return this.getValuePerHour() * this.getHours();
	}
	
	public LocalDate DateConverterStringToLocalDate(String stringDate) {
		DateTimeFormatter dateEditor = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate response;
		try {
			response = LocalDate.parse(stringDate, dateEditor);
		}catch ( Exception err) {
			response = null;
		}	
		return response;
	}
	
	//toString
	public String toString() {
		return String.format("Contract's Date: %s", this.getDate());
	}
}
