/****************************************************
 * CashRegister Class                               *
 * Simulates the sale of a retail item              *
 ****************************************************/
public class CashRegister {
    //***********************************************
    // Fields                                       *
    // Holds RetailItem object, quantity, and tax   *
    //***********************************************
    private RetailItem item;
    private int quantity;
    private final double TAX_RATE = 0.06;

    //***********************************************
    // Constructor                                  *
    // Initializes item and quantity purchased      *
    //***********************************************
    public CashRegister(RetailItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    //***********************************************
    // getSubtotal Method                           *
    // Returns subtotal (price * quantity)          *
    //***********************************************
    public double getSubtotal() {

        return item.getPrice() * quantity;
    }

    //***********************************************
    // getTax Method                                *
    // Returns tax (subtotal * TAX_RATE)            *
    //***********************************************
    public double getTax() {

        return getSubtotal() * TAX_RATE;
    }

    //***********************************************
    // getTotal Method                              *
    // Returns total (subtotal + tax)               *
    //***********************************************
    public double getTotal() {

        return getSubtotal() + getTax();
    }

    //***********************************************
    // toString Method                               *
    // Returns quantity and item details             *
    //***********************************************
    public String toString() {
        return  item + " | " + String.format("Quantity: %3d",quantity);
    }
}

