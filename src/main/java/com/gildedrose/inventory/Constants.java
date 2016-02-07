package com.gildedrose.inventory;

public class Constants {
	
	//Properties
	public static final int MIN_QUALITY_ITEM = 0;
	public static final int MAX_QUALITY_ITEM = 50;
	public static final int MIN_SELLIN_ITEM = 0;
	public static final int MILLENARIY_QUALITY = 80;
	
	//Event Passes switch increment when days left
	public static final int EVENT_PASSES_FIRST_INCREMENT_ON = 10;
	public static final int EVENT_PASSES_SECOND_INCREMENT_ON = 5;
	
	//Item Types
	public static final String TYPE_FRESH = "Fresh";
	public static final String TYPE_ORDINARY = "Ordinary";
	public static final String TYPE_MILLENARY = "Millenary";
	public static final String TYPE_AGED = "Aged";
	public static final String TYPE_EVENT_PASS = "event pass";
	
	//Dummy Items
	public static final String ITEM_ORDINARY_FOOD = "Ordinary food";
	public static final String ITEM_AGED_CHEESE = "Aged Cheese";
	public static final String ITEM_ORDINARY_DRINK = "Ordinary drink";
	public static final String ITEM_MILLENARY_HONEY = "Millenary Honey";
	public static final String ITEM_VIP = "VIP special event passes";
	public static final String ITEM_FRESH_FOOD = "Fresh food";
	
	//Quality Degradation
	public static final int QUALITY_DEGRADATION_DEFAULT = 1;
	public static final int QUALITY_DEGRADATION_FRESH = 2;
	public static final int QUALITY_DEGRADATION_EXPIRED = 2;
	
	//Quality Promotion
	public static final int QUALITY_PROMOTION_DEFAULT = 1;
	public static final int QUALITY_PROMOTION_FIRST = 2;
	public static final int QUALITY_PROMOTION_SECOND = 3;
	
	
	//SellIn Degradation
	public static final int SELLIN_DEGRADATION_DEFAULT = 1;
	public static final int SELLIN_DEGRADATION_MILLENARY = 0;

}
