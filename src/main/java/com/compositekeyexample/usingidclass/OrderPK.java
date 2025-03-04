package com.compositekeyexample.usingidclass;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class OrderPK implements Serializable {

    private int orderId;
    private int productId;

//    public OrderPK(int orderId, int productId) {
//        this.orderId = orderId;
//        this.productId = productId;
//    }

//    // Override equals() and hashCode() for proper comparison
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true; // If both objects are the same, return true
//        if (obj == null || getClass() != obj.getClass()) return false; // If different classes, return false
//
//        OrderPK orderPK = (OrderPK) obj;
//        return orderId == orderPK.orderId && productId == orderPK.productId; // Compare values
//    }
//
//    @Override
//    public int hashCode() {
//        return orderId + productId; // Generate a unique hash based on key values
//    }
}

