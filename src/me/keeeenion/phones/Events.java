package me.keeeenion.phones;

import me.keeeenion.phones.apps.MainMenu;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Events implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if(e.getAction() != Action.RIGHT_CLICK_AIR || e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		if(e.getMaterial() != Material.CLAY_BRICK) return;
		if(!e.getMaterial().getData().getName().toLowerCase().contains("Phone")) return;
		MainMenu.show(e.getPlayer());
	}
	
}
