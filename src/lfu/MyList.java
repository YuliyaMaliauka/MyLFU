package lfu;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyList {
	Map<String,  Integer>map2;
	LinkedList<String> list[];
	int maxSize;
        int countDelite;
    
	public MyList(int maxSize, float f)
	{	
		countDelite = (int) (maxSize*f);
		list  = new LinkedList[maxSize];
        	this.maxSize = maxSize;
		map2  = new LinkedHashMap<String, Integer>(maxSize*4/3, 0.75f, true) {
			private static final long serialVersionUID = -3588047435434569014L;
			@Override
			protected boolean removeEldestEntry(Map.Entry<String, Integer>eldest) {
				return size() >maxSize;
			}             
		};
				
		for (int i = 0; i<=maxSize-1; i++){
			list[i] = new LinkedList<String>();
		}			
	}

	public String put(String s, Integer in){
		LinkedList<String> list1 = list[0];	
		map2.put(s, 0);	
		list1.add(s);
		if(list1.size()>maxSize){	
			list1.removeFirst();
		}
		return s;
	}
	public boolean remove(){
		for (int i = 0; i<list.length; i++)
		{
			if(!list[i].isEmpty()){			
				for(int l = 0; l<=countDelite; l++)
				list[i].clear();
		    		list[list.length-1].clear();
			}	
		}
		return true;
	}

	public void get(String s)
	{	Integer in = 0;
		if(map2.containsKey(s)){		
			in = map2.get(s) + 1;
			if(in>=maxSize)	{
				remove();
				LinkedList<String> list1 = list[maxSize-1];
				list1.add(s);
			}
			else{
				map2.put(s, in);
				LinkedList<String> list1 = list[in];
				list1.add(s);
				list[in-1].remove(s);
			}
		}
		else{
			map2.put(s, 0);
		}		
	}
	public void print() {
		for (int i=0; i<list.length; i++)
		System.out.println(i+" = "+list[i].toString());
	}
}

