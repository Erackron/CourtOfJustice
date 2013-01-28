package com.mcdr.courtofjustice;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.mcdr.courtofjustice.command.CommandHandler;
import com.mcdr.courtofjustice.utils.CoJMetrics;
import com.timvisee.manager.permissionsmanager.PermissionsManager;
import com.timvisee.manager.economymanager.EconomyManager;

public class CourtOfJustice extends JavaPlugin {
	public static CourtOfJustice in;
	public static Logger l;
	public static BukkitScheduler scheduler;
	public static Server server;
	public static PluginDescriptionFile pdf;
	public PermissionsManager pm;
	public EconomyManager em;
	
	public CourtOfJustice(){
		in = this;
		l = Bukkit.getLogger();
		scheduler = Bukkit.getScheduler();
		pdf = getDescription();
		server = getServer();
	}
	
	@Override
	public void onEnable(){
		setupEconomyManager();
		setupPermissionsManager();
		getCommand("courtofjustice").setExecutor(new CommandHandler());
		setupMetrics();
		l.info("["+getName()+"] Version "+pdf.getVersion()+" Enabled");
	}
	
	@Override
	public void onDisable(){
		l.info("["+getName()+"] Disabled");
	}
	
	/**
	 * Setup the economy manager
	 */
	public void setupEconomyManager() {
		// Setup the economy manager
		this.em = new EconomyManager(this.getServer(), this);
		this.em.setup();
	}
	
	/**
	 * Get the economy manager
	 * @return economy manager
	 */
	public EconomyManager getEconomyManager() {
		return this.em;
	}
	
	/**
	 * Setup the permissions manager
	 */
	public void setupPermissionsManager() {
		// Setup the permissions manager
		this.pm = new PermissionsManager(this.getServer(), this);
		this.pm.setup();
	}
	
	/**
	 * Get the permissions manager
	 * @return permissions manager
	 */
	public PermissionsManager getPermissionsManager() {
		return this.pm;
	}
	
	private void setupMetrics(){
		try{
			CoJMetrics metrics = new CoJMetrics(this);
			
			if(metrics.start())
		    	l.info("["+getName()+"] Sending metrics data");
		    else
		    	l.info("["+getName()+"] Disabled sending metrics data");
		} catch (IOException e) {
			l.warning("["+getName()+"] Failed to contact mcstats.org");
		}
	}
	
}
