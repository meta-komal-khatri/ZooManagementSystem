package zoo;

public class Snake extends Reptile {
	Snake(String name,int age,float weight,float length){
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
		return "Snake";
	}
	public int numberOfLegs() {
		int numberOfLegs= 0;
		return numberOfLegs;
	}
	public float getLength() {
		return LengthInMeters;
	}
}
