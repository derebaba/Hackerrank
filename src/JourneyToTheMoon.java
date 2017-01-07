import java.io.*;

public class JourneyToTheMoon {
	//	use disjoint set
	Node[] astronauts;
	class Node {
		Node parent = this;
		int val;
		public Node(int n)
		{
			val = n;
		}
	}
	
	public JourneyToTheMoon(int n)
	{
		astronauts = new Node[n];
		for(int i = 0; i < n; i++)
		{
			astronauts[i] = new Node(i);
		}
			
	}
	
	public void union(Node n1, Node n2)
	{
		//	if they are in the same set, do nothing
		if(findSet(n1) == findSet(n2))
			return;
		
		findSet(n1).parent = n2;
	}
	
	//	finds the parent
	public Node findSet(Node node)
	{
		return node == node.parent ? node : findSet(node.parent);
	}
	
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int I = Integer.parseInt(temp[1]);
		JourneyToTheMoon jttm = new JourneyToTheMoon(N);
	
		for(int i = 0; i < I; i++)
		{
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			// Store a and b in an appropriate data structure of your choice
			jttm.union(jttm.astronauts[a], jttm.astronauts[b]);
		}
	   
		int[] ast = new int[N];	//	i-th country has ast[i] astronauts
		
		for(Node n : jttm.astronauts)
		{
			ast[jttm.findSet(n).val]++;
		}
		
		long combinations = 0;
		// Compute the final answer - the number of combinations
		
		//	Answer = (axb) + (axc) + (bxc) = (axb) + (a+b)xc
		int prev = 0;
		for(int i = 0; i < N; i++)
		{
			combinations += ast[i] * prev;
			prev += ast[i];
		}
	  
		System.out.println(combinations);
    }
}

 
