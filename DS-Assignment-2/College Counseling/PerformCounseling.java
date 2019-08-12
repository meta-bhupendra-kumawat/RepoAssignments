import java.util.Map;

/* This is an application class. This class used the functionality of class to read data from excel file
 * and perform the allotment and write it to excel file as output.
 * @author Bhupendra
 */
public class PerformCounseling {
	public static void main(String args[]) throws Exception {
		String programFilePath = "D:\\Development\\Metacube Assignments\\DS-Assignment-2\\Programs.xls";
		String studentFilePath = "D:\\Development\\Metacube Assignments\\DS-Assignment-2\\Students.xls";
		String outputFilePath = "D:\\Development\\Metacube Assignments\\DS-Assignment-2\\Allotment.xls";
		CollegeCounseling cc = new CollegeCounseling(programFilePath, studentFilePath);
		cc.allotBranch();

		Map<String, String> allotment = cc.getAllotment();
		for(Map.Entry<String, String> entry : allotment.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		cc.getAllotmentFile(outputFilePath);
	}
}
