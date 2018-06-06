/*
* Alicé Lesowski
* ComparingFiles
* HW 3
* This program takes 2 input files and compares them line by line.
* Then it prints the differences in the files to an output file
* or prints they are the same if there are no differences.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CompareInput{

	public static void main(String[] args) throws IOException{
		boolean same = true;
		int lnum = 1;
		
		BufferedWriter output = null;
		try{
     		File out = new File("output/diff.txt");
       		if(!out.exists()){
     			out.createNewFile();
       		}
       		
        FileWriter fw = new FileWriter(out);
        output = new BufferedWriter(fw);
        BufferedReader input1 = new BufferedReader(new FileReader("input/input1.txt"));
		BufferedReader input2 = new BufferedReader(new FileReader("input/input2.txt"));
		String line1 = input1.readLine();
		String line2 = input2.readLine();
		
		while(line1!=null || line2!=null){
			if(line1 == null || line2 == null) {
				same = false;
				break;
			}
			else if(!line1.equalsIgnoreCase(line2)) {
				same = false;
				break;
			}
			line1 = input1.readLine();
			line2 = input2.readLine();
			lnum++;
		}
		
		if(same){
			System.out.println("Files are the same");
			output.write("Files are the same");
		}
		else{
			System.out.println("Files are different at line: " + lnum + "\n");
			System.out.println("Input 1 = " + line1 + " , Input = " + line2);
			output.write("Files are different at line: " + lnum + "\n");
			output.write("Input 1 = " + line1 + " , Input = " + line2);
		}
		input1.close();
		input2.close();
		output.close();
		}
		catch(IOException e) {
			System.err.format("IOException: %s%n", e);
		}	
	}
}
