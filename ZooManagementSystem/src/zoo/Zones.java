package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Zones {
	ZooManager zoomanager=new ZooManager(13);
	public int totalCapacityOfZone;
	public int capacityOfZone;
	public String ZoneName;
	public List<Cage> cageList=new ArrayList<Cage>();
	public final String typeOfZone;
	Scanner sc=new Scanner(System.in);
	
	public Zones(int capacityOfZone,String typeOfZone,String ZoneName){
		totalCapacityOfZone=capacityOfZone;
		this.capacityOfZone=0;
		this.typeOfZone=typeOfZone;
		this.ZoneName=ZoneName;
	}
	/**
	 * add a new cage to zone compatible with zone type 
	 * @param capacityOfCage number 
	 * @param typeOfCage  should be exactly the same as in animal list
	 * @return true if cage added successfully otherwise false
	 */
	public boolean addCage(int capacityOfCage,String typeOfCage) {
		if(totalCapacityOfZone==0){
			throw new AssertionError("Null zone can not add new cage");
		}
		System.out.println("added---------1");
			System.out.println("added---------2");
			if(capacityOfZone<totalCapacityOfZone ) {
				//check type of zone
				switch(typeOfZone){
				case "Mammal":
					//check type of cage
					switch(typeOfCage){
					case "Lion":
						System.out.println("added---------3");
						cageList.add(new Cage(capacityOfCage,typeOfCage));
						capacityOfZone++;
						return true;
					
					case "BlackBear":
						cageList.add(new Cage(capacityOfCage,typeOfCage));
						capacityOfZone++;
						return true;
				}
				break;
				case "Reptile":
					switch(typeOfCage){
					case "Snake":
						cageList.add(new Cage(capacityOfCage,typeOfCage));
						capacityOfZone++;
						return true;
					
					case "Crocodile":
						cageList.add(new Cage(capacityOfCage,typeOfCage));
						capacityOfZone++;
						return true;
						
					}
				break;
				case "Bird":
					switch(typeOfCage){
					case "Peacock":
						cageList.add(new Cage(capacityOfCage,typeOfCage));
						capacityOfZone++;
						return true;	
					}
					break;
				}
			}
		
		
		return false;
	}
	/**
	 * add animal to cage which is compatible with cage type
	 * @param name should be exactly the same as it is in animal list
	 * @param age 
	 * @param weight
	 * @param type should be exactly the same as it is in animal list
	 * @param category
	 * @return
	 */
	public boolean addAnimalToZone(String name,int age,float weight,String type,String category){
		boolean animalAdded=false;
	
		 outer: for(Cage cage:cageList) {
				if(cage.getCageType().equals(type)) {
					System.out.println("added--1");
					if(cage.occupiedCapacityOfCage()<cage.totalCapacityOfCage()) {
						animalAdded=cage.addAnimalToCage(name, age, weight, type);
						if(animalAdded) {
							break outer;
						}
					}
				}
		 }
		return animalAdded;
	}
	//function overloading
	public boolean addAnimalToZone(String name,int age,float weight,float lengthInMeters,String type,String category){
		boolean animalAdded=false;
	
		 outer: for(Cage cage:cageList) {
				if(cage.cageType.equals(type)) {
					if(cage.capacityOfCage<cage.totalCapacityOfCage()) {
						animalAdded=cage.addAnimalToCage(name, age, weight,lengthInMeters, type);
						if(animalAdded) {
							break outer;
						}
					}
				}
		 }
		return animalAdded;
	}
	//function overloading
	public boolean addAnimalToZone(String name,int age,float weight,float lengthInMeters,float lengthOfFeathers,boolean canFly ,String type,String category){
		boolean animalAdded=false;
	
		 outer: for(Cage cage:cageList) {
				if(cage.cageType.equals(type)) {
					if(cage.capacityOfCage<cage.totalCapacityOfCage()) {
						animalAdded=cage.addAnimalToCage(name, age, weight,lengthOfFeathers,canFly, type);
						if(animalAdded) {
							break outer;
						}
					}
				}
		 }
		return animalAdded;
	}
	/**
	 * it removes specific animal from zoo who is dead
	 * @param name unique name and should be exactly the same as in the animal list
	 * @param type type also should be exactly same as in the animal list
	 * @param category
	 * @return 
	 */
	public boolean deathOfAnimal(String name,String type,String category){
		boolean death=false;
		for(Cage cage:cageList){
			if(cage.getCageType().equals(type)){
				death=cage.deathOfAnimal(name,type,category);
				
			}
			if(death){
				break;
			}
		}
		return death;
	}
	/**
	 * information of all cages 
	 * @return list of cages
	 */
	public List<Cage> getInfoOfCages(){
		return cageList;
	}
	/**
	 * spare capacity of zone
	 * @return number
	 */
	public int sparecapacityOfZone() {
		return capacityOfZone;
	}
	public String getTypeOfZone() {
		return typeOfZone;
	}
	
	public int totalCapacityOfZone() {
		return totalCapacityOfZone;
	}
	public int spareCapacityOfZone() {
		return capacityOfZone;
	}
}
