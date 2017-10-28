package com.Pandahyun.Money;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class MoneyManage {
	
	public static HashMap<Player, Integer> Moneys = new HashMap<Player, Integer>();
	
	public static void save(File Folder, Player p)
	{
		FileWriter fw;
		try
		{
			File pf = new File(Folder, "\\Money\\" + p.getName() + ".mgm");
			if(!pf.exists())
			{
				pf.getParentFile().mkdirs();
				if(!pf.createNewFile())
					p.sendMessage(pf.getPath());
			}
			fw = new FileWriter(pf);
			BufferedWriter bf = new BufferedWriter(fw);
			bf.write(p.getName() + "\n" + Moneys.get(p));
			bf.flush();
			bf.close();
		}
		catch (IOException e)
		{
			p.sendMessage(e.getMessage() + "file making error");
		}
	}
	
	public static int loadMoney(File Folder, Player p)
	{
		try {
			FileReader fr = new FileReader(new File(Folder, "Money\\" + p.getName() + ".mgm"));
			BufferedReader br = new BufferedReader(fr);
			try {
				br.readLine();
				int temp =Integer.parseInt(br.readLine());
				br.close();
				Moneys.put(p, temp);
				return temp;
			} catch (IOException e) {
				p.sendMessage("loadMoney IOExceptionError");
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			p.sendMessage("FileNotFoundError");
		}
		
		return -1;
	}
	
	public static void AddMoney(File Folder, Player p, int money)
	{
		int temp = Moneys.get(p);
		temp += money;
		Moneys.put(p, temp);
	}
}
