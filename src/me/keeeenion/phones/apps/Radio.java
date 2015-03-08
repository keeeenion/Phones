package me.keeeenion.phones.apps;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

public class Radio implements Listener {
	
	public String name = "Radio";
	
	private static Inventory inv;
    private ItemStack play, state, stop;
   
    public Radio() {
            inv = Bukkit.getServer().createInventory(null, 9, this.name);
           
            play = createWool(DyeColor.GREEN, ChatColor.GREEN + "PLAY", "Start the radio");
            state = createWool(DyeColor.YELLOW, ChatColor.YELLOW + "STATE", "PAUSED");
            stop = createWool(DyeColor.RED, ChatColor.RED + "STOP", "Stop the radio");
           
            inv.setItem(2, play);
            inv.setItem(4, state);
            inv.setItem(6, stop);
    }
   
    private ItemStack createWool(DyeColor dc, String name, String lore) {
            ItemStack i = new Wool(dc).toItemStack(1);
            ItemMeta im = i.getItemMeta();
            im.setDisplayName(name);
            im.setLore(Arrays.asList(lore));
            i.setItemMeta(im);
            return i;
    }
    
    private void editItem(ItemStack i, String lore) {
    	ItemMeta im = i.getItemMeta();
    	im.setLore(Arrays.asList(lore));
    }
   
    public static void show(Player p) {
            p.openInventory(inv);
    }
   
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
    	if (!(e.getWhoClicked() instanceof Player)) return;
    	if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
    	if (e.getCurrentItem().getItemMeta() == null) return;
            
    	if (e.getCurrentItem().getItemMeta().getDisplayName().contains("STOP")) {
    		e.setCancelled(true);
    		editItem(e.getCurrentItem(), "STOPPED");
    		startRadio((Player) e.getWhoClicked());
    	}
            
    	if (e.getCurrentItem().getItemMeta().getDisplayName().contains("PLAY")) {
    		e.setCancelled(true);
    		editItem(e.getCurrentItem(), "STARTED");
    		stopRadio((Player) e.getWhoClicked());
    	}
    }
    
    //FUNCTIONS
    
    public void startRadio(Player p) {
    	//SOME API STUFF HERE
    }
    
    public void stopRadio(Player p) {
    	//SOME API STUFF HERE
    }
	
}
