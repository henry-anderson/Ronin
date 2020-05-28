package org.henrya.ronin.combineddkp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.henrya.ronin.combineddkp.backup.WebDKPSession;

public class Main {
	public static void main(String[] args) throws Exception {
    	if(args.length > 0) {
        	boolean webLoad = false;
    		if(args.length == 1) {
    			webLoad = true;
    		}
    		else if(args.length == 2) {
    			webLoad = false;
    		}
    		else {
    			System.out.println("Incorrect parameters use: java -jar CombinedDKP.jar [file]    or    java -jar CombinedDKP.jar [file] [backup]");
    			System.exit(1);
    		}
	        try {
	        	File inputFile = new File(args[0]);
	        	ParsedDKPTable table;
	        	if(webLoad) {
		        	System.out.println("Loading...");
		        	WebDKPSession httptable = new WebDKPSession("https://www.webdkp.com/dkp/Agamaggan/uuirvjj");
		        	httptable.loadPlayers();
		        	httptable.loadAwards();
		            System.out.println("Table has been loaded.");
		            table = new ParsedDKPTable(httptable);
		            table.saveFile(new File("backup.txt"));
	        	}
	        	else {
	        		File backupFile = new File(args[1]);
	        		table = new ParsedDKPTable(backupFile);
	        		System.out.println("Table has been loaded.");
	        	}
	
	        	List<Player> players = new ArrayList<Player>();
	        	BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        	String line = "";
	        	
		        while((line = reader.readLine()) != null) {
		        	List<String> alts = new ArrayList<String>();
		        	String[] accounts = line.toLowerCase().split(",");
		        	String main;
		        	if(accounts.length > 1) {
		        		main = accounts[0].trim();
		        		alts = new ArrayList<String>();
		        		for(String alt : Arrays.copyOfRange(accounts, 1, accounts.length)) {
		        			alts.add(alt.trim());
		        		}
		        	}
		        	else {
		        		main = accounts[0].trim();
		        	}
		        	players.add(new Player(main, alts));
		        }
		        reader.close();
				for(Player player : players) {
					if(table.playerExists(player.getMain())) {
						player.addCombinedLifetime(table.getPlayer(player.getMain()).getLifetimePoints());
						player.addCombined90Days(table.getPlayer(player.getMain()).getPoints90Days());
						player.addCombined45Days(table.getPlayer(player.getMain()).getPoints45Days());
					}
					else {
						System.out.println("Player not found on WebDKP: " + player.getMain());
					}
					for(String alt : player.getAlts()) {
						if(table.playerExists(alt)) {
							player.addCombinedLifetime(table.getPlayer(alt).getLifetimePoints());
							player.addCombined90Days(table.getPlayer(alt).getPoints90Days());
							player.addCombined45Days(table.getPlayer(alt).getPoints45Days());
						}
						else {
							System.out.println("Player not found on WebDKP: " + alt);
						}
					}
				}
				System.out.println("Complete... Creating table");
				
				
				File output = new File("combined.csv");
				BufferedWriter writer = new BufferedWriter(new FileWriter(output));
				System.out.println("Main,Combined Lifetime,Combined 90 Day Activity,Combined 45 Day Activity,Main 90 Day Activity");
				writer.append("Main,Combined Lifetime,Combined 90 Day Activity,Combined 45 Day Activity,Main 90 Day Activity");
				writer.newLine();
				for(Player player : players) {
					System.out.println(player.getMain() + "," + player.getCombinedLifetime() + "," + player.getCombined90Days() + "," + player.getCombined45Days() + "," + table.getPlayer(player.getMain()).getPoints90Days());
					writer.append(player.getMain() + "," + player.getCombinedLifetime() + "," + player.getCombined90Days() + "," + player.getCombined45Days() + "," + table.getPlayer(player.getMain()).getPoints90Days());
					writer.newLine();
				}
				writer.close();
	            
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
    	}
    	else {
			System.out.println("Incorrect parameters use: java -jar CombinedDKP.jar [file]    or    java -jar CombinedDKP.jar [file] [backup]");
    	}
    	
	}
}
