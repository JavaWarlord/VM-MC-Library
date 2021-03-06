package com.valiantmarauders.minecraft.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * This class listens for a {@link Player} to click on a {@link Block} and
 * updates a {@link SelectionManager}
 * 
 * @author JavaWarlord
 * 
 */
public class PlayerClickBlockListener implements Listener {

	private BlockClickHandler handler;

	public PlayerClickBlockListener(BlockClickHandler handler) {
		// TODO Auto-generated constructor stub
		this.handler = handler;
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOW)
	public void onPlayerInteract(PlayerInteractEvent event) {
		Material material = null;
		// Check to see if the player has something in his hands
		if (event.getItem() != null) {
			material = event.getItem().getType();
			if (handler != null) {
				handler.notify(event.getPlayer(), event.getAction(), material,
						event.getClickedBlock());
			}
		}
	}
}
