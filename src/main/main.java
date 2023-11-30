package main;

import java.util.Vector;

public class main {
	
	Vector<stations> Addstations;
    Vector<stations> Loadstations;
	Vector<stations> Mulstations;
	Vector<cache> Cache;
	Vector<instruction> instructions;
	int pc;
	int currentcycle;
	public void next()
	{
		
		for(instruction i :instructions)
		{ 
			if(instruction.issue==0) 
			{   
				issue(i);
				if(instruction.issue!=0)
				{
					break;
					
				}
			}
			
			
		}
		for(instruction i :instructions)
		{ 
			if(instruction.issue!=0) 
			{   
				if(instruction.execute[0]==0)
				{ 
					execute(i);
					
					if(instruction.execute[0]!=0)
					{ 
						break;
					}
					
				}
				
			}
			
			
		}

		for(instruction i :instructions)
		{ 
			if(instruction.issue!=0) 
			{   
				if(instruction.execute[0]!=0)
				{ 
					
					
					if(instruction.writeres==0)
					{ 
						writeres(i);

						if(instruction.writeres!=0)
						{ 
							break;
						}
					}
					
				}
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	currentcycle++;
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	private void execute(instruction instruction)
	{
//instruction will have have the optyp (mul,add,load...) as op r1,r2,r3 as r1,r2,r3 and issue,exectue writeresult attrbutes
// exectute will be array of two depicting start and end cycles your job is to check wether 
//it should execute the op or no and when it will finish using the stations and cache which will have all attributes of the normal table
//in addition to exectime attribute		(if bnez is true set pc to to r2)


		
		
		
	}
	private void issue(instruction instruction)
	{
		//instruction will have have the optyp (// enum muls,adds,subs,divs,bnez,lw,sw) as op r1,r2,r3 as r1,r2,r3 and issue,exectue writeresult attrbutes
		// exectute will be array of two depicting start and end cycles 
		//your job is to use the station to check wh=ether there is an availabe statiob bassed on the op and set the issue
		//attribute  busy to current cycle if it should be should issued
		//


				
				
				
    }
	private void writeres(instruction instruction)
	{
		//instruction will have have the optyp (mul,add,load...) as op r1,r2,r3 as r1,r2,r3 and issue,exectue writeresult attrbutes
		// exectute will be array of two depicting start and end cycles 
		//your job  is to check wether it will write its result now or no based on comparsion with the end time to the current 
		//cycle and update the chache and stations accordingly


				
				
				
    }
	
	
	
	
	
	
	
	
	
	
	
	

}
