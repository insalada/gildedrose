package com.gildedrose.inventory;

/**
 * Inherited class from Item class for event passes items
 * @author Ivan
 *
 */
public class EventItem extends GenericItem{

	private String name;
	private int sellIn;
	private int quality;


	public EventItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	/**
	 * Increases quality based on event passes items degradation
	 */
	public void updateQuality() {
		if(sellIn < 0) {
			quality = Constants.MIN_QUALITY_ITEM;
		}else {
			for (int i=0; i<getIncrementFactor(); i++) {
				if(quality < Constants.MAX_QUALITY_ITEM) {
					quality += Constants.QUALITY_PROMOTION_DEFAULT;
				}
			}
		}
	}

	/**
	 * Decreases sell in date
	 */
	public void updateSellIn() {
		sellIn -= Constants.SELLIN_DEGRADATION_DEFAULT;
	}

	/**
	 * Determines how many times we need to increase the quality
	 * @return
	 */
	public int getIncrementFactor() {
		if(sellIn <= Constants.EVENT_PASSES_FIRST_INCREMENT_ON){
			if(sellIn <= Constants.EVENT_PASSES_SECOND_INCREMENT_ON){
				return Constants.QUALITY_PROMOTION_SECOND;
			}else{
				return Constants.QUALITY_PROMOTION_FIRST;
			}
		}else{
			return Constants.QUALITY_PROMOTION_DEFAULT;
		}
	}

	/**
	 * Getters and Setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSellIn() {
		return sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

}
