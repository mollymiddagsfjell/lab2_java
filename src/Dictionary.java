//package default;

import java.util.ArrayList;

import java.io.*;

public class Dictionary {
	
	ArrayList<Word> theDictionary;
	FileWriter outputWriter;
	
	public Dictionary(){theDictionary = new ArrayList<Word>();}
	
	public Dictionary(String arg) 
	{
		theDictionary = new ArrayList<Word>();
		addWords(arg);
	}
	
	public void addWords(String arg) 
	{
		String[] splitWords = arg.split(" + ");
		for(int i = 0; i < splitWords.length; i++)
		{
			try
			{ Integer.valueOf(splitWords[i]);}
			catch(NumberFormatException ierr) {
				if(!splitWords[i].equals(""))
				{
					theDictionary.add(new Word(splitWords[i]));
				}
			}	
		}
	}
	
	public int numberOfWords(){return theDictionary.size();}
	
	public void removeDuplicates() 
	{
		for(int i = 0; i < theDictionary.size() - 1; i++)
		{
			for(int j = i + 1; j < theDictionary.size(); j++) 
			{
				if(theDictionary.get(i).getWord().equals(theDictionary.get(j).getWord()))
				{
					for(int m = 0; m < theDictionary.get(j).getCounts(); m++)
					{
						theDictionary.get(i).increaseCounts();
					}
					theDictionary.remove(j); 
					j--;
				}
			}
		}
	}
	
	public String countOccurences() {
        String returnString = new String();
        int[] counts;
        int max = 1;
        
        for (int j = 0; j < theDictionary.size(); j++) 
        {
            if (theDictionary.get(j).getCounts() > max) max = theDictionary.get(j).getCounts();
        }
       
        counts = new int[max+1];
        
        for (int j=0; j < max+1; j++) 
        {
        	counts[j]=0;
        }

        for (int j=0; j < theDictionary.size(); j++) 
        {
        	counts[theDictionary.get(j).getCounts()] = counts[theDictionary.get(j).getCounts()] + 1;
        }

        for (int j=0; j < counts.length; j++) 
        {
            if (counts[j]>0) returnString = returnString + "There are " + counts[j] + " that occured " + j + " times.\n";
        }

        return returnString;
    }

    public void sortDictionaryByCounts() {
        int activeSlot, theCounts;
        
        for (int j=0; j < theDictionary.size()-1; j++) 
        {
        	activeSlot = j; 
            theCounts = theDictionary.get(j).getCounts();
            
            for (int k=j+1; k < theDictionary.size(); k++) 
            {
                if (theDictionary.get(k).getCounts() > theCounts) 
                {
                	activeSlot = k; 
                    theCounts = theDictionary.get(k).getCounts();
                }
            }
            
            if (activeSlot != j) 
            {
                System.out.println("The " + j + " " + activeSlot);
                theDictionary.add(j,theDictionary.get(activeSlot));
                theDictionary.remove(activeSlot+1);
            }
        }
    }

    public void setFileName(String theName) {
        try {outputWriter = new FileWriter(new File(theName));}
        catch (IOException ierr) {}
    }

    public void saveFile() {
        try {outputWriter.write(toString());}
        catch (IOException ierr) {}
    }

    public String toString() {
        int i = 0;
        for (int j = 0; j < theDictionary.size(); j++) i = i + theDictionary.get(j).getCounts();
        String result = "Total words : " + theDictionary.size() + " and total occurences " + i + "\r\n";

        for (int j=0; j < theDictionary.size(); j++) {
            result = result + theDictionary.get(j) + "\r\n";
        }

        return result;
    }

}