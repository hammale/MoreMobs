package me.hammale.MoreMobs;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Sheep;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.WorldListener;

public class MoreMobsChunkListener extends WorldListener {
    
        
	    public final MoreMobs plugin;
		
		public MoreMobsChunkListener(MoreMobs plugin) {
			this.plugin = plugin;
		}
		public void onChunkLoad(ChunkLoadEvent event){
			World w = event.getWorld();
		    int chance = plugin.getGiantChance(w);
		    int chunkAmount = plugin.getChunkChance(w);
		    
		    int bx = event.getChunk().getX()<<4;
			int bz = event.getChunk().getZ()<<4;
			
			Block b = w.getBlockAt(bx, 127, bz);
			int i = 1;
			Block down = b.getRelative(BlockFace.DOWN, 1);
			while (down.getType() == (Material.AIR)){
				 down = b.getRelative(BlockFace.DOWN, i);
				 i++;
			}
		    
		    if(chance != -1){			
			int ran = (int) (Math.random() * chance);
			if(ran == 0){
        	Location l = down.getLocation();
			w.spawnCreature(l, CreatureType.GIANT);			
			}
		    }
			if(chunkAmount != -1){
			int chance1 = (int) (Math.random() * chunkAmount);
			if(plugin.getWorldId(event.getWorld()) == 1 && chance1 == 0){
				int mob = (int) (Math.random() * 5);
				Location l = down.getLocation();
				World world = event.getWorld();
				CreatureType type = null;
				switch(mob) {
				case 0: type = CreatureType.CHICKEN;
				             break;
				case 1: type = CreatureType.COW;
				            break;
				case 2: type = CreatureType.PIG;
				            break;
				case 3: type = CreatureType.SHEEP;
				            break;
				case 4: type = CreatureType.WOLF;
				            break;
				}
				 
				world.spawnCreature(l, type);       
			}
			else if(plugin.getWorldId(event.getWorld()) == 2){
				//its the nether so we wont spawn anything...
				//that might cause NOTHING the spawn in the neather.. that can be good..
			}
			else{
				//someone didnt read the wiki on configuration...
				//TODO: add the End!!!		
			}
		}
	}
		public void sheepSpawner(World world, Location l, CreatureType type){
    		
			DyeColor color = DyeColor.WHITE;
    		int allow = plugin.getColor(world);
    		if(allow == 1){
    		Byte ran = (byte) (Math.random() * 15);
    		switch(ran) {
    		case 0:color = DyeColor.BROWN;      break;
    		case 1:color = DyeColor.WHITE;      break;
    		case 2:color = DyeColor.ORANGE;     break;
    		case 3:color = DyeColor.MAGENTA;    break;
    		case 4:color = DyeColor.LIGHT_BLUE; break;
    		case 5:color = DyeColor.YELLOW;     break;
    		case 6:color = DyeColor.LIME;       break;
    		case 7:color = DyeColor.PINK;       break;
    		case 8:color = DyeColor.GRAY;       break;
    		case 9:color = DyeColor.SILVER;     break;
    		case 10:color = DyeColor.CYAN;      break;
    		case 11:color = DyeColor.PURPLE;    break;
    		case 12:color = DyeColor.BLUE;      break;
    		case 13:color = DyeColor.GREEN;     break;
    		case 14:color = DyeColor.RED;       break;
    		case 15:color = DyeColor.BLACK;     break;
    		}
    		Sheep sheep = (Sheep) world.spawnCreature(l, type);     		
    		sheep.setColor(color);
    		}	
		}
}