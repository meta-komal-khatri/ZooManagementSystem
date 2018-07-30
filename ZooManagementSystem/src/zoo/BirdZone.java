package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BirdZone implements Zone {
	public int capacityOfZone;
	final String typeOfZone="Bird";
	List<Cage> cageList=new ArrayList<Cage>();
	Scanner sc=new Scanner(System.in);
	BirdZone(int capacityOfZone){
		this.capacityOfZone=capacityOfZone;
	}
	public void addCage(int capacityOfCage,String typeOfCage) {
		if(capacityOfZone>0) {
			cageList.add(new Cage(capacityOfCage,typeOfCage));
			capacityOfZone--;
		}
	}
	public List<Cage> getInfoOfCages(){
		return cageList;
	}
	public int capacityOfZone() {
		return capacityOfZone;
	}
	public String getTypeOfZone() {
		return "Bird";
	}
	public boolean addAnimalToZone(String name,int age,float weight,float lengthOfFeathers,boolean canFly,String type ) {
		boolean newCage=true;
		boolean animalAdded=false;
		for(Cage cage:cageList) {
			if(cage.capacityOfCage>0) {
				animalAdded=cage.addAnimalToCage(name, age, weight,lengthOfFeathers,canFly, type);
				newCage=false;
				if(animalAdded) {
					break;
				}
			}
			
		}
		
		if(newCage) {
			if(capacityOfZone>0) {
			System.out.print("There is no space in any cage do you want to add new cage??\n yes or no");
			char ch=sc.next().charAt(0);
			if(ch=='y') {
			System.out.println("Eneter capacity for new cage");
			int capacityOfCage=sc.nextInt();
				
					cageList.add(new Cage(capacityOfCage,"Mammal"));
					capacityOfZone--;
					animalAdded=cageList.get(cageList.size()-1).addAnimalToCage(name, age, weight,lengthOfFeathers,canFly, type);
				}
			}
			else {
				System.out.println("Add new Zone All Zones Are Full");
			}
			
		}
		return animalAdded;
	}
}
