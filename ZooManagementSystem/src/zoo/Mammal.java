package zoo;

public abstract class Mammal implements Animal{
	String Name;
	int Age;
	float weight;
	int numberOfLegs;
	public String getCategory() {
		return "Mammal";
	}
}
