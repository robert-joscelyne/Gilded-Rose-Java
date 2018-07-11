public class GildedRose {

    public String name;
    public int sellIn;
    public int quality;

    public GildedRose(String name, int quality, int sellIn) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static GildedRose of(String name, int quality, int sellIn) {
        return new GildedRose(name, quality, sellIn);
    }

    public void tick() {
        if (this.name == "normal") {
            this.sellIn -= 1;
            this.quality -= 1;

            if (this.sellIn <= 0) {
                this.quality -= 1;
            }
            if (this.quality < 0) {
                this.quality = 0;
            }

            return;
        }

        if (this.name != "Aged Brie" && this.name != "Backstage passes to a TAFKAL80ETC concert") {
            if (this.quality > 0) {
                if (this.name != "Sulfuras, Hand of Ragnaros") {
                    this.quality = this.quality - 1;
                }
            }
        } else {
            if (this.quality < 50) {
                this.quality = this.quality + 1;

                if (this.name == "Backstage passes to a TAFKAL80ETC concert") {
                    if (this.sellIn < 11) {
                        if (this.quality < 50) {
                            this.quality = this.quality + 1;
                        }
                    }
                    if (this.sellIn < 6) {
                        if (this.quality < 50) {
                            this.quality = this.quality + 1;
                        }
                    }
                }
            }
        }

        if (this.name != "Sulfuras, Hand of Ragnaros") {
            this.sellIn = this.sellIn - 1;
        }

        if (this.sellIn < 0) {
            if (this.name != "Aged Brie") {
                if (this.name != "Backstage passes to a TAFKAL80ETC concert") {
                    if (this.quality > 0) {
                        if (this.name != "Sulfuras, Hand of Ragnaros") {
                            this.quality = this.quality - 1;
                        }
                    }
                } else {
                    this.quality = this.quality - this.quality;
                }
            } else {
                if (this.quality < 50) {
                    this.quality = this.quality + 1;
                }
            }
        }
    }
}
