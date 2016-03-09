package javapractice;

public class LinkedList {
	private String data;
	private LinkedList next;

	LinkedList(String data, LinkedList next) {
		this.data = data;
		this.next = next;
	}
 
	public void addList(LinkedList list, String value) {
		LinkedList newList = new LinkedList(value, null);
		if(list == null) {
			list = newList;
			return;
		}
		while(list.next != null) {
			list = list.next;
		}
		list.next = newList;
	}
	
	public void deleteNode(LinkedList list, String value) {
		LinkedList prev = null;
		while(list != null) {
			if(list.data.equals(value)){
				prev.next=list.next;
			}
			prev = list;
			list = list.next;
			
		}
		
	}
}
