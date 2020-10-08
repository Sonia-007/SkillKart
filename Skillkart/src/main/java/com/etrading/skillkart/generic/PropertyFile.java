package com.etrading.skillkart.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.Spliterator;

public class PropertyFile {
	

	public static String getpropertyValue(String path,String key) 
	{
		String data=null;
	
		try {
		FileInputStream f1=new FileInputStream(path);
		Properties ph=new Properties();
		ph.load(f1);
		data=ph.getProperty(key);
		
	}
		catch(IOException e ) {
			System.out.println(e);
		}
		return data;
}
	public static Set<Entry<Object,Object>> getpropertyValue(String path)
	{
		Set<Entry<Object,Object>> data=null;
		try {
			FileInputStream f1=new FileInputStream(path);
			Properties ph=new Properties();
			ph.load(f1);
			data=ph.entrySet();
			
		}
		catch(IOException e) {
			System.out.println(e);
		}
		return data;
	}
	public static Set<Object> getpropertyValue1(String path)
	{
		Set<Object> data=null;
		try {
			FileInputStream f1=new FileInputStream(path);
			Properties ph=new Properties();
			ph.load(f1);
			data=ph.keySet();
			
			
		}
		catch(IOException e) {
			System.out.println(e);
		}
		return data;
	}
	
}
