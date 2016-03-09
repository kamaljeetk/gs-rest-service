package javapractice;

// Awesome job. I am proud of u.
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Fibonaci {

// Handle negative numbers.	
public int factorial(int n){
	if (n==0) return 0;
	if (n==1) return 1;
	System.out.println(n+"*");
	return n*(factorial(n-1));
	
}

// Handle 0 and negative
public  int fibonacci(int number){
	if(number <= 0) {
		throw new IllegalArgumentException("Please enter positive Number.");
	}
	
	if(number == 1 ){ 
		return 0; 
	} 
	if(number == 2 ){ 
		return 1; 
	} 
	int res=  (fibonacci(number-1) + fibonacci(number -2)); //tail recursion }  0 1 1 2 3 5
	return res;
}

// Null check is missing
public int countA(String s){
	int count=0;
	char[] array=s.toCharArray();
	for (char c : array) {
		if( (c=='a')||(c=='A')){
			count++;
		}
	}
	return count;
}

// List is null;
public void reverseList(List<String> l){
	List<String> reverse=new LinkedList<String>();
	int J=l.size();
	
	for(int i=J;i>0;i--){
		reverse.add(l.get(i-1));
	}
	
	l.clear();
	l.addAll(reverse);
}


        
@SuppressWarnings("unchecked")
public String sort(String s){
	char[] arr=s.toCharArray();
	ArrayList<Character> l=new ArrayList<Character>();
	
	for (char c : arr) {
		l.add(c);
	}
	
	Collections.sort(l);
	
	return l.toString();
}


public static void main(String[] args){
	Fibonaci f=new Fibonaci();
	int n=10,i=1;
	for ( int c = 1 ; c <= n ; c++ )
	   {
	      System.out.println( f.fibonacci(i));
	      i++; 
	   }
	
	System.out.println("Count of A inasarljjraAgjreg456jthnaaajerAA   "+ f.countA("asarljjraAgjreg456jthnaaajerAA"));
	
	List<String> l=new LinkedList<String>();
	
	l.add("kamal");
	l.add("Manpreet");
	l.add("Anhad");
	l.add("Guddu");
	int i1=0;
	f.reverseList(l);
	System.out.println("REVERSED lIST");
	System.out.println(l);
	
	System.out.println(f.sort("kamal"));
	SimpleDateFormat sysForm = new SimpleDateFormat("yyyy/MM/DD HH:mm");
    Date curdate= new Date();
    System.out.println(sysForm.format(curdate));

}



























}
