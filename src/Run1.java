
import lfu.MyList;

public class Run1 {
	
	public static void main(String[] args) {
		MyList list = new MyList(4, 0.8f);
		list.put("a", 1);
		list.put("b", 2);
		list.put("c", 3);
		list.put("d", 4);
		list.put("e", 5);
		list.put("f", 6);		
		list.get("c");
		list.get("d");
		list.get("c");
		list.get("d");
		list.get("c");
		list.get("d");
		list.get("f");
		list.get("f");
		list.get("f");
		list.get("d");
		list.get("f");
		list.put("a", 1);
		list.put("b", 2);
		list.put("c", 3);
		list.put("d", 4);
		list.get("c");
		list.get("d");
		list.get("c");
		list.get("d");
		list.get("c");
		list.get("d");
		list.get("f");
		list.get("c");
		list.get("d");
				
		list.print();
		
	}

}
