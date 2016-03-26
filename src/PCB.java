//	http://www.java2s.com/Tutorial/Java/0140__Collections/LinkedListClass.htm

import java.util.Random ;

public class PCB implements Comparable<PCB>
{
	
	private int	PCB_ID ;
	
	private Integer[] alloc__A	= new Integer[3];
	private Integer[] max__A	= new Integer[3];
	private Integer[] need__A	= new Integer[3];
	
	private static int	PCB__K;
	private Random random__X ;
		
	// constructor methods
	// default constructor
		
	public PCB (Integer[] IImax)
	{
		Random random__X	= new Random();

		PCB__K		+= 1 ;	//=====>	Increment the static variable for Process ID
		PCB_ID		= PCB__K ; 
		
		for (int ii = 0; ii < 3; ii++)	// iterate for each resource type A, B, C
		{
			int pctOfMax	= (int) (IImax[ii] *0.75) ; 	// set to 0.75 of the max
			max__A[ii]	= (random__X.nextInt(pctOfMax)) ;	// random number from 0 to pctOfMax
			alloc__A[ii]	= 0 ;
			need__A[ii]	= max__A[ii] ; 
		}
	}	
	
	public String showPCB()
	{
		return 
			 "ID: "	+ Integer.toString(PCB_ID)
			+ "\talloc:"	+ Integer.toString(alloc__A[0])
					+ ","	+ Integer.toString(alloc__A[1])
					+ ","	+ Integer.toString(alloc__A[2])
			+ "\tmax:"	+ Integer.toString(max__A[0])
					+ ","	+ Integer.toString(max__A[1])
					+ ","	+ Integer.toString(max__A[2])
			+ "\tneed:"	+ Integer.toString(need__A[0])
					+ ","	+ Integer.toString(need__A[1])
					+ ","	+ Integer.toString(need__A[2])
			;
	}

//	public int compareTo (PCB pcb0) 
//	{
//		int mem0	= pcb0.get_memBase();
//		return this.memBase - mem0 ;
//	}	
	
	//	set methods
	
	public Integer[] get_max()
	{
		return max__A ;
	}
	
	public Integer[] get_alloc()
	{
		return alloc__A ;
	}
	
	public void	set_alloc(Integer[] iiA)
	{
		for	(int ii = 0; ii < 3; ii++)
		{
			alloc__A[ii] = iiA[ii];
			need__A[ii]	= max__A[ii] - alloc__A[ii] ;
		}
	}
	
	public int get_ID()
	{
		return PCB_ID;
	}
	
	// Set methods , void returns no value
	
	public void set_PCB_ID (int id0)
	{
		PCB_ID	= id0 ;
	}
	
}
