package lab2;

import graph.Graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lab2 {

  /**
   * Generic depth first search in a graph, starting from the vertex u.
   *
   * @param g the graph to search in
   * @param u the start vertex
   * @param visited set of visited vertices (should be empty for a full search)
   * @param <T> the vertex type
   */
  private static <T> void dfs(Graph<T> g, T u, Set<T> visited) {
    visited.add(u);
    for (T v : g.neighbours(u)) {
      if (!visited.contains(v)) {
        dfs(g, v, visited);
      }
    }
  }

  public static boolean isConnected(Graph<Integer> g) {
    // TODO(D2): implement this!
    Set<Integer> sInt = new HashSet<Integer>();
    dfs(g,0, sInt);
    for(int v: g.vertexSet()){
      if(!sInt.contains(v)){
        return false;
      }
    }
    return true;
  }

  public static int nbrOfComponents(Graph<Integer> g) {
    // TODO(D3): implement this!
    int count = 0;
    Set<Integer> sInt = new HashSet<Integer>(g.vertexCount());
    for(int i: g.vertexSet()){
      if(!sInt.contains(i)){
        dfs(g, i,sInt);
        count++;
      }
    }
    return count;
  }

  public static boolean pathExists(Graph<Integer> g, int u, int v) {
    // TODO(D4): implement this!
    if(u==v){
      return true;
    }
    Set<Integer> visited = new HashSet<>();
    return pathExists(g,u,v,visited);
  }

  private static boolean pathExists(Graph<Integer> g, int u, int v, Set<Integer> visited){
    visited.add(u);
    for(int x: g.neighbours(u)){
      if(!visited.contains(x)){
        if (pathExists(g,x,v,visited)) return true;
      }
    }
    return visited.contains(v);
  }

  public static List<Integer> findPath(Graph<Integer> g, int u, int v) {
    // TODO(D5): implement this!
    return Collections.emptyList();
  }
}

