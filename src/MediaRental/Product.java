package MediaRental;

/**
 * Created by Obberton13 on 2/16/2015.
 */
public class Product
{
    protected int id;
    protected String title;
    protected String type;
    protected String genre;
    protected int catalogId;
    protected String description;
    protected FrequentCustomerStrategy s;
    protected RentalPricingStrategy rs;
    protected boolean available;


    public Product(int catalogId, boolean available)
    {
        this.catalogId = catalogId;
        this.available = available;
    }


    public Product(String title, String type, String genre, String description, boolean available)
    {
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.catalogId = 0;
        this.id = 0;
        this.available = available;
    }

    public Product(String title, String type, String genre, String description, int catalogID, boolean available)
    {
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.catalogId = catalogID;
        this.id = 0;
        this.available = available;
    }

    public Product(String title, String type, String genre, String description, int id, int catalogID, boolean available)
    {
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.catalogId = catalogID;
        this.id = id;
        this.available = available;
    }

    public Product(String title, String type, String genre, String description, int id, int catalogID, FrequentCustomerStrategy f, RentalPricingStrategy r, boolean available)
    {
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.catalogId = catalogID;
        this.id = id;
        this.rs = r;
        this.s = f;
        this.available = available;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getType()
    {
        return type;
    }

    public double getPrice(int daysRented)
    {
        if (this.rs == null)
        {
            return 0.0;
        }
        return this.rs.getRentalCharge(daysRented);

    }

    public void setType(String type)
    {
        this.type = type;
    }

    public boolean getAvailable()
    {
        return this.available;
    }

    public int getCatalogId()
    {
        return catalogId;
    }

    public void setCatalogId(int id)
    {
        catalogId = id;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setCustomerStrategy(FrequentCustomerStrategy strategy)
    {
        s = strategy;
    }

    public FrequentCustomerStrategy getCustomerStrategy()
    {
        return s;
    }

    public void setRentalPricingStrategy(RentalPricingStrategy strategy)
    {
        rs = strategy;
    }

    public RentalPricingStrategy getRentalPricingStrategy()
    {
        return rs;
    }

    public boolean returnToStore()
    {
        available = true;
        return true;
    }


    @Override
    public String toString()
    {
        return "" + id + ", " + title + ", " + type + ", " + genre;
    }
}