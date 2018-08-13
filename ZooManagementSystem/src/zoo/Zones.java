package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Zones {
	private int totalCapacityOfZone;
	private int currentcapacityOfZone;
	private String ZoneName;
	private List<Cage> cageList=new ArrayList<Cage>();
	private final String typeOfZone;

	public Zones(int capacityOfZone,String typeOfZone,String ZoneName){
		totalCapacityOfZone=capacityOfZone;
		this.currentcapacityOfZone=0;
		this.typeOfZone=typeOfZone;
		this.ZoneName=ZoneName;
	}
	/**
	 * @return the totalCapacityOfZone
	 */
	public int getTotalCapacityOfZone() {
		return totalCapacityOfZone;
	}
	/**
	 * @param totalCapacityOfZone the totalCapacityOfZone to set
	 */
	public void setTotalCapacityOfZone(int totalCapacityOfZone) {
		this.totalCapacityOfZone = totalCapacityOfZone;
	}
	/**
	 * @return the currentcapacityOfZone
	 */
	public int getCurrentcapacityOfZone() {
		return currentcapacityOfZone;
	}
	/**
	 * @param currentcapacityOfZone the currentcapacityOfZone to set
	 */
	public void setCurrentcapacityOfZone(int currentcapacityOfZone) {
		this.currentcapacityOfZone = currentcapacityOfZone;
	}
	/**
	 * @return the zoneName
	 */
	public String getZoneName() {
		return ZoneName;
	}
	/**
	 * @param zoneName the zoneName to set
	 */
	public void setZoneName(String zoneName) {
		ZoneName = zoneName;
	}
	/**
	 * @return the cageList
	 */
	public List<Cage> getCageList() {
		return cageList;
	}
	/**
	 * @param cageList the cageList to set
	 */
	public void setCageList(List<Cage> cageList) {
		this.cageList = cageList;
	}
	/**
	 * @return the typeOfZone
	 */
	public String getTypeOfZone() {
		return typeOfZone;
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
		if(currentcapacityOfZone<totalCapacityOfZone ) {
			switch(typeOfZone){
			case "Mammal":
				switch(typeOfCage){
				case "Lion":
					cageList.add(new Cage(capacityOfCage,typeOfCage));
					currentcapacityOfZone++;
					return true;		

				case "BlackBear":
					cageList.add(new Cage(capacityOfCage,typeOfCage));
					currentcapacityOfZone++;
					return true;
				}
				break;
			case "Reptile":
				switch(typeOfCage){
				case "Snake":
					cageList.add(new Cage(capacityOfCage,typeOfCage));
					currentcapacityOfZone++;
					return true;		

				case "Crocodile":
					cageList.add(new Cage(capacityOfCage,typeOfCage));
					currentcapacityOfZone++;
					return true;
				}
				break;
				case "Bird":
					switch(typeOfCage){
					case "Peacock":
						cageList.add(new Cage(capacityOfCage,typeOfCage));
						currentcapacityOfZone++;
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
	
	}
