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
	

	private void issue(instruction i) {
		// TODO Auto-generated method stub
		
	}


	private void writeres(instruction instruction)
	{
		//instruction will have have the optyp (mul,add,load...) as op r1,r2,r3 as r1,r2,r3 and issue,exectue writeresult attrbutes
		// exectute will be array of two depicting start and end cycles 
		//your job  is to check wether it will write its result now or no based on comparsion with the end time to the current 
		//cycle and update the chache and stations accordingly
                                                  

				
				
				
    }
	
	
	private void execute(instruction instruction) {
	    optype Type = instruction.type;
	  
	    
	    switch (Type) {
	        case adds  :
	            executeAdd(instruction);
	            break;
	        case subs  :
	            executeAdd(instruction);
	            break;
	        case muls:
	            executeMultiply(instruction);
	            break;
	        case divs:
	            executeMultiply(instruction);
	            break;
	        case lw:
	            executeLoad(instruction);
	            break;
	        case sw:
	            executeStore(instruction);
	            break;
	       
	        // Other operation cases
	        default:
	            // Handle unsupported operations or errors
	            break;
	    }
	}

	private void executeStore(instruction instruction) {
		   IntRegister r2 = null;
		    for( IntRegister r :IntRegisterfile) {
		    	if(r.name==instruction.destination) {
		    		r2=r;
		    	}
		    }
		    
		    int issueCycle = instruction.issue;
		    int[] executeCycles = instruction.exec;

		    stations loadstation = null ; 
		    for(stations s :Loadstations) {
		    	if(!s.busy) {
		    		loadstation=s;
		    		break;
		    	}
		    }
		   // MultiplyFunctionalUnit mulUnit = getAvailableMultiplyUnit();

		   
		        if (loadstation!=null) {
		      if(r2.qj=="") {
		       loadstation.instruction=instruction;
		      instruction.exec[0]=currentcycle;
		      instruction.exec[1]=currentcycle+instruction.exectime;
		
		      }
		
		
		         } else {
		            // Handle station or unit not available
		            // Possibly stall or implement a mechanism to handle this situation
		        }

		
	}


	private void executeAdd(instruction instruction) {
	   
	    IntRegister r2 = null;
	    for( IntRegister r :IntRegisterfile) {
	    	if(r.name==instruction.source1) {
	    		r2=r;
	    	}
	    }
	    IntRegister r3=null;
	    for( IntRegister r :IntRegisterfile) {
	    	if(r.name==instruction.source1) {
	    		r3=r;
	    	}
	    }
	    int issueCycle = instruction.issue;
	    int[] executeCycles = instruction.exec;

	    stations addstation = null ; 
	    for(stations s :Addstations) {
	    	if(!s.busy) {
	    		addstation=s;
	    		break;
	    	}
	    }
	   // MultiplyFunctionalUnit mulUnit = getAvailableMultiplyUnit();

	   
	        if (addstation!=null) {
	        	 boolean readyToExecute = true;

		            if (r2.qj!="") {
		            
		                addstation.vj=r2.value;
		                addstation.Qj="";
		            } else {
		                addstation.Qj=r2.qj;
		                readyToExecute = false;
		            }

		            if (r2.qj!="") {
			            
		                addstation.vj=r2.value;
		                addstation.Qj="";
		            } else {
		                addstation.Qj=r2.qj;
		                readyToExecute = false;
		            }

		            if (readyToExecute) {
		                addstation.busy=true;
		             

		                executeCycles[0] = currentcycle;
		                executeCycles[1] = currentcycle +instruction.exectime;


		                instruction.exec=executeCycles;
		               
		            }
   
	         
	
	
	
	
	         } else {
	            // Handle station or unit not available
	            // Possibly stall or implement a mechanism to handle this situation
	        }
	   
	}


	private void executeMultiply(instruction instruction) {
	  String r1 = instruction.destination;
	    IntRegister r2 = null;
	    for( IntRegister r :IntRegisterfile) {
	    	if(r.name==instruction.source1) {
	    		r2=r;
	    	}
	    }
	    IntRegister r3=null;
	    for( IntRegister r :IntRegisterfile) {
	    	if(r.name==instruction.source1) {
	    		r3=r;
	    	}
	    }
	    int issueCycle = instruction.issue;
	    int[] executeCycles = instruction.exec;

	    stations mulStation = null ; 
	    for(stations s :Mulstations) {
	    	if(!s.busy) {
	    		mulStation=s;
	    		break;
	    	}
	    }
	   // MultiplyFunctionalUnit mulUnit = getAvailableMultiplyUnit();

	   
	        if (mulStation!=null) {
	            boolean readyToExecute = true;

	            if (r2.qj!="") {
	            
	                mulStation.vj=r2.value;
	                mulStation.Qj="";
	            } else {
	                mulStation.Qj=r2.qj;
	                readyToExecute = false;
	            }

	            if (r2.qj!="") {
		            
	                mulStation.vj=r2.value;
	                mulStation.Qj="";
	            } else {
	                mulStation.Qj=r2.qj;
	                readyToExecute = false;
	            }

	            if (readyToExecute) {
	                mulStation.busy=true;
	             

	                executeCycles[0] = currentcycle;
	                executeCycles[1] = currentcycle +instruction.exectime;


	                instruction.exec=executeCycles;
	               
	            }
	        } else {
	            // Handle resource unavailability scenarios
	            // Implement mechanisms to handle resource conflicts or stalls
	        }
	   
	}


	private void executeLoad(instruction instruction) {
		  
	    IntRegister r2 = null;
	    for( IntRegister r :IntRegisterfile) {
	    	if(r.name==instruction.destination) {
	    		r2=r;
	    	}
	    }
	    
	    int issueCycle = instruction.issue;
	    int[] executeCycles = instruction.exec;

	    stations loadstation = null ; 
	    for(stations s :Loadstations) {
	    	if(!s.busy) {
	    		loadstation=s;
	    		break;
	    	}
	    }
	   // MultiplyFunctionalUnit mulUnit = getAvailableMultiplyUnit();

	   
	        if (loadstation!=null) {
	       loadstation.busy=true;
	       loadstation.instruction=instruction;
	      instruction.exec[0]=currentcycle;
	      instruction.exec[1]=currentcycle+instruction.exectime;
	
	
	
	
	         } else {
	            // Handle station or unit not available
	            // Possibly stall or implement a mechanism to handle this situation
	        }
	}


	/*private void executeBNEZ(instruction instruction) {
	    int r2 = instruction.getOperand2();
	    int issueCycle = instruction.getIssueCycle();
	    int[] executeCycles = instruction.getExecute();

	    BNEZReservationStation bnezStation = getAvailableBNEZStation();
	    BNEZFunctionalUnit bnezUnit = getAvailableBNEZUnit();

	    if (bnezStation != null && bnezUnit != null) {
	        if (!bnezStation.isBusy() && bnezUnit.isFree()) {
	            boolean readyToExecute = true;

	            if (isRegisterAvailable(r2)) {
	                int value = getValueFromRegister(r2);
	                bnezStation.setResult(value == 0 ? 0 : 1); // Set result to 0 or 1 based on r2 value
	                bnezStation.setQj(0);
	            } else {
	                bnezStation.setQj(getWaitingStationForRegister(r2));
	                readyToExecute = false;
	            }

	            if (readyToExecute) {
	                bnezStation.setBusy(true);

	                int latencyForBNEZ = getLatencyForBNEZ();
	                executeCycles[0] = issueCycle;
	                executeCycles[1] = issueCycle + latencyForBNEZ;

	                bnezUnit.setBusy(true);
	                bnezUnit.setRemainingCycles(latencyForBNEZ);

	                if (bnezStation.getResult() == 1) {
	                    int targetAddress = getValueFromRegister(r2); // Assuming r2 holds the target address
	                    setProgramCounter(targetAddress); // Set PC to the value in r2
	                }

	                instruction.setExecute(executeCycles);
	            }
	        } else {
	            // Handle resource unavailability scenarios
	            // Implement mechanisms to handle resource conflicts or stalls
	        }
	    } else {
	        // Handle no available station or unit
	        // Implement mechanisms to handle resource unavailability scenarios
	    }
	}
	
	
	*/
	
	
	
	
	
	

}
