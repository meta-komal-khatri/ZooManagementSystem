package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Zones {
	public int totalCapacityOfZone;
	public int capacityOfZone;
	public String ZoneName;
	List<Cage> cageList=new ArrayList<Cage>();
	final String typeOfZone;
	Scanner sc=new Scanner(System.in);
	public Zones(int capacityOfZone,String typeOfZone,String ZoneName){
		totalCapacityOfZone=capacityOfZone;
		this.capacityOfZone=0;
		this.typeOfZone=typeOfZone;
		this.ZoneName=ZoneName;
	}
	public boolean addCage(int capacityOfCage,String typeOfCage) {
		if(capacityOfZone<totalCapacityOfZone ) {
			if(typeOfZone.equalsIgnoreCase(typeOfCage)) {
			cageList.add(new Cage(capacityOfCage,typeOfCage));
			capacityOfZone++;
			return true;
		}
		}
		
		return false;
	}
	public List<Cage> getInfoOfCages(){
		return cageList;
	}
	public int sparecapacityOfZone() {
		return capacityOfZone;
	}
	public String getTypeOfZone() {
		return typeOfZone;
	}
	public boolean addAnimalToZone(String name,int age,float weight,float lengthInMeters,float lengthOfFeathers,boolean canFly ,String type,String category) {
		boolean newCage=true;
		boolean animalAdded=false;
		//return animalAdded;
		outer: for(Cage cage:cageList) {
			if(cage.cageType.equals(category)) {
				switch(category) {
				case "Mammal":
					if(cage.capacityOfCage>0) {
						animalAdded=cage.addAnimalToCage(name, age, weight, type);
						newCage=false;
						if(animalAdded) {
							break outer;
						}
					}
				break;
				case "Reptile":
					if(cage.capacityOfCage>0) {
						animalAdded=cage.addAnimalToCage(name, age, weight,lengthInMeters, type);
						newCage=false;
						if(animalAdded) {
							break outer;
						} 
					}
				break;
				case "Bird":
					if(cage.capacityOfCage>0) {
						animalAdded=cage.addAnimalToCage(name, age, weight,lengthOfFeathers,canFly, type);
						newCage=false;
						if(animalAdded) {
							break outer;
						}
					}
				break;
				}
			}
		}
		return animalAdded;
	}
	public List<String> getNameOfAnimalsInZone(){
		List<String> animalsInZone=new ArrayList<String>();
		for(Cage cage:cageList) {
			for(Animal animal:cage.animalList) {
				animalsInZone.add(animal.getName());
			}
		}
		return animalsInZone;
	}
	public List<String> findAnimals(String animalName){
		List<String> animalDetails=new ArrayList<String>();
		for(Cage cage:cageList) {
			animalDetails=cage.findAnimals(animalName);
		}
		return animalDetails;
	}
	public int totalCapacityOfZone() {
		return totalCapacityOfZone;
	}
	public int spareCapacityOfZone() {
		return capacityOfZone;
	}
}
