package me.magicbar.gui;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SellGUI {
	
	@SuppressWarnings("deprecation")
	public static void CommonGUI(Player p)
	{
		Inventory inv = Bukkit.createInventory(null, 9, p.getName() + " Name");
		inv.setItem(0, getItem("매직바",Arrays.asList(ChatColor.AQUA + p.getName()), 403, 10, 1));
		inv.setItem(1, getItem("농부 상점열기",Arrays.asList(ChatColor.AQUA + "농부 상점을 엽니다"),Material.DIAMOND_HOE.getId(),0,1));
		p.openInventory(inv);
	}
	
	public static void FarmerGUI(Player p)
	{
		Inventory inv = Bukkit.createInventory(null, 27,"Farmer - GUI");
		inv.setItem(0, getItem("Farmer GUI",Arrays.asList("GUI made Test"),10,10,1));
		p.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack getItem(String name, List<String> lore, int id, int meta, int stack)
	{
		ItemStack item = new ItemStack(id, stack);
		item.setDurability((short)meta);
		ItemMeta _meta = item.getItemMeta();
		_meta.setDisplayName(name);
		_meta.setLore(lore);
		item.setItemMeta(_meta);
		
		return item;
	}
}
