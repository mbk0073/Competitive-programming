/**
 * Created by Ambikeya on 21-10-2016.
 */
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


class Node implements Comparator<Node>{
    int cost;
    int node;
    Node(){}
    Node(int node, int cost){
        this.node=node;
        this.cost=cost;
    }
    @Override
    public int compare(Node n1, Node n2){
        if(n1.cost>n2.cost)return 1;
        if(n2.cost>n1.cost)return -1;
        return 0;
    }
}
class Prim {

    //variable declaration
    public Set<Integer> visited;
    public PriorityQueue<Node> pq;
    public ArrayList<Map<Integer, Integer>> adjList;
    public int distance[];

    public void getNeighbors(int currentvertex){
        Map<Integer, Integer> currentNode=adjList.get(currentvertex);
        int node, cost;
        for(Map.Entry<Integer,Integer> entry:currentNode.entrySet()){
            node=entry.getKey();
            cost=entry.getValue();
            if(!visited.contains(node)){
                distance[node]=Math.min(distance[node], adjList.get(currentvertex).get(node));
                pq.add(new Node(node,distance[node]));
            }
        }
    }

    public void intialize(int n){
        visited=new HashSet<>();
        pq=new PriorityQueue<>(n+1,new Node());
        adjList=new ArrayList<>(n+1);
        distance=new int[n+1];
        for(int i=0;i<=n;++i){
            distance[i]=Integer.MAX_VALUE;
            adjList.add(new HashMap<>());
        }
    }

    public void PrimMST(int source, int n){
        distance[source]=0;
        pq.add(new Node(source, 0));
        while(visited.size()<n){
            int node=pq.remove().node;
            if(visited.contains(node))continue;
            visited.add(node);
            getNeighbors(node);

        }

    }

    public static void main(String []args){
        Scanner scanner=new Scanner(System.in);
        int N,M;

        N=scanner.nextInt();
        M=scanner.nextInt();

        Prim prim=new Prim();
        prim.intialize(N);
        for(int j=1; j<=M; ++j){
        /*
        * Creating an adjacency List which allows for faster traversal through the graph
        * Does not allow parallel edges by keeping only the smaller one
        * */
            int node1=scanner.nextInt();
            int node2=scanner.nextInt();
            int distance=scanner.nextInt();

            if(prim.adjList.get(node1).get(node2)!=null){
                int temp=prim.adjList.get(node1).get(node2);
                if(temp<distance)continue;
            }

            prim.adjList.get(node1).put(node2,distance);
            prim.adjList.get(node2).put(node1, distance);

        }

        //end of graph initialization as a adjlist

        int s=scanner.nextInt();
        prim.PrimMST(s,N);
        int sum=0;
        //the distance array holds all the distances
        //In this program we print the total sum of all distances i.e. the net cost of the MST
        for(int i=1; i<=N; ++i)sum+=prim.distance[i];
        System.out.println(sum);
    }
}
