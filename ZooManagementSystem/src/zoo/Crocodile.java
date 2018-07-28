package zoo;

public class Crocodile extends Reptile {

	Crocodile(String name,int age,float weight,float length){
		super.Name=name;
		super.Age=age;
		super.weight=weight;
		super.LengthInMeters=length;
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
		return "Crocodile";
	}
	public int numberOfLegs() {
		int numberOfLegs= 4;
		return numberOfLegs;
	}
	public float getLength() {
		return LengthInMeters;
	}
}
