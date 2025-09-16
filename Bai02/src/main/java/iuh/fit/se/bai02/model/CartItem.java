package iuh.fit.se.bai02.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItem {
    private int id;
    private Product product;
    private int quantity;

    public double getTotalPrice(){
        return quantity*product.getPrice();
    }

}
