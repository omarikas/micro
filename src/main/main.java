package main;

import java.util.Vector;

public class main {
	
	Vector<stations> Addstations;
    Vector<stations> Loadstations;
	Vector<stations> Mulstations;
	Vector<Integer> Cache;
	Vector<IntRegister> IntRegisterfile;
	Vector<FloatRegister> FloatRegisterfile;
	Vector<instruction> instructions;
	int currentcycle;
	public void next()
	{
		
		for(instruction i :instructions)
		{ 
			if(i.issue==0) 
			{   
				issue(i);
				if(i.issue!=0)
				{
					break;
					
				}
			}
			
			
		}
		for(instruction i :instructions)
		{ 
			if(i.issue!=0) 
			{   
				if(i.exec[0]==0)
				{ 
					execute(i);
					
					if(i.exec[0]!=0)
					{ 
						break;
					}
					
				}
				
			}
			
			
		}

		for(instruction i :instructions)
		{ 
			if(i.issue!=0) 
			{   
				if(i.exec[0]!=0)
				{ 
					
					
					if(i.writeres==0)
					{ 
						writeres(i);

						if(i.writeres!=0)
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
		//htbos lw el insstruction de el issue bta3ha kan kan abl el cycle de (insturction.issue<currentcycle)
		//lw ah htshof hya mhtaga eh fl source1 we el source 2 we shof lw dool fl cache msh mhtagen haga
		//lw msh mhtagen htmla el execution bl current cycle we el current cycle +instruction .exectime


		
		
		
	}
	private void issue(instruction instruction)
	{
		//switch 3al optyp we shof anhy vector of stations htbos 3leh we shof lw fe mkan fl station de
		//be enk tdwr fl busy attribute lw fe mkan amlha bl intstruction bta3k we set el issue bl current cycle


				
				
				
    }
	private void writeres(instruction instruction)
	{

       
       int end =instruction.exec[2]
	   if(currentcycle >= end+1){
		 if(optype.equals(subs) || optype.equals(adds) || optype.equals(addi) || optype.equals(subi) ){
			for(stations i :Addstations){
				if(instruction.equals(station.instruction)){
					station.busy=false
				}
			}
		}
			if(optype.equals(mulvs) || optype.equals(divs) || optype.equals(addi) || optype.equals(subi) ){
				for(stations i :Addstations){
					if(instruction.equals(station.instruction)){
						station.busy=false
					}
				}
				
		 }
		 if(optype.equals(lw) || optype.equals(sw)  ){
			for(stations i :Addstations){
				if(instruction.equals(station.instruction)){
					station.busy=false
				}
			}
			
		  

	
	   }
	   int destination=instruction.destination;
	   String source1= instruction.source1;
	   String source2= instruction.source2;
	   int imm= instruction.immediate;
		//instruction will have have the optyp (mul,add,load...) as op r1,r2,r3 as r1,r2,r3 and issue,exectue writeresult attrbutes
		// exectute will be array of two depicting start and end cycles 
		//your job  is to check wether it will write its result now or no based on comparsion with the end time to the current 
		//cycle and update the chache and stations accordingly
        // if lw ana equal to subs adds addi subi haloop on addstations le7ad ma ala2y station el instruction ely gowaha zai el instruction ely m3aky
		
   //if instrcution.equals(station.instruction) 
   //station.busy=false
	//h3ml kda lel multiply w kman lel load station
	//h3ml variable esmo inrtuction.destination w yeb2a gowa loop el kebera
	// String source1= instrucrtion.source1
    // h3ml nafs el haga le source 2 w el immediate			
				
    }

	
	
	
}
	
	

}
