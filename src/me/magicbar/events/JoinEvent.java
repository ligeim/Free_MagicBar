package me.magicbar.events;

import java.io.File;
import java.util.Arrays;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.magicbar.gui.SellGUI;
import me.magicbar.money.MoneyManage;

public class JoinEvent implements Listener{
	File Folder;
	public JoinEvent(File Folder)
	{
		this.Folder = Folder;
	}
	
	@EventHandler
	public void PlayerJoinEvent(PlayerJoinEvent event)
	{
		if(!MoneyManage.Moneys.containsKey(event.getPlayer()))
		{
			MoneyManage.Moneys.put(event.getPlayer(), (Integer) 0);
			MoneyManage.save(Folder, event.getPlayer());
		}
		event.getPlayer().getInventory().addItem(SellGUI.getItem("test", Arrays.asList("FarmerGUI"), 403,0, 3));
		MoneyManage.AddMoney(Folder, event.getPlayer(), 1000);
		MoneyManage.save(Folder, event.getPlayer());
		MoneyManage.loadMoney(Folder, event.getPlayer());
	}
}
