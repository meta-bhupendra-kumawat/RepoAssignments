import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.print.attribute.HashAttributeSet;

/**
 * This is as component class. This method consists of method to perform operations
 * on graph data structure.
 * @author Bhupendra.
 */
public class Graph implements GraphInterface {
	
	// Instance variables.
	List<Edge> edgeList[]; 
	int numOfVertices;
	int source;
	int distance[];
	
	// Constructor.
	public Graph(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		edgeList = new LinkedList[ numOfVertices ];
		distance = new int[ numOfVertices ];
	}
	
	// This method add edges to the graph.
	public void addEdge(int vertexNum, List<Edge> listOfEdges) {
		edgeList[ vertexNum ] = listOfEdges;
	}
	
	/**
	 * This method performs depth first search. It follows recursive approach.
	 * @param isVisited array.
	 * @param stack.
	 */
	public void performDFS( boolean isVisited[], Stack<Integer> stack) {
		for(int i = 0; i < edgeList[ stack.peek() ].size(); i++) {
			if(!isVisited[ edgeList[ stack.peek() ].get(i).destination ]) {
				isVisited[ edgeList[ stack.peek() ].get(i).destination ] = true;
				stack.push(edgeList[ stack.peek() ].get(i).destination);
				performDFS(isVisited, stack);
 			}
		}
		stack.pop();
	}
	
	/**
	 * This method performs depth first search.
	 * @param vertex.
	 * @return boolean array for the connected vertices from given vertex.
	 */
	public boolean[] DFS(int vertex) {
		boolean isVisited[] = new boolean[ numOfVertices  ];
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(vertex);
		isVisited[vertex] = true;
		this.performDFS(isVisited, stk);
		return isVisited;
	}

	/** 
	 * This is an overridden method. This method checks whether a graph is connected or not. 
	 * (non-Javadoc)
	 * @see GraphInterface#isConnected()
	 */
	@Override
	public boolean isConnected() {
		boolean isVisited[] = this.DFS(0);
		for(int i = 0; i < isVisited.length; i++) {
			if(!isVisited[i])
				return false;
		}
		return true;
	}
	
	/** 
	 * This method returns the list of vertices reachable from given vertex.
	 * (non-Javadoc)
	 * @see GraphInterface#reachable(int)
	 */
	@Override
	public List<Integer> reachable(int vertex) {
		boolean isVisited[] = this.DFS(vertex);
		List<Integer> reachable = new ArrayList<Integer>();
		for(int i = 0; i < isVisited.length; i++) {
			if(isVisited[i]) 
				reachable.add(i);
		}
		return reachable;
	}
	
	/**
	 * This is an overridden method. This method uses dijsktra algorithm for finding shortest path.
	 * @see GraphInterface#ShortestPath(int)
	 */
	@Override
	public int[] shortestPath(int source) {
		int shortestDistance[] = new int[numOfVertices];
		Set<Integer> visited = new HashSet<Integer>();
		Set<Integer> unvisited = new HashSet<Integer>();
		int previousVertex[] = new int[numOfVertices];
		
		// Initializing shortest distance array with infinite value.
		for(int i = 0; i < numOfVertices; i++) {
			
			// Adding all the vertices to unvisited set.
			unvisited.add(i);

			if(i == source)
				shortestDistance[i] = 0;
			else
				shortestDistance[i] = Integer.MAX_VALUE;
		}
		previousVertex[source] = Integer.MIN_VALUE;
		int shortestDistanceFromSource[] = dijsktra(source, shortestDistance, visited, unvisited, previousVertex);
		
		// Showing the shortest distance array.
		for(int i = 0; i < shortestDistanceFromSource.length; i++)
			System.out.println(shortestDistanceFromSource[i]);
		
		return shortestDistance;
	}
	
	
	/**
	 * Helper method.
	 * This method uses Dijsktra algorithm for finding graphs shortest path.
	 * This method works recursively.
	 * @param source
	 * @param shortestDistance
	 * @param visited
	 * @param unvisited
	 * @param previousVertex
	 * @return distance array.
	 */
	private int[] dijsktra(int source, int shortestDistance[], Set<Integer> visited, Set<Integer> unvisited, int previousVertex[]) {
		
		// Base condition.
		if(unvisited.isEmpty())
			return shortestDistance;
		
		int nearestVertex = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < edgeList[source].size(); i++) {
			if(unvisited.contains(edgeList[source].get(i).source) 
					&& shortestDistance[edgeList[source].get(i).destination] > edgeList[source].get(i).weight + shortestDistance[source]) {
				shortestDistance[edgeList[source].get(i).destination] = edgeList[source].get(i).weight + shortestDistance[source];
				previousVertex[edgeList[source].get(i).destination] = source;
			}
		}
		
		// Marking vertex as visited.
		visited.add(source);
		unvisited.remove(source);
		
		// Finding minimum distance vertex from source vertex.
		for(int i = 0; i < shortestDistance.length; i++) {
			if(unvisited.contains(i) && min > shortestDistance[i]) {
				min = shortestDistance[i];
				nearestVertex = i;
			}
		}
		return dijsktra(nearestVertex, shortestDistance, visited, unvisited, previousVertex);
	}
	
	/**
	 * Helper method.
	 * This method uses prim's algorithm for finding minimum spanning tree.
	 * @param source vertex
	 * @param shortestDistance
	 * @param visited
	 * @param unvisited
	 * @param parent
	 * @param previousVertex
	 * @return
	 */
	private int[] prims(int source, int shortestDistance[], Set<Integer> visited,
			Set<Integer> unvisited, int parent[], int previousVertex[]) {

		if (unvisited.isEmpty())
			return parent;

		int nextVertex = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < edgeList[source].size(); i++) {
			if (unvisited.contains(edgeList[source].get(i).source)
					&& shortestDistance[edgeList[source].get(i).destination] > edgeList[source].get(i).weight) {
				shortestDistance[edgeList[source].get(i).destination] = edgeList[source].get(i).weight;
				previousVertex[edgeList[source].get(i).destination] = source;
			}
		}
		visited.add(source);
		unvisited.remove(source);

		// Finding minimum distance vertex from source vertex.
		for (int i = 0; i < shortestDistance.length; i++) {
			if (unvisited.contains(i) && min > shortestDistance[i]) {
				min = shortestDistance[i];
				nextVertex = i;
				parent[i] = previousVertex[i];
			}
		}
		return prims(nextVertex, shortestDistance, visited, unvisited, parent, previousVertex);
	}
	
	/**
	 * This method is used to find minimum spanning tree.
	 *  (non-Javadoc)
	 * @see GraphInterface#getMST(int)
	 */
	@Override
	public int[] getMST(int source) {
		
		// Variables.
		int distance[] = new int[numOfVertices];
		Set<Integer> visited = new HashSet<Integer>();
		Set<Integer> unvisited = new HashSet<Integer>();
		int parent[] = new int[numOfVertices];
		int previousVertex[] = new int[numOfVertices];
		
		// Initializing the source vertex parent.
		parent[source] = -1;
		
		// Initializing variables.
		for(int i = 0; i < numOfVertices; i++) {

			// Adding all the vertices to unvisited set.
			unvisited.add(i);

			// Initializing distance array.
			if(i == source)
				distance[i] = 0;
			else
				distance[i] = Integer.MAX_VALUE;
		}
		prims(source, distance, visited, unvisited, parent, previousVertex);
		
		// Showing minimum spanning tree.
		System.out.println("\n\n-----MST-----");
		for(int i = 0; i < parent.length; i++)
			System.out.println( i + " --> " + parent[i]);
		
		return parent;
	}
}
