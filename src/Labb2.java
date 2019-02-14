
	import java.io.*;
	public class Labb2 {
		
	        static String questionToUser = "You have the following options :\n"
			+ "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
			+ "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
			+ "List reduced content : type '1'\nList full content : type '2'\n"
			+ "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";
	    	
	        private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	        
	        public static String consoleInput() {
	        	
	        	String myString;
	        	
	        	try {
	        		/*
	    	    InputStreamReader myInputStreamReader = new InputStreamReader(System.in);
	   		
	    	    System.out.println(questionToUser);
	   			consoleReader = new BufferedReader(myInputStreamReader);
	   		
	   			myString = consoleReader.readLine();*/
	        		System.out.println(questionToUser);
	        		myString = consoleReader.readLine();
	        		
	   			}
	   			catch(IOException ierr1) { myString = "";}
	        	
	   			return myString;
	         }
	        
	        public static void main(String[] args) {
	        	
	        	int result;
	        	String[] inputSplit;
				String textFromFile;
				
				Dictionary theDic = new Dictionary();
	        	
	        	do{
	        		String input = consoleInput();
	        		if(input=="") {
	        			System.out.println("Something went wrong");
	        		}
	        		
        		try { result = Integer.valueOf(input);
        		
        			// switch ints
	        			switch(result)
	        			{
	        			case 1: Word.changeOutputFormat(0);
	        					System.out.println(theDic);
	        					break;
	        			case 2: Word.changeOutputFormat(1);
	        					System.out.println(theDic);
	        					break;
	        			case 3: theDic.removeDuplicates();
	        					break;
	        			case 4: theDic.sortDictionaryByCounts();
	        					break;
	        			case 5: System.out.println(theDic.countOccurences());
	        					break;
	        			}		
        			}
        		catch(NumberFormatException ierr) 
        			{
        				
        				inputSplit = input.split(" +");
        				if(inputSplit.length==2)
        				{
        					
        					if(inputSplit[0] == "load")
        					{ 

        						File fileName = new File(inputSplit[1] + ".txt");
        						
        						if(fileName.exists() == true) 
        						{System.out.println(fileName);}
        							String readText = new String();
        							try 
        							{
            							BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        							while((textFromFile = reader.readLine()) != null)
	        							{
	            								readText = readText + " " + textFromFile;
	            						}
	        							
            							reader.close();
            							theDic.addWords(readText);
        							}
        							catch(FileNotFoundException ierr2) {System.out.println("No fucking file");}
        							catch(IOException ierr3) {System.out.println("IO Exception");}
        							
        					}
        					
        					else if (inputSplit[0] == "save")
        					{
        						System.out.println("fu mf");

	        						File nameToSave = new File(inputSplit[1]);
	        						
	        						try 
	        						{
	        							BufferedWriter newFile = new BufferedWriter(new FileWriter(nameToSave));
	        							 
	        							newFile.write(theDic.toString());
	        							newFile.close();
	        							
	        						} catch(IOException ierr2) {System.out.println("IO Exception");}
	        				}
        				}
        				else 
        				{
        					System.out.println("load mf");
        					theDic.addWords(input);
        				}

        			}
	        		
	        	}
	        	while(consoleInput()!="end");	
	        	
	        }

	        
	}


