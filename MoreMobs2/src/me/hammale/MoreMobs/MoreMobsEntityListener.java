package me.hammale.MoreMobs;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.inventory.ItemStack;

public class MoreMobsEntityListener extends EntityListener {
	        
    public final MoreMobs plugin;
	public FileConfiguration config;
	
	        public MoreMobsEntityListener(MoreMobs plugin)
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
	          	if(e.getEntity() instanceof LivingEntity){
		        	LivingEntity entity = (LivingEntity) e.getEntity();
	        		World w = entity.getWorld();
		        	int h = plugin.getHealth(type, w);
		        	if(!(h == -1)){
		        	if( h != 0){
		        	entity.setHealth(h);
		        	}else if( h == 0){
		        	entity.setHealth(1);	
		        	}
		        	}
	          	}
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
        		//Sheep sheep = spawnedSheep.get(0);
        		}
        	}
        	@Override
        	public void onEntityDamage(EntityDamageEvent e) {
        		if(e.getEntity() instanceof LivingEntity) {
		        	int health = ((LivingEntity) e.getEntity()).getHealth();
	        		Entity entity = e.getEntity();
	        		CreatureType type = null;
	        		
		        	if     (entity instanceof CaveSpider) {type = CreatureType.CAVE_SPIDER;}
		        	else if(entity instanceof Spider)     {type = CreatureType.SPIDER;}
		        	else if(entity instanceof Cow)        {type = CreatureType.COW;}
		        	else if(entity instanceof Pig)        {type = CreatureType.PIG;}
		        	else if(entity instanceof Skeleton)   {type = CreatureType.SKELETON;}
		        	else if(entity instanceof PigZombie)  {type = CreatureType.PIG_ZOMBIE;}
		        	else if(entity instanceof Slime)      {type = CreatureType.SLIME;}
		        	else if(entity instanceof Zombie)     {type = CreatureType.ZOMBIE;}
		        	else if(entity instanceof Giant)      {type = CreatureType.GIANT;}
		        	else if(entity instanceof Sheep)      {type = CreatureType.SHEEP;}
		        	else if(entity instanceof Enderman)   {type = CreatureType.ENDERMAN;}
		        	else if(entity instanceof Silverfish) {type = CreatureType.SILVERFISH;}
		        	else if(entity instanceof Creeper)    {type = CreatureType.CREEPER;}
		        	else if(entity instanceof Squid)      {type = CreatureType.SQUID;}
		        	else if(entity instanceof Wolf)       {type = CreatureType.WOLF;}
		        	else if(entity instanceof Ghast)      {type = CreatureType.GHAST;}
		        	else                                  {type = CreatureType.CHICKEN; }
		        	
//		        	int h = plugin.getHealth(type);
//		        	/System.out.println(h);		        	
					 if (e.getEntity() instanceof Player) {
				            if (e.getCause().equals(DamageCause.ENTITY_ATTACK)) {
//					        	int h1 = ((LivingEntity) e.getEntity()).getHealth();
//					        	int damage = ((LivingEntity) e.getEntity()).getLastDamage();
//					        	int newhealth = damage+h1;
//					        	//int newhealth = h1-damage;
//					        	((LivingEntity) e.getEntity()).setHealth(newhealth);
//					        	
					        	
					        	EntityDamageByEntityEvent attackEvent = (EntityDamageByEntityEvent) e;
			                    Entity ae = attackEvent.getDamager();					        	
				        		
			                    CreatureType tpe = CreatureType.CAVE_SPIDER;
			                    World w = entity.getWorld();
					        	int d = plugin.getDamage(tpe, w);
					        	int h1 = ((LivingEntity) e.getEntity()).getHealth();
			                    
					        	if(ae instanceof CaveSpider) {
					        		
						        	tpe = CreatureType.CAVE_SPIDER;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Spider) {

						        	tpe = CreatureType.SPIDER;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Skeleton) {

						        	tpe = CreatureType.SKELETON;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof PigZombie) {

						        	tpe = CreatureType.PIG_ZOMBIE;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Slime) {

						        	tpe = CreatureType.SLIME;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Zombie) {
						        	tpe = CreatureType.ZOMBIE;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Giant) {

						        	tpe = CreatureType.GIANT;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Enderman) {

						        	tpe = CreatureType.ENDERMAN;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Silverfish) {

						        	tpe = CreatureType.SILVERFISH;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Creeper) {

						        	tpe = CreatureType.CREEPER;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Wolf) {

						        	tpe = CreatureType.WOLF;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	if(ae instanceof Ghast) {

						        	tpe = CreatureType.GHAST;
						        	w = entity.getWorld();
						        	 d = plugin.getDamage(tpe, w);
						        	 if(!(d == -1)){
							        //e.setCancelled(true);
						        	 int damage = e.getDamage();
						        	 h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	 int newhealth = damage+h1;
						        	 Player player = (Player) e.getEntity();
						        	 int finalhealth = newhealth;
						        	 
						        	 ItemStack hel = player.getInventory().getHelmet();
						        	 ItemStack cst = player.getInventory().getChestplate();
						        	 ItemStack leg = player.getInventory().getLeggings();
						        	 ItemStack bot = player.getInventory().getBoots();
						        	 int i = 0;
						        	 if(hel != null || cst != null || leg != null || bot != null ){
						        		 if (cst.getType() == Material.CHAINMAIL_CHESTPLATE || cst.getType() == Material.GOLD_CHESTPLATE || cst.getType() == Material.IRON_CHESTPLATE || cst.getType() == Material.LEATHER_CHESTPLATE || cst.getType() == Material.DIAMOND_CHESTPLATE) {
							                 finalhealth = newhealth+8;	
							                
							                
						        		 }else if (leg.getType() == Material.CHAINMAIL_LEGGINGS || leg.getType() == Material.GOLD_LEGGINGS || leg.getType() == Material.IRON_LEGGINGS || leg.getType() == Material.LEATHER_LEGGINGS || leg.getType() == Material.DIAMOND_LEGGINGS) {
							                finalhealth = newhealth+6;	
							               
							               
						        		 }else if (bot.getType() == Material.CHAINMAIL_BOOTS || bot.getType() == Material.GOLD_BOOTS || bot.getType() == Material.IRON_BOOTS || bot.getType() == Material.LEATHER_BOOTS || bot.getType() == Material.DIAMOND_BOOTS) {
							                 finalhealth = newhealth+3;		
							                
							        	}
						        		 if (hel.getType() == Material.CHAINMAIL_HELMET || hel.getType() == Material.GOLD_HELMET || hel.getType() == Material.IRON_HELMET || hel.getType() == Material.LEATHER_HELMET || hel.getType() == Material.DIAMOND_HELMET) {
							                 finalhealth = newhealth+3;	
							                
							                
							        		 }
						        	 }else{
							        		finalhealth = newhealth;

							        		
							        	}						             					        							        	 
						        	if(h1-d >= 0 && h1-d <= 200){
						        	((LivingEntity) e.getEntity()).setHealth(finalhealth-d);
						        	}else if (h1-d <= 0){
						        	((LivingEntity) e.getEntity()).setHealth(0);
						        	}else if (h1-d >= 200){
							        ((LivingEntity) e.getEntity()).setHealth(200);
							        }
						        	h1 = ((LivingEntity) e.getEntity()).getHealth();
						        	
						        	 }						        	
						        }
					        	//TOTAL HUMAN HEALTH 20
					        	//0.5 HEART = 1
				            }
					 }
		        	
		        	
//		        	if(h == 2){
//		        		health = ((LivingEntity) entity).getHealth();
//			        	((LivingEntity) entity).setHealth(health/2);
//			        	health = ((LivingEntity) entity).getHealth();
//		        	}
		        	
		        	
        		//System.out.println(health);
        		}
        		}
}	            	                	             