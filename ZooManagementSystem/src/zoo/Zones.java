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
	 * 
	 * @param capacityOfCage add a new cage to zone compatible with zone type 
	 * @param typeOfCage 
	 * @return true if cage added successfully otherwise false
	 */
	public boolean addCage(int capacityOfCage,String typeOfCage) {
		if(totalCapacityOfZone==0){
			throw new AssertionError("Null zone can not add new cage");
		}
		if(capacityOfZone<totalCapacityOfZone ) {
			switch(typeOfZone){
			case "Mammal":
				switch(typeOfCage){
				case "Lion":
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
				default:
					throw new AssertionError();
				}

			}
			return false;
		}

		public boolean addAnimalToZone(Animal animal){
			boolean animalAdded=false;

			outer: for(Cage cage:cageList) {
				if(cage.getCageType().equals(animal.getType())&& cage.getCapacityOfCage()<cage.getTotalCapacityOfCage()) {
					animalAdded=cage.addAnimalToCage(animal);
					if(animalAdded) {
						break outer;
					}
				}
			}
			return animalAdded;
		}
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
		/**
		 * return name of all animals in zone 
		 * @return
		 */
		public List<String> getNameOfAnimalsInZone(){
			List<String> animalsInZone=new ArrayList<String>();
			for(Cage cage:cageList) {
				for(Animal animal:cage.animalList) {
					animalsInZone.add(animal.getName());
				}
			}
			return animalsInZone;
		}
		/**
		 * finds animal by their name
		 * @param animalName
		 * @return
		 */
		public List<String> findAnimals(String animalName){
			List<String> animalDetails=new ArrayList<String>();
			for(Cage cage:cageList) {
				animalDetails=cage.findAnimals(animalName);
			}
			return animalDetails;
		}
		/**
		 * 
		 * @return
		 */
		public int totalCapacityOfZone() {
			return totalCapacityOfZone;
		}
		public int spareCapacityOfZone() {
			return capacityOfZone;
		}
	}
