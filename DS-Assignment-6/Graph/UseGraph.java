import java.util.LinkedList;
import java.util.Stack;

/**
 * This is an application class.
 * @author Bhupendra
 */
public class UseGraph {

	public static void main(String args[]) {
		Graph g = new Graph(9);
		LinkedList<Edge> edgeList;
		
//		= new LinkedList<Edge>() {{
//				add(new Edge(1, 2, 0));	add(new Edge(1, 3, 0));
//				add(new Edge(1, 4, 0));
//			}};
//			g.addEdge(1, edgeList);
		
		
//		edgeList = new LinkedList<Edge>() {{
//			add(new Edge(1, 2, 0));	add(new Edge(1, 3, 0));
//			add(new Edge(1, 4, 0));
//		}};
//		g.addEdge(1, edgeList);
//		
//		edgeList = new LinkedList<Edge>() {{
//			add(new Edge(2, 5, 0));	add(new Edge(2, 1, 0));
//		}};
//		g.addEdge(2, edgeList);
//		
//		edgeList = new LinkedList<Edge>() {{
//			add(new Edge(3, 1, 0));	add(new Edge(3, 5, 0));
//		}};
//		g.addEdge(3, edgeList);
//		
//		edgeList = new LinkedList<Edge>() {{
//			add(new Edge(4, 1, 0));	add(new Edge(4, 5, 0));
//		}};
//		g.addEdge(4, edgeList);
//		
//		edgeList = new LinkedList<Edge>() {{
//			add(new Edge(5, 2, 0));	add(new Edge(5, 3, 0));
//			add(new Edge(5, 4, 0));	
//		}};
//		g.addEdge(5, edgeList);
//------------------------------------------------------------------------------------------------------------------------------------------		
		
		edgeList = new LinkedList<Edge>() {{
			add(new Edge(0, 1, 4));		add(new Edge(0, 7, 8));
		}};
		g.addEdge(0, edgeList);
		
		edgeList = new LinkedList<Edge>() {{
			add(new Edge(1, 0, 4));		add(new Edge(1, 2, 8));
			add(new Edge(1, 7, 11));
		}};
		g.addEdge(1, edgeList);
		
		edgeList = new LinkedList<Edge>() {{
			add(new Edge(2, 1, 8));		add(new Edge(2, 3, 7));	
			add(new Edge(2, 5, 4));		add(new Edge(2, 8, 2));
		}};
		g.addEdge(2, edgeList);
		
		edgeList = new LinkedList<Edge>() {{
			add(new Edge(3, 2, 7));		add(new Edge(3, 4, 9));
			add(new Edge(3, 5, 14));
		}};
		g.addEdge(3, edgeList);
		
		edgeList = new LinkedList<Edge>() {{
			add(new Edge(4, 3, 9));		add(new Edge(4, 5, 10));
		}};
		g.addEdge(4, edgeList);
		
		edgeList = new LinkedList<Edge>() {{
			add(new Edge(5, 2, 4));		add(new Edge(5, 3, 14));
			add(new Edge(5, 4, 10));	add(new Edge(5, 6, 2));
		}};
		g.addEdge(5, edgeList);
		
		edgeList = new LinkedList<Edge>() {{
			add(new Edge(6, 5, 2));		add(new Edge(6, 7, 1));
			add(new Edge(6, 8, 6));		
		}};
		g.addEdge(6, edgeList);
		
		edgeList = new LinkedList<Edge>() {{
			add(new Edge(7, 0, 8));		add(new Edge(7, 1, 11));
			add(new Edge(7, 6, 1));		add(new Edge(7, 8, 7));
		}};
		g.addEdge(7, edgeList);
		
		edgeList = new LinkedList<Edge>() {{
			add(new Edge(8, 2, 2));		add(new Edge(8, 6, 6));
			add(new Edge(8, 7, 7));
		}};
		g.addEdge(8, edgeList);
		
		System.out.println(g.isConnected());
		System.out.println(g.reachable(0));
		g.shortestPath(0);
		g.getMST(0);
	}
}
