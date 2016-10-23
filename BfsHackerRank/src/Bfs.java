/**
 * Created by asus on 14-10-2016.
 */
import java.util.*;

public class Bfs {
    private static Queue<Integer>q;
    private static boolean visited[];
    private static int distance[];
    private static ArrayList<ArrayList<Integer>> adjList;

    public static void bfs(int s){
        ArrayList<Integer> a;
        q=new LinkedList<>();
        q.add(s);

        visited[s]=true;
        int count=0;
        while(!q.isEmpty()){
            count=count+6;
            int element=q.remove();
            a=adjList.get(element);
            for(int i:a){
                visited[i]=true;
                q.add(i);
                distance[i]=count;
            }
        }


    }


    public static void main(String []args){

        Scanner scanner=new Scanner(System.in);
        int q=scanner.nextInt();
        for(int j=1; j<=q; ++j){

            int N=scanner.nextInt();
            int M=scanner.nextInt();
            adjList=new ArrayList<>(N+1);
            for(int t=0; t<N+1; ++t)adjList.add(new ArrayList<Integer>(M));

            distance=new int[N+1];
            visited=new boolean[N+1];
            for(int i=1; i<=M; ++i){
                int m=scanner.nextInt();
                int n=scanner.nextInt();
                adjList.get(m).add(n);//add nth node to the mth one
            }//creation of adjacency list
            int s=scanner.nextInt();//starting node
            bfs(s);
            for(int i=1; i<=N; ++i){
                if(i==s)continue;
                System.out.print(((distance[i]==0)?-1:distance[i])+" ");
            }
            System.out.println();
        }

    }
}
