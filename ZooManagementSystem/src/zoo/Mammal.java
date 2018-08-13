package zoo;

import java.util.ArrayList;
import java.util.List;

public class Mammal implements Animal{
	private String name;
	private int age;
	private float weight;
	String type;
	public Mammal(String name,int age,float weight,String type){
		this.name=name;
		this.age=age;
		this.weight=weight;
		this.type=type;
	}
	public String getCategory() {
		return "Mammal";
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public float getweight() {
		return weight;
	}
	public String getSound() {
		if("Lion".equals(type)){
		return "Roar";
		}
		else{
			return "Growls";
		}
		
	}
	public String getType() {
		return type;
	}
	public int numberOfLegs() {
		if("Lion".equals(type)){
			return 4;
			}
			else{
				return 2;
			}
		
	}
	public List<String> getInfo(){
		List<String> animalDetails=new ArrayList<String>();
		animalDetails.add(getName());
		animalDetails.add(getSound());
		animalDetails.add(getType());
		animalDetails.add(Integer.toString(getAge()));
		animalDetails.add(Integer.toString(numberOfLegs()));
		animalDetails.add(Float.toString(getweight()));
		return animalDetails;
	}
}
