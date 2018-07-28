package zoo;

public abstract class Reptile implements Animal {
	String Name;
	int Age;
	float weight;
	int numberOfLegs;
	float LengthInMeters;
	public String getCategory() {
		return "Reptile";
	}
}
