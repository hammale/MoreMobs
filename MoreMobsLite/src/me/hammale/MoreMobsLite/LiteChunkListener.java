package me.hammale.MoreMobsLite;

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

public class LiteChunkListener extends WorldListener {
           
	    public final MobsLite plugin;
		
		public LiteChunkListener(MobsLite plugin) {
			this.plugin = plugin;
		}
		public void onChunkLoad(ChunkLoadEvent event){
			World w = event.getWorld();
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
				case 5: type = CreatureType.MUSHROOM_COW;
						break;
				case 6: type = CreatureType.VILLAGER;//LOL random villagers >:)
	            		break;
				case 7: type = CreatureType.CAVE_SPIDER;
						break;
				case 8: type = CreatureType.CREEPER;
						break;
				case 9: type = CreatureType.SILVERFISH;
						break;
				case 10: type = CreatureType.SKELETON;
						break;
				case 11: type = CreatureType.SLIME;
						break;
				case 12: type = CreatureType.SPIDER;
						break;
				case 13: type = CreatureType.ZOMBIE;
						break;
				case 14: type = CreatureType.SQUID;
						break;
				case 15: type = CreatureType.SNOWMAN;
						break;
				}
				world.spawnCreature(l, type);       
			}else if(plugin.getWorldId(event.getWorld()) == 2 && chance1 == 0){
				//NETHER
				int mob = (int) (Math.random() * 5);
				Location l = down.getLocation();
				World world = event.getWorld();
				CreatureType type = null;
				switch(mob) {
				case 0: type = CreatureType.GHAST;
				             break;
				case 1: type = CreatureType.PIG_ZOMBIE;
				            break;
				case 2: type = CreatureType.BLAZE;
				            break;
				case 3: type = CreatureType.MAGMA_CUBE;
				            break;
				}				 
				world.spawnCreature(l, type);  
			}else if(plugin.getWorldId(event.getWorld()) == 3 && chance1 == 0){
				//END
				int mob = (int) (Math.random() * 5);
				Location l = down.getLocation();
				World world = event.getWorld();
				CreatureType type = null;
				switch(mob) {
				case 0: type = CreatureType.ENDERMAN;
				             break;
				case 1: type = CreatureType.ENDER_DRAGON;
				            break;
				}				 
				world.spawnCreature(l, type);  
			}else{
				//someone didn't read the wiki on configuration...	
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