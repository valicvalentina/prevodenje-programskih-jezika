//package lab1ppj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LeksickiAnalizator {
	private static String[] poms;

	public static void main (String[] args) {
		List<String> list = new ArrayList<>();
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     // StringBuilder sb = new StringBuilder();
	      
	      try {
	    	
	         
	        String linija= null;
	         long currentLine = 0;
	     // linija = br.readLine();
	        while(( (linija=br.readLine())!=null)) {
	      // if(linija.trim().isEmpty()) {
	    	  //nn continue;
	       //} 
	      // System.out.println("prolaz");
	        	
//	        	while(linija.equals("") || linija.isEmpty()) {
//	        	currentLine++;
//	        linija=br.readLine();
//	        	}
	        	if(linija.trim().isEmpty()) {
	        		currentLine++;
	        		continue;
	        	}
	     //  if(!linija.equals("")) {
	    	  // System.out.println("prolaz2");
	        	 try {
	        //	 if(!linija.equals("")) {
	        		 currentLine++;
	        		// String[] znakovi =  linija.trim().split(" ");
	        		 List<String> li1 = new ArrayList<>();
	        	       int j=0;
	        			String s = linija.trim();
	        			boolean prazno = false;
	        			for(int i=0;i<s.length();i++) {
	        				if(s.charAt(i)!=' ' && prazno==false && s.charAt(i)!='\t' ) {
	        					if(!(li1.isEmpty())) {
	        						li1.set(j,li1.get(j)+ Character.toString(s.charAt(i)));
	        					} else {
	        						li1.add(j,Character.toString(s.charAt(i)));
	        					}
	        				} else if(s.charAt(i)==' ' || s.charAt(i) == '\t' ) {
	        					prazno=true;
	       	} else if((s.charAt(i)!=' '&& prazno == true) || (s.charAt(i)!='\t' && prazno==true)) {
	        					j++;
	        					prazno = false;
	        					li1.add(j, Character.toString(s.charAt(i)));
	        				}
	        			}

	        	        String[] znakovi = new String[li1.size()];
	        	        znakovi = li1.toArray(znakovi);
	        		// System.out.println(Arrays.toString(znakovi));
	        		 
	        		 // trazi min
	        		 List<String> l = new ArrayList<>();
	        	
	       for(int i=0;i<znakovi.length;i++) {
	    	   int min = 99999;
	    	   String minznak = null;
	    	   boolean dobro = true;
	    	   
	    	  // List<String> l = new ArrayList<>();
	    	   if((znakovi[i].startsWith("0") ||(znakovi[i].startsWith("1")) ||
	    		 (znakovi[i].startsWith("2")) || (znakovi[i].startsWith("3")) ||
	    			(znakovi[i].startsWith("4")) || (znakovi[i].startsWith("5")) ||
	    			 (znakovi[i].startsWith("6")) || (znakovi[i].startsWith("7")) ||
	    				 (znakovi[i].startsWith("8"))|| (znakovi[i].startsWith("9")))
	    				 &&
	    				!( znakovi[i].endsWith("0") ||(znakovi[i].endsWith("1")) ||
	    	    		 (znakovi[i].endsWith("2")) || (znakovi[i].endsWith("3")) ||
	    	    			(znakovi[i].endsWith("4")) || (znakovi[i].endsWith("5")) ||
	    	    			 (znakovi[i].endsWith("6")) || (znakovi[i].endsWith("7")) ||
	    	    				 (znakovi[i].endsWith("8"))|| (znakovi[i].endsWith("9")))
	    				 ) {
	    		   int poz = 0;
	    		   for(int k=0;k<znakovi[i].length();k++) {
	    			   if(!(znakovi[i].charAt(k)=='0' || znakovi[i].charAt(k)=='1' 
	    					  || znakovi[i].charAt(k)=='2' || znakovi[i].charAt(k)=='3'
	    				|| znakovi[i].charAt(k)=='4' || znakovi[i].charAt(k)=='5'
	    				|| znakovi[i].charAt(k)=='6' || znakovi[i].charAt(k)=='7'
	    				|| znakovi[i].charAt(k)=='8' || znakovi[i].charAt(k)=='9') ) {
	    				poz = k;
	    				 break;  
	    				   
	    			   }
	    		   }
	    		   List<String> lis = new ArrayList<>();
	    		   lis.add(znakovi[i].substring(0,poz));
	    		   lis.add(znakovi[i].substring(poz,znakovi[i].length()));
	    		   List<String> li = new ArrayList<>(Arrays.asList(znakovi));
	   	   	    li.addAll(i,lis);
	   	           li.remove(i + lis.size());
	   	           znakovi = li.toArray(znakovi);
	    		   
	    		   
	    		   
	    	   }
	    	   if(znakovi[i].length()>1 && (znakovi[i].contains("*") || znakovi[i].contains("+")
		        		|| znakovi[i].contains("-") ||(!znakovi[i].equals("//") && znakovi[i].contains("/"))
		        		|| znakovi[i].contains(")") || znakovi[i].contains("(") || znakovi[i].contains("=")
		        		)&& !znakovi[i].startsWith("//")) {
	    		   //System.out.println("t");
	    	   while(dobro==true) {
	    		  // System.out.println(znakovi[i]);
	    		   min = 9999;
	    	   if(znakovi[i].length()>1 && znakovi[i].contains("*")) {
	    		   //System.out.println("1");
	    		   if(znakovi[i].indexOf("*")<min) {
	    			   min = znakovi[i].indexOf("*");
	    		       minznak = "*";
	    		     //  System.out.println("prvi");
	    	   }
	    	   }
	    	   if(znakovi[i].length()>1 && znakovi[i].contains("+")) {
	    		  // System.out.println("2");
	    		   if(znakovi[i].indexOf("+")<min) {
	    		   min = znakovi[i].indexOf("+");
	    		   minznak = "+";
	    	   }
	    	   }
	    	   
	    	   if( znakovi[i].contains("-")) {
	    		   
	    		   if(znakovi[i].indexOf("-")<min) {
	    		   min = znakovi[i].indexOf("-");
	    		   minznak = "-";
	    		   }
	    	   }
	    	   
	    	   if(znakovi[i].contains("/")) {
	    		   if(znakovi[i].indexOf("/")<min) {
	    		   min = znakovi[i].indexOf("/");
	    		   minznak = "/";
	    		   }
	    	   }
	    	   if(znakovi[i].contains(")")) {
	    		   if(znakovi[i].indexOf(")")<min) {
	    		   min = znakovi[i].indexOf(")");
	    		   minznak = ")";
	    		   }
	    	   }
	    	   if(znakovi[i].length()>1 && znakovi[i].contains("(")) {
	    		   if(znakovi[i].indexOf("(")<min) {
	    		   min = znakovi[i].indexOf("(");
	    		   minznak = "(";
	    		   }
	    	   }
	    	   if(znakovi[i].length()>1 && znakovi[i].contains("=")) {
	    		   if(znakovi[i].indexOf("=")<min) {
	    		   min = znakovi[i].indexOf("=");
	    		   minznak = "=";
	    		   }
	    	   }
	       //System.out.println(znakovi[i]);
	       if(min>0) {
	        l.add(znakovi[i].substring(0,min));
	       }
	        l.add(minznak);
	        if(min+1<znakovi[i].length()) {
	        znakovi[i] = znakovi[i].substring(min+1, znakovi[i].length());
	      // System.out.println(znakovi[i]);
	      // System.out.println(min);
	     //  System.out.println(minznak);
	        } else {
	        	dobro = false;
	        }
	        
	        min=9999;
	        //System.out.println(min);
	       // System.out.println(znakovi[i]);
	        if(!(znakovi[i].contains("*") || znakovi[i].contains("+")
	        		|| znakovi[i].contains("-") || znakovi[i].contains("/")
	        		|| znakovi[i].contains("(") || znakovi[i].contains("=")
	        		 || znakovi[i].contains(")")) || 
	        		(znakovi[i].equals("*") ||znakovi[i].equals("+") ||
	        		znakovi[i].equals("-") ||znakovi[i].equals("/") 
	        		|| znakovi[i].equals("(") || znakovi[i].equals(")") ||
	        		znakovi[i].equals("=")) ){
	        	//System.out.println("vani");
	        	l.add(znakovi[i]);
	        	dobro = false;
	        }
	       }		
	    	   List<String> li = new ArrayList<>(Arrays.asList(znakovi));
	   	    li.addAll(i,l);
	           li.remove(i + l.size());
	           znakovi = li.toArray(znakovi);
	           l.clear();
	          // i=i+l.size()-1;
	    	 //  System.out.println(Arrays.toString(znakovi));
	    	 //  l.forEach(System.out::println);
      		 
	        		 }	
	       }
	      // l.forEach(System.out::println);
	        		
	        		
	        		 //System.out.println(Arrays.toString(znakovi));
	        		 //System.out.println(znakovi[0].charAt(0));
	        		 for(int i=0; i<znakovi.length; i++) {
	         if(znakovi[i].equals("//") || znakovi[i].startsWith("//")  ){ break;}
	        			 //System.out.println(znakovi[i]);
	        			 //System.out.println(znakovi[i] == ")");
	        			 if((znakovi[i].charAt(0) == '0') ||
	        					 (znakovi[i].charAt(0) == '1') ||
	        					 (znakovi[i].charAt(0) == '2') ||
	        					 (znakovi[i].charAt(0) == '3') ||
	        					 (znakovi[i].charAt(0) == '4') ||
	        					 (znakovi[i].charAt(0) == '5') ||
	        					 (znakovi[i].charAt(0) == '6') ||
	        					 (znakovi[i].charAt(0) == '7') ||
	        					 (znakovi[i].charAt(0) == '8') ||
	        					 (znakovi[i].charAt(0) == '9') ) {
	        				 znakovi[i] = ("BROJ" +" "+ currentLine + " " +znakovi[i] );
	        				 //System.out.println(znakovi[i]);
	        				 
	        			 } else if(znakovi[i].equals(")")){
	        				 znakovi[i] = ("D_ZAGRADA" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 
	        			 else if(znakovi[i].equals("(")){
	        				 znakovi[i] = ("L_ZAGRADA" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 
	        			 else if(znakovi[i].equals("=")){
	        				 znakovi[i] = ("OP_PRIDRUZI" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 
	        			 else if(znakovi[i].equals("+")){
	        				 znakovi[i] = ("OP_PLUS" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 
	        			 else if(znakovi[i].equals("-")){
	        				 znakovi[i] = ("OP_MINUS" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 
	        			 else if(znakovi[i].equals("*")){
	        				 znakovi[i] = ("OP_PUTA" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 else if(znakovi[i].equals("/")){
	        				 znakovi[i] = ("OP_DIJELI" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 else if(znakovi[i].equals("za")){
	        				 znakovi[i] = ("KR_ZA" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 else if(znakovi[i].equals("od")){
	        				 znakovi[i] = ("KR_OD" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 else if(znakovi[i].equals("do")){
	        				 znakovi[i] = ("KR_DO" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } 
	        			 else if(znakovi[i].equals("az")){
	        				 znakovi[i] = ("KR_AZ" +" "+ currentLine + " " +znakovi[i] );
	        			
	        			 } else {
	        				 
	        				 znakovi[i] = ("IDN" +" "+ currentLine + " " +znakovi[i] );
	        			 
	        			 }
	        			 
	        		 }
	        		 
	        		 for (String znak : znakovi) { 
	        	            // Add each element into the list 
	                       if(znak.startsWith("//")) { break;}
	        	            list.add(znak); 
	        	        } 
	        		 
	        	// }
	         }catch(Exception e) {
	        	 break;
	         }
	      //  }
	      // linija = br.readLine();
	      } }catch (IOException ioe) {
	         System.out.println(ioe);
	      }
	      list.forEach(System.out::println);
	}
}