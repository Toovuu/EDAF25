package lab1;

import graph.Graph;
import graph.SimpleGraph;

import java.util.Collection;

public class Lab1 {
  /**
   * Returns the number of vertices in the graph g.
   */
  public static int vertexCount(Graph<Integer> g) {
    // TODO(D1): implement this!
    return g.vertexCount();
  }

  /**
   * Returns the number of edges in the graph g.
   */
  public static int edgeCount(Graph<Integer> g) {
    // TODO(D2): implement this!
    int sum = 0;
    for(int i: g.vertexSet()){
      sum += g.neighbours(i).size();
    }
    return sum;
  }

  /**
   * Returns true if there is an edge from vertex u to vertex v.
   * Returns false if u and v are not connected or if there is only an edge from v to u.
   *
   * @param g a graph containing u and v
   * @param u index of the first vertex in g
   * @param v index of the second vertex in g
   */
  public static boolean edgeBetween(Graph<Integer> g, int u, int v) {
    // TODO(D3): implement this!
    Collection<Integer> sInt = g.neighbours(u);
    return sInt.contains(v);  }

  /**
   * Returns a simple graph with at least 6 vertices and at least 10 edges.
   */
  public static Graph<Integer> buildGraph() {
    // TODO(D5): implement this!
    return new SimpleGraph(11,
            new int[][]{{0,1}, {1,2}, {2,3}, {3,4}, {4,5}, {5,6}, {6,7}, {7,8}, {8,9}, {9,10}});  }
}
