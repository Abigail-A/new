	import java.io.File; 
	import java.io.IOException; 
	import java.io.RandomAccessFile; 
	import java.lang.NumberFormatException; 

	public class CreateFiles { 

		public static void main(String data[]) 
	    { 
	  
	        try { 
	  
	           
	            String newName = data[0]; 
	            long newNumber = Long.parseLong(data[1]); 
	  
	            String nameNumberString; 
	            String name; 
	            long number; 
	            int index; 
	  
	            // Using file pointer creating the file. 
	            File file = new File("Contact.txt"); 
	  
	            if (!file.exists()) { 
	  
	                // Create a new file if not exists. 
	                file.createNewFile(); 
	            } 
	  
	            // Opening file in reading and write mode. 
	  
	            RandomAccessFile raf 
	                = new RandomAccessFile(file, "rw"); 
	            boolean found = false; 
	  
	            // Checking whether the name 
	            // of contact already exists. 
	            // getFilePointer() give the current offset 
	            // value from start of the file. 
	            while (raf.getFilePointer() < raf.length()) { 
	  
	                // reading line from the file. 
	                nameNumberString = raf.readLine(); 
	  
	                // finding the position of '!' 
	                index = nameNumberString.indexOf('!'); 
	  
	                // separating name and number. 
	                name = nameNumberString 
	                           .substring(0, index); 
	                number 
	                    = Long 
	                          .parseLong( 
	                              nameNumberString 
	                                  .substring(index + 1)); 
	  
	                // if condition to find existence of record. 
	                if (name == newName || number == newNumber) { 
	                    found = true; 
	                    break; 
	                } 
	            } 
	  
	            if (found == false) { 
	  
	                // Enter the if block when a record 
	                // is not already present in the file. 
	                nameNumberString 
	                    = newName 
	                      + "!"
	                      + String.valueOf(newNumber); 
	  
	                // writeBytes function to write a string 
	                // as a sequence of bytes. 
	                raf.writeBytes(nameNumberString); 
	  
	                // To insert the next record in new line. 
	                raf.writeBytes(System.lineSeparator()); 
	  
	                // Print the message 
	                System.out.println(" data added. "); 
	  
	                // Closing the resources. 
	                raf.close(); 
	            } 
	            // The contact to be updated 
	            // could not be found 
	            else { 
	  
	                // Closing the resources. 
	                raf.close(); 
	  
	                // Print the message 
	                System.out.println(" Input name"
	                                   + " cannot be added. "); 
	            } 
	        } 
	  
	        catch (IOException ioe) { 
	  
	            System.out.println(ioe); 
	        } 
	        catch (NumberFormatException nef) { 
	  
	            System.out.println(nef); 
	        } 
		} 
	

	
}
