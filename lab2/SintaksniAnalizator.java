//package ppjlab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SintaksniAnalizator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(
		        new InputStreamReader(System.in));
		Map<Integer, List<String>> ulazi = new LinkedHashMap<Integer, List<String>>();
		List<String> stog = new ArrayList<>();
		int brojac=0;
		String line=" ";
		boolean ima=false;
		//try {
			while(( (line=reader.readLine())!=null)) {
				try {
				String [] polje = line.split(" ");
				//System.out.println(line.equals(""));
				if(polje.length==3) {
				ulazi.put(brojac, new ArrayList<String>());
				 ulazi.get(brojac).add(polje[0]);
				 ulazi.get(brojac).add(polje[1]);
				 ulazi.get(brojac).add(polje[2]);
				//System.out.println(Arrays.toString(polje));
				//System.out.println("tu1");
				}
				ima=true;
				brojac++;
				Arrays.fill(polje, null);
				}catch(Exception e) {
					break;
				}
				}
			reader.close();
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		//System.out.println("tu");
		if(ima==false) {
			System.out.println("<program>");
			System.out.println(" <lista_naredbi>");
			System.out.println("  $");
		} else {
		stog.add("pocetak");
		stog.add("<program>");
		int i=0;
		Object firstKey = ulazi.keySet().toArray()[i];
		Object value = ulazi.get(firstKey).get(0);
		boolean kraj = true;
		boolean tocno = false;
//		for (String name: ulazi.keySet()) {
//		    String key = name.toString();
//		    String valu = ulazi.get(name).toString();
//		    System.out.println(key + " " + valu);
//		}
		int p=0;
		boolean krivo=false;
		List<String> values = new ArrayList<>();
		while (kraj==true) {
		   
		    
		    
		    if(stog.get(stog.size()-1).equals("<program>")){
		   if(value.equals("IDN") || value.equals("KR_ZA") || value.equals("kraj")) {
			  
			   values.add("<program>");
			   String str = " ";
			    for (char c : stog.get(stog.size()-1).toCharArray()) {
			        if (c == ' ') {
			            str+=" ";
			        }
			    }
			   stog.remove(stog.size()-1);
			   stog.add(str+"<lista_naredbi>");
		   }else {
			   krivo=true;
			   kraj=false;
		   }
		     } 
		    
		    
		    else if(stog.get(stog.size()-1).trim().equals("<lista_naredbi>")){
				   if(value.equals("IDN") || value.equals("KR_ZA")) {
					  // for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					//   }
					   values.add(stog.get(stog.size()-1));
					   String str = " ";
					    for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   stog.remove(stog.size()-1);
					   stog.add(str + "<lista_naredbi>");
					   stog.add(str + "<naredba>");
				   }
				   else if(value.equals("KR_AZ") || value.equals("kraj")) {
					   //for(int r= 0; r < stog.size()-1; r++) {
						 //  System.out.print(" ");
					   //}
					   values.add(stog.get(stog.size()-1));
					  // for(int f= 0; f < stog.size(); f++) {
					//	   System.out.print(" ");
					//   }
					   String str = " ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   values.add(str +"$");
					   if(stog.get(stog.size()-1).trim().equals("pocetak")) {
						   p=0;
					   }

					   stog.remove(stog.size()-1);
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     }
		    
		    
		    else if(stog.get(stog.size()-1).trim().equals("<naredba>")){
				   if(value.equals("IDN")) {
					  // for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					 //  }
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   stog.remove(stog.size()-1);
					   if(stog.get(stog.size()-1).trim().equals("pocetak")) {
						   p=0;
					   }
					   
					   stog.add(str + "<naredba_pridruzivanja>");
				   }
				   else if(value.equals("KR_ZA")) {
					 //  for(int r= 0; r < stog.size()-1; r++) {
						//   System.out.print(" ");
					//   }
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   stog.remove(stog.size()-1);
					   

					   stog.add(str + "<za_petlja>");
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     } 
		    
		    
		    else if(stog.get(stog.size()-1).trim().equals("<naredba_pridruzivanja>")){
				   if(value.equals("IDN")) {
					  // for(int r= 0; r < stog.size()-1; r++) {
						//   System.out.print(" ");
					   //}
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   values.add(str + value + " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   
					   stog.remove(stog.size()-1);
					  

					   stog.add(str + "<E>");
					   stog.add(str + "OP_PRIDRUZI");
					   
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   } else {
						   value = "kraj";
					   }
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     }
		    
		    
		    else if(stog.get(stog.size()-1).trim().equals("<za_petlja>")){
				   if(value.equals("KR_ZA")) {
					 //  for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					  // }
					   String str2=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str2+=" ";
					        }
					    }
					
					   values.add(stog.get(stog.size()-1));
		               values.add(str2+value + " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   stog.remove(stog.size()-1);
					  
					   stog.add(str + "KR_AZ");
					   stog.add(str + "<lista_naredbi>");
					   stog.add(str + "<E>");
					   stog.add(str + "KR_DO");
					   stog.add(str + "<E>");
					   stog.add(str +"KR_OD");
					   stog.add(str + "IDN");
					   i++;
					   if(i<ulazi.size()) {
					   firstKey = ulazi.keySet().toArray()[i];
					   value = ulazi.get(firstKey).get(0);
					   } else {
						   value = "kraj";
					   }
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     }
		    
		    else if(stog.get(stog.size()-1).trim().equals("<E>")){
				   if(value.equals("IDN") ||value.equals("BROJ") || value.equals("OP_PLUS") || value.equals("OP_MINUS") ||
						   value.equals("L_ZAGRADA")) {
					  // for(int r= 0; r < stog.size()-1; r++) {
						//   System.out.print(" ");
					   //}
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   stog.remove(stog.size()-1);
					   

					   stog.add(str + "<E_lista>");
					   stog.add(str + "<T>");
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     }
		    
		    
		    else if(stog.get(stog.size()-1).trim().equals("<T>")){
				   if(value.equals("IDN") ||value.equals("BROJ") || value.equals("OP_PLUS") || value.equals("OP_MINUS") ||
						   value.equals("L_ZAGRADA")) {
					//   for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					  // }
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   stog.remove(stog.size()-1);

					   stog.add(str +"<T_lista>");
					   stog.add(str +"<P>");
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     }
		    
		    
		    else if(stog.get(stog.size()-1).trim().equals("<E_lista>")){
				   if(value.equals("IDN") ||value.equals("D_ZAGRADA") || value.equals("KR_ZA") || value.equals("KR_DO") ||
						   value.equals("KR_AZ") || value.equals("kraj")) {
				//	   for(int r= 0; r < stog.size()-1; r++) {
				//		   System.out.print(" ");
				//	   }
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   values.add(str + "$");
					   
					   stog.remove(stog.size()-1);
				   }
				     
				   else if(value.equals("OP_PLUS") || value.equals("OP_MINUS")) {
					//   for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					//   }
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   values.add(str + value + " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					  

					   stog.add(str + "<E>");
					   //stog.add("OP_PRIDRUZI");
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   } else {
						   value = "kraj";
					   }
				     }else {
				    	 krivo=true;
				    	 kraj=false;
				     }
		    }
		    
		    
		    else if(stog.get(stog.size()-1).trim().equals("<T_lista>")){
				   if(value.equals("OP_PUTA") || value.equals("OP_DIJELI")) {
					 //  for(int r= 0; r < stog.size()-1; r++) {
						//   System.out.print(" ");
					   //}
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   values.add(str + value + " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					 

					   stog.add(str +"<T>");
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   } else {
						   value = "kraj";
					   }
				   } else if(value.equals("IDN") ||value.equals("D_ZAGRADA") || value.equals("KR_ZA") || value.equals("KR_DO") ||
						   value.equals("KR_AZ") || value.equals("kraj") || value.equals("OP_PLUS") || value.equals("OP_MINUS")) {
					  // for(int r= 0; r < stog.size()-1; r++) {
						//   System.out.print(" ");
					   //}
					  
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   values.add(str + "$");
					   stog.remove(stog.size()-1);
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     } 
		    
		    
		    else if(stog.get(stog.size()-1).trim().equals("<P>")){
				   if(value.equals("OP_PLUS") || value.equals("OP_MINUS")) {
					
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   values.add(stog.get(stog.size()-1));
					   values.add(str + value + " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					  

					   stog.add(str +"<P>");
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   }else {
						  value = "kraj";
					   }
				   } else if(value.equals("L_ZAGRADA")) {
					//   for(int r= 0; r < stog.size()-1; r++) {
				//		   System.out.print(" ");
				//	   }
					   
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
			
					   values.add(str + value + " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					   stog.add(str +"D_ZAGRADA");
					   stog.add(str +"<E>");
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   } else {
						   value= "kraj";
					   }
				   } else if(value.equals("IDN") || value.equals("BROJ")) {
					//   for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					//   }
					   values.add(stog.get(stog.size()-1));
					   String str=" ";
					   for (char c : stog.get(stog.size()-1).toCharArray()) {
					        if (c == ' ') {
					            str+=" ";
					        }
					    }
					   values.add(str + value+ " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   }else {
						   value="kraj";
					   }
				   } else {
					   krivo=true;
					   kraj=false;
				   }
				     } 
		    
		    
		       else if(stog.get(stog.size()-1).trim().equals("KR_OD")){
				   if( value.equals("KR_OD")) {
				//	   for(int r= 0; r < stog.size()-1; r++) {
				//		   System.out.print(" ");
				//	   }
					   values.add(stog.get(stog.size()-1) + " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   }else {
						   value = "kraj";
					   }
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     } 
		    
		    
		       else if(stog.get(stog.size()-1).trim().equals("KR_DO")){
				   if(value.equals("KR_DO")) {
					//   for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					  // }
					   values.add(stog.get(stog.size()-1)+ " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   }else {
						   value="kraj";
					   }
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     } 
		    
		    
		       else if(stog.get(stog.size()-1).trim().equals("D_ZAGRADA")){
				   if(value.equals("D_ZAGRADA")) {
					//   for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					  // }
					   values.add(stog.get(stog.size()-1)+ " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   }else {
						   value = "kraj";
					   }
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     } 
		    
		    
		       else if(stog.get(stog.size()-1).trim().equals("KR_AZ")){
				   if(value.equals("KR_AZ")) {
					//   for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					  // }
					   values.add(stog.get(stog.size()-1)+ " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   }else {
						   value = "kraj";
					   }
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     } 
		    
		    
		       else if(stog.get(stog.size()-1).trim().equals("OP_PRIDRUZI")){
				   if(value.equals("OP_PRIDRUZI")) {
					//   for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					  // }
					   values.add(stog.get(stog.size()-1)+ " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   }else {
						   value = "kraj";
					   }
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     } 
		    
		    
		       else if(stog.get(stog.size()-1).trim().equals("IDN")){
				   if(value.equals("IDN")) {
					//   for(int r= 0; r < stog.size()-1; r++) {
					//	   System.out.print(" ");
					  // }
					   values.add(stog.get(stog.size()-1)+ " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
					   stog.remove(stog.size()-1);
					   i++;
					   if(i<ulazi.size()) {
						 firstKey = ulazi.keySet().toArray()[i];
						 value = ulazi.get(firstKey).get(0);
					   }else {
						   value = "kraj";
					   }
				   }else {
					   krivo=true;
					   kraj=false;
				   }
				     }
		    
		    
		       else if(stog.get(stog.size()-1).trim().equals("pocetak")) {
		    	   if(value.equals("kraj")) {
		    		   tocno=true;
		    		   kraj = false;
		    	   }else {
		    		   krivo=true;
		    		   kraj=false;
		    	   }
		       } 
		       else {
		    	   System.out.println("err" + value+ " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
		    	   krivo=true;
		    	   kraj=false;
		       }
		    
		    
		}
		if(krivo==false) {
	    	values.forEach(System.out::println);
	    }else {
	    	if(value!="kraj") {
	    	 System.out.println("err" +" "+ value+ " " + ulazi.get(firstKey).get(1)+ " " + ulazi.get(firstKey).get(2));
	    	}else {
	    		System.out.println("err kraj");
	    	}
	    }
		
		
		//System.out.println(tocno);
		
		
		
		
		
		
		
		
		
		
		}	
	}

}
