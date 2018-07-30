package zoo;

import java.util.ArrayList;
import java.util.List;

public class Cage {
	int totalCapacityOfCage;
	int capacityOfCage;
	String cageType;
	List<Animal> animalList=new ArrayList<Animal>();
	public Cage(int capacityOfCage,String cageType){
		this.totalCapacityOfCage=capacityOfCage;
		this.capacityOfCage=0;	
		this.cageType=cageType;
	}
	public boolean addAnimalToCage(String name,int age,float weight,String type) {
		boolean successOfAddingAnimal=false;
		if(capacityOfCage<totalCapacityOfCage) {
			switch(type) {
				case "Lion":
					animalList.add(new Lion(name,age,weight));
					capacityOfCage++;
					successOfAddingAnimal=true;
					break;
				case "BlackBear":
					animalList.add(new BlackBear(name,age,weight));
					capacityOfCage++;
					successOfAddingAnimal=true;
					break;
				default :
					System.out.println("No Such Animal");
					break;
			}
		}
		return successOfAddingAnimal;
			
	}
	public boolean addAnimalToCage(String name,int age,float weight,float lengthInMeters,String type) {
		boolean successOfAddingAnimal=false;
		if(capacityOfCage<totalCapacityOfCage) {
			switch(type) {
				case "Snake":
					animalList.add(new Snake(name,age,weight,lengthInMeters));
					capacityOfCage++;
					successOfAddingAnimal=true;;
					break;
				case "Crocodile":
					animalList.add(new Crocodile(name,age,weight,lengthInMeters));
					capacityOfCage++;
					successOfAddingAnimal=true;
					break;
				default :
					System.out.println("No Such Animal");
					break;
			}
		}
		return successOfAddingAnimal;
	}
	public boolean addAnimalToCage(String name,int age,float weight,float lengthOfFeathers,boolean canFly,String type) {
		boolean successOfAddingAnimal=false;
		if(capacityOfCage<totalCapacityOfCage) {
			switch(type) {
				case "Snake":
					animalList.add(new Peacock(name,age,weight,lengthOfFeathers,canFly));
					capacityOfCage++;
					successOfAddingAnimal=true;
					break;
			
				default :
					System.out.println("No Such Animal");
					break;
		
			}
		}
		return successOfAddingAnimal;
	}
	public int getCageCapacity() {
		return capacityOfCage;
	}
	public String getCageType() {
		return cageType;
	}
	public List<String> getNameOfAllAnimalsInCage() {
		List<String> animalNameList=new ArrayList<String>();
		for(Animal animal:animalList) {
			animalNameList.add(animal.getName());
		}
		return animalNameList;
	}
	public List<String> findAnimals(String animalName){
		List<String> animalDetails=new ArrayList<String>();
		for(Animal animal:animalList) {
			if(animal.getName().equals(animalName)) {
				animalDetails=animal.getInfo();
			}
		}
		return animalDetails;
	}
	public int totalCapacityOfCage() {
		return totalCapacityOfCage;
	}
	public int spareCapacityOfCage() {
		return capacityOfCage;
	}
	
}
