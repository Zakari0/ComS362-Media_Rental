package MediaRental.Model;

import MediaRental.DatabaseSupport;

import java.util.ArrayList;

/**
 * Created by Obberton13 on 2/16/2015.
 */
public class Store
{
	private static DatabaseSupport db = null;

	public Store()
	{
	}

	public static boolean addCustomer(String name, String address) {
        DatabaseSupport db = new DatabaseSupport();
        Customer customer = new Customer(name, address);
        customer.setId(db.addCustomer(customer));
        return db.addCustomer(customer) != 0;

    }

    /**
     * @param cid the ID of the customer to remove
     * @return true on success, false otherwise
     */
    public static boolean removeCustomer(int cid) {
        db.removeCustomer(cid);
        return true;
    }

    /**
     * @param name the name of the product to create
     * @param type the type of the product to create
     * @return true on success, false otherwise
     */
    public static boolean createProduct(String name, String type, String genre) {
        Product product = new Product(name);
        product.setType(type);
        product.setId(db.addProductToCatalog(product));
        
        return db.addProductToCatalog(product) != 0;
    }

    /**
     * @param pid the ID of the product to add to the store
     * @param qty the amount of the product to add to the store
     * @return true on success, false otherwise
     */
    public static boolean addProduct(int pid, int qty) {
        for (int i = 0; i < qty; i++)
        {
            db.addProductToStore(pid);
        }
        
        return db.addProductToStore(pid) != 0;
    }

    /**
     * @param cid The ID of the customer who is doing the purchasing
     * @return true on success, false otherwise
     */
    public static boolean createTransaction(int cid){
        Transaction transaction = new Transaction();
        transaction.setCustomer(db.getCustomer(cid));
        transaction.setId(db.addTransactionToStore(transaction));
        return db.addTransactionToStore(transaction) != 0;
    }

    /**
     * @param productID The ID of the product to add to the transaction
     * @param transactionID The ID of the transaction to be added to
     * @return true on success, false otherwise
     */
    public static boolean addSale(Transaction transaction, Product product, double price) {
        Sale sale = new Sale();
        sale.setProduct(product);
        transaction.addSale(sale);
        sale.setId(db.addSaleToStore(sale));
        db.addSaleToTransaction(sale.getId(),transaction);
        
        return db.addSaleToStore(sale) != 0;
    }

    /**
     * @param product The product to add to the transaction
     * @param transaction The transaction to be added to
     * @param dueDate the date the Rental will be due
     * @return true on success, false otherwise
     */
    public static boolean addRental(Product product, Transaction transaction, String dueDate) {
        Rental rental = new Rental();
        rental.setProduct(product);
        rental.setDueDate(dueDate);
        transaction.addRental(rental);
        rental.setId(db.addRentalToStore(rental));
        db.addRentalToTransaction(rental.getId(),rental.getDueDate(),transaction);
        
        return db.addRentalToStore(rental) != 0;
    }

    /**
     * @param title the title of the product you are looking for
     * @param type the type of the product you are looking for
     * @return
     */
    public static ArrayList<Product> findProduct(String title, String type) {
        return db.findProducts(title,type);
    }

    public static Transaction getTransaction(int tid)
    {
//        return DatabaseSupport.getTransaction(tid);
//        TODO
        return new Transaction();
    }

	private DatabaseSupport getDatabaseSupportInstance()
	{
		if (db == null)
		{
			db = new DatabaseSupport();
		}
		return db;
	}
}
