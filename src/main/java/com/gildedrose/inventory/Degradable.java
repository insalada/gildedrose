package com.gildedrose.inventory;

/**
 * Interface that defines degradable methods
 * @author Ivan
 *
 */
public interface Degradable {
	public void updateQuality();
	public void updateSellIn();
	
	/**
	 * Default method for determining quality units to increase/decrease
	 * @return the incremental factor
	 */
	public default int getIncrementFactor(int sellIn) {
		if(sellIn < Constants.MIN_SELLIN_ITEM){
			return Constants.QUALITY_DEGRADATION_EXPIRED;
		}else {
			return Constants.QUALITY_DEGRADATION_DEFAULT;
		}
	}
}
