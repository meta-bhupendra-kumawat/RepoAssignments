import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/* This method is used to read the data from an external source file. This file can be of xls extension
 * which is an excel file.
 * @author Bhupendra
 */
public class ReadExcel {
	
	// Instance variables used to store file path.
    private String inputProgramsFile;
    private String inputStudentsFile;

    /* Setters
     * @param inputFile program file path.
     */
    public void setInputFile(String inputFile) {
        this.inputProgramsFile = inputFile;
    }
    
    /* Setters
     * @param inputFile student file path.
     */
    public void setStudentsFile(String inputFile) {
        this.inputStudentsFile = inputFile;
    }

    /* This method is used to read all the programs offered by some college specified in programs
     * excel sheet.
     * @return HashMap of programs with their capacities.
     * @throws IOException
     */
    public Map<String, Integer> readPrograms() throws IOException  {
    	Map<String, Integer> programs = new HashMap<String, Integer>();
        File inputWorkbook = new File(inputProgramsFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet(0);

            for (int i = 0; i < sheet.getRows(); i++) {
            	programs.put(sheet.getCell(0, i).getContents(), 
            			Integer.parseInt(sheet.getCell(1, i).getContents()));
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return programs;
    }
    
    /* This method is used to read all the students preferences offered by some college specified in 
     * students excel sheet.
     * @return List of students preferences.
     * @throws IOException
     */
    public List<StudentPreferences> readStudents() throws IOException  {
    	List<StudentPreferences> studentPreference = new ArrayList<StudentPreferences>();
        File inputWorkbook = new File(inputStudentsFile);
        StudentPreferences preferences;
        try {
           Workbook w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet(0);

            for (int i = 0; i < sheet.getRows(); i++) {
            	preferences = new StudentPreferences(
            			sheet.getCell(0, i).getContents(),
            			sheet.getCell(1, i).getContents(), 
            			sheet.getCell(2, i).getContents(), 
            			sheet.getCell(3, i).getContents(), 
            			sheet.getCell(4, i).getContents(), 
            			sheet.getCell(5, i).getContents());
            	studentPreference.add(preferences);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return studentPreference;
    }
}