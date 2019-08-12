import java.io.File;
import java.util.Map;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

 /* This class is used to write the data by creating an excel file at the specified path.
 * @author Bhupendra
 */
class WriteExcel {

	// Instance variables.
	String outputFilePath;
	Map<String, String> allotment;
	
	/* Constructor.
	 * @param outputFilePath path of the output file.
	 * @param allotment data that is desired to be written in excel file.
	 */
	public WriteExcel(String outputFilePath, Map<String, String> allotment) {
		this.outputFilePath = outputFilePath;
		this.allotment = allotment;
	}
	
	/* This method write the data to excel sheet of given output file.
	 * @throws Exception
	 */
	public void writeToExcel() throws Exception {
		
		WritableWorkbook workbook = Workbook.createWorkbook(new File(outputFilePath));
		WritableSheet sheet = workbook.createSheet("Sheet1", 0);
		
		jxl.write.Label label;
		int i = 0;
		for(Map.Entry<String, String> details : allotment.entrySet()) {
			label = new jxl.write.Label(0, i, details.getKey());
			sheet.addCell(label);
			label = new jxl.write.Label(1, i, details.getValue());
			sheet.addCell(label);
			i++;
		}
		workbook.write();
		workbook.close();
	}
}
