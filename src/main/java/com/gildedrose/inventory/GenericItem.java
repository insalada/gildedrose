package com.gildedrose.inventory;

/**
 * Abstract class that defines how an Item must be
 * @author Ivan
 *
 */
public abstract class GenericItem extends Item implements Degradable{
	private String name;
    private int sellIn;
    private int quality;
    
	public GenericItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
	}


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
