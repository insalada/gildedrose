package com.gildedrose.inventory;

/**
 * This class provide methods appling Factory Pattern
 * @author Ivan
 *
 */
public class ItemFactory {
	
	/**
	 * This method will create the instance from the proper class based on object's name
	 * @param name
	 * @param sellIn
	 * @param quality
	 * @return a new instance that belongs the proper class
	 */
	public GenericItem getItem(Item item) {
		String name = item.getName();
		int sellIn = item.getSellIn();
		int quality = item.getQuality();
		if(name.contains(Constants.TYPE_FRESH)) {
			return new FreshItem(name, sellIn, quality);
		}else if(name.contains(Constants.TYPE_AGED)) {
			return new AgedItem(name, sellIn, quality);
		}else if(name.contains(Constants.TYPE_EVENT_PASS)) {
			return new EventItem(name, sellIn, quality);
		}else if(name.contains(Constants.TYPE_MILLENARY)) {
			return new MillenaryItem(name, sellIn, quality);
		}else {
			return new OrdinaryItem(name, sellIn, quality);
		}
	}

}
