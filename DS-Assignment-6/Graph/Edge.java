/**
 * This is a component class. This class represents the edge of the graph.
 * @author Bhupendra
 */
public class Edge {

	// Instance variables.
	int source;
	int destination;
	int weight;
	
	// Constructor.
	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}
