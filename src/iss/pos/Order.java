package iss.pos;
//billy
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Order {
	private List<OrderItem> items;
	
	public List<OrderItem> getItems() {
		this.sortBySKU();
		return items;
	}

	public Order(){
		items = new ArrayList<OrderItem>();
	}
	
	public void add(Product prod, int qty){
		OrderItem oi = getOrderItem(prod.getSku());
		
		if (oi==null){
			oi = new OrderItem();
			oi.setProduct(prod);
			oi.setQuantity(qty);		
			items.add(oi);
			this.sortBySKU();
		} else {
			oi.setQuantity(oi.getQuantity() + qty);
		}
	}
	
	public OrderItem getOrderItem(String sku){
		Iterator<OrderItem> itr = items.iterator();
		
		while(itr.hasNext()){
			OrderItem oi = itr.next();
			
			if (oi.getProduct().getSku()==sku){
				return oi;
			}
		}		
		return null;
	}
	
	public void sortBySKU(){
		items.sort(new Comparator<OrderItem>() {

			@Override
			public int compare(OrderItem item1, OrderItem item2) {
				return item1.getProduct().getSku()
						.compareToIgnoreCase(item2.getProduct().getSku());
			}
			
		});
	}
	
	public double getTotalPrice(){
		double total = 0;
		Iterator<OrderItem> itr = items.iterator();
		
		while(itr.hasNext()){
			OrderItem oi = itr.next();
			total += oi.getProduct().getPrice();
			//total += oi.getQuantity()*oi.getProduct().getPrice();
		}			
		
		return total;
	}

	@Override
	public String toString() {
		List<OrderItem> allitems = getItems();
		String output="";
		for(OrderItem oitem : allitems ){
			Product prod = oitem.getProduct();
			output = output.concat(prod.getName()+" "+prod.getSku()+" "+prod.getPrice()+" Quantity: "+oitem.getQuantity()+"\r\n");
		}
		return output;
	}
	
	
}
