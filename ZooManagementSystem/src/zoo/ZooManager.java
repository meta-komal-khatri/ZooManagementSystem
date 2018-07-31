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
	 * @return if zone added successfully return true else false
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
	 * adds animal 
	 * @param name should be unique for each animal
	 * @param age should be a number
	 * @param weight could be a float number
	 * @param lengthInMeters float number
	 * @param lengthOfFeathers
	 * @param canFly true or false
	 * @param type
	 * @param category
	 * @return
	 */
	//function overloading
	public boolean addAnimal(String name,int age,float weight ,String type,String category) {
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.typeOfZone.equals(category)) {
				animalAdded=zone.addAnimalToZone(name, age, weight, type, category);
				if(animalAdded) {
					break;
				}
			}
		}
		return animalAdded;
	}
	//function overloading
	public boolean addAnimal(String name,int age,float weight,float lengthInMeters ,String type,String category) {
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.typeOfZone.equals(category)) {
				animalAdded=zone.addAnimalToZone(name, age, weight, lengthInMeters, type, category);
				if(animalAdded) {
					break;
				}
			}
		}
		return animalAdded;
	}
	//function overloading
	public boolean addAnimal(String name,int age,float weight,float lengthInMeters ,float lengthOfFeathers,boolean canFly,String type,String category) {
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.typeOfZone.equals(category)) {
				animalAdded=zone.addAnimalToZone(name, age, weight, lengthInMeters,lengthOfFeathers,canFly, type, category);
				if(animalAdded) {
					break;
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
		for(Zones zone:zoneList){
			if(zone.getTypeOfZone().equals(category)){
				death=zone.deathOfAnimal(name,type,category);
			}
		}
		return death;
	}
	/**
	 * get list of all zones available in zoo
	 * @return list of zones
	 */
	public List<Zones> getZoneList(){
		return zoneList;
	}
}