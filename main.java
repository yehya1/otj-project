import java.util.*;


public class main {
	public static  Map<String,Map> timeunitinfo ()
	{
		Map<String ,Integer>  cartime = new HashMap<String ,Integer>();
		Map<String ,Map>  cartype = new HashMap<String ,Map>();
		cartime.put("r", 1);
		cartime.put("c", 2);
		cartype.put("mcycle", cartime);
		cartime = new HashMap<String ,Integer>();
		cartime.put("r", 3);
		cartime.put("c", 4);
		cartype.put("private", cartime);
		cartime = new HashMap<String ,Integer>();
		cartime.put("r", 5);
		cartime.put("c", 6);
		cartype.put("trailer", cartime);
		return cartype;
	}
	public static List<List> inputcarsinfo(){
		
		List<List> carlist = new ArrayList< List>();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			List<String> carinfo = new ArrayList<String>();
			String endflag = input.next();
			if(endflag.equals("quit")) {
				break;
			}
			carinfo.add(endflag);
			carinfo.add(input.next());
			carlist.add(carinfo);	
		}
		return carlist;
	}
	public static List<List> queuearrangement(List<List> carlist ,  Map<String , Map> cartype ){
		List<Integer> refuelinglist = new ArrayList<Integer>();
		List<Integer> cleaninglist = new ArrayList<Integer>();
		int r=0,c = 1;
		for(int i=0 ;i<carlist.size();) {
			if(((String) carlist.get(i).get(1)).isEmpty()) {
				i++;
			}else {
			for(;!((String) carlist.get(r).get(1)).contains("r") && r < carlist.size()-1;r++);
			for(;!((String) carlist.get(c).get(1)).contains("c") && c < carlist.size()-1;c++);
			if(cleaninglist.size()>=refuelinglist.size()) {
				if(cleaninglist.indexOf(r)==refuelinglist.size()) {
					for(;cleaninglist.lastIndexOf(r)>refuelinglist.size()-1;) {
						refuelinglist.add(-1);
					}
				}
				System.out.println("Vehicle "+r+" starts refueling in time "+refuelinglist.size()+".");
				for(int j =0 ;j < ((Integer)cartype.get(carlist.get(r).get(0)).get("r")) 
						&& c <carlist.size();j++) {
					if(((String) carlist.get(r).get(1)).contains("r"))
							refuelinglist.add(r);
				}
				List<String> help = carlist.get(r); 
				help.set(1, help.get(1).replace("r", ""));
				carlist.set(r,help);
				r=i;
			}else {
				if(refuelinglist.indexOf(c)==cleaninglist.size()) {
					for(;refuelinglist.lastIndexOf(c)>cleaninglist.size()-1;) {
						cleaninglist.add(-1);
					}
				}
				System.out.println("Vehicle "+c+" starts cleaning in time "+cleaninglist.size()+".");
				for(int j =0 ;j < ((Integer)cartype.get(carlist.get(c).get(0)).get("c"))
						&& c <carlist.size();j++) {
					if(((String) carlist.get(c).get(1)).contains("c"))
						cleaninglist.add(c);
				}	
				List<String> help = carlist.get(c); 
				help.set(1, help.get(1).replace("c", ""));
				carlist.set(c,help);
				c=i;
			}
			
			}
		}
		List<List> rc = new ArrayList<List>();
		rc.add(refuelinglist);
		rc.add(cleaninglist);
		return rc;
	}
	public static void main(String[] args) {
	    Map<String , Map> cartype = timeunitinfo();
	
	    // the input copy it => mcycle rc trailer r mcycle rc private c private c private r private r mcycle r mcycle r private rc trailer c mcycle r private r trailer rc private r quit
		List<List> carlist = inputcarsinfo();
		
		List<>

	}

}
