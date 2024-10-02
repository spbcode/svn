package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String args[]) {
		List<Customer> customers = new ArrayList();
		while(true) {
			Customer c = new Customer("sam");
			customers.add(c);
			if(customers.size()>1000) {
				for(int i=0;i<10;i++) {
					customers.remove(i);
				}
			}
		}
		
	}

}
