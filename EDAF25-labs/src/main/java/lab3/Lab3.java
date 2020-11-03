package lab3;

import graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lab3 {
  public static <T> int distance(Graph<T> g, T source, T dest) {
    // TODO(D4): implement this!
    int dis = 0;
    Set<T> visited = new HashSet<>();
    Set<T> curLevel = new HashSet<>();
    visited.add(source);
    curLevel.add(source);
    while(!curLevel.isEmpty()){
      Set<T> nextLevel = new HashSet<>();
      for(T w: curLevel){
        if(w.equals(dest)){
          return dis;
        }
        for(T n: g.neighbours(w)){
          if(!visited.contains(n)){
            visited.add(n);
            nextLevel.add(n);
          }
        }
      }
      dis++;
      curLevel=nextLevel;
    }
    return -1;
  }
}
