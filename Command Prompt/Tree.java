import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tree {
	
	Node root;
	Node currentDirectory;
	Node node;
	Node newNode;
	public Tree() {
		root = new Node();
		root.fileName = "root";
		currentDirectory = root;
		root.subDirectoryList = new ArrayList<Node>();
		root.subDirectoryMap = new HashMap<String, Node>();
	}
	
	public boolean makeDirectory(String newFileName) {
		if(newFileName == null)
			return false;
		if((currentDirectory != null) && (currentDirectory.subDirectoryMap != null) && currentDirectory.subDirectoryMap.containsKey(newFileName)) {
			System.out.println("Directory with name \"" + newFileName + "\" already exist.");
			return false;
		}
		newNode = new Node();
		newNode.parent = currentDirectory; 	
		newNode.fileName = newFileName;
		if(currentDirectory.subDirectoryList == null) {
			currentDirectory.subDirectoryList = new ArrayList<Node>();
			currentDirectory.subDirectoryMap = new HashMap<String, Node>();
		}
		currentDirectory.subDirectoryList.add(newNode);
		currentDirectory.subDirectoryMap.put(newFileName, newNode);
		System.out.println("Directory created : " + newFileName + " under parent : " + currentDirectory.fileName );
		return true;		
	}
	
	
	public void print(Node root) {
		System.out.println(root.fileName);
		if(this.isDirectory(root)) {
			for(Map.Entry<String, Node> n : root.subDirectoryMap.entrySet()) 
				print(n.getValue());
			System.out.print(" ");
		}
	}
	
	public void changeDirectory(String directoryName) {
		if(currentDirectory.fileName.equals(directoryName)) {
			System.out.println("You are already present in specified directory!!");
			return;
		}
		if((currentDirectory.fileName.equals("root")) && directoryName.equals("cd..")) {
			System.out.println("You are in root Directory!! No pareny diretory is available.");
			return;
		}
		if(directoryName.equals("cd..")) {
			currentDirectory = currentDirectory.parent;
			System.out.println("Directory Changed to: " + currentDirectory.fileName);
			return;
		}
		if(currentDirectory.parent != null && currentDirectory.parent.subDirectoryMap.containsKey(directoryName)) {
			currentDirectory = currentDirectory.parent.subDirectoryMap.get(directoryName);
			System.out.println("Directory Changed to: " + currentDirectory.fileName);
			return;
		}
		if( currentDirectory.subDirectoryMap != null && currentDirectory.subDirectoryMap.containsKey(directoryName)) {
			currentDirectory = currentDirectory.subDirectoryMap.get(directoryName);
			System.out.println("Directory Changed to: " + currentDirectory.fileName);
			return;
		}
		System.out.println("The system cannot find the path specified.");
	}
	
	
	public boolean isDirectory(Node n) {
		if(n.subDirectoryList == null) 
			return false;
		if(n.subDirectoryMap == null)
			return false;
		return true;
	}
	
	public Node showCurrentDirectory() {
		System.out.println("Current Directory" + currentDirectory.fileName);
		return currentDirectory;
	}
	
	
	public void printList(Node n) {   
		Node currentParent;
		if(n.fileName.equals("root"))
			currentParent = root;
		else
			currentParent = n.parent;
		
		System.out.println("File Name \t No. of Subfiles \t\t TimeStamp");
		
		if(this.isDirectory(n)) {
			int filesInDirectory;
			for(Map.Entry<String, Node> dir : currentParent.subDirectoryMap.entrySet()) {
				if(dir.getValue().subDirectoryMap == null)
					filesInDirectory = 0;
				else
					filesInDirectory = dir.getValue().subDirectoryMap.size();
				System.out.println(dir.getValue().fileName + "\t\t\t" + filesInDirectory + "\t\t" + dir.getValue().timeStamp);
			}
			System.out.print(" ");
		}
	}
	
	public String find(String fileName) {
		String path = "";
		if(this.isDirectory(currentDirectory) && currentDirectory.subDirectoryMap.containsKey(fileName)) {
			path = currentDirectory.fileName;
			return currentDirectory.fileName;
		}
		if(this.isDirectory(currentDirectory)) {
			Map<String, Node> subFolders = currentDirectory.subDirectoryMap;
			for(Map.Entry<String, Node> directory : subFolders.entrySet()) {
				
					currentDirectory = directory.getValue();		System.out.println(currentDirectory.fileName +" "+ this.isDirectory(currentDirectory));
					path = path + "\\" + find(fileName);

			}
		}
		if(path.equals(""))
			return "No such file found in current directory!";
		return path;
	}
}
