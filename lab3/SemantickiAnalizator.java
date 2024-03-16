//package labos3ppj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SemantickiAnalizator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(
		        new InputStreamReader(System.in));
		List<String> prvo = new ArrayList<>();
		List<String> pojava = new ArrayList<>();
		List<String> zax = new ArrayList<>();
		Map<String,List<String>> zared = new LinkedHashMap<>();
		Map<String,List<String>> var = new LinkedHashMap<>();
		int brojprid=0;
		int brojac=0;
		String line=" ";
		boolean ima=false;
		boolean pridruzi = false;
		boolean krza=false;
		boolean krod=false;
		boolean krdo=false;
		boolean uza=false;
		boolean kraj=false;
		//List<String> var = new ArrayList<>();
		while( ((line=reader.readLine())!=null)&&(kraj==false)) {
			try {
	if(line.trim().split(" ").length==3) {
		String [] arr = line.trim().split(" ");
		if(arr[0].equals("IDN")&&krza==false&&!(Integer.valueOf(arr[1])==brojprid)&&krod==false&&krdo==false){
			if(uza==false) {
				List<String> prvo2 = new ArrayList<>();
				for(String s:prvo) {
					String [] polje = s.split(" ");
					prvo2.add(polje[1]);
				}
				if(!prvo2.contains(arr[2])) {
			prvo.add(arr[1]+" "+arr[2]);
				}
			pridruzi=false;
			}else {
				String z = ((String) zared.keySet().toArray()[(zared.size()-1)]);
				List<String> zared2 = zared.get(z);
				if(!zared2.contains(arr[2])) {
				zared.get(z).add(arr[1]+" "+arr[2]);
				}
			}
		}else if(arr[0].equals("OP_PRIDRUZI")) {
			pridruzi=true;
			brojprid=Integer.valueOf(arr[1]);
		}else if(arr[0].equals("IDN")&&pridruzi==true&&krza==false&&(Integer.valueOf(arr[1])==brojprid)&&krod==false&&krdo==false) {
			if(uza==false) {
				boolean dobro=false;
			for(String s:prvo) {
				String [] polje = s.split(" ");
				if(arr[2].equals(polje[1])&&!(arr[1].equals(polje[0]))) {
					System.out.println(arr[1]+ " "+s);
					dobro=true;
					
				}
			} if(dobro==false) {
				System.out.println("err" +" "+ arr[1]+" " + arr[2]);
				kraj=true;
			}
		}else {
			String z = ((String) zared.keySet().toArray()[(zared.size()-1)]);
			List<String> za =zared.get(z);
			boolean imauza=false;
			boolean uprvo=false;
			boolean dobro=false;
		for(int i=0;i<zared.size();i++) {
			String z2 = ((String) var.keySet().toArray()[(i)]);
			List<String> za2 = var.get(z2);
//			for(String s:za) {
//				String [] polje = s.split(" ");
				if(arr[2].equals(za2.get(2))) {
					System.out.println(arr[1]+ " "+za2.get(0)+za2.get(1)+za2.get(2));
					imauza=true;
					dobro=true;
				//}
				}
				}if(imauza==false) {
				
					for(String ss:prvo) {
						String [] polje2 = ss.split(" ");
						if(arr[2].equals(polje2[1])&&!(arr[1].equals(polje2[0]))) {
							System.out.println(arr[1]+ " "+ss);
							uprvo=true;
							dobro=true;
							
						}
				}
			}if(uprvo==false&&imauza==false) {
				for(String s:za) {
			String [] polje = s.split(" ");
			if(arr[2].equals(polje[1])&&!(arr[1].equals(polje[0]))) {
				System.out.println(arr[1]+ " "+s);
				imauza=true;
				dobro=true;
				
			//}
				}
			}
		}  if(dobro==false) {
			System.out.println("err" +" "+ arr[1]+" " + arr[2]);
			kraj=true;
		}
		}
		}else if(arr[0].equals("KR_ZA")) {
			
			krza=true;
			uza=true;
			zared.put(arr[1],new ArrayList<>());
		}else if(arr[0].equals("IDN")&&krza==true) {
			var.put(arr[1],new ArrayList<>());
			String z = ((String) zared.keySet().toArray()[(zared.size()-1)]);
			List<String> za = var.get(z);
		 za.add(arr[1]);
		 za.add(" ");
		 za.add(arr[2]);
			zared.get(arr[1]).add(arr[1]+" "+arr[2]);
			krza=false;
		}else if(arr[0].equals("KR_OD")) {
			krod=true;
		}else if(arr[0].equals("IDN")&&krza==false&&krod==true) {
			boolean dobro=false;
			String vari = ((String) var.keySet().toArray()[(var.size()-1)]);
			List<String> varij = var.get(vari);
			if(varij.contains(arr[2])) {
				System.out.println("err" +" "+ arr[1]+" " + arr[2]);
				kraj=true;
			}
			
			
			
			for(int i=0;i<var.size()-1;i++) {
				String z2 = ((String) var.keySet().toArray()[(i)]);
				List<String> za2 = var.get(z2);
//				for(String s:za) {
//					String [] polje = s.split(" ");
					if(arr[2].equals(za2.get(2))) {
						System.out.println(arr[1]+ " "+za2.get(0)+za2.get(1)+za2.get(2));
						
						dobro=true;
					//}
					}
			
			}
			
			
			
			
			for(String s:prvo) {
				String [] polje = s.split(" ");
				if(arr[2].equals(polje[1])&&kraj==false) {
					System.out.println(arr[1]+ " "+s);
					dobro=true;
				}
			}if(dobro==false&&kraj==false) {
				System.out.println("err" +" "+ arr[1]+" " + arr[2]);
				kraj=true;
			}
		}else if(arr[0].equals("KR_DO")){
			krod=false;
			krdo=true;
		}else if(arr[0].equals("IDN")&&krza==false&&krod==false&&krdo==true
				&&(((String) zared.keySet().toArray()[(zared.size()-1)]).equals(arr[1]))) {
			String vari = ((String) var.keySet().toArray()[(var.size()-1)]);
			List<String> varij = var.get(vari);
			if(varij.contains(arr[2])) {
				System.out.println("err" +" "+ arr[1]+" " + arr[2]);
				kraj=true;
			}
			boolean dobro=false;
			for(int i=0;i<var.size()-1;i++) {
				String z2 = ((String) var.keySet().toArray()[(i)]);
				List<String> za2 = var.get(z2);
//				for(String s:za) {
//					String [] polje = s.split(" ");
					if(arr[2].equals(za2.get(2))) {
						System.out.println(arr[1]+ " "+za2.get(0)+za2.get(1)+za2.get(2));
						
						dobro=true;
					//}
					}
			
			}
			for(String s:prvo) {
				String [] polje = s.split(" ");
				if(arr[2].equals(polje[1])&&kraj==false) {
					System.out.println(arr[1]+ " "+s);
					dobro=true;
				}
			}if(dobro==false&&kraj==false) {
				System.out.println("err" +" "+ arr[1]+" " + arr[2]);
				kraj=true;
			}
		}else if(arr[0].equals("IDN")&&krdo==true
				&&!(((String) zared.keySet().toArray()[(zared.size()-1)]).equals(arr[1]))) {
			String z = ((String) zared.keySet().toArray()[(zared.size()-1)]);
			krdo=false;
			
			List<String> zaodv = new ArrayList<>();
			List<String> za =zared.get(z);
			for(String s:za) {
				String [] polje = s.split(" ");
				zaodv.add(polje[0]);
			}
			if(!zaodv.contains(arr[2])) {
				
				zared.get(z).add(arr[1]+" "+arr[2]);
			}
				
		}		else if(arr[0].equals("KR_AZ")){
			krdo=false;
			String z = ((String) zared.keySet().toArray()[(zared.size()-1)]);
			zared.remove(zared.keySet().toArray()[(zared.size()-1)]);
			var.remove(var.keySet().toArray()[(var.size()-1)]);
			if(zared.isEmpty()) {
				uza=false;
			}
		}
				
	}		
		}catch(Exception e) {
			break;
		}
			
		}	
			
		//pojava.forEach(System.out::println);	
	
		}
}
