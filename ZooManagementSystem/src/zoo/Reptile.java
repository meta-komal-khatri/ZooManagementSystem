package zoo;

import java.util.ArrayList;
import java.util.List;

public class Reptile implements Animal {
	String Name;
	int Age;
	float weight;
	int numberOfLegs;
	float LengthInMeters;
	String type;
	public String getCategory() {
		return "Reptile";
	}
	public Reptile(String name,int age,float weight,float length, String type){
		this.Name=name;
		this.Age=age;
		this.weight=weight;
		this.LengthInMeters=length;
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
		return "Hiss";
	}
	public String getType() {
		return type;
	}
	public int numberOfLegs() {
		int numberOfLegs= 0;
		return numberOfLegs;
	}
	public float getLength() {
		return LengthInMeters;
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
