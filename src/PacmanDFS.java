import java.util.*;

public class PacmanDFS {
	//	PacmanDFS objects represent nodes
	
	private boolean isVisited, isAdded;	//	isAdded is true if it is in the stack
	private char c;
	private int row, col;
	private PacmanDFS parent;
	
	public PacmanDFS(char c, int row, int col) {
		isVisited = false;
		this.c = c;
		this.row = row;
		this.col = col;
		parent = null;
		isAdded = false;
	}
	
	public boolean isValid()
	{
		if(c == '%')
			return false;
		else
			return true;
	}
	
	public boolean isVisited()
	{
		return isVisited;
	}
	
	public boolean visit()	//	returns true if it finds food
	{
		isVisited = true;
		if(c == '.')
			return true;
		else return false;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}

	public PacmanDFS getParent() {
		return parent;
	}

	public void setParent(PacmanDFS parent) {
		this.parent = parent;
	}
	
	public void add() {
		isAdded = true;
	}
	
	public boolean isAdded() {
		return isAdded;
	}

	public static void main(String[] args) {
		
        Scanner scan = new Scanner(System.in);
        int px = scan.nextInt(); //  pacman x
        int py = scan.nextInt(); //  pacman y
        int fx = scan.nextInt(); //  food x
        int fy = scan.nextInt(); //  food y
        int row = scan.nextInt(); //  #rows
        int col = scan.nextInt(); //  #columns
        
        PacmanDFS[][] board = new PacmanDFS[row][col];
        
        for(int i = 0; i < row; i++) 
        {
        	String line = scan.next();
        	for(int j = 0; j < line.length();j++) 
        	{
        		board[i][j] = new PacmanDFS(line.charAt(j), i, j);
        	}
        }
        scan.close();
        
        dfs(row, col, px, py, fx, fy, board);
        
    }
	
	public static void dfs(int r, int c, int pacman_r, int pacman_c, int food_r, int food_c, PacmanDFS[][] grid)
	{
		
		Stack<PacmanDFS> st = new Stack<PacmanDFS>();
		
		PacmanDFS pushNode = grid[pacman_r][pacman_c];	//	start from pacman
		pushNode.visit();
		int curx = pacman_r, cury = pacman_c;
		int explored = 1;	//	explored node count
		String output = pacman_r + " " + pacman_c + "\n";	//	visited node coords
        while(!pushNode.visit())
        {
        	pushNode = grid[curx - 1][cury];	//	up
        	if(pushNode.isValid() && !pushNode.isAdded())
        	{
        		st.push(pushNode);
        		pushNode.add();
        		pushNode.setParent(grid[curx][cury]);
        	}
        		
        	
        	pushNode = grid[curx][cury - 1];	//	left
        	if(pushNode.isValid() && !pushNode.isAdded())
        	{
        		st.push(pushNode);
        		pushNode.add();
        		pushNode.setParent(grid[curx][cury]);
        	}
        	
        	pushNode = grid[curx][cury + 1];	//	right
        	if(pushNode.isValid() && !pushNode.isAdded())
        	{
        		st.push(pushNode);
        		pushNode.add();
        		pushNode.setParent(grid[curx][cury]);
        	}
        	
        	pushNode = grid[curx + 1][cury];	//	down
        	if(pushNode.isValid() && !pushNode.isAdded())
        	{
        		st.push(pushNode);
        		pushNode.add();
        		pushNode.setParent(grid[curx][cury]);
        	}

        	pushNode = st.pop();
        	if(pushNode == null)
        	{
        		System.out.println("No path found");
        		System.exit(0);
        	}
        		
        	while(pushNode.isVisited())
        		pushNode = st.pop();
        	explored++;
        	curx = pushNode.getRow();
        	cury = pushNode.getCol();
        	output += curx + " " + cury + "\n";
        	
        }
        output = explored + "\n" + output;
        System.out.print(output);
        
        String route = "";	//	route from pacman to food
        int path = 0;	//	path length from pacman to food
        while(!pushNode.equals(grid[pacman_r][pacman_c]))
        {
        	route = pushNode.getRow() + " " + pushNode.getCol() + "\n" + route;
        	pushNode = pushNode.getParent();
        	path++;
        }
        
        route = pushNode.getRow() + " " + pushNode.getCol() + "\n" + route;
        System.out.println(path);
        System.out.println(route);
	}
	
	/*	Sample input:
	 * 	3 9  
		5 1  
		7 20  
		%%%%%%%%%%%%%%%%%%%%
		%--------------%---%  
		%-%%-%%-%%-%%-%%-%-%  
		%--------P-------%-%  
		%%%%%%%%%%%%%%%%%%-%  
		%.-----------------%  
		%%%%%%%%%%%%%%%%%%%%  
	 */
}
