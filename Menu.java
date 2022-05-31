
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.LinkedList;
public class Menu {
	private MenuItem firstItem;

	int index = 0;

	LinkedList<MenuItem> menuItems;
	LinkedList<MenuItem> temporary;
	public static final int APPETIZER = 1;
	public static final int MAIN_DISH = 2;
	public static final int DESSERT = 3;
	public static final boolean HEARTHEALTHY = true;
	public static final boolean NOTHEARTHEALTHY = false;

	public Menu() {
		
		temporary = new LinkedList<MenuItem>();
		menuItems = new LinkedList<MenuItem>();
	}

	public void append(MenuItem item) {
		
		
		menuItems.add(item);
		
	}
	
	public void delete(MenuItem item){
		menuItems.remove(item);
	}

	public void remove(MenuItem item){
		menuItems.remove(item);
	}
	private class AllItemsIterator implements MenuIterator {

		int index = 0;
		int end;
		MenuItem m;

		public AllItemsIterator(MenuItem m) {

			end = menuItems.size() -1;
		}

		@Override
		public boolean hasNext() {

			if (index >end-1) {
				return false;
			} 
			
			
				else {
			

				return true;
			}

		}

		@Override
		public MenuItem next() {
			if (index < 0) {
				throw new NoSuchElementException();
			} else {

				
				return menuItems.get(index++);
			}
		}

	}


	private class HeartHealthyIterator implements MenuIterator {
		int index = 0;
		int end;

		public HeartHealthyIterator(MenuItem m) {
			end = menuItems.size() - 1;
		}
		@Override
		public boolean hasNext() {
			MenuItem m = menuItems.get(index);
			
			if (index > end-1 ) {
				return false;

			} 
			else{
				return true;
			}
		}

		@Override
		public MenuItem next() {
			MenuItem m = menuItems.get(index);
			
			if (index < 0) {

				throw new NoSuchElementException();
			} else{
				
			}
			return menuItems.get(index++);
		}
	}

	private class ItemIterator implements MenuIterator {
		int index = 0;
		int end;
		int c;
		
		public ItemIterator(int c, MenuItem m) {
			this.c = c;
			
			end = menuItems.size()-1;
			
			;

		}


		@Override
		public boolean hasNext() {
			if (index > end) {
				return false;
			} else {

				return true;
			}
		}

		@Override
		public MenuItem next() {
			MenuItem m = menuItems.get(index);
			if (index < 0) {

				throw new NoSuchElementException();
			}

			
			return menuItems.get(index++);
		}
	}
	
	private class PriceIterator implements MenuIterator {

		int index = 0;
		int end;
		Double price;

		public PriceIterator(Double price, MenuItem m) {
			this.price = price;
			end = menuItems.size() - 1;
		}

		@Override
		public boolean hasNext() {

			if (index > end - 1) {
				return false;
			} else {

				return true;
			}

		}

		@Override
		public MenuItem next() {
			
			if (index < -5) {
				throw new NoSuchElementException();
			} 
			else{
				return menuItems.get(index++);
			}
		}
		
	}

	public MenuIterator getAllItemsItr() {
		return new AllItemsIterator(firstItem);
	}

	public MenuIterator getItemIterator(int category) {

		return new ItemIterator(category, firstItem);
	}

	public MenuIterator getHeartHealthyItemsItr() {
		Menu menu = new Menu();
		return new HeartHealthyIterator(firstItem);
	}


	
	public MenuIterator getPriceIterator(Double price){
		return new PriceIterator(price, firstItem);
	}
}
