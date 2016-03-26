import java.util.LinkedList ;
import java.util.Random ;

public class DeadlockManager 
{	
	private static Integer[] instances__A	= 
		{10	,5	,7
		} ;
	private static Integer[] noNeed = 
		{0	,0	,0
		} ;
	
	public static void main(String args[]) 	
	{
		int QREADY__T = 10 ;	final int mem__T = 256;		
		Random random__X	= new Random();
		Integer[] iiMax ;
		Integer[] iiAlloc ;
		
		LinkedList<PCB> QReady	= new LinkedList<PCB>();	//#0010 Create List QReady
								
		PCB PCB_Ready	; 	//#0040 Create the field: PCB_Ready

		for (int ii = 0; ii < QREADY__T; ii++)
		{
			PCB pcb0 = new PCB(instances__A);		//#0050 create PCB
			iiMax	= pcb0.get_max() ;	//#0060 get the max for PCB
		
			QReady.add(pcb0) ;			//#0070 Add PCB object onto QReady 
		}
		
		for (PCB loopI : QReady)	// loop for each item in QReady
		{
			PCB pcb0 = QReady.get(random__X.nextInt(QReady.size())) ;
			Integer[] maxA	= pcb0.get_max() ;
			Integer[] allocA	= pcb0.get_alloc() ;
			
			boolean resource__F	= false;

			for (int ii = 0; ii < 3; ii++)	//#0100 assign resources to alloc
			{
				if (instances__A[ii] > 0)	//#0110 check that resources are available
				{
					if (allocA[ii] < maxA[ii])
					{
						allocA[ii]	= allocA[ii]	+ 1 ;	// add to alloc
						instances__A[ii] = instances__A[ii]	- 1 ; // decrement availability
						
						System.out.printf("#0180 alloc id: %d\tres: %d\t,%s\tleft: %d\n"
								,pcb0.get_ID()
								,ii
								,allocA[ii]
								,instances__A[ii]
								) ;
					}
					resource__F	= true;
				}
			}
			
			if (resource__F)
			{
				pcb0.set_alloc(allocA);
				System.out.printf("#0190 allocate\t%s\n"	,pcb0.showPCB()) ;
			}
			else
			{
				System.out.printf("#0191 no alloc\t%s\n"	,pcb0.showPCB()) ;
				break ;	
			}
		}
			
		for (PCB loopI : QReady)
			System.out.printf("%s\n"	,loopI.showPCB()) ;
		
			System.out.println("----------------------------------------------------");
		}
}
