package Product_Management;


	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Scanner;

public class ProductManagement {
	
	
		static ArrayList<Product> al= new ArrayList();
		
		//******* Main Function*******
		public static void  ProductManagement() throws IOException  {
			loadDataFromFileToArrayList();
			
			Scanner scanner= new Scanner(System.in);
			boolean CanIKeepRunningTheProgram= true;
					
			while(CanIKeepRunningTheProgram == true) {
				
				
				
				System.out.println("**** Welcome to Product Management****");
				System.out.println("\n");
				
				System.out.println("What would you like to do?");
				System.out.println("1. Add Product");
				System.out.println("2. Edit Product");
				System.out.println("3. Delete Product");
				System.out.println("4. Search Product");
				System.out.println("5. Quit");
				
				int optionSelectedByUser= scanner.nextInt();
				 if (optionSelectedByUser==ProductOptions.QUIT_PRODUCT){
					 
					 File file= new File("C:\\Users\\Lenovo\\eclipse-workspace\\Shop_Management\\src\\Product_Management\\product.txt");
					 FileWriter fileWriter= new FileWriter(file, false);
					 BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
					 
					 for (Product user: al) {
						 bufferedWriter.write( user.ProductName +"," + user.ProductID + "," + user.Price + "," + user.Quantity +"," + user.Category + "\n");
					 }
					 bufferedWriter.close();
					 fileWriter.close();
					 file= null;
				
					 System.out.println("!!! Program Closed");
					 CanIKeepRunningTheProgram= false;
				 }else if (optionSelectedByUser==ProductOptions.ADD_PRODUCT) {
					addProduct();
					 System.out.println("\n");
				 }else if (optionSelectedByUser==ProductOptions.SEARCH_PRODUCT) {
					 System.out.println("Enter Product Name to Search:");
					 scanner.nextLine();
					 String sn = scanner.nextLine();
					 searchProduct(sn);
					 System.out.println("\n");
					 
				 }else if (optionSelectedByUser==ProductOptions.DELETE_PRODUCT) {
					 System.out.println("Enter Product Name to delete:");
					 scanner.nextLine();
					 String deleteProductName  = scanner.nextLine();
					 deleteProduct(deleteProductName);
					 System.out.println("\n"); 
					 
				 }else if (optionSelectedByUser==ProductOptions.EDIT_PRODUCT) {
					 System.out.println("Enter Product Name to edit:");
					 scanner.nextLine();
					 String editProductName  = scanner.nextLine();
					 editProduct(editProductName);
					 System.out.println("\n");  
				 }
			}
		}
		

		// ***** Add Product Function*****
		public static void addProduct()throws IOException {
			Scanner scanner = new Scanner(System.in);
			Product userObject=new Product();
			
			System.out.print("Product Name: ");
			userObject.ProductName = scanner.nextLine();
		  

		    System.out.print("Product ID: ");
		    userObject.ProductID = scanner.nextLine();
		  
		    System.out.print("Price:");
		    userObject.Price = scanner.nextLine();
		   
		    System.out.print("Quantity: ");
		    userObject.Quantity = scanner.nextLine();
		    
		    System.out.print("Categoy: ");
		    userObject.Category = scanner.nextLine();
		    
		    System.out.println(" Product Name: "+ userObject.ProductName);
		    System.out.println(" ProductID: "+ userObject.ProductID);
		    System.out.println(" Price: "+ userObject.Price);
		    System.out.println(" Quantity: "+ userObject.Quantity);
		    System.out.println(" Category: "+ userObject.Category);
		   
		   al.add(userObject);
		    
		
		}
		public static void searchProduct(String ProductName) {
			for (Product user : al) {
				if (user.ProductName.equalsIgnoreCase(ProductName)) {
		 System.out.println(" Product Name: "+ user.ProductName);
		    System.out.println(" Product ID: "+ user.ProductID);
		    System.out.println(" Price: "+ user.Price);
		    System.out.println(" Quantity: "+ user.Quantity);
		    System.out.println(" Category: "+ user.Category);
		    return;
				}
		}
				System.out.println("Product not found.");
		}
		
		public static void deleteProduct(String ProductName) {
			Iterator<Product> userIterator=al.iterator();
			
			while (userIterator.hasNext()) {
				Product user= userIterator.next();
				if(user.ProductName.equalsIgnoreCase(ProductName)) {
					userIterator.remove();
				}
					System.out.println("Product"+ user.ProductName+" has been deleted.");
					break;
				}
		}
			
			public static void editProduct( String ProductName) {
			for (Product user : al) {
			if (user.ProductName.equalsIgnoreCase(ProductName)) {
			
			Scanner scanner= new Scanner(System.in);
			
			System.out.println("Edit Product: "+ user.ProductName);
			
			
			System.out.println(" New Product Name: ");
			user.ProductName = scanner.nextLine();
			
			
			System.out.println(" New Product ID: ");
			user.ProductID = scanner.nextLine();
			
			System.out.println(" New Price:");
			user.Price = scanner.nextLine();
			
			System.out.println(" New Quantity: ");
			user.Quantity = scanner.nextLine();
			
			System.out.println(" New Category: ");
			user.Category = scanner.nextLine();
			
			System.out.println("Product information updated.");
			return;
			}
			}
			System.out.println("Product not found ");
			
			}
			
			public static void loadDataFromFileToArrayList() throws IOException {
				File file= new File("C:\\Users\\Lenovo\\eclipse-workspace\\Shop_Management\\src\\Product_Management\\product.txt");
				FileReader fr= new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line ="";
				 while((line= br.readLine())!=null)
				 {
					 Product user= new Product();
					 String[] userDataArray= line.split(",");
					 if (userDataArray.length>4)
					 {
						 user.ProductName=userDataArray[0];
						 user.ProductID=userDataArray[1];
						 user.Price=userDataArray[2];
						 user.Quantity=userDataArray[3];
						 user.Quantity=userDataArray[4];
						 al.add(user);
				 }
			}
	br.close();
	fr.close();
	file=null;
		}

			}	
			
		


