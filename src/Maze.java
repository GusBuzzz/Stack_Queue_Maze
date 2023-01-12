
public class Maze {

	// Attributes *****************************************************************
	private char[][] board;
	private char[][] playboard;

    // Constructors ****************************************************************
	public Maze() {}
	
	public Maze(char[][] maze) {
		board = maze;
		/*board = new char[maze.length][maze[0].length];
		for (int i=0; i<maze.length; i++) {
			for (int j=0; j<maze[0].length; j++)
				board[i][j] = maze[i][j];
		}*/
	}

    // Getters and Setters *********************************************************
	/**
	 * @return the board
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	// Other methods, specific to Mazes *******************************************
	// print board, inDepthFirst, byLevel, QSCompetition
	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j] + ", ");
			System.out.println();
		}
	}
	
	/** 
     * TODO 2.1: Complete below the body of the method inDepthFirst
     * This method navigates through the maze in a depth-first manner.
     * As it goes, it collects rewards and keeps track of the number of visited cells.
     * It returns an 1D array of 2 int elements, representing: the number of visited cells 
     * and the total reward at the time when the exit is reached.
     */
	public int[] inDepthFirst() {
		int[] scores = new int[2]; // will hold the number of points and the number of steps
		char[][] currentboard = this.board;
		int[] currentlocation;
		int numSteps = 0; // keeps track of the number of visited cells
		int Spoints = 0; // keeps track of the number of points collected throughout the traversal
		
		StackA<MazeStatus> S = new StackA<MazeStatus>(this.board.length*this.board[0].length); 
		MazeStatus MS = new MazeStatus(this,0,0); // current status as you start the navigation in the top left corner
		S.push(MS); // you initialize the stack
		
		while (!S.isEmpty()) {
			// We access and remove the maze at the top of our stack
			// ADD CODE HERE
			MazeStatus curr = S.pop();
			/*
			Perform a stack operation that will give you what's in the stack.

			*/

            // We update our number of steps
			// ADD CODE HERE
			numSteps++;
				//update numSteps by how many steps you took 
				//(is it ever more than one?)
			/*

			You use that object's getLocation method to get your current location in the maze
			And then you use that location to access that spot on the maze.
			Check to see what characters (if any) are on this location in the maze.
			A ‘P’ cell yields 15 pts; 

			if the character at your current location is P:
					then you increment Spoints by 15.

			A ‘p’ cell yields 10 pts; 

			if the character at your current location is p:
					then you increment Spoints by 10 points.

			A ‘s’ cell yields 5 pts; 

			if the character at your current location is s:
					then you increment Spoints by 5 points.

			An 'E' cell yields 50 pts;

			if the character at your current location is p:
					then you increment Spoints by 10 points.
					you want to exit the loop somehow.


			You are checking the location of whatever you received
			from your stack at the board.

			*/
            
			// We check if we are getting any rewards and update the Spoints
            // ADD CODE HERE
			currentlocation = curr.getLocation();

            if(board[curr.getLocation()[0]][curr.getLocation()[1]] == 'P'){
				Spoints += 15;
			}
			if(board[curr.getLocation()[0]][curr.getLocation()[1]] == 'p'){
				Spoints += 10;
			}
			if(board[curr.getLocation()[0]][curr.getLocation()[1]] == 's'){
				Spoints += 5;
			}
			if(board[curr.getLocation()[0]][curr.getLocation()[1]] == 'E'){
				Spoints += 50;
				break;
			}
            // We update the cell as visited
			// ADD CODE HERE
			currentboard[currentlocation[0]][currentlocation[1]] = 'X';
			/*

			You want to update the location of your current maze status
			object from the stack to visited. 'X' represents unvisitable
			so that's a good option.

			*/
			// We identify the next immediate steps (up / left / down / right?)
            // and push the corresponding maze status in the stack
			// ADD CODE HERE
			int[] right = {currentlocation[0] + 1, currentlocation[1]};
			int[] up = {currentlocation[0], currentlocation[1] - 1};
			int[] down = {currentlocation[0], currentlocation[1] + 1};
			int[] left = {currentlocation[0] - 1, currentlocation[1]};

			//right
			if (right[0] >= 0 && right[1] >= 0 && right[0] < board.length && right[1] < board[0].length) {
				if (board[right[0]][right[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(right[0], right[1]);
					S.push(newStatus);
				}
			}
			//up
			if (up[0] >= 0 && up[1] >= 0 && up[0] < board.length && up[1] < board[0].length) {
				if (board[up[0]][up[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(up[0], up[1]);
					S.push(newStatus);
				}
			}
			//down
			if (down[0] >= 0 && down[1] >= 0 && down[0] < board.length && down[1] < board[0].length) {
				if (board[down[0]][down[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(down[0], down[1]);
					S.push(newStatus);
				}
			}
			//left
			if (left[0] >= 0 && left[1] >= 0 && left[0] < board.length && left[1] < board[0].length) {
				if (board[left[0]][left[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(left[0], left[1]);
					S.push(newStatus);
				}
			}
			/*

			If left is in bounds:
				make a maze status object with this location and perform a
				stack operation such that that maze status object will be
				in the stack.

			If up is in bounds:
				put it somehow in the stack as a maze status object.


			*/


		}	
		scores[0] = Spoints;
		scores[1] = numSteps;
		return scores;
	}

	/** 
     * TODO 2.2: Complete below the body of the method byLevel
     * This method navigates through the maze in a level-order manner.
     * As it goes, it collects rewards and keeps track of the number of visited cells.
     * It returns an 1D array of 2 int elements, representing: the number of visited cells 
     * and the total reward at the time when the exit is reached.
     */
	public int[] byLevel() {
		int[] scores = new int[2]; // will hold the number of points and the number of steps
		char[][] currentboard = this.board;
		int[] currentlocation;
		int numSteps = 0; // keeps track of the number of visited cells
		int Qpoints = 0; // keeps track of the number of points collected throughout the traversal
		
		QueueL<MazeStatus> Q = new QueueL<MazeStatus>();
		MazeStatus MS = new MazeStatus(this,0,0); // current status as you start the navigation in the top left corner
		Q.enqueue(MS);  // you initialize the queue
		
		while (!Q.isEmpty()) {
			// We access and remove the maze at the head of our queue
            // ADD CODE HERE
			MazeStatus curr = Q.dequeue().getData();
            // We update our number of steps
			// ADD CODE HERE
			if(currentboard[curr.getLocation()[0]][curr.getLocation()[1]] == 'X'){
				continue;
			}
			numSteps++;
			// We check if we are getting any rewards and update the Qpoints
            // ADD CODE HERE

			currentlocation = curr.getLocation();

			if(board[curr.getLocation()[0]][curr.getLocation()[1]] == 'P'){
				Qpoints += 15;
			}
			if(board[curr.getLocation()[0]][curr.getLocation()[1]] == 'p'){
				Qpoints += 10;
			}
			if(board[curr.getLocation()[0]][curr.getLocation()[1]] == 's'){
				Qpoints += 5;
			}
			if(board[curr.getLocation()[0]][curr.getLocation()[1]] == 'E'){
				Qpoints += 50;
				break;
			}
            // We update the cell as visited
			// ADD CODE HERE
			currentboard[currentlocation[0]][currentlocation[1]] = 'X';
            // We identify the next immediate steps (up / left / down / right?)
            // and enqueue the corresponding maze status in the queue
			// ADD CODE HERE
			int[] right = {currentlocation[0] + 1, currentlocation[1]};
			int[] up = {currentlocation[0], currentlocation[1] - 1};
			int[] down = {currentlocation[0], currentlocation[1] + 1};
			int[] left = {currentlocation[0] - 1, currentlocation[1]};

			//right
			if (right[0] >= 0 && right[1] >= 0 && right[0] < board.length && right[1] < board[0].length) {
				if (board[right[0]][right[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(right[0], right[1]);
					Q.enqueue(newStatus);
				}
			}
			//up
			if (up[0] >= 0 && up[1] >= 0 && up[0] < board.length && up[1] < board[0].length) {
				if (board[up[0]][up[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(up[0], up[1]);
					Q.enqueue(newStatus);
				}
			}
			//down
			if (down[0] >= 0 && down[1] >= 0 && down[0] < board.length && down[1] < board[0].length) {
				if (board[down[0]][down[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(down[0], down[1]);
					Q.enqueue(newStatus);
				}
			}
			//left
			if (left[0] >= 0 && left[1] >= 0 && left[0] < board.length && left[1] < board[0].length) {
				if (board[left[0]][left[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(left[0], left[1]);
					Q.enqueue(newStatus);
				}
			}
		}	
		scores[0] = Qpoints;
		scores[1] = numSteps;
		return scores;
	}
	
	/** 
     * TODO 3.1: Complete below the body of the method QScompetition
     * This method runs the previous two methods step by step (as if in parallel)
     * It stops whenever one of the two processes (stack-based or queue-based) reaches the exit.
     * At this point, the process that collected the most reward points wins.
     */
	public void QScompetition() {
        // We start by initializing the two mazes into two similar boards at different addresses
        char[][] Sboard = new char[board.length][board[0].length];
		char[][] Qboard = new char[board.length][board[0].length];
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				Sboard[i][j] = board[i][j];
				Qboard[i][j] = board[i][j];
			}
		}
	
		char[][] Scurrentboard = new char[board.length][board[0].length];
		char[][] Qcurrentboard = new char[board.length][board[0].length];
		int[] Scurrentlocation; 
		int[] Qcurrentlocation; 
		int Spoints = 0;  // keeps track of the number of points collected throughout the stack-based traversal
		int Qpoints = 0;  // keeps track of the number of points collected throughout the queue-based traversal
		
		// Initialize the Q for the traversal
		QueueL<MazeStatus> Q = new QueueL<MazeStatus>();
		Maze MQ = new Maze(Qboard);
		MazeStatus QMS = new MazeStatus(MQ,0,0);
		Q.enqueue(QMS);
		
		// Initialize the S for the traversal
		StackA<MazeStatus> S = new StackA<MazeStatus>(this.board.length*this.board[0].length);
		Maze MS = new Maze(Sboard);
		MazeStatus SMS = new MazeStatus(MS,0,0);
		S.push(SMS);
		
		while (!Q.isEmpty() && !S.isEmpty()) {
			// We access and remove the maze at the head of our queue
            // ADD CODE HERE
			MazeStatus Qcurr = Q.dequeue().getData();
            // We access and remove the maze at the top of our stack
			// ADD CODE HERE
			MazeStatus Scurr = S.pop();
			// We check if we are getting any rewards and update the Qpoints
            // ADD CODE HERE
			Qcurrentlocation = Qcurr.getLocation();

			while(Qcurrentboard[Qcurrentlocation[0]][Qcurrentlocation[1]] == 'X'){
				Qcurr = Q.dequeue().getData();
				Qcurrentlocation = Qcurr.getLocation();
			}

			if(board[Qcurr.getLocation()[0]][Qcurr.getLocation()[1]] == 'P'){
				Qpoints += 15;
			}
			if(board[Qcurr.getLocation()[0]][Qcurr.getLocation()[1]] == 'p'){
				Qpoints += 10;
			}
			if(board[Qcurr.getLocation()[0]][Qcurr.getLocation()[1]] == 's'){
				Qpoints += 5;
			}
			if(board[Qcurr.getLocation()[0]][Qcurr.getLocation()[1]] == 'E'){
				Qpoints += 50;
			}
			// We check if we are getting any rewards and update the Spoints
            // ADD CODE HERE
			Scurrentlocation = Scurr.getLocation();

			if(board[Scurr.getLocation()[0]][Scurr.getLocation()[1]] == 'P'){
				Spoints += 15;
			}
			if(board[Scurr.getLocation()[0]][Scurr.getLocation()[1]] == 'p'){
				Spoints += 10;
			}
			if(board[Scurr.getLocation()[0]][Scurr.getLocation()[1]] == 's'){
				Spoints += 5;
			}
			if(board[Scurr.getLocation()[0]][Scurr.getLocation()[1]] == 'E'){
				Spoints += 50;
			}
            // We update the cell as visited in the Qcurrentboard
			// ADD CODE HERE
			Qcurrentboard[Qcurrentlocation[0]][Qcurrentlocation[1]] = 'X';
            // We update the cell as visited in the Scurrentboard
			// ADD CODE HERE
			Scurrentboard[Scurrentlocation[0]][Scurrentlocation[1]] = 'X';
            // If one process has reached the end, then we check which one has the most point
            // and we declare the winner and exit
            // ADD CODE HERE
			if(board[Scurr.getLocation()[0]][Scurr.getLocation()[1]] == 'E'
					|| board[Qcurr.getLocation()[0]][Qcurr.getLocation()[1]] == 'E'){
				if(Spoints > Qpoints){
					System.out.print("Stacks win!!!");
				}
				else if (Spoints < Qpoints) {
					System.out.print("Queues win!!!");
				}
				else {
					System.out.print("Tie!!!");
				}
				break;
			}
            // If none has reached the exit yet:
            // We identify the next immediate steps in the Qcurrentboard (up / left / down / right?)
            // and enqueue the corresponding maze status in the queue
			// ADD CODE HERE
			int[] Qdown = {Qcurrentlocation[0] + 1, Qcurrentlocation[1]};
			int[] Qleft = {Qcurrentlocation[0],Qcurrentlocation[1] - 1};
			int[] Qright = {Qcurrentlocation[0], Qcurrentlocation[1] + 1};
			int[] Qup = {Qcurrentlocation[0] - 1, Qcurrentlocation[1]};

			//right
			if (Qright[0] >= 0 && Qright[1] >= 0 && Qright[0] < board.length && Qright[1] < board[0].length) {
				if (board[Qright[0]][Qright[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(Qright[0], Qright[1]);
					Q.enqueue(newStatus);
				}
			}
			//up
			if (Qup[0] >= 0 && Qup[1] >= 0 && Qup[0] < board.length && Qup[1] < board[0].length) {
				if (board[Qup[0]][Qup[1]] != 'X') {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(Qup[0], Qup[1]);
					Q.enqueue(newStatus);
				}
			}
			//down
			if (Qdown[0] >= 0 && Qdown[1] >= 0 && Qdown[0] < board.length && Qdown[1] < board[0].length) {
				if (board[Qdown[0]][Qdown[1]] != 'X' ) {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(Qdown[0], Qdown[1]);
					Q.enqueue(newStatus);
				}
			}
			//left
			if (Qleft[0] >= 0 && Qleft[1] >= 0 && Qleft[0] < board.length && Qleft[1] < board[0].length) {
				if (board[Qleft[0]][Qleft[1]] != 'X' ) {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(Qleft[0], Qleft[1]);
					Q.enqueue(newStatus);
				}
			}
            // We identify the next immediate steps in the Scurrentboard (up / left / down / right?)
            // and push the corresponding maze status in the stack
			// ADD CODE HERE
			int[] Sdown = {Scurrentlocation[0] + 1, Scurrentlocation[1]};
			int[] Sleft = {Scurrentlocation[0], Scurrentlocation[1] - 1};
			int[] Sright = {Scurrentlocation[0], Scurrentlocation[1] + 1};
			int[] Sup = {Scurrentlocation[0] - 1, Scurrentlocation[1]};

			//right
			if (Sright[0] >= 0 && Sright[1] >= 0 && Sright[0] < board.length && Sright[1] < board[0].length) {
				if (board[Sright[0]][Sright[1]] != 'X' ) {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(Sright[0], Sright[1]);
					S.push(newStatus);
				}
			}
			//up
			if (Sup[0] >= 0 && Sup[1] >= 0 && Sup[0] < board.length && Sup[1] < board[0].length) {
				if (board[Sup[0]][Sup[1]] != 'X' ) {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(Sup[0], Sup[1]);
					S.push(newStatus);
				}
			}
			//down
			if (Sdown[0] >= 0 && Sdown[1] >= 0 && Sdown[0] < board.length && Sdown[1] < board[0].length) {
				if (board[Sdown[0]][Sdown[1]] != 'X' ) {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(Sdown[0], Sdown[1]);
					S.push(newStatus);
				}
			}
			//left
			if (Sleft[0] >= 0 && Sleft[1] >= 0 && Sleft[0] < board.length && Sleft[1] < board[0].length) {
				if (board[Sleft[0]][Sleft[1]] != 'X' ) {
					MazeStatus newStatus = new MazeStatus(this,0,0);
					newStatus.changeLocation(Sleft[0], Sleft[1]);
					S.push(newStatus);
				}
			}
 		}	
	}
	
}
