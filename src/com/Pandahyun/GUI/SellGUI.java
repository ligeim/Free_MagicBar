package com.Pandahyun.GUI;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class SellGUI {
	
	@SuppressWarnings("deprecation")
	public static void CommonGUI(Player p)
	{
		Inventory inv = Bukkit.createInventory(null, 9, p.getName() + " Name");
		inv.setItem(0, getItem("매직바",Arrays.asList(ChatColor.AQUA + p.getName()),403,10,1));
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
	public static ItemStack getItem(String name, List<String> lore, int ID, int Meta, int STACK)
	{
		ItemStack Item = new MaterialData(ID, (byte)Meta).toItemStack(STACK);
		ItemMeta meta = Item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lore);
		Item.setItemMeta(meta);
		
		return Item;
	}
}
