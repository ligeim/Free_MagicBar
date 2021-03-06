package me.magicbar.main;

import java.io.File;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.magicbar.command.CommandMoney;
import me.magicbar.events.JoinEvent;
import me.magicbar.events.PlayerSellGUIEvent;
import me.magicbar.money.MoneyManage;

/*
 * MagicBar Project
 * By Gangguen
 * 
 * component
 * - 도박(보류)
 * - GUI
 *
 * - 나침반 - 어부
 * - 시계 - 농부
 * - CD - 광부
 * - ? - 요리사
 * - ? - 사냥꾼
 * - ? - 사육사
 * 
 * - 승리 조건
 * 
 * - 아ㅣ아ㅣㄹ나어란어ㅏㄹ너ㅏㅣ 승리
 * - 땅 다 잃을 경우 패배
 * - 땅을 강제로 사가지고 땅을 하나도 가지고 있지 않을 경우 마지막 땅을 가져간 사람에게 구속된다.
 * 
 * - 자본가 승리
 * - 돈모아서 아이템 사면 승리
 * 
 * - 탐험가 승리
 * - 맵에서 아이템을 모두 찾아 모으면 승리
 */

public class Main extends JavaPlugin implements Listener {
	
	public File Folder = new File(getDataFolder().getParentFile(), "\\Magicbar\\");
	
	//@SuppressWarnings("deprecation")
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new JoinEvent(Folder), this);
		getServer().getPluginManager().registerEvents(new PlayerSellGUIEvent(), this);
		getCommand("돈").setExecutor(new CommandMoney());
		
		for (Player p : Bukkit.getServer().getOnlinePlayers())
		{
			MoneyManage.loadMoney(Folder, p);
		}
		
		Bukkit.getLogger().info("매직바 플러그인 기동");	
		if (!Folder.exists())
			Folder.mkdirs();
	}
	
	@SuppressWarnings("deprecation")
	public void onDisable()
	{
		Bukkit.getLogger().info("매직바 플러그인 종료");
		
		for (Player p : Bukkit.getOnlinePlayers())
		{
			MoneyManage.save(Folder, p);
		}
	}
}
