package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooManager {
	int capacityOfZoo;
	int spareCapacityOfZoo;
	Scanner sc=new Scanner(System.in);
	List<Zones> zoneList=new ArrayList<Zones>();
	public ZooManager(int capacityOfZoo) {
		this.capacityOfZoo=capacityOfZoo;
		spareCapacityOfZoo=0;
	}
	/**
	 * add new zone to zoo along with unique zone name,type and capacity
	 * @param capacityOfZone
	 * @param typeOfZone
	 * @param ZoneName name should be unique
	 */
	public boolean addNewZone(int capacityOfZone,String typeOfZone,String ZoneName) {
		if(spareCapacityOfZoo<capacityOfZoo) {
			zoneList.add(new Zones(capacityOfZone,typeOfZone,ZoneName));
			spareCapacityOfZoo++;
			return true;
		}
		return false;
	}
	/**
	 * get list of all zones available in zoo
	 * @return list of zones
	 */
	public List<Zones> getZoneList(){
		return zoneList;
	}
	/**
	 * adds animal 
	 * @param name should be unique
	 * @param age
	 * @param weight
	 * @param lengthInMeters
	 * @param lengthOfFeathers
	 * @param canFly
	 * @param type
	 * @param category
	 * @return
	 */

	public boolean addAnimal(String name,int age,float weight ,String type,String category) {
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.getTypeOfZone().equals(category)) {
				animalAdded=zone.addAnimalToZone(new Mammal(name, age, weight,type));
				if(animalAdded){
					break;
				}
			}
		}
		return animalAdded;
	}
	public boolean addAnimal(String name,int age,float weight,float lengthInMeters ,String type,String category) {
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.getTypeOfZone().equals(category)) {
				animalAdded=zone.addAnimalToZone(new Reptile(name, age, weight,lengthInMeters,type));
				if(animalAdded){
					break;
				}
			}
		}
		return animalAdded;
	}
	public boolean addAnimal(String name,int age,float weight,float lengthInMeters ,float lengthOfFeathers,boolean canFly,String type,String category) {
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.getTypeOfZone().equals(category)) {
				animalAdded=zone.addAnimalToZone(new Bird(name, age, weight,lengthOfFeathers,canFly,type));
				if(animalAdded){
					break;
				}
			}
		}
		return animalAdded;
	}
	public boolean deathOfAnimal(String name,String type,String category){
		boolean death=false;
		for(Zones zone:zoneList){
			if(zone.getTypeOfZone().equals(category)){
				death=zone.deathOfAnimal(name,type,category);
			}
		}
		return death;
	}
	/**
	 * get name of all animals in zoo including cages,zones
	 * @return
	 */
	public List<String> allAnimalsInZoo(){
		List<String> animalsInZone=new ArrayList<String>();
		for(Zones zone:zoneList) {
			for(Cage cage:zone.getCageList()) {
				for(Animal animal:cage.animalList) {
					animalsInZone.add(animal.getName());
				}
			}
		}
		return animalsInZone;
	}
	/**
	 * search animal by their name in zoo
	 * @param animalName
	 * @return
	 */
	public List<String> findAnimalByName(String animalName){
		List<String> animalDetails=new ArrayList<String>();
		for(Zones zone:zoneList) {
			animalDetails=zone.findAnimals(animalName);
		}
		return animalDetails;
	}
	/**
	 * total capacity of zoo 
	 * @return
	 */
	public int totalCapacityOfZoo() {
		return capacityOfZoo;
	}
	/**
	 * 
	 * @param zoneName
	 * @return
	 */



	public void move(String ZoneName,int fromCageNumber,int toCageNumber,String animalName) {
		for(Zones zone:zoneList) {
			if(zone.getZoneName().equals(ZoneName)) {
				if(zone.getCageList().get(toCageNumber-1).getCageType().equals(zone.getCageList().get(fromCageNumber-1).getCageType())) {
					for(Animal animal:zone.getCageList().get(fromCageNumber-1).animalList) {
						if(animal.getName().equals(animalName)) {
							zone.getCageList().get(toCageNumber-1).animalList.add(animal);
							zone.getCageList().get(fromCageNumber-1).animalList.remove(animal);
						}
					}
				}
			}
		}
	}

}