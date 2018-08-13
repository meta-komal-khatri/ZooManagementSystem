package zoo;

import java.util.ArrayList;
import java.util.List;

public class Bird implements Animal{
	String Name;
	int Age;
	float weight;
	int numberOfLegs;
	float lengthOfFeathers;
	boolean canFly;
	String type;
	public String getCategory() {
		return "Bird";
	}
	public Bird(String name,int age,float weight,float length,boolean canFly,String type){
		this.Name=name;
		this.Age=age;
		this.weight=weight;
		this.lengthOfFeathers=length;
		this.canFly=canFly;
		this.type=type;
	}
	public String getName() {
		return Name;
	}
	public int getAge() {
		return Age;
	}
	public float getweight() {
		return weight;
	}
	public String getSound() {
		return "Scream";
	}
	public String getType() {
		return type;
	}
	public int numberOfLegs() {
		int numberOfLegs= 2;
		return numberOfLegs;
	}
	public float getLength() {
		return lengthOfFeathers;
	}
	public List<String> getInfo(){
		List<String> animalDetails=new ArrayList<String>();
		animalDetails.add(getName());
		animalDetails.add(getSound());
		animalDetails.add(getType());
		animalDetails.add(Integer.toString(getAge()));
		animalDetails.add(Integer.toString(numberOfLegs()));
		animalDetails.add(Float.toString(getweight()));
		animalDetails.add(Float.toString(getLength()));
		return animalDetails;
	}
}
