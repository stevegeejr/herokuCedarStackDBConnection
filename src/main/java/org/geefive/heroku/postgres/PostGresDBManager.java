/*
herokuCedarStackDBConnection: Example of how to connect a java application to the Heroku PostgreSQL 
database when using the cedar stack

Copyright (C) 2011  Steve S Gee Jr
https://stevegeejr@github.com/stevegeejr/herokuCedarStackDBConnection.git
ioexcept@gmail.com

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/gpl-3.0.html>.
*/

package org.geefive.heroku.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

public class PostGresDBManager {
    private HttpSession session = null;
	private static final Logger logger = LoggerFactory.getLogger(org.geefive.heroku.postgres.PostGresDBManager.class);

    private String DATABASE = null;
    private String DBUSERNAME = null;
    private String DBPASSWORD = null;
    private String URL = null;
    Map<String, String> envVariables = null;

    
	public PostGresDBManager(HttpSession _session){
		session = _session;
		envVariables = System.getenv();
		String SHARED_DATABASE_URL = envVariables.get("SHARED_DATABASE_URL");
		logger.info("SHARED_DATABASE_URL: " + SHARED_DATABASE_URL);
	    StringTokenizer stok = new StringTokenizer(SHARED_DATABASE_URL,":");
	    DATABASE = stok.nextToken();
	    logger.info("DATABASE: " + DATABASE);
	    DBUSERNAME = stok.nextToken().substring(2);
	    logger.info("USERNAME: " + DBUSERNAME);
	    stok = new StringTokenizer(stok.nextToken(),"@");
	    DBPASSWORD = stok.nextToken();
	    logger.info("PASSWORD: " + maskPassword(DBPASSWORD));
	    URL = "jdbc:postgresql://" + stok.nextToken();
	    logger.info("URL: " + URL);
	}
	
	private String maskPassword(String in){
		int counter = 0;
		String result = "";
		if(in != null)
		while(counter < in.length()){
			result += "*";
			counter++;
		}
		return result;
	}
	
	public String openConnection(){
		StringBuffer result = new StringBuffer();
		try{
			Class.forName("org.postgresql.Driver");
			Connection conn = null;
			try{
				conn = DriverManager.getConnection(URL,DBUSERNAME,DBPASSWORD);
				result.append("CONNECTED: " + !conn.isClosed());
			}catch(Exception ex){
				ex.printStackTrace();
				StackTraceElement[] lines = ex.getStackTrace();
				int totalRow = lines.length;
				int row = 0;
				result.append(ex.getMessage()).append("<br>");
				while(row < totalRow || row < 10){
					result.append(lines[row]).append("<br>");
					row++;
				}
			}finally{
				try{conn.close();}catch(Exception ex){}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("Unrecoverable Exception:openConnection",ex);
		}
		return result.toString();
	}

}
