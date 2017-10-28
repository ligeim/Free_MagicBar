package com.Pandahyun.Command;

import org.bukkit.entity.Player;

public class CommandHelp {
	public static void CmdHelp(Player p)
	{
		p.sendMessage("----매직바 도움말----");
		p.sendMessage("/돈");
		p.sendMessage("/땅"); // 내가 가지고 있는 땅 보기
		p.sendMessage("/은행");
		p.sendMessage("/부동산"); // 아이템을 살때
	}
}
