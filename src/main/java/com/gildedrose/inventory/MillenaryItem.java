package com.gildedrose.inventory;
/**
 * Inherited class from Item class for millenary items
 * @author Ivan
 *
 */
public class MillenaryItem extends GenericItem{
	
	private String name;
    private int sellIn;
    private int quality;
    
    
	public MillenaryItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
	}
	
	/**
	 * Modify quality based on millenary items
	 */
	public void updateQuality() {
		//Modificable in the foreesable future
	}

	/**
	 * Decreases sell in date
	 */
	public void updateSellIn() {
		//Modificable in the foreesable future
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
