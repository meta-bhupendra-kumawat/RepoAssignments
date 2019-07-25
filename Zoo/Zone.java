
public class Zone {

	static int zoneCapacity = 5;
	static int counter = 1;
	final int zoneID;
	boolean park;
	boolean canteen;
	int cagesInsideZone = 0;
	String zoneName;
	String type;
	
	Cage cageArray[] = new Cage[zoneCapacity];

	public Zone() {
		this.zoneID = Zone.counter;
		zoneName = "Zone "+Zone.counter++;
		cagesInsideZone++;
		Zoo.zonesOpened++;
	}
	
	public boolean hasPark() {
		return park;
	}
	
	public boolean hasCanteen() {
		return canteen;		
	}

}
