# GildedRose Approach
This is a quick approach for a kata modification approach taken from GildedRose Kata. In brief, it is a refactoring skills exercise.

# Description

Welcome to team ipbSoft Franchise Inventory. We do business just with the finest goods on the market. Unfortunately, our goods’ quality is constantly degrading as their sell in date approaches. To manage it we have built a system that updates our inventory’s information. It was built this summer by an intern in the little time he had between parties, and now he has moved on to Ibiza to learn more about our country’s culture. As the new developer in charge of the system we want you to refactor the code so that you are comfortable with it and we want you to add a new feature to our system so we can sell a new category of items.

# Specifications

- All items have an attribute called SellIn that holds the number of days we have to sell the item.

- All items have an attribute named Quality that stores how valuable the item is.

- The main functionality is responsible of lowering both values for every item at the end of each day.

Nothing complex so far, right? Now let us tell you what makes it interesting:

- Quality of an Item degrades twice as fast once the sell by date has passed. The Quality cannot get negative.

- "Aged Cheese" increases in Quality as it gets older

- An item’s Quality can never get bigger than 50

- "Millenary Honey", has no sell in date and its Quality doesn’t change over the time.

- "VIP special event passes", like aged cheese, gets its Quality bigger as its SellIn date approaches; when there are 10 days or less for the SellIn date Quality increases by 2 and when there are 5 days or less it increases by 3. However, after the event Quality drops to zero.


We want to add fresh items to our catalog. To do so we need to update our inventory system:

- "Fresh" items degrade in Quality twice as fast as normal items


Feel free to make any changes to the UpdateQuality method, add any new code and refactorthe existing one (reorganize it, create new classes, interfaces, apply design patterns...) as long as everything still works correctly. However, do not change neitherthe Item class nor “Items” property in Inventory’s class as those lines were written by our CTO himself and he will get very angry if they get changed since it would mean there is something wrong with his code.

Just for clarification, an item can never have its Quality value above 50, however "Millenary Honey" is a very special item and as such its Quality is 80 and it never alters.
