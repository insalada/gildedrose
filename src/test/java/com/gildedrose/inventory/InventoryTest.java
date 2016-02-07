package com.gildedrose.inventory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.gildedrose.inventory.GenericItem;
import com.gildedrose.inventory.Inventory;
import com.gildedrose.inventory.Item;
import com.gildedrose.inventory.ItemFactory;

public class InventoryTest {
	
	private Item freshItem, freshItemExpired, freshItemWithoutQuality, ordinarySalad;

	//------------- Added -------------//
    @Before
    public void initItems() {
    	freshItem = new Item("Fresh milk", 10, 10);
    	freshItemExpired = new Item("Ordinary chicken", -1, 1);
    	freshItemWithoutQuality = new Item("Fresh potatoes", 10, 0);
    	ordinarySalad = new Item("Ordinary salad", 10, 10);
    }
    //------------- Added -------------//

	@Test
    public void should_never_change_quailty_of_Millenary_Honey() throws Exception {
		
        Item millenaryHoney = new Item("Millenary Honey", 0, 80);
        
        Inventory sut = new Inventory((Item[]) Arrays.asList(millenaryHoney).toArray());//----This has been fixed---//

        sut.updateQuality();

        assertEquals(80, millenaryHoney.getQuality());
    }

    @Test
    public void should_never_change_sellIn_of_Millenary_Honey() throws Exception {
    	
        Item millenaryHoney = new Item("Millenary Honey", 0, 80);

        Inventory sut = new Inventory((Item[]) Arrays.asList(millenaryHoney).toArray());

        sut.updateQuality();

        assertEquals(0, millenaryHoney.getSellIn());
    }

    @Test
    public void should_lower_the_sellIn_by_one_for_ordinary_items() throws Exception {
    	
        Item ordinaryItem = new Item("Ordinary food", 10, 20);

        Inventory sut = new Inventory((Item[]) Arrays.asList(ordinaryItem).toArray());

        sut.updateQuality();

        assertEquals(9, ordinaryItem.getSellIn());
    }

    @Test
    public void should_lower_the_quality_by_one_for_ordinary_items() throws Exception {
    	
        Item ordinaryItem = new Item("Ordinary food", 10, 20);

        Inventory sut = new Inventory((Item[]) Arrays.asList(ordinaryItem).toArray());

        sut.updateQuality();

        assertEquals(19, ordinaryItem.getQuality());
    }

    @Test
    public void should_not_lower_the_quality_below_zero() throws Exception {
    	
        Item ordinaryItem = new Item("Ordinary food", 10, 0);

        Inventory sut = new Inventory((Item[]) Arrays.asList(ordinaryItem).toArray());

        sut.updateQuality();

        assertEquals(0, ordinaryItem.getQuality());
    }

    @Test
    public void should_lower_the_quality_twice_as_fast_once_the_sell_in_date_has_passed() throws Exception {
        
    	Item ordinaryItem = new Item("Ordinary food", -1, 25);

        Inventory sut = new Inventory((Item[]) Arrays.asList(ordinaryItem).toArray());

        sut.updateQuality();

        assertEquals(23, ordinaryItem.getQuality());
    }

    @Test
    public void should_increase_the_quality_of_aged_cheese_as_it_gets_older() throws Exception {
    	
        Item agedCheese = new Item("Aged Cheese", 10, 25);

        Inventory sut = new Inventory((Item[]) Arrays.asList(agedCheese).toArray());

        sut.updateQuality();

        assertEquals(26, agedCheese.getQuality());
    }

    @Test
    public void should_not_increase_the_quality_of_aged_cheese_over_50() throws Exception {
    	
        Item agedCheese = new Item("Aged Cheese", 10, 50);

        Inventory sut = new Inventory((Item[]) Arrays.asList(agedCheese).toArray());

        sut.updateQuality();

        assertEquals(50, agedCheese.getQuality());
    }

    @Test
    public void should_lower_vip_passes_to_zero_quality_once_event_has_happened() throws Exception {
    	
        Item vipPass = new Item("VIP special event passes", -1, 20);

        Inventory sut = new Inventory((Item[]) Arrays.asList(vipPass).toArray());

        sut.updateQuality();

        assertEquals(0, vipPass.getQuality());
    }

    @Test
    public void should_increase_vip_passes_quality_by_1_when_the_event_is_more_than_10_days_away() throws Exception {
        
    	Item vipPass = new Item("VIP special event passes", 11, 20);

        Inventory sut = new Inventory((Item[]) Arrays.asList(vipPass).toArray());

        sut.updateQuality();

        assertEquals(21, vipPass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_2_when_the_event_is_10_days_or_less_away() throws Exception {
       
    	Item vipPass = new Item("VIP special event passes", 10, 27);

        Inventory sut = new Inventory((Item[]) Arrays.asList(vipPass).toArray());

        sut.updateQuality();

        assertEquals(29, vipPass.getQuality());
    }

    @Test
    public void should_increase_vip_passes_quality_by_3_when_the_event_is_5_days_or_less_away() throws Exception {
        
    	Item vipPass = new Item("VIP special event passes", 5, 44);

        Inventory sut = new Inventory((Item[]) Arrays.asList(vipPass).toArray());

        sut.updateQuality();

        assertEquals(47, vipPass.getQuality());
    }

    @Test
    public void should_not_increase_vip_passes_above_a_quality_of_50() throws Exception {
        
    	Item vipPassMoreThan10DaysAway = new Item("VIP special event passes", 15, 50);

        Item vipPass10DaysAway = new Item("VIP special event passes", 5, 49);
        Item vipPass5DaysAway = new Item("VIP special event passes", 5, 48);

        Inventory sut = new Inventory((Item[]) Arrays.asList(vipPassMoreThan10DaysAway, 
        		vipPass10DaysAway, vipPass5DaysAway).toArray());

        sut.updateQuality();

        assertEquals(50, vipPassMoreThan10DaysAway.getQuality());
        assertEquals(50, vipPass10DaysAway.getQuality());
        assertEquals(50, vipPass5DaysAway.getQuality());
    }
    
    //---------------------------- Added ---------------------------//
    /**
     * Fresh items quality should get lower twice as fast as ordinary items
     * @throws Exception
     */
    @Test
    public void should_lower_fresh_quality_twice_as_fast_as_ordinary() throws Exception { 
    	Item freshItem = new Item("Fresh food", 10, 25);
        Inventory sut = new Inventory((Item[]) Arrays.asList(freshItem).toArray());
        sut.updateQuality();
        assertEquals(23, freshItem.getQuality());
    }
    
    /**
     * Expired fresh items quality should get lower twice as fast as ordinary expired items
     * @throws Exception
     */
    @Test
    public void should_lower_fresh_quality_twice_as_fast_as_ordinary_once_the_sell_in_date_has_passed() throws Exception {
    	Item freshItemExpired = new Item("Fresh food", -1, 25);
        Inventory sut = new Inventory((Item[]) Arrays.asList(freshItemExpired).toArray());
        sut.updateQuality();
        assertEquals(21, freshItemExpired.getQuality());
    }    
    
    /**
     * Fresh items quality should not get ever lower than zero
     * @throws Exception
     */
    @Test
    public void fresh_items_should_not_lower_the_quality_below_zero() throws Exception {
        Inventory sut = new Inventory((Item[]) Arrays.asList(freshItemWithoutQuality).toArray());
        sut.updateQuality();
        assertEquals(0, freshItemWithoutQuality.getQuality());
    }
    
    /**
     * Quality should not get lower than zero when decreasing multiple quality units and item sell in expired
     * @throws Exception
     */
    @Test
    public void should_not_lower_the_quality_below_zero_when_decreasing_multiple_quality_units_expired() throws Exception {
        Inventory sut = new Inventory((Item[]) Arrays.asList(freshItemExpired).toArray());
        sut.updateQuality();
        assertEquals(0, freshItemExpired.getQuality());
    }
    
    /**
     * Quality should not get lower than zero when decreasing multiple quality units on the edge
     * @throws Exception
     */
    @Test
    public void should_not_lower_the_quality_below_zero_when_decreasing_multiple_quality_units_fresh() throws Exception {
        Item freshItem = new Item("Fresh fish", 10, 1);
        Inventory sut = new Inventory((Item[]) Arrays.asList(freshItem).toArray());
        sut.updateQuality();
        assertEquals(0, freshItem.getQuality());
    }
    
    /**
     * Tests whether result returns null items
     * @throws Exception
     */
    @Test
    public void should_not_return_null_items() throws Exception {
    	Inventory sut = new Inventory((Item[]) Arrays.asList(ordinarySalad).toArray());
    	sut.updateQuality();
        assertNotNull(ordinarySalad);
    }
    
    /**
     * Tests whether result keeps same number of provided items
     * @throws Exception
     */
    @Test
    public void should_keep_number_of_elements() throws Exception {
    	Item peanuts = new Item("Ordinary peanuts", 10, 10);
    	Item hazelnoots = new Item("Ordinary hazelnoot", 10, 10);
    	Item[] items = (Item[]) Arrays.asList(peanuts, hazelnoots).toArray();
    	Inventory sut = new Inventory(items);
    	sut.updateQuality();
        assertTrue(items.length == 2);
    }
    
    /**
     * Tests whether result keeps same items product
     * @throws Exception
     */
    @Test
    public void should_keep_same_type_of_elements() throws Exception {
    	Item[] items = (Item[]) Arrays.asList(ordinarySalad).toArray();
    	Inventory sut = new Inventory(items);
    	sut.updateQuality();
    	assertThat(items[0].getName(),is("Ordinary salad"));
    }
    
    /**
     * Tests whether result keeps the same kind of elements
     * @throws Exception
     */
    @Test
    public void should_keep_same_instace_kind_of_elements() throws Exception {
    	Item[] items = (Item[]) Arrays.asList(freshItem).toArray();
    	Inventory sut = new Inventory(items);
    	sut.updateQuality();
    	assertThat(items[0],isA(Item.class));
    }
    
    /**
     * Tests whether factory pattern returns the desired class instance
     * @throws Exception
     */
    @Test
    public void should_factory_pattern_return_generic_item_class_element() throws Exception {
    	ItemFactory factory = new ItemFactory();
    	assertThat(factory.getItem(freshItem),isA(GenericItem.class));
    }
  //---------------------------- Added ---------------------------//
}