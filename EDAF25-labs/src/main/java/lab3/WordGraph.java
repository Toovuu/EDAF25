package lab3;

import graph.Graph;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordGraph implements Graph<String> {
  private final Map<String, Set<String>> graph = new HashMap<>();

  public WordGraph(Path wordfile, WordCriteria criteria) throws IOException {
    // TODO(D1): load all words from file (wordfile).
    try(Reader in = Files.newBufferedReader(wordfile)){
      Scanner scan = new Scanner(in);
      while(scan.hasNext()){
        String word = scan.nextLine();
        graph.put(word, new HashSet<>());
      }
    }
    for(String s: graph.keySet()){
      for(String k : graph.keySet()){
        if(criteria.adjacent(s,k)){
          graph.get(s).add(k);
        }
      }
    }
    // TODO(D3): compute word neighbours (according to criteria).

  }

  @Override public int vertexCount() {
    // TODO(D1): implement this!
    return graph.size();
  }

  @Override public Collection<String> vertexSet() {
    // TODO(D1): implement this!
    return graph.keySet();
  }

  @Override public Collection<String> neighbours(String v) {
    return graph.getOrDefault(v, Collections.emptySet());
  }
}
