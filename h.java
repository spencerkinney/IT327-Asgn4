/**
 * Spencer Kinney
 * slkinn1
 * Assignment 4
 * IT327 - Dr. Chung-Chih Li
 */
class h {
	/**
	 * Performs the main 'h' function for the SML algorithm
	 * Table being used as a record for variables which is stored as an array
	 * Each position represents the value of each variable in the format: [x, y, z, w]
	 * For activation records, usually I would use a stack, however it is not needed in this situation
	 * because there is no trace back or traversing needed through the records
	 * @param x
	 * @param y
	 * @param table
	 * @return
	 */
	public static int fun_h (int x, int y, int[] table) {
		table[0] = x;
		table[1] = y;
		table[2] = x+1;
		if (x==0) return fun_g(table[1], table);
		else return table[2] + fun_g(fun_h(table[0]-1, table[1], table), table);
	}
	
	/**
	 * Performs the 'g' function for the SML algorithm.
	 * @param w
	 * @param table
	 * @return
	 */
	public static int fun_g (int w, int[] table) {
		table[3] = w;
		table[2] = table[1] + 1;
		if (w==0) return table[0];
		else return table[2] + fun_f(w-1, table);
	}
	
	/**
	 * Performs the 'f' function for the SML algorithm.
	 * @param x
	 * @param table
	 * @return
	 */
	public static int fun_f (int x, int[] table) {
		table[0] = x;
		if (x==0) return 0;
		else return table[2] + x + fun_g(table[3] - 1, table);
	}
	
	public static void main(String[] args) {
		/* Accepts program arguments of length 2 */
		if(args.length != 2) {
			System.out.println("Usage: java h <integer> <integer>");
			System.exit(1);
		}
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int[] variableTable = new int[4];
		System.out.println( "h("+x+","+y+")="+ fun_h(x,y, variableTable) );
	}
}