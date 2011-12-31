package me.hammale.MoreMobs;

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

public class MoreMobs extends JavaPlugin
{
	// logging function
	public Logger log = Logger.getLogger("Minecraft");
	protected void logMessage (String msg) {
	this.log.info("[MoreMobs]" + msg);
	}
	public FileConfiguration config;
	
  private final MoreMobsEntityListener entityListener = new MoreMobsEntityListener(this);
  private final MoreMobsChunkListener chunkListener = new MoreMobsChunkListener(this);
  
  public void onEnable()
  {
	    
	  	loadConfiguration();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.ENTITY_DAMAGE, this.entityListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.CREATURE_SPAWN, this.entityListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.CHUNK_LOAD, this.chunkListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.ENTITY_COMBUST, this.entityListener, Event.Priority.Low, this);
        log.info("[moremobs] enabled!");
  }
public void onDisable() {
    log.info("[moremobs] disabled!");
}


public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	if(cmd.getName().equalsIgnoreCase("mmreload")){
		reloadConfig();
		sender.sendMessage(ChatColor.LIGHT_PURPLE + "MoreMobs Reloaded!");
		if(sender.getName() == "CONSOLE") {
			log.info("[moremobs] reloaded by the console");
		}
		else{
			log.info("[moremobs] reloaded by " + sender.getName());
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
    
    if(w.getEnvironment() != Environment.NETHER){
    	
    String path0 = "World." + wrld + "." + "WorldType.Type";
    
    String path = "World." + wrld + "." + "NumberOfMobs.CAVE_SPIDER";
    
    String path1 = "World." + wrld + "." + "NumberOfMobs.CHICKEN";
    
    String path2 = "World." + wrld + "." + "NumberOfMobs.COW";
    
    String path3 = "World." + wrld + "." + "NumberOfMobs.CREEPER";
    
    String path4 = "World." + wrld + "." + "NumberOfMobs.ENDERMAN";
    
    String path5 = "World." + wrld + "." + "NumberOfMobs.GHAST";
    
    String path8 = "World." + wrld + "." + "NumberOfMobs.PIG";
    
    String path9 = "World." + wrld + "." + "NumberOfMobs.PIG_ZOMBIE";
    
    String path10 = "World." + wrld + "." + "NumberOfMobs.SHEEP";
    
    String path11 = "World." + wrld + "." + "NumberOfMobs.SILVERFISH";
    
    String path12 = "World." + wrld + "." + "NumberOfMobs.SKELETON";
    
    String path13 = "World." + wrld + "." + "NumberOfMobs.SLIME";
    
    String path14 = "World." + wrld + "." + "NumberOfMobs.SPIDER";
    
    String path15 = "World." + wrld + "." + "NumberOfMobs.SQUID";
    
    String path16 = "World." + wrld + "." + "NumberOfMobs.WOLF";
    
    String path17 = "World." + wrld + "." + "NumberOfMobs.ZOMBIE";
    
    String path18 = "World." + wrld + "." + "Giants.ChanceOfSpawn";
    
    String path19 = "World." + wrld + "." + "MobsSpawnedOnChunkLoad.ChanceOfSpawn";

    String path20 = "World." + wrld + "." + "MobsBurnInSunlight.ZOMBIE";
    
    String path21 = "World." + wrld + "." + "MobsBurnInSunlight.SKELETON";
    
    String path22 = "World." + wrld + "." + "MobHealth.CAVE_SPIDER";
    
    String path23 = "World." + wrld + "." + "MobHealth.CHICKEN";
    
    String path24 = "World." + wrld + "." + "MobHealth.COW";
    
    String path25 = "World." + wrld + "." + "MobHealth.CREEPER";
    
    String path26 = "World." + wrld + "." + "MobHealth.ENDERMAN";
    
    String path27 = "World." + wrld + "." + "MobHealth.GHAST";
    
    String path28 = "World." + wrld + "." + "MobHealth.PIG";
    
    String path29 = "World." + wrld + "." + "MobHealth.PIG_ZOMBIE";
    
    String path30 = "World." + wrld + "." + "MobHealth.SHEEP";
    
    String path31 = "World." + wrld + "." + "MobHealth.SILVERFISH";
    
    String path32 = "World." + wrld + "." + "MobHealth.SKELETON";
    
    String path33 = "World." + wrld + "." + "MobHealth.SLIME";
    
    String path34 = "World." + wrld + "." + "MobHealth.SPIDER";
    
    String path35 = "World." + wrld + "." + "MobHealth.SQUID";
    
    String path36 = "World." + wrld + "." + "MobHealth.WOLF";
    
    String path37 = "World." + wrld + "." + "MobHealth.ZOMBIE";
    
    String path56 = "World." + wrld + "." + "MobHealth.GIANT";    
    
    String path38 = "World." + wrld + "." + "MobDamage.CAVE_SPIDER";
    
    String path41 = "World." + wrld + "." + "MobDamage.CREEPER";
    
    String path42 = "World." + wrld + "." + "MobDamage.ENDERMAN";
    
    String path43 = "World." + wrld + "." + "MobDamage.GHAST";
    
    String path45 = "World." + wrld + "." + "MobDamage.PIG_ZOMBIE";
    
    String path47 = "World." + wrld + "." + "MobDamage.SILVERFISH";
    
    String path48 = "World." + wrld + "." + "MobDamage.SKELETON";
    
    String path49 = "World." + wrld + "." + "MobDamage.SLIME";
    
    String path50 = "World." + wrld + "." + "MobDamage.SPIDER";
        
    String path52 = "World." + wrld + "." + "MobDamage.WOLF";
    
    String path53 = "World." + wrld + "." + "MobDamage.ZOMBIE";
    
    String path55 = "World." + wrld + "." + "MobDamage.GIANT";
    
    String path54 = "World." + wrld + "." + "SheepColor.allow";
    
    config.addDefault(path0, 1);
    config.addDefault(path, 4);
    config.addDefault(path1, 4);
    config.addDefault(path2, 4);
    config.addDefault(path3, 4);
    config.addDefault(path4, 4);
    config.addDefault(path5, 4);
    config.addDefault(path8, 4);
    config.addDefault(path9, 4);
    config.addDefault(path10, 4);
    config.addDefault(path11, 4);
    config.addDefault(path12, 4);
    config.addDefault(path13, 4);
    config.addDefault(path14, 4);
    config.addDefault(path15, 4);
    config.addDefault(path16, 4);
    config.addDefault(path17, 4);
    config.addDefault(path19, 5);
    config.addDefault(path18, 200);
    config.addDefault(path20, 1);
    config.addDefault(path21, 1);
    
    config.addDefault(path22, -1);
    config.addDefault(path23, -1);
    config.addDefault(path24, -1);
    config.addDefault(path25, -1);
    config.addDefault(path26, -1);
    config.addDefault(path27, -1);
    config.addDefault(path28, -1);
    config.addDefault(path29, -1);
    config.addDefault(path30, -1);
    config.addDefault(path31, -1);
    config.addDefault(path32, -1);
    config.addDefault(path33, -1);
    config.addDefault(path34, -1);
    config.addDefault(path35, -1);
    config.addDefault(path36, -1);
    config.addDefault(path37, -1);
    
    config.addDefault(path38, -1);
    config.addDefault(path41, -1);
    config.addDefault(path42, -1);
    config.addDefault(path43, -1);
    config.addDefault(path45, -1);
    config.addDefault(path47, -1);
    config.addDefault(path48, -1);
    config.addDefault(path49, -1);
    config.addDefault(path50, -1);
    config.addDefault(path52, -1); 
    config.addDefault(path53, -1);
    config.addDefault(path54, 1);
    }else{  	
    	
    	 String path0 = "World." + wrld + "." + "WorldType.Type";
    	    
    	    String path = "World." + wrld + "." + "NumberOfMobs.CAVE_SPIDER";
    	    
    	    String path1 = "World." + wrld + "." + "NumberOfMobs.CHICKEN";
    	    
    	    String path2 = "World." + wrld + "." + "NumberOfMobs.COW";
    	    
    	    String path3 = "World." + wrld + "." + "NumberOfMobs.CREEPER";
    	    
    	    String path4 = "World." + wrld + "." + "NumberOfMobs.ENDERMAN";
    	    
    	    String path5 = "World." + wrld + "." + "NumberOfMobs.GHAST";
    	    
    	    String path8 = "World." + wrld + "." + "NumberOfMobs.PIG";
    	    
    	    String path9 = "World." + wrld + "." + "NumberOfMobs.PIG_ZOMBIE";
    	    
    	    String path10 = "World." + wrld + "." + "NumberOfMobs.SHEEP";
    	    
    	    String path11 = "World." + wrld + "." + "NumberOfMobs.SILVERFISH";
    	    
    	    String path12 = "World." + wrld + "." + "NumberOfMobs.SKELETON";
    	    
    	    String path13 = "World." + wrld + "." + "NumberOfMobs.SLIME";
    	    
    	    String path14 = "World." + wrld + "." + "NumberOfMobs.SPIDER";
    	    
    	    String path15 = "World." + wrld + "." + "NumberOfMobs.SQUID";
    	    
    	    String path16 = "World." + wrld + "." + "NumberOfMobs.WOLF";
    	    
    	    String path17 = "World." + wrld + "." + "NumberOfMobs.ZOMBIE";
    	    
    	    String path18 = "World." + wrld + "." + "Giants.ChanceOfSpawn";
    	    
    	    String path19 = "World." + wrld + "." + "MobsSpawnedOnChunkLoad.ChanceOfSpawn";

    	    String path20 = "World." + wrld + "." + "MobsBurnInSunlight.ZOMBIE";
    	    
    	    String path21 = "World." + wrld + "." + "MobsBurnInSunlight.SKELETON";
    	    
    	    String path22 = "World." + wrld + "." + "MobHealth.CAVE_SPIDER";
    	    
    	    String path23 = "World." + wrld + "." + "MobHealth.CHICKEN";
    	    
    	    String path24 = "World." + wrld + "." + "MobHealth.COW";
    	    
    	    String path25 = "World." + wrld + "." + "MobHealth.CREEPER";
    	    
    	    String path26 = "World." + wrld + "." + "MobHealth.ENDERMAN";
    	    
    	    String path27 = "World." + wrld + "." + "MobHealth.GHAST";
    	    
    	    String path28 = "World." + wrld + "." + "MobHealth.PIG";
    	    
    	    String path29 = "World." + wrld + "." + "MobHealth.PIG_ZOMBIE";
    	    
    	    String path30 = "World." + wrld + "." + "MobHealth.SHEEP";
    	    
    	    String path31 = "World." + wrld + "." + "MobHealth.SILVERFISH";
    	    
    	    String path32 = "World." + wrld + "." + "MobHealth.SKELETON";
    	    
    	    String path33 = "World." + wrld + "." + "MobHealth.SLIME";
    	    
    	    String path34 = "World." + wrld + "." + "MobHealth.SPIDER";
    	    
    	    String path35 = "World." + wrld + "." + "MobHealth.SQUID";
    	    
    	    String path36 = "World." + wrld + "." + "MobHealth.WOLF";
    	    
    	    String path37 = "World." + wrld + "." + "MobHealth.ZOMBIE";
    	    
    	    String path56 = "World." + wrld + "." + "MobHealth.GIANT";    
    	    
    	    String path38 = "World." + wrld + "." + "MobDamage.CAVE_SPIDER";
    	    
    	    String path41 = "World." + wrld + "." + "MobDamage.CREEPER";
    	    
    	    String path42 = "World." + wrld + "." + "MobDamage.ENDERMAN";
    	    
    	    String path43 = "World." + wrld + "." + "MobDamage.GHAST";
    	    
    	    String path45 = "World." + wrld + "." + "MobDamage.PIG_ZOMBIE";
    	    
    	    String path47 = "World." + wrld + "." + "MobDamage.SILVERFISH";
    	    
    	    String path48 = "World." + wrld + "." + "MobDamage.SKELETON";
    	    
    	    String path49 = "World." + wrld + "." + "MobDamage.SLIME";
    	    
    	    String path50 = "World." + wrld + "." + "MobDamage.SPIDER";
    	        
    	    String path52 = "World." + wrld + "." + "MobDamage.WOLF";
    	    
    	    String path53 = "World." + wrld + "." + "MobDamage.ZOMBIE";
    	    
    	    String path55 = "World." + wrld + "." + "MobDamage.GIANT";
    	    
    	    String path54 = "World." + wrld + "." + "SheepColor.allow";
    	    
    	    config.addDefault(path0, 2);
    	    config.addDefault(path, 4);
    	    config.addDefault(path1, 4);
    	    config.addDefault(path2, 4);
    	    config.addDefault(path3, 4);
    	    config.addDefault(path4, 4);
    	    config.addDefault(path5, 4);
    	    config.addDefault(path8, 4);
    	    config.addDefault(path9, 4);
    	    config.addDefault(path10, 4);
    	    config.addDefault(path11, 4);
    	    config.addDefault(path12, 4);
    	    config.addDefault(path13, 4);
    	    config.addDefault(path14, 4);
    	    config.addDefault(path15, 4);
    	    config.addDefault(path16, 4);
    	    config.addDefault(path17, 4);
    	    config.addDefault(path19, 5);
    	    config.addDefault(path18, 200);
    	    config.addDefault(path20, 1);
    	    config.addDefault(path21, 1);
    	    
    	    config.addDefault(path22, -1);
    	    config.addDefault(path23, -1);
    	    config.addDefault(path24, -1);
    	    config.addDefault(path25, -1);
    	    config.addDefault(path26, -1);
    	    config.addDefault(path27, -1);
    	    config.addDefault(path28, -1);
    	    config.addDefault(path29, -1);
    	    config.addDefault(path30, -1);
    	    config.addDefault(path31, -1);
    	    config.addDefault(path32, -1);
    	    config.addDefault(path33, -1);
    	    config.addDefault(path34, -1);
    	    config.addDefault(path35, -1);
    	    config.addDefault(path36, -1);
    	    config.addDefault(path37, -1);
    	    
    	    config.addDefault(path38, -1);
    	    config.addDefault(path41, -1);
    	    config.addDefault(path42, -1);
    	    config.addDefault(path43, -1);
    	    config.addDefault(path45, -1);
    	    config.addDefault(path47, -1);
    	    config.addDefault(path48, -1);
    	    config.addDefault(path49, -1);
    	    config.addDefault(path50, -1);
    	    config.addDefault(path52, -1); 
    	    config.addDefault(path53, -1);
    	    config.addDefault(path54, 1);
    	
    	
 }
	 
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

public int getGiantChance(World w){
    config = getConfig();
    String wrld = w.getName();
    int chance = config.getInt("World." + wrld + "." + "Giants.ChanceOfSpawn"); 
    return chance;
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
public int getHealth(CreatureType type, World w){
    config = getConfig();
    String ty = type.toString();
    String wrld = w.getName();
    int amnt = config.getInt("World." + wrld + "." + "MobHealth." + ty); 
    return amnt;
}
public int getDamage(CreatureType type, World w){
    config = getConfig();
    String ty = type.toString();
    String wrld = w.getName();
    int amnt = config.getInt("World." + wrld + "." + "MobDamage." + ty); 
    return amnt;
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
