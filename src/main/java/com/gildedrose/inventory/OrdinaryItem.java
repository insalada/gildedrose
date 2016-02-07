package com.gildedrose.inventory;
/**
 * Inherited class from Item class for ordinary items
 * @author Ivan
 *
 */
public class OrdinaryItem extends GenericItem{
	
	private String name;
    private int sellIn;
    private int quality;
    
	public OrdinaryItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
	}
	
	/**
	 * Degradates quality based on ordinary items degradation
	 */
	public void updateQuality() {
		for (int i=0; i<getIncrementFactor(sellIn); i++) {
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
