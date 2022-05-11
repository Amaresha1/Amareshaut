package com.crm.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SampleTestJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Set<String> set = new HashSet<String>();
		set.add("ram");
		set.add("sam");
		set.add("zam");
		set.add("aam");
		
		Iterator<String> it = set.iterator();

		
		while (it.hasNext()) {
			
			System.out.println(it.next());
		}

		
	}

}
