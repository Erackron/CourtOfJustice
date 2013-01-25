package com.mcdr.courtofjustice.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.bukkit.configuration.file.YamlConfiguration;

import com.mcdr.courtofjustice.CourtOfJustice;

public class CoJConfigUpdater {
	
	private String latestVersion;
	
	public CoJConfigUpdater(){
		latestVersion = CourtOfJustice.in.getDescription().getVersion();
	}
	
	public void updateFiles(){
		updateGlobalConfig();		
	}
	
	private void updateGlobalConfig(){
		YamlConfiguration global = getYamlConfig(getFile("config.yml"));
		
		if(global == null)
			return;
		
		String configVersion;
		if(global.isSet("ConfigVersion"))
			configVersion = global.getString("ConfigVersion");
		else{
			configVersion = "0";
		}
		if(!Utility.isOlderVersion(configVersion, latestVersion))
			return;
		
		CourtOfJustice.l.info("[CourtOfJustice] Creating backup of config.yml");
		File configFile = getFile("config.yml");
		File backupFile = new File(CourtOfJustice.in.getDataFolder().getPath(), "old_files" + File.separator + "v" + configVersion + File.separator + "config.yml");
		
		((File) new File(backupFile.getParent())).mkdirs();
		
		try {
			Utility.fileToFile(configFile, backupFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CourtOfJustice.l.info("[CourtOfJustice] Global config backup created");
		
		if(Utility.isOlderVersion(configVersion, "0.1")){
			CourtOfJustice.l.info("[CourtOfJustice] Updating config.yml");
			
			//Update stuff here
			
			try {
				global.save(getFile("config.yml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Use this part only if the last version didn't have a configversion in the config.yml
			try {
				PrintWriter stream = new PrintWriter(new BufferedWriter(new FileWriter(getFile("config.yml"), true)));
				stream.println();
				stream.println();
				stream.print("ConfigVersion: " + latestVersion);
				
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			CourtOfJustice.l.info("[CourtOfJustice] Global config updated");
		}
	}
	
	private YamlConfiguration getYamlConfig(File file){		
		YamlConfiguration yamlConfig = new YamlConfiguration();
		
		try {
			yamlConfig.load(file);
		} catch (Exception e) {
			return null;
		}
		
		return yamlConfig;		
	}
	
	private File getFile(String name){
		return ((File) new File(CourtOfJustice.in.getDataFolder().getPath() + File.pathSeparator + name));
	}
}