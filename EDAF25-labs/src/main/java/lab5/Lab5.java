package lab5;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Lab5 {
  /**
   * Computes the maximum flow for a flow network.
   * @param g a graph with edge capacities and a source and sink
   * @return shortest distance between start and end
   */
  public static int maxFlow(FlowGraph g, int source, int sink) {
    // TODO(D2): Impelementera Edmonds-Karp varianten av Ford-Fulkerson algoritmen.
    // Det vill säga, använd bredden först-sökning för att hitta en väg med positivt flöde,
    // subtrahera det flödet och upprepa tills det inte går att skicka igenom mer flöden.
    int flow = 0;
    int[][] residual = new int[g.vertexCount()][g.vertexCount()];
    for(int i = 0; i<g.vertexCount(); i ++){
      for(int j = 0; j<g.vertexCount(); j++){
        residual[i][j] = g.getCapacity(i,j);
      }
    }
    int [] pred = new int[g.vertexCount()];
    while(bfs(g.vertexCount(), source, sink, residual, pred)){
      int back = sink;
      int min = Integer.MAX_VALUE;
      while(back!=source){
        min=Math.min(min,residual[pred[back]][back]);
        back = pred[back];
      }
      int back2=sink;
      while(back2!=source){
        residual[pred[back2]][back2]-=min;
        residual[back2][pred[back2]]+=min;
        back2 = pred[back2];
      }
      flow+=min;
    }
    return flow;
  }

  /**
   * Read a flowgraph from a file.
   */
  public static FlowGraph loadFlowGraph(Path path) throws IOException {
    // TODO(D3): läs in ett flödesnätverk från fil.
    // Filen börjar med ett heltal som anger antalet noder,
    // sedan följer ett tal m som är antalet bågar.
    // Resten av filen består av m rader där varje rad anger en båge i
    // formatet u v c som beskriver en båge från en nod u till v med kapacitet c.
    try(Reader in = Files.newBufferedReader(path)){
      Scanner scan = new Scanner(in);
      int nodes = scan.nextInt();
      int edges = scan.nextInt();
      FlowEdge[] flowEdges = new FlowEdge[edges];
      for(int i = 0; i < edges; i++){
        int source = scan.nextInt();
        int dest = scan.nextInt();
        int cap = scan.nextInt();
        if(cap==-1){
          cap=Integer.MAX_VALUE;
        }
        flowEdges[i] = new FlowEdge(source,dest,cap);
      }
      return new FlowGraph(nodes, flowEdges);
    }
  }

  public static boolean bfs(int numVertex, int start, int end, int[][] residual, int[] pred){
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    queue.offer(start);
    boolean[] visited = new boolean[numVertex];
    visited[start] = true;
    while(!queue.isEmpty()){
      int current = queue.poll();
      for (int neighbour = 0; neighbour < numVertex; neighbour++){
        if (residual[current][neighbour]>0 && visited[neighbour]==false ){
            visited[neighbour] = true;
            queue.offer(neighbour);
            pred[neighbour] = current;

        }
      }
    }
    return visited[end];
  }

}
