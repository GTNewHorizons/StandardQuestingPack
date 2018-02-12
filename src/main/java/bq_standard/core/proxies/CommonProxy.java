package bq_standard.core.proxies;

import bq_standard.client.gui.UpdateNotification;
import bq_standard.handlers.ConfigHandler;
import bq_standard.rewards.loot.LootRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy
{
	public boolean isClient()
	{
		return false;
	}

	public void registerHandlers()
	{
		FMLCommonHandler.instance().bus().register(new UpdateNotification());
		FMLCommonHandler.instance().bus().register(new ConfigHandler());
		MinecraftForge.EVENT_BUS.register(new LootRegistry());
	}

	public void registerThemes()
	{
	}
}
