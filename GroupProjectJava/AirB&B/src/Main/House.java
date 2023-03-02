package Main;


import java.time.Period;
import java.time.ZonedDateTime;
import java.util.*;
import Exception.*;

public class House implements Comparable<House>{

private final UUID id;
private String name;
private int nRooms;
private int nBeds;
private final int floor;
private double price;
private Period availability;
private SortedMap<ZonedDateTime, Period> bookedPeriods;
private ZonedDateTime startAvailability;


public House(UUID id,String name,int nRooms,int nBeds,int floor) {
   this.id=id;
   this.name=name;
   this.nRooms=nRooms;
   this.nBeds=nBeds;
   this.floor = floor;
   bookedPeriods = new TreeMap<>();
   availability = null;
   startAvailability = null;
}

public House(String name, int nRooms, int nBeds, int floor, double price){
	id = UUID.randomUUID();
	this.name=name;
	this.nRooms=nRooms;
	this.nBeds=nBeds;
	this.floor = floor;
	setPrice(price);
	bookedPeriods = new TreeMap<>();
	availability = null;
	startAvailability = null;
}

public House(String name, int nRooms, int nBeds, int floor){
	id = UUID.randomUUID();
	this.name=name;
	this.nRooms=nRooms;
	this.nBeds=nBeds;
	this.floor = floor;
	bookedPeriods = new TreeMap<>();
	availability = null;
	startAvailability = null;
}

public House(String name, int nRooms, int nBeds, int floor, ZonedDateTime startAvailability, Period availability){
	id = UUID.randomUUID();
	this.name=name;
	this.nRooms=nRooms;
	this.nBeds=nBeds;
	this.floor = floor;
	setAvailability(startAvailability, availability);
	bookedPeriods = new TreeMap<>();
}

public House(String name, int nRooms, int nBeds, int floor, double price, ZonedDateTime startAvailability, Period availability){
	id = UUID.randomUUID();
	this.name=name;
	this.nRooms=nRooms;
	this.nBeds=nBeds;
	this.floor = floor;
	setPrice(price);
	setAvailability(startAvailability, availability);
	bookedPeriods = new TreeMap<>();
}

public UUID getId() {
	  return id;
}

public String getName() {
	  return name;
}

public int getNrooms() {
	   return nRooms;
}

public int getNbeds() {
	  return nBeds;
}

public int getFloor() {
	  return floor;
}
	
//Getter and Setter
public double getPrice() {
	return price;
}

//Getter and Setter	
public Period getAvailability() {
	return availability;
}

public void setPrice(double price) {
	this.price=price;
}

public void setAvailability(ZonedDateTime startAvailability, Period availability) {
	this.availability=availability;
	this.startAvailability = startAvailability;
}

public boolean isAvailable(ZonedDateTime startNeed, Period periodNeed){
	if((startNeed.isEqual(startAvailability) || startNeed.isAfter(startAvailability))
			&& startNeed.isBefore(startAvailability.plus(availability))
				&& (startNeed.plus(periodNeed).isEqual(startAvailability.plus(availability))
				|| startNeed.plus(periodNeed).isBefore(startAvailability.plus(availability)))){
		if(!bookedPeriods.containsKey(startNeed)){
			for (ZonedDateTime time : bookedPeriods.keySet()) {
				if(startNeed.isAfter(time)
						&& startNeed.isBefore(time.plus(bookedPeriods.get(time)))
						&& (startNeed.plus(periodNeed).isEqual(time.plus(bookedPeriods.get(time)))
						|| startNeed.plus(periodNeed).isBefore(time.plus(bookedPeriods.get(time))))){
					return false;
				}
			}
			return true;
		}
	}
	return false;
}

public void addSlot(ZonedDateTime startDate, Period period) throws DateNotAvailableException{
	if(isAvailable(startDate, period)){
		bookedPeriods.put(startDate, period);
		return;
	}throw new DateNotAvailableException();
}

	@Override
	public int compareTo(House o) {
		return this.id.compareTo(o.id);
	}
}
