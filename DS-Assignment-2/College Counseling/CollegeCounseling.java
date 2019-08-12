import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* This is a component class. This class is implemented for allotment of branch applied by students
 * on the basis of their ranks and preferences.
 * @author Bhupendra
 */
public class CollegeCounseling {
	
	// Instance Variables.
	Map<String, Integer> programs;
	List<StudentPreferences> studentPreference;
	private Map<String, String> allotment;
	ReadExcel re;
	WriteExcel we;
	Queue queue;
	
	/* Constructor.
	 * @param programsFile	file path which contains programs offered by college. 
	 * @param studentsFile	file path which contains students with their preferences.
	 * @throws Exception
	 */
	public CollegeCounseling( String programsFile, String studentsFile) throws Exception{
		re = new ReadExcel();
		re.setInputFile(programsFile);
		re.setStudentsFile(studentsFile);
		programs = re.readPrograms();
		studentPreference = re.readStudents();
		allotment = new HashMap<String, String>();
		queue = new Queue(studentPreference.size());
		
		for(StudentPreferences sp : studentPreference) 
			queue.enqueue(sp);
	}
	
	// This method allots branches to students on the basis of their ranks and preferences.
	public void allotBranch() {
		StudentPreferences sp;
        while(!queue.isEmpty()) {
        	
        	sp = queue.dequeue();
        	String name = sp.name;
        	String first = sp.first;
        	String second = sp.second;
        	String third = sp.third;
        	String fourth = sp.fourth;
        	String fifth = sp.fifth;
        	
        	if(programs.get(first) != null && programs.get(first) > 0) {
        		allotment.put(name, first);
        		int count = programs.get(first) - 1;
        		programs.put(first, count);
        		continue;
        	}
        	if(programs.get(second) != null && programs.get(second) > 0) {
        		allotment.put(name, second);
        		int count = programs.get(second) - 1;
        		programs.put(second, count);
        		continue;
        	}	
        	if(programs.get(third) != null && programs.get(third) > 0) {
        		allotment.put(name, third);
        		int count = programs.get(third) - 1;
        		programs.put(third, count);
        		continue;
        	}
        	if(programs.get(fourth) != null && programs.get(fourth) > 0) {
        		allotment.put(name, fourth);
        		int count = programs.get(fourth) - 1;
        		programs.put(fourth, count);
        		continue;
        	}
        	if(programs.get(fifth) != null && programs.get(fifth) > 0) {
        		allotment.put(name, fifth);
        		int count = programs.get(fifth) - 1;
        		programs.put(fifth, count);
        		continue;
        	}
        	else
        		System.out.println("No allotment available.");
        }
	}
	
	/* This method used to get the student with their alloted branch as key value pair.
	 * @return Map of students with their alloted branch.
	 */
	public Map<String, String> getAllotment() {
		this.allotBranch();
		return this.allotment;
	}
	
	/* This method writes the allotment to the excel file.
	 * @param outputFilePath file path
	 * @return true if file is written successfully, false otherwise.
	 * @throws Exception
	 */
	public boolean getAllotmentFile(String outputFilePath) throws Exception {
		we = new WriteExcel(outputFilePath, allotment);
		we.writeToExcel();
		return true;
	}
}
