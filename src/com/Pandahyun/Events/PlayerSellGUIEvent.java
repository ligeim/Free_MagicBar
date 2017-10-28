package com.Pandahyun.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerSellGUIEvent implements Listener{
	@EventHandler
	public void onUseSell(PlayerInteractEvent e)
	{
		Action action = e.getAction();
		if(e.getItem().hasItemMeta() &&
			(action == Action.RIGHT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK)
				&& (e.getItem().getItemMeta().getLore().contains("FarmerGUI")))
					com.Pandahyun.GUI.SellGUI.FarmerGUI(e.getPlayer());
	}
}
