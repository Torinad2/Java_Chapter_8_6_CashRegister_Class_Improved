/****************************************************
 * RetailItem Class                                 *
 * Holds data about retail store items              *
 ****************************************************/
public class RetailItem {
    //***********************************************
    // Fields                                       *
    // Description, Units on Hand, and Price        *
    //***********************************************
    private String description;
    private int unitsOnHand;
    private double price;

    //***********************************************
    // Constructor                                  *
    // Initializes description, units, and price    *
    //***********************************************
    public RetailItem(String description, int unitsOnHand, double price) {
        this.description = description;
        this.unitsOnHand = unitsOnHand;
        this.price = price;
    }

    //***********************************************
    // Setter Methods                               *
    // Set values for fields                        *
    //***********************************************
    public void setDescription(String description) {

        this.description = description;
    }

    public void setUnitsOnHand(int unitsOnHand) {

        this.unitsOnHand = unitsOnHand;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    //***********************************************
    // Getter Methods                               *
    // Return values of fields                      *
    //***********************************************
    public String getDescription() {

        return description;
    }

    public int getUnitsOnHand() {

        return unitsOnHand;
    }

    public double getPrice() {

        return price;
    }

    //***********************************************
    // toString Method                              *
    // Returns a formatted string of the item data  *
    //***********************************************
    public String toString() {
        return String.format("Description: %14s | Units: %3d | Price: $%6.2f",
                description, unitsOnHand, price);
    }

    //***********************************************
    // subtractUnitsOnHand Method                   *
    // Decreases inventory by specified quantity    *
    //***********************************************
    public void subtractUnitsOnHand(int quantity) {
        unitsOnHand -= quantity;
    }
}

