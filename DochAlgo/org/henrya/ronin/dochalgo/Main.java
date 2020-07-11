package org.henrya.ronin.dochalgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.henrya.httpicnic.http.HttpConnectionException;
import org.henrya.ronin.dochalgo.frames.InputFrame;

/**
 * An algorithm for determining who is next in line for DG
 * @author Henry Anderson
 *
 */
public class Main {
	/* A month in milliseconds */
	public static final long MONTH = 30 * 24 * 60 * 60 * 1000L;
	
	public static void main(String[] args) {
		InputFrame frame = new InputFrame();
		frame.setVisible(true);
		/* try {
			List<Candidate> candidates = new ArrayList<Candidate>();
			System.out.println("Loading DG candidates...");
			File file = new File("/Users/henryanderson/Desktop/dg.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				line = line.toLowerCase();
				if(line.contains(",")) {
					String[] split = line.split(",");
					String main = split[0].trim();
					List<String> alts = new ArrayList<String>();
					for(String alt : split) {
						alt = alt.trim();
						if(!alt.equals(main)) {
							alts.add(alt);
						}
			    	}
					//candidates.add(new Candidate(main, alts));
			    }
				else {
					String main = line.trim();
					//candidates.add(new Candidate(main, new ArrayList<String>()));
			    }
			}
			br.close();
			
			for(Candidate candidate : candidates) {
				System.out.println(candidate.getMain() + " - " +  Arrays.toString(candidate.getAlts().toArray()));
			}
						
			WebDKPSession session = new WebDKPSession("https://webdkp.com/dkp/Agamaggan/uuirvjj");
			System.out.println("Loading players...");
			session.loadPlayers(candidates);
			System.out.println("Loading awards...");
			session.loadAwards(candidates);
			
			for(Candidate candidate : candidates) {
				if(session.playerExists(candidate.getMain())) {
					candidate.addCombinedLifetime(session.getPlayer(candidate.getMain()).getLifetimePoints());
					candidate.addCombined90Days(session.getPlayer(candidate.getMain()).getPoints90Days());
				}
				else {
					System.out.println("Player not found: " + candidate.getMain());
				}
				for(String alt : candidate.getAlts()) {
					if(session.playerExists(alt)) {
						candidate.addCombinedLifetime(session.getPlayer(alt).getLifetimePoints());
						candidate.addCombined90Days(session.getPlayer(alt).getPoints90Days());
					}
					else {
						System.out.println("Player not found: " + alt);
					}
				}
			}
			
			for(Candidate candidate : candidates) {
				System.out.println(candidate.getMain() + " - " + candidate.getCombinedLifetime() + " - " + candidate.getCombined90Days());
			}
			
		} catch(IOException | HttpConnectionException e) {
			e.printStackTrace();
		} */
	}
}
