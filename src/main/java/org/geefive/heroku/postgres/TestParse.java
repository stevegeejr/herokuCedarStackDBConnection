package org.geefive.heroku.postgres;

import java.util.*;

public class TestParse {

	public static void main(String args[]){
	    String POSTGRES_URL = "postgres://butiwvicyo:5Ll7sLHc5OCd_cTGQd-m@ec2-50-19-225-156.compute-1.amazonaws.com/butiwvicyo";
	    StringTokenizer stok = new StringTokenizer(POSTGRES_URL,":");
	    
	    
	    
	    System.out.println("DATABASE: " + stok.nextToken());
	    String username = stok.nextToken().substring(2);
	    System.out.println("USERNAME: " + username);
//	    String passwordUrl = 
//	    System.out.println("TOKEN_03: " + stok.nextToken());
	    
	    stok = new StringTokenizer(stok.nextToken(),"@");
	    System.out.println("PASSWORD: " + stok.nextToken());
	    System.out.println("URL: " + stok.nextToken());

	}
	
	
}
