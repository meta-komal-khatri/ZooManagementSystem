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
	public void addNewZone(int capacityOfZone,String typeOfZone,String ZoneName) {
		if(spareCapacityOfZoo<capacityOfZoo) {
		zoneList.add(new Zones(capacityOfZone,typeOfZone,ZoneName));
		spareCapacityOfZoo++;
		}
	
	}
	public List<Zones> getZoneList(){
		return zoneList;
	}
	public boolean addAnimal(String name,int age,float weight,float lengthInMeters,float lengthOfFeathers,boolean canFly ,String type,String category) {
		boolean newZone=true;
		boolean animalAdded=false;
		for(Zones zone:zoneList) {
			if(zone.typeOfZone.equals(category)) {
				animalAdded=zone.addAnimalToZone(name, age, weight, lengthInMeters, lengthOfFeathers, canFly, type, category);
				if(animalAdded) {
					break;
				}
			}
		}
		if(!animalAdded) {
			System.out.println("All cages are full");
			for(Zones zone:zoneList) {
				if(zone.capacityOfZone>0) {
					System.out.println("There is a space in "+zone.ZoneName);
					newZone=false;
					System.out.println("Do you want to add cage if yes press 'y' else press 'n'");
					char ch=sc.next().charAt(0);
					if(ch=='y') {
						System.out.println("Enter Cage Capacity");
						int capacity=sc.nextInt();
						String typeOfCage=category;
						zone.cageList.add(new Cage(capacity,typeOfCage));
						zone.capacityOfZone--;
						if(category.equals("Mammal")) {
							animalAdded=zone.cageList.get(zone.cageList.size()-1).addAnimalToCage(name, age, weight, type);
						}
						else if(category.equals("Reptile")) {
							animalAdded=zone.cageList.get(zone.cageList.size()-1).addAnimalToCage(name, age, weight, lengthInMeters, type);
						}
						else if(category.equals("Bird")) {
							animalAdded=zone.cageList.get(zone.cageList.size()-1).addAnimalToCage(name, age, weight, lengthOfFeathers, canFly, type);
						}
					}
				}
			}
		}
		if(newZone) {
			System.out.println("there is no space in any zone add new you zone");
		}
		return animalAdded;
	}
	public List<String> allAnimalsInZoo(){
		List<String> animalsInZone=new ArrayList<String>();
		for(Zones zone:zoneList) {
			for(Cage cage:zone.cageList) {
				for(Animal animal:cage.animalList) {
					animalsInZone.add(animal.getName());
				}
			}
		}
		return animalsInZone;
	}
	public List<String> findAnimalByName(String animalName){
		List<String> animalDetails=new ArrayList<String>();
		for(Zones zone:zoneList) {
		animalDetails=zone.findAnimals(animalName);
		}
		return animalDetails;
	}
	public int totalCapacityOfZoo() {
		return capacityOfZoo;
	}
	public int totalCapacityOfSpecificZone(String zoneName) {
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(zoneName)) {
				return zone.totalCapacityOfZone();
			}
		}
		return 0;
	}
	public int totalCapacityOfSpecificCage(String zoneName,int cageNumber) {
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(zoneName)) {
				return zone.cageList.get(cageNumber-1).totalCapacityOfCage();
			}
		}
		return 0;
	}
	public int spareCapacityOfZoo() {
		int sum=0;
		for(Zones zone:zoneList) {
			sum+=spareCapacityOfSpecificZone(zone.ZoneName);
		}
		return sum;
	}
	public int spareCapacityOfSpecificZone(String ZoneName) {
		int sum=0;
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(ZoneName)) {
				for(int i=0;i<zone.cageList.size();i++) {
					sum+=zone.cageList.get(i).spareCapacityOfCage();
				}
				return sum;
			}
		}
		return 0;
	}
	public int spareCapacityOfSpecificCage(String ZoneName,int cageNumber) {
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(ZoneName)) {
				return zone.cageList.get(cageNumber-1).spareCapacityOfCage();
				
			}
		}
		return 0;
	}
	public void move(String ZoneName,int fromCageNumber,int toCageNumber,String animalName) {
		for(Zones zone:zoneList) {
			if(zone.ZoneName.equals(ZoneName)) {
				if(zone.cageList.get(toCageNumber-1).cageType.equals(zone.cageList.get(fromCageNumber-1).cageType)) {
				for(Animal animal:zone.cageList.get(fromCageNumber-1).animalList) {
					if(animal.getName().equals(animalName)) {
						zone.cageList.get(toCageNumber-1).animalList.add(animal);
						zone.cageList.get(fromCageNumber-1).animalList.remove(animal);
					}
				}
				}
			}
		}
	}
}