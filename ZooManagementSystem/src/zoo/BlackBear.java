package zoo;

public class BlackBear extends Mammal {
	BlackBear(String name,int age,float weight){
		super.Name=name;
		super.Age=age;
		super.weight=weight;
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
		return "Growls";
	}
	public String getType() {
		return "Bear";
	}
	public int numberOfLegs() {
		int numberOfLegs= 2;
		return numberOfLegs;
	}
}
