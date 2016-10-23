import java.util.*;

public class Main
{

    static int capX;
    static int capY;
    static ArrayList<ArrayList<Integer> > arr;
    static ArrayList<ArrayList<Point> > robots;
    static int n;
    static int m;


    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        char type;
        String temp;
        String ans = "";
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        arr = new ArrayList<ArrayList<Integer> >(n);

        for(int i = 0; i < n; i++)
        {
            arr.add(new ArrayList<Integer>(m));
        }

        for(int i = 0; i < n; i++)
        {
            temp = sc.nextLine();

            for(int j = 0; j < m; j++)
            {
                type = temp.charAt(j);
                if(type == '*')
                {
                    arr.get(i).add(0);
                }
                else if(type == '.')
                {
                    arr.get(i).add(1);
                }
                else
                {
                    arr.get(i).add(2);
                    capX = i;
                    capY = j;
                }
            }
        }

        robots = new ArrayList<ArrayList<Point> >(n);

        for(int i = 0; i < n; i++)
        {
            robots.add(new ArrayList<Point>(m));
            for(int j = 0; j < m; j++)
            {
                robots.get(i).add(new Point(i, j));
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                String tem = shortestpath(robots.get(i).get(j).x, robots.get(i).get(j).y);
                ans += tem;
            }
        }


        System.out.println(ans);

    }

    public static void shiftAll(String path)
    {
        for(int chr = 0; chr < path.length(); chr++)
        {
            char move = path.charAt(chr);

            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                {
                    int x = robots.get(i).get(j).x;
                    int y = robots.get(i).get(j).y;

                    if(move == 'U')
                    {
                        if(x > 0 && !(arr.get(x - 1).get(y) == 0))
                        {
                            robots.get(i).get(j).x = x - 1;
                        }
                    }
                    else if(move == 'D')
                    {
                        if(x < n - 1 && !(arr.get(x + 1).get(y) == 0))
                        {
                            robots.get(i).get(j).x = x + 1;
                        }
                    }
                    else if(move == 'L')
                    {
                        if(y > 0 && !(arr.get(x).get(y - 1) == 0))
                        {
                            robots.get(i).get(j).y = y - 1;
                        }
                    }
                    else
                    {
                        if(y < m - 1 && !(arr.get(x).get(y + 1) == 0))
                        {
                            robots.get(i).get(j).y = y + 1;
                        }
                    }

                }
            }
        }
    }

    public static String shortestpath(int x, int y)
    {
        if(arr.get(x).get(y) != 1)
        {
            return "";
        }

        Queue<Point> queue = new LinkedList<Point>();
        boolean[][] visited = new boolean[n][m];
        String[][] path = new String[n][m];
        visited[x][y] = true;
        path[x][y] = "";
        Point temp;

        queue.add(new Point(x, y));

        while(!queue.isEmpty())
        {
            temp = queue.remove();

            if(temp.x == capX && temp.y == capY)
            {
                shiftAll(path[capX][capY]);
                return path[capX][capY];
            }

            if(0 < temp.x)
            {
                if(!visited[temp.x - 1][temp.y] && !(arr.get(temp.x - 1).get(temp.y) == 0))
                {
                    queue.add(new Point(temp.x - 1, temp.y));
                    path[temp.x - 1][temp.y] = path[temp.x][temp.y] + "U";
                    visited[temp.x - 1][temp.y] = true;

                }
            }

            if(0 < temp.y)
            {
                if(!visited[temp.x][temp.y - 1] && !(arr.get(temp.x).get(temp.y - 1) == 0))
                {
                    queue.add(new Point(temp.x, temp.y - 1));
                    path[temp.x][temp.y - 1] = path[temp.x][temp.y] + "L";
                    visited[temp.x][temp.y - 1] = true;

                }
            }

            if(n - 1 > temp.x)
            {
                if(!visited[temp.x + 1][temp.y] && !(arr.get(temp.x + 1).get(temp.y) == 0))
                {
                    queue.add(new Point(temp.x + 1, temp.y));
                    path[temp.x + 1][temp.y] = path[temp.x][temp.y] + "D";
                    visited[temp.x + 1][temp.y] = true;

                }
            }

            if(m - 1 > temp.y)
            {
                if(!visited[temp.x][temp.y + 1] && !(arr.get(temp.x).get(temp.y + 1) == 0))
                {
                    queue.add(new Point(temp.x, temp.y + 1));
                    path[temp.x][temp.y + 1] = path[temp.x][temp.y] + "R";
                    visited[temp.x][temp.y + 1] = true;

                }
            }
        }
        return path[capX][capY];
    }


}

class Point
{
    int x;
    int y;

    public Point(int a, int b)
    {
        x = a; y = b;
    }
}