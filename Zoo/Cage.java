

public class Cage {

	static int counter = 1;
	static String cageName;
	static int cageCapacity = 3;
	final int cageID;
	int animalsInsideCage = 0;
	String animalInCage;
	Animal animalArray[] = new Animal[cageCapacity];
	
	public Cage(){
		cageID = counter;
		cageName = "Cage-" + Cage.counter++;
		animalsInsideCage++;
	}
	
//	public Cage addToCage(Animal a, String category){
//		
//		
//		return null;
//	}
	

}
