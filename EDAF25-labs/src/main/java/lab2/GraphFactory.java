package lab2;

import graph.Graph;
import graph.SimpleGraph;

public class GraphFactory {
  /** Returns a connected graph of at least 5 vertices. */
  public static Graph<Integer> buildConnected() {
    // TODO(D1): implement this!
    return new SimpleGraph(5, new int[][]{
            {0,1},
            {1,0},
            {1,2},
            {2,1},
            {2,3},
            {3,2},
            {3,4},
            {4,3},
            {4,0},
            {0,4}
    });
  }

  /** Returns a disconnected graph of at least 5 vertices. */
  public static Graph<Integer> buildDisconnected() {
    // TODO(D1): implement this!
    return new SimpleGraph(5, new int[][]{
            {0,1},
            {1,0},
            {1,2},
            {2,1},
            {2,0},
            {0,2},
            {3,4},
            {4,3}
    });
  }
}
