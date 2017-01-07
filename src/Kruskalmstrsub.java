import java.util.*;

public class Kruskalmstrsub {
	//	Kruskal (MST): Really Special Subtree
	PriorityQueue<Edge> edges;
	int[] nodes;	//	nodes[i] is i-th node's parent
	
	public Kruskalmstrsub(int m, int n)
	{
		Comparator<Edge> c = new EdgeComparator();
		edges = new PriorityQueue<Edge>(m, c);
		nodes = new int[n + 1];
		for(int i = 0; i < n + 1; i++)
			nodes[i] = i;
	}
	
	public void addEdge(int x, int y, int r)
	{
		edges.offer(new Edge(x, y, r));
	}
	
	class Edge {
		int n1, n2, w;
		Edge(int x, int y, int r)
		{
			n1 = x;
			n2 = y;
			w = r;
		}
	}
	
	class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge e1, Edge e2) {
			if(e1.w < e2.w)
				return -1;
			else if(e1.w > e2.w)
				return 1;
			else
				return 0;
		}
		
	}
	
	public void union(int n1, int n2)
	{
		//	if they are in the same set, do nothing
		if(findSet(n1) == findSet(n2))
			return;
		
		nodes[findSet(n1)] = findSet(n2);
	}
	
	//	finds the parent
	public int findSet(int node)
	{
		return node == nodes[node] ? node : findSet(nodes[node]);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Kruskalmstrsub kmst = new Kruskalmstrsub(M, N);

		for(int i = 0; i < M; i++)
		{
			int x = sc.nextInt();	//	1st node
			int y = sc.nextInt();	//	2nd node
			int r = sc.nextInt();	//	edge weight
			kmst.addEdge(x, y, r);
		}
		
		HashSet<Integer> hs = new HashSet<Integer>(N);
		int out = 0;
		while(!kmst.edges.isEmpty())
		{
			Edge e = kmst.edges.poll();
			//System.out.println(e.n1 + " " + e.n2 + " " + e.w);
			if(kmst.findSet(e.n1) != kmst.findSet(e.n2))
			{
				//System.out.println("kasdf " + e.n1 + " " + e.n2 + " " + e.w);
				hs.add(e.n1);
				hs.add(e.n2);
				kmst.union(e.n1, e.n2);
				out += e.w;
			}
		}
		System.out.println(out);
		sc.close();
	}
}
