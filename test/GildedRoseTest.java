import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {
    @Test
    public void updatesNormalItemsBeforeSellDate() {
        GildedRose item = new GildedRose("normal", 10,5);
        item.tick();
        assertEquals(9, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void updatesNormalItemsOnTheSellDate() {
        GildedRose item = new GildedRose("normal", 10,0);
        item.tick();
        assertEquals(8, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void updatesNormalItemsAfterTheSellDate() {
        GildedRose item = new GildedRose("normal", 10,-5);
        item.tick();
        assertEquals(8, item.quality);
        assertEquals(-6, item.sellIn);
    }

    @Test
    public void updatesNormalItemsWithQualityOf0() {
        GildedRose item = new GildedRose("normal", 0,5);
        item.tick();
        assertEquals(0, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void updatesBrieItemsBeforeTheSellDate() {
        GildedRose item = new GildedRose("Aged Brie", 10,5);
        item.tick();
        assertEquals(11, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void updatesBrieItemsBeforeTheSellDateWithMaxQuality() {
        GildedRose item = new GildedRose("Aged Brie", 50,5);
        item.tick();
        assertEquals(50, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void updatesBrieItemsOnTheSellDate() {
        GildedRose item = new GildedRose("Aged Brie", 10,0);
        item.tick();
        assertEquals(12, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void updatesBrieItemsOnTheSellDateNearMaxQuality() {
        GildedRose item = new GildedRose("Aged Brie", 49,0);
        item.tick();
        assertEquals(50, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void updatesBrieItemsOnTheSellDateWithMaxQuality() {
        GildedRose item = new GildedRose("Aged Brie", 50,0);
        item.tick();
        assertEquals(50, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void updatesBrieItemsAfterTheSellDate() {
        GildedRose item = new GildedRose("Aged Brie", 10,-10);
        item.tick();
        assertEquals(12, item.quality);
        assertEquals(-11, item.sellIn);
    }

    @Test
    public void updatesBrieItemsAfterTheSellDateWithMaxQuality() {
        GildedRose item = new GildedRose("Aged Brie", 50,-10);
        item.tick();
        assertEquals(50, item.quality);
        assertEquals(-11, item.sellIn);
    }

    @Test
    public void updatesSulfurasItemsBeforeTheSellDate() {
        GildedRose item = new GildedRose("Sulfuras, Hand of Ragnaros", 10,5);
        item.tick();
        assertEquals(10, item.quality);
        assertEquals(5, item.sellIn);
    }

    @Test
    public void updatesSulfurasItemsOnTheSellDate() {
        GildedRose item = new GildedRose("Sulfuras, Hand of Ragnaros", 10,5);
        item.tick();
        assertEquals(10, item.quality);
        assertEquals(5, item.sellIn);
    }

    @Test
    public void updatesSulfurasItemsAfterTheSellDate() {
        GildedRose item = new GildedRose("Sulfuras, Hand of Ragnaros", 10,-1);
        item.tick();
        assertEquals(10, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void updatesBackstagePassItemsBeforeTheSellDate() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10,11);
        item.tick();
        assertEquals(11, item.quality);
        assertEquals(10, item.sellIn);
    }


    @Test
    public void updatesBackstagePassItemsCloseToTheSellDate() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10,10);
        item.tick();
        assertEquals(12, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void updatesBackstagePassItemsBeforeTheSellDateAtMaxQuality() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50,10);
        item.tick();
        assertEquals(50, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void updatesBackstagePassItemsVeryCloseToTheSellDate() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10,5);
        item.tick();
        assertEquals(13, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void updatesBackstagePassItemsVeryCloseToTheSellDateAtMaxQuality() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50,5);
        item.tick();
        assertEquals(50, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void updatesBackstagePassItemsWithOneDayLeftToSell() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10,1);
        item.tick();
        assertEquals(13, item.quality);
        assertEquals(0, item.sellIn);
    }

    @Test
    public void updatesBackstagePassItemsWithOneDayLeftToSellAtMaxQuality() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 50,1);
        item.tick();
        assertEquals(50, item.quality);
        assertEquals(0, item.sellIn);
    }

    @Test
    public void updatesBackstagePassItemsOnSellDate() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10,0);
        item.tick();
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void updatesBackstagePassItemsAfterTheSellDate() {
        GildedRose item = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10,-1);
        item.tick();
        assertEquals(0, item.quality);
        assertEquals(-2, item.sellIn);
    }

//    @Test
    public void updatesConjuredItemsBeforeTheSellDate() {
        GildedRose item = new GildedRose("Conjured Mana Cake", 10,10);
        item.tick();
        assertEquals(8, item.quality);
        assertEquals(9, item.sellIn);
    }

//    @Test
    public void updatesConjuredItemsAtZeroQuality() {
        GildedRose item = new GildedRose("Conjured Mana Cake", 0,10);
        item.tick();
        assertEquals(0, item.quality);
        assertEquals(9, item.sellIn);
    }

//    @Test
    public void updatesConjuredItemsOnTheSellDate() {
        GildedRose item = new GildedRose("Conjured Mana Cake", 10,0);
        item.tick();
        assertEquals(6, item.quality);
        assertEquals(-1, item.sellIn);
    }

//    @Test
    public void updatesConjuredItemsBeforeTheSellDateAtZeroQuality() {
        GildedRose item = new GildedRose("Conjured Mana Cake", 0,0);
        item.tick();
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);
    }

//    @Test
    public void updatesConjuredItemsAfterTheSellDate() {
        GildedRose item = new GildedRose("Conjured Mana Cake", 10,-10);
        item.tick();
        assertEquals(6, item.quality);
        assertEquals(-11, item.sellIn);
    }

//    @Test
    public void updatesConjuredItemsAfterTheSellDateAtZeroQuality() {
        GildedRose item = new GildedRose("Conjured Mana Cake", 0,10);
        item.tick();
        assertEquals(0, item.quality);
        assertEquals(-11, item.sellIn);
    }
}