package com.Pandahyun.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.Pandahyun.Money.MoneyManage;

public class CommandMoney implements Listener, CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command label, String command, String[] args)
	{
		Player p = (Player) sender;
		p.sendMessage("hello");
		if(command.equals("돈"))
		{
			p.sendMessage("당신이 가지고 있는 돈은 : " + MoneyManage.Moneys.get(p));
			return true;
		}
		CommandHelp.CmdHelp(p);
		return false;
	}
	
	
}
