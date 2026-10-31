package JMarch02;

import java.util.Arrays;
import java.util.Collections;

public class oops_fractional_knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wts = {10,40,20,30};
		int[] prices = {60,40,100,120};
		int bag = 50;
		fractional_knapsack(wts, prices, bag);

	}
	
	public static void fractional_knapsack(int[] wt, int[] price, int bag) {
		
		Item[] Items = new Item[wt.length];
		for(int i = 0; i < Items.length; i++) {
//			Items[i].wt = wt[i];
//			Items[i].price = price[i];
			
			Items[i] = new Item(wt[i],price[i]);
		}
		
		Arrays.sort(Items, Collections.reverseOrder());
		
		double vib = 0;
		int sib = bag;
		
		int i = 0;
		while(sib > 0) {
			if(Items[i].wt < sib) {
				vib = vib + Items[i].price;
				sib = sib - Items[i].wt;
			} else {
				vib = vib + Items[i].ratio * sib;
				sib = 0;
			}
			i++;
		}
		
		System.out.println(vib);
		
	}

	private static class Item implements Comparable<Item> {

		int wt;
		int price;
		double ratio;

		Item(int wt, int price) {
			this.wt = wt;
			this.price = price;
			this.ratio = price * 1.0 / wt;
		}
		/*Item(int wt1, int price1) {
			wt = wt1;  // 
			price = price1;
			ratio = price * 1.0 / wt;
		} */

		public void display() {
			System.out.println("[wt = " + wt + ", p = " + price + ", ratio = " + ratio);
		}

		public int compareTo(Item other) {
			if (this.ratio > other.ratio)
				return 1;
			else if (this.ratio == other.ratio)
				return 0;
			else
				return -1;
		}
	}
}
