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

public class MainMenu implements Listener {
	
	public String name = "RASPBERRY PHONE v0.2";
	
	private static Inventory inv;
    private ItemStack back, home, options;
   
    public MainMenu() {
            inv = Bukkit.getServer().createInventory(null, 92, this.name);
           
            back = createWool(DyeColor.GREEN, ChatColor.GREEN + "BACK", "Get back once");
            home = createWool(DyeColor.YELLOW, ChatColor.YELLOW + "HOME", "Get back to home menu");
            options = createWool(DyeColor.RED, ChatColor.RED + "OPTIONS", "Configure your device");
           
            inv.setItem(85, back);
            inv.setItem(87, home);
            inv.setItem(89, options);
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
            
    	if (e.getCurrentItem().getItemMeta().getDisplayName().contains("BACK")) {
    		e.setCancelled(true);
    		//PLAYERAPI.GET("LAST KNOWN PLACE.PHONE");
    	}
            
    	if (e.getCurrentItem().getItemMeta().getDisplayName().contains("HOME")) {
    		e.setCancelled(true);
    		editItem(e.getCurrentItem(), "STARTED");
    		MainMenu.show((Player )e.getWhoClicked());
    	}
    	
    	if (e.getCurrentItem().getItemMeta().getDisplayName().contains("OPTIONS")) {
    		e.setCancelled(true);
    		editItem(e.getCurrentItem(), "STARTED");
    		//Options.show((Player )e.getWhoClicked());
    	}
    }
}
