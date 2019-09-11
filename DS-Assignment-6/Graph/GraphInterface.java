import java.util.List;
import java.util.Set;

/**
 * This is a component class. This is an interface used for implementing graphs.
 * @author Bhupendra.
 */
public interface GraphInterface {
	
	/**
	 * This method checks whether a graph is connected or not.
	 * @return true if the graph is connected, false otherwise.
	 */
	boolean isConnected();
	
	/**
	 * his method returns the list of vertices reachable from given vertex.
	 * @param vertex.
	 * @return list of vertices.
	 */
	List<Integer> reachable(int vertex);
	
	/**
	 * @param source vertex.
	 * @return array of parent vertex.
	 */
	int[] getMST(int source);
	
	/**
	 * This method uses dijsktra algorithm for finding shortest path.
	 * @param source vertex.
	 * @return distance array from the given source.
	 */
	int[] shortestPath(int source);
}
