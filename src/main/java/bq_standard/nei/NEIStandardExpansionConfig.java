package bq_standard.nei;

import org.apache.logging.log4j.Level;

import bq_standard.core.BQ_Standard;
import codechicken.nei.api.IConfigureNEI;

public class NEIStandardExpansionConfig implements IConfigureNEI {
	@Override
	public String getName() {
		return "BQ " + BQ_Standard.NAME;
	}

	@Override
	public String getVersion() {
		return BQ_Standard.VERSION;
	}

	@Override
	public void loadConfig() {
		codechicken.nei.api.API.registerRecipeHandler(new bq_standard.nei.NEIRewardHandler());
		BQ_Standard.logger.log(Level.INFO, "Registered NEI handler for " + BQ_Standard.NAME);
	}
}
