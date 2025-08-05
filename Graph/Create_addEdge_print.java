import java.util.*;

public class Main {
    public static void main(String[] args) {
      Graph g = new Graph(5);
      g.addEdge(0,2);
      g.addEdge(0,3);
      g.addEdge(1,2);
      g.addEdge(1,4);
      g.addEdge(2,3);
      g.addEdge(2,4);
      g.addEdge(3,4);
      g.printGraph();
  }
}

class Graph{
  private int V;
  private List<List<Integer>> adjList;
  public Graph(int V){
    this.V = V;
    adjList = new ArrayList<>();
    for(int i=0; i<V; i++){
      adjList.add(new ArrayList<>());
    }
  }
  // add edge
  public void addEdge(int u, int v){
    adjList.get(u).add(v);
    adjList.get(v).add(u);
  }
  //print the Graph
  public void printGraph(){
    for(int i=0; i<V; i++){
      System.out.print("Vertex "+ i +":");
      for(int node : adjList.get(i)){
        System.out.print(node +" ");
      }
      System.out.println();
    }
  }
}
