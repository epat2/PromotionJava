package iss.pos;

import iss.pos.test.Products;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

public class Main {
    private boolean quit = false;
    static HashMap<String,Product> products = new HashMap<String, Product>(); 

    static 
    {
        products.put("A",    new Product("A", "Red Dress",   100.0));
        products.put("B",  new Product("B", "Green Dress", 100.0));
        products.put("C",   new Product("C", "Blue Dress",  100.0));
        products.put("D",  new Product("D", "White Socks", 10.0));
        products.put("E",    new Product("E", "Red Socks",   10.0));
    }
    
	public static void main(String[] args) throws IOException {
        Main main = new Main();
        Order o = new Order();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
	        System.out.println("Input SKU: ");
	        String sku = main.readInput(reader);
	
	        System.out.println("Input Quantity: ");       
	        String quantity = main.readInput(reader);
	        
	        o.add(products.get(sku), Integer.valueOf(quantity));	  
	        
	        System.out.println("Continue with more items(y/n) ? ");
	        String continueyesno = main.readInput(reader);

	        if(continueyesno.compareTo("n")==0){
	        	break;
	        }
        }
        System.out.println("Order submitted is:");
        System.out.println(o.toString());
        System.out.println("Ended");       
        
	}

    public String readInput(BufferedReader reader) throws IOException{
        return reader.readLine();
    }
    
    public String readInput(Reader  reader) throws IOException{
    	String inputstr = "";
        char input = (char) reader.read();
        inputstr+=input;
        return inputstr;
    }    

    public boolean quit(){
        return quit;
   }
}
