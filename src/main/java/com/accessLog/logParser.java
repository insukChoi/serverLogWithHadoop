package com.accessLog;

import org.apache.hadoop.io.Text;

public class logParser {
	
	private String ip;
	
	public logParser(Text text){

		String[] colums = text.toString().split(" - - ");
		
		ip = colums[0];
		
	}

	public String getIp() {
		return ip;
	}
}
