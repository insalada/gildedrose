package com.gildedrose.inventory;

/**
 * Inherited class from Item class for fresh items
 * @author Ivan
 *
 */
public class FreshItem extends GenericItem{
	
	private String name;
    private int sellIn;
    private int quality;
    
    
	public FreshItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
	}
	
	/**
	 * Degradates quality based on fresh items degradation
	 */
	public void updateQuality() {				
		for (int i=0; i<getIncrementFactor(); i++) {
			if(quality > Constants.MIN_QUALITY_ITEM) {
				quality -= Constants.QUALITY_DEGRADATION_DEFAULT;
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
	 * Determines how many times we need to increase/decrease the quality
	 * @return the incremental factor
	 */
	public int getIncrementFactor() {
		if(sellIn < Constants.MIN_SELLIN_ITEM){
			return Constants.QUALITY_DEGRADATION_EXPIRED * Constants.QUALITY_DEGRADATION_FRESH;
		}else {
			return Constants.QUALITY_DEGRADATION_FRESH;
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
