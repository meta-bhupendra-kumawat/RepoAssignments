import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class Node {
	Node newNode;
	Node parent;
	String fileName;
	List<Node> subDirectoryList;
	Map<String, Node> subDirectoryMap;
	Timestamp timeStamp;
	public Node() {
		timeStamp = new Timestamp(System.currentTimeMillis());
	}
}
