package zombi.kampung.pisang22.jamburock;

import java.io.Serializable;
import java.util.ArrayList;

public class McDonny implements Serializable {

    // variable
    public String combo_meal, combo_size;
    public int quantity;
    public ArrayList<String> add_on;
    public double total_price;

    //constructor
    public McDonny() {
        combo_meal = "";
        combo_size = "";
        quantity = 0;
        add_on = new ArrayList<>();
        total_price = 0.0;
    }

    //calculation
    public double calculatePrice(int quantity) {
        if (combo_size.equalsIgnoreCase("Small RM 2.50")) {
            total_price = quantity * 2.5;
        }
        else if (combo_size.equalsIgnoreCase("Medium RM 4.00")) {
            total_price = quantity * 4.00;
        }
        else if (combo_size.equalsIgnoreCase("Large RM 6.00")) {
            total_price = quantity * 6.00;
        }

        return total_price;

    }

}
