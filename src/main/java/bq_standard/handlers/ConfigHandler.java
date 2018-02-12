package bq_standard.handlers;

import org.apache.logging.log4j.Level;

import bq_standard.core.BQS_Settings;
import bq_standard.core.BQ_Standard;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	public static Configuration config;

	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(BQ_Standard.MODID)) {
			initConfigs();
		}
	}

	public static void initConfigs() {
		if (config == null) {
			BQ_Standard.logger.log(Level.ERROR, "Config attempted to be loaded before it was initialised!");
			return;
		}

		BQS_Settings.hideUpdates = config.getBoolean("Hide Updates", Configuration.CATEGORY_GENERAL, false, "Hide update notifications");
		BQS_Settings.registerNEIQuestRewards = config.getBoolean("Register NEI Quest Rewards", Configuration.CATEGORY_GENERAL, true, "Register NEI Quest Rewards");

		config.save();

		BQ_Standard.logger.log(Level.INFO, "Loaded configs...");
	}
}
