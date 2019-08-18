import java.io.File;
import java.io.IOException;

public class FileHierarchy {

	public static void main(String[] args)throws Exception {
		Tree t = new Tree();
//		t.makeDirectory("YOYOBABAY");
//		t.root.makeDirectory("INSIDE ROOT");
//		t.root.subDirectoryList.get(0).makeDirectory("DD1");
//		t.root.subDirectoryList.get(0).subDirectoryList.get(0).makeDirectory("DD1-1");
//		
//		t.root.subDirectoryList.get(0).makeDirectory("DD2");
//		t.root.subDirectoryList.get(0).makeDirectory("DD3");
//		t.root.makeDirectory("INS ROOT@2");
//		t.root.subDirectoryList.get(1).makeDirectory("DD@2");
//		t.print(t.root);
		
////		t.makeDirectory("YOYOBABAY");
//		System.out.println(t.root.subDirectoryMap.size());
//		
//		System.out.println(t.currentDirectory.fileName);
//		t.changeDirectory("cd..");		
//		
//		t.changeDirectory("YOYOBABAY");
//		System.out.println();
//		t.changeDirectory("cd..");		
////		t.print(t.currentDirectory);				
//		
//		t.makeDirectory("INS @1");
//		t.makeDirectory("INS @2");					System.out.println();
//		System.out.println();
//		
//		t.changeDirectory("INS @2");
////		System.out.println(t.currentDirectory.subDirectoryMap.size());  //>>>>>>>>>>>>>>>>>>>>>>
//		System.out.println(t.currentDirectory.parent.fileName);
//		
//		t.makeDirectory("DD1");
//		t.makeDirectory("DD2");
//		t.makeDirectory("DD3");
//		t.makeDirectory("DD4");
//		
//		t.changeDirectory("DD1");
//		t.makeDirectory("DD1-1");
//		t.showCurrentDirectory();
//		t.changeDirectory("cd..");
//		t.changeDirectory("INS @2");
//		
//		System.out.println("\n\nTree\n");
//		t.displayTree(t.root, 2);
//		System.out.println("\n\n");
//		
//		
////		t.changeDirectory("cd..");
//		t.changeDirectory("DD1");
//		System.out.println(t.currentDirectory.fileName);
//		t.printList(t.currentDirectory);
//		
//		t.changeDirectory("cd..");
//		t.changeDirectory("cd..");
//		System.out.println("\n\n");
//		System.out.println(t.find("DD1-1"));
//		t.changeDirectory("DD3");
//		System.out.println(t.currentDirectory.parent.fileName);
//		System.out.println("\u2514");

		t.showCurrentDirectory();
		t.makeDirectory("Dir1");	
		
		t.changeDirectory("Dir1");
		t.showCurrentDirectory();
		
		t.changeDirectory("cd..");
	}
}
