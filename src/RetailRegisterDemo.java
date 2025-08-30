/**********************************************************
 * RetailRegisterDemo                                     *
 * Builds inventory, processes purchases,                 *
 * checks stock, updates units, and totals                *
 **********************************************************/
public class RetailRegisterDemo {
    public static void main(String[] args) {

        //*************************************************
        // Create an array of RetailItem objects          *
        // Six inventory items with description, units,   *
        // and price. Each object is stored in the array. *
        //*************************************************
        RetailItem[] inventory = new RetailItem[] {
                new RetailItem("Jacket",        12, 59.95),   // 12 Jackets, $59.95 each
                new RetailItem("Designer Jeans",14, 34.95),   // 14 Jeans, $34.95 each
                new RetailItem("Shirt",         20, 24.95),   // 20 Shirts, $24.95 each
                new RetailItem("Coat",          75, 89.95),   // 75 Coats, $89.95 each
                new RetailItem("Hat",           41, 14.95),   // 41 Hats, $14.95 each
                new RetailItem("T-Shirt",       24,  4.95)    // 24 T-Shirts, $4.95 each
        };

        //*************************************************
        // Display Inventory before sales                 *
        // Uses implicit toString() from RetailItem       *
        //*************************************************
        System.out.println("Inventory before sales:");
        for (RetailItem item : inventory) {
            System.out.println(item); // Print each item’s description, units, and price
        }
        System.out.println();         // Blank line for spacing

        //*************************************************
        // Build purchase plan                            *
        // Each element: {inventoryIndex, requestedQty}   *
        //*************************************************
        int[][] purchasePlan = {
                {0, 2},   // Request 2 Jackets (index 0)
                {1, 10},  // Request 10 Designer Jeans (index 1)
                {2, 3},   // Request 3 Shirts (index 2)
                {3, 5},   // Request 5 Coats (index 3)
                {4, 2},   // Request 2 Hats (index 4)
                {5, 7}    // Request 7 T-Shirts (index 5)
        };

        //*************************************************
        // Create array of CashRegister objects           *
        // Each sale will be stored here                  *
        //*************************************************
        CashRegister[] sales = new CashRegister[purchasePlan.length];

        // Variables to hold overall totals
        double overallSubtotal = 0.0;
        double overallTax = 0.0;

        //*************************************************
        // Process Purchases                              *
        // - Check available stock                        *
        // - Clamp purchase quantity to available units   *
        // - Create CashRegister object                   *
        // - Update inventory after sale                  *
        // - Display sale details and accumulate totals   *
        //*************************************************
        System.out.println("Sales:");
        for (int i = 0; i < purchasePlan.length; i++) {
            int idx = purchasePlan[i][0];          // Index of the item in inventory
            int requestedQty = purchasePlan[i][1]; // Quantity requested by customer
            RetailItem item = inventory[idx];      // Get the corresponding item

            int available = item.getUnitsOnHand(); // Units currently in stock

            // Clamp purchase: actual quantity = min(requested, available)
            int actualQty = Math.max(0, Math.min(requestedQty, available));

            // Create CashRegister object for this sale
            sales[i] = new CashRegister(item, actualQty);

            // Update inventory (subtract sold units)
            item.subtractUnitsOnHand(actualQty);

            // Show per-sale details
            System.out.print(sales[i]);            // Implicit toString of CashRegister
            System.out.printf("|  Subtotal: $%6.2f |  Tax: $%.2f%n",
                    sales[i].getSubtotal(), sales[i].getTax());

            // Accumulate overall totals
            overallSubtotal += sales[i].getSubtotal();
            overallTax += sales[i].getTax();
        }

        System.out.println();                      // Blank line for spacing

        //*************************************************
        // Show Overall Totals                            *
        // Displays subtotal, tax, and total of all sales *
        //*************************************************
        System.out.println("Overall Totals:");
        System.out.printf("Subtotal: $%.2f%n", overallSubtotal);
        System.out.printf("Tax:      $%.2f%n", overallTax);
        System.out.printf("Total:    $%.2f%n", (overallSubtotal + overallTax));
        System.out.println();

        //*************************************************
        // Show Updated Inventory                         *
        // Inventory reflects remaining stock after sales *
        //*************************************************
        System.out.println("Inventory after Sales:");
        for (RetailItem item : inventory) {
            System.out.println(item);               // Print updated item details
        }

        //*************************************************
        // Output Developer Credit                        *
        //*************************************************
        System.out.println();
        System.out.println("Developed by: Nikita Baiborodov");

    }
}
