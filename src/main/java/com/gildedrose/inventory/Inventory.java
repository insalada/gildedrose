package com.gildedrose.inventory;

public class Inventory {
	private Item[] items;

	/**
	 * Constructor that boxing an array of Items
	 * @param items
	 */
	public Inventory(Item[] items) {
		super();
		this.items = items;
	}

	/**
	 * Default constructor
	 */
	public Inventory() {
		super();
		items = new Item[]{
				new Item("Ordinary food", 10, 20),
				new Item("Aged Cheese", 2, 0),
				new Item("Ordinary drink", 5, 7),
				new Item("Millenary Honey", 0, 80),
				new Item("VIP special event passes", 15, 20),
				new Item("Fresh food", 3, 6)
		};

	}

	/**
	 * Alters the items quality
	 */
	public void updateQuality() {
		for(Item item: items) {
			//Instance Item Factory
			ItemFactory factory = new ItemFactory();
			//Invoke Factory creator
			GenericItem currentItem = factory.getItem(item);
			//Update product quality
			currentItem.updateQuality();
			//Update product sell in
			currentItem.updateSellIn();
			//Keep the items array structure so we do not change cto's array
			item.setQuality(currentItem.getQuality());
			item.setSellIn(currentItem.getSellIn());
		}
	}
}
