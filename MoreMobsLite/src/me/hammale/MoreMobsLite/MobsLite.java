package me.hammale.MoreMobsLite;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.CreatureType;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MobsLite extends JavaPlugin
{
	// logging function
	public Logger log = Logger.getLogger("Minecraft");
	protected void logMessage (String msg) {
	this.log.info("[MoreMobsLite]" + msg);
	}
	public FileConfiguration config;
	
  private final LiteEntityListener entityListener = new LiteEntityListener(this);
  private final LiteChunkListener chunkListener = new LiteChunkListener(this);
  
  public void onEnable()
  {
	    
	  	loadConfiguration();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.CREATURE_SPAWN, this.entityListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.CHUNK_LOAD, this.chunkListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.ENTITY_COMBUST, this.entityListener, Event.Priority.Low, this);
        log.info("[MoreMobsLite] Enabled!");
  }
public void onDisable() {
    log.info("[MoreMobsLite] Disabled!");
}


public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	if(cmd.getName().equalsIgnoreCase("mmreload")){
		reloadConfig();
		sender.sendMessage(ChatColor.LIGHT_PURPLE + "MoreMobs Reloaded!");
		if(sender.getName() == "CONSOLE") {
			log.info("[MoreMobsLite] Reloaded by the console");
		}
		else{
			log.info("[MoreMobsLite] Reloaded by " + sender.getName());
		}
		return true;
	}
	return false; 
}

public void loadConfiguration(){
    //We must initialize the config
    config = getConfig();
    config.options().copyDefaults(true); 
    
    for(World w : this.getServer().getWorlds()) {
    String wrld = w.getName();    
    	
    String path0 = "World." + wrld + "." + "WorldType.Type";
    
    if(w.getEnvironment() == Environment.NORMAL){
    	config.addDefault(path0, 1);
    }else if(w.getEnvironment() == Environment.NETHER){
    	config.addDefault(path0, 2);
    }else if(w.getEnvironment() == Environment.THE_END){
    	config.addDefault(path0, 3);
    }
    
    //NORMAL MOBS
    if(w.getEnvironment() == Environment.NORMAL){		
    String path = "World." + wrld + "." + "NumberOfMobs.CAVE_SPIDER";
    config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.CHICKEN";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.COW";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.CREEPER";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.PIG";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.SHEEP";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.SILVERFISH";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.SKELETON";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.SLIME";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.SPIDER";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.SQUID";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.WOLF";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.ZOMBIE";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.MUSHROOM_COW";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.VILLAGER";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.SNOWMAN";
     config.addDefault(path, 4);
     path = "World." + wrld + "." + "NumberOfMobs.ENDERMAN";
     config.addDefault(path, 4);
    }
    
    //NETHER MOBS
    if(w.getEnvironment() == Environment.NETHER){
    String path = "World." + wrld + "." + "NumberOfMobs.PIG_ZOMBIE";
    config.addDefault(path, 4);
    path = "World." + wrld + "." + "NumberOfMobs.GHAST"; 
    config.addDefault(path, 4);
    path = "World." + wrld + "." + "NumberOfMobs.MAGMA_CUBE";
    config.addDefault(path, 4);
    path = "World." + wrld + "." + "NumberOfMobs.BLAZE";
    config.addDefault(path, 4);
    }
    
    //END MOBS
    if(w.getEnvironment() == Environment.THE_END){
    String path = "World." + wrld + "." + "NumberOfMobs.ENDER_DRAGON";   
    config.addDefault(path, 4);
    path = "World." + wrld + "." + "NumberOfMobs.ENDERMAN";
    config.addDefault(path, 4);
    }
    
    //OTHER STUFF  
    String path19 = "World." + wrld + "." + "MobsSpawnedOnChunkLoad.ChanceOfSpawn";

    String path20 = "World." + wrld + "." + "MobsBurnInSunlight.ZOMBIE";
    
    String path21 = "World." + wrld + "." + "MobsBurnInSunlight.SKELETON";
    
    String path54 = "World." + wrld + "." + "SheepColor.allow";
    
    config.addDefault(path19, 5);
    config.addDefault(path20, 1);
    config.addDefault(path21, 1);
    config.addDefault(path54, 1);
	 
 }
    
    config.options().copyDefaults(true);  
    saveConfig();
}
public int getAmount(CreatureType type, World w){
    config = getConfig();
    String ty = type.toString();
    String wrld = w.getName();
    int amnt = config.getInt("World." + wrld + "." + "NumberOfMobs." + ty); 
    return amnt;
}
public int getChunkChance(World w){
    config = getConfig();
    String wrld = w.getName();
    int chance = config.getInt("World." + wrld + "." + "MobsSpawnedOnChunkLoad.ChanceOfSpawn"); 
    return chance;
}

public int getMobBurn(int number, World w){
    config = getConfig();
	CreatureType ty = CreatureType.SKELETON;
    if(number == 1){
    	ty = CreatureType.SKELETON;
    }
    if(number == 2){
    	ty = CreatureType.ZOMBIE;
    }
    String wrld = w.getName();
    int chance = config.getInt("World." + wrld + "." + "MobsBurnInSunlight." + ty); 
    return chance;
}
public int getColor(World w){
    config = getConfig();
    String wrld = w.getName();
    int amnt = config.getInt("World." + wrld + "." + "SheepColor.allow"); 
    return amnt;
}
public int getWorldId(World w){
    config = getConfig();
    String wrld = w.getName();
    int amnt = config.getInt("World." + wrld + "." + "WorldType.Type"); 
    return amnt;
}
}
