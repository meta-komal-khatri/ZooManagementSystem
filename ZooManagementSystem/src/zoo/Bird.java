package zoo;

public abstract class Bird implements Animal{
	String Name;
	int Age;
	float weight;
	int numberOfLegs;
	float lengthOfFeathers;
	public String getCategory() {
		return "Bird";
	}
}
