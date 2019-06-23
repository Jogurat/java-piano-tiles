package Piano;

import java.util.Map;
import java.util.HashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.stream.Stream;

import javax.swing.KeyStroke;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Symbol {

	protected static Map<String, Pair <String,Integer>> noteMap = new HashMap<String, Pair<String,Integer>>();
	protected static Map<String, Integer> nameMap = new HashMap<String, Integer>();
	protected static Map<String, String> keyStrokeMap = new HashMap<String, String>();
	private int symbolDuration; //Moze biti 4(1/4) ili 8(1/8)
	
	public Symbol(int duration) {
		symbolDuration=duration;
	}
	
	public abstract boolean isNote();
	public abstract boolean isComplex();
	
	public int getDuration() {
		return symbolDuration;
	}
	
	//Ucitavanje mape!
	public static void loadMap() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data/map.csv")));
			Stream<String> stream = br.lines();
			stream.forEach(e->{
				//Parsiranje
				Pattern pattern = Pattern.compile("^(.*),(.*),(.*)$");
				Matcher match = pattern.matcher(e);
				if(match.matches()) {
					String mapKey = match.group(1);
					String name = match.group(2);
					Integer value = Integer.parseInt(match.group(3));
					
					noteMap.put(mapKey, new Pair<String, Integer>(name, value));
					nameMap.put(name, value);
					keyStrokeMap.put(name, mapKey);
				}
			});
			br.close();
		} catch (IOException e) {}
	}
	
	
}	
	
