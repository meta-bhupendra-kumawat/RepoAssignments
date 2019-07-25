
/* This is a component class.
 * This class consists of methods to provide the functionality for managing zoo.
 * @author Bhupendra
 */
public class Zoo {
	
	// Instance variables.
	static int zooCapacity = 10;
	static int zonesOpened = 0;
	static Zone zoneArray[] = new Zone[zooCapacity];
	
	/* This method is used to add animals to zoo. 
	 * @param name Name of animal.
	 * @param age animal age.
	 * @param weight animal weight.
	 * @return true if insertion is successful, false otherwise.
	 */
	public boolean insertAnimal(String name, int age, double weight )
	{
		Animal a;
		
		name = name.toUpperCase();
		
		switch(name){
		
		case "LION" :
		    a = new Lion(age, weight, name);
			Zoo.addToCage(a);
			break;
			
		case "TIGER":
			break;
			
		case "CROCODILE":
			a = new Crocodile(age, weight, name);
			Zoo.addToCage(a);
			break;
			
		case "SNAKE":
			break;
			
			
		case "PEACOCK":
			a = new Peacock(age, weight, name);
			Zoo.addToCage(a);
			break;
			
		case "PARROT":
			break;
			
			default:
				System.out.println("Invalid animal name.");
		}
		return true;
	}
	
	
	/* This methods adds animal to its desire cage of suitable zone.
	 * @param a Object of Animal class.
	 * @return true if animal is added successfully to zoo, false otherwise.
	 */
	public static boolean addToCage(Animal a)
	{
		Zone zoneObj = null;
		Zone z;
		Cage cageObj = null;
		Cage c;
		Animal aObj;
		
		for(int i = 0; i < Zoo.zooCapacity; i++)
		{
			z = zoneArray[i];
			if(z != null && z.type == a.category && Zoo.zonesOpened < Zoo.zooCapacity){
				for(int j = 0; j < Zone.zoneCapacity; j++ )
				{
					c = z.cageArray[j];
					if(c != null && c.animalInCage == a.animalName && c.animalsInsideCage < Cage.cageCapacity){
						for(int k = 0; k < Cage.cageCapacity; k++){
							aObj = c.animalArray[k];
							if(aObj == null){
								c.animalArray[k] = a;
								zoneArray[i].cagesInsideZone++;
								z.cageArray[j].animalsInsideCage++;
								return true;
							}
						}
					}
					if(c == null){
						cageObj = new Cage();
						cageObj.animalInCage = a.animalName;
						cageObj.animalArray[0] = a;
						z.cageArray[j] = cageObj;
						return true;
					}
				}
			}
			if(z == null){
				zoneObj = new Zone();
				zoneObj.type = a.category;
				cageObj = new Cage();
				cageObj.animalInCage = a.animalName;
				cageObj.animalArray[0] = a;
				zoneObj.cageArray[0] = cageObj;
				zoneArray[i] = zoneObj;							
				return true;
			}
		}		
		return false;
	}
	
	/* This method adds a zone to zoo.
	 * @return true if zone is added successfully, false otherwise.
	 */
	public boolean addZone(){
		int i = 0;
		while(zoneArray[i] != null && i < Zoo.zooCapacity)
			i++;
		if(i == Zoo.zooCapacity){
			System.out.println("Zoo is full. Zone can't be added!!");
			return false;
		}
		Zone z = new Zone();
		zoneArray[i] = z;
		System.out.println("New Zone Added to zoo with Zone Id:" + z.zoneID);
		return true;
	}
	
	/* This method deletes animal from zoo.
	 * @param animalId 
	 * @return true if deletion is successful, false otherwise.
	 */
	public boolean deleteAnimal(int animalId)
	{				
		for(int i = 0; i < Zoo.zonesOpened; i++){											
			for(int j = 0; j < zoneArray[i].cagesInsideZone; j++){							
				for(int k = 0; k < zoneArray[i].cageArray[j].animalsInsideCage; k++){		
					if(zoneArray[i].cageArray[j].animalArray[k].animalId == animalId){
						zoneArray[i].cageArray[j].animalArray[k] = null;
						zoneArray[i].cageArray[j].animalsInsideCage--;
						if(zoneArray[i].cageArray[j].animalsInsideCage == 0)
						{
							zoneArray[i].cagesInsideZone--;
						}
						System.out.println("Animal deleted with Id : " + animalId);
						return true;
					}					
				}
			}
		}
		System.out.println("Animal with Id : " + animalId + "not found.");
		return false;
	}
	
	/* This method adds cage inside given zone.
	 * @param zoneId
	 * @return true if cage is successfully added, false otherwise.
	 */
	public boolean addCage(int zoneId) {
		Cage c;
		for(int i = 0; i < zooCapacity; i++){
			if(zoneArray[i].zoneID == zoneId && zoneArray[i].cagesInsideZone < Zone.zoneCapacity )
			{
				int j = 0;
				while(zoneArray[i].cageArray[j] != null || j < Zone.zoneCapacity)
					j++;
				if(j == Zone.zoneCapacity){
					System.out.println("This zone if full. Can't add more cages.");
					return false;
				}
				else{
					c = new Cage();
					c.animalsInsideCage = 0;
					zoneArray[i].cageArray[j] = c;
					return true;
				}
			}
		}
		return false;
	}
}
