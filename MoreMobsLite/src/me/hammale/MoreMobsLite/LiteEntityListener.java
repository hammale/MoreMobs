package me.hammale.MoreMobsLite;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityListener;;

public class LiteEntityListener extends EntityListener {
	        
    public final MobsLite plugin;
	public FileConfiguration config;
	
	        public LiteEntityListener(MobsLite plugin)
	        {
	          this.plugin = plugin;
	        }
	        
	        public void onEntityCombust(EntityCombustEvent e)
	        {
        		if(e.getEntity() instanceof LivingEntity) {
	        	int i = 1;
	        	int j = 2;
	        	LivingEntity entity = (LivingEntity) e.getEntity();
	        	if(entity instanceof Skeleton) {
	        		World w = entity.getWorld();
		        	int allow = plugin.getMobBurn(i, w);
		        	if(allow == 1){
		        	e.setCancelled(true);
		        	}
	        	}
	        	if(entity instanceof Zombie) {
	        		World w = entity.getWorld();
		        	int allow = plugin.getMobBurn(j, w);
		        	if(allow == 1){
		        	e.setCancelled(true);
		        	}
	        	}
        		}
	        }
	        
	        public void onCreatureSpawn(CreatureSpawnEvent e)
	        {
	        	SpawnReason reason = e.getSpawnReason();
	        	CreatureType type = e.getCreatureType();
				if(type == CreatureType.SHEEP){
					World w = e.getEntity().getWorld();
					Location l = e.getLocation();
					int allow = plugin.getColor(w);
		    		if(allow == 1){
		    			colorSheep(w, l, type, e.getEntity());
		    		}
				}
				
	        	if (reason.toString().equals("NATURAL")){     
	        	Location l = e.getLocation();
				World world = l.getWorld();
							   								
				int i = 0;
				World w = e.getEntity().getWorld();
		       	int amnt = plugin.getAmount(type, w);
		       	if(amnt == -1){
		       		e.setCancelled(true);
		       		
				while(i < amnt){
					world.spawnCreature(l, type);
					i++;
				}
			}          			
	       }	      	
	    }
        	public void sheepSpawner(World world, Location l, CreatureType type){
        		
        		DyeColor color = null;
        		int allow = plugin.getColor(world);
        		if(allow == 1){
        		Byte ran = (byte) (Math.random() * 15);
        		
        		switch(ran){
        		case 0:color = DyeColor.WHITE; break;
        		case 1:color = DyeColor.ORANGE; break;
        		case 2:color = DyeColor.MAGENTA; break;
        		case 3:color = DyeColor.LIGHT_BLUE; break;
        		case 4:color = DyeColor.LIME; break;
        		case 5:color = DyeColor.PINK; break;
        		case 6:color = DyeColor.GRAY; break;
        		case 7:color = DyeColor.SILVER; break;
        		case 8:color = DyeColor.CYAN; break;
        		case 9:color = DyeColor.PURPLE; break;
        		case 10:color = DyeColor.BLUE; break;
        		case 11:color = DyeColor.BROWN; break;
        		case 12:color = DyeColor.GREEN; break;
        		case 13:color = DyeColor.RED; break;
        		case 14:color = DyeColor.BLACK; break;
        		case 15:color = DyeColor.YELLOW; break;
        		}
        		Sheep sheep = (Sheep) world.spawnCreature(l, type);     		
        		sheep.setColor(color);       		
        		//Sheep sheep = spawnedSheep.get(0);
        		}
        	}
            public void colorSheep(World world, Location l, CreatureType type, Entity e){
        		
        		DyeColor color = DyeColor.WHITE;
        		int allow = plugin.getColor(world);
        		if(allow == 1){
        		Byte ran = (byte) (Math.random() * 15);
        		switch(ran){
        		case 0:color = DyeColor.WHITE; break;
        		case 1:color = DyeColor.ORANGE; break;
        		case 2:color = DyeColor.MAGENTA; break;
        		case 3:color = DyeColor.LIGHT_BLUE; break;
        		case 4:color = DyeColor.LIME; break;
        		case 5:color = DyeColor.PINK; break;
        		case 6:color = DyeColor.GRAY; break;
        		case 7:color = DyeColor.SILVER; break;
        		case 8:color = DyeColor.CYAN; break;
        		case 9:color = DyeColor.PURPLE; break;
        		case 10:color = DyeColor.BLUE; break;
        		case 11:color = DyeColor.BROWN; break;
        		case 12:color = DyeColor.GREEN; break;
        		case 13:color = DyeColor.RED; break;
        		case 14:color = DyeColor.BLACK; break;
        		case 15:color = DyeColor.YELLOW; break;
        		}
        		Sheep sheep = (Sheep) e;     		
        		sheep.setColor(color);
        		}
        	}
}	            	                	             