package com.compositekeyexample.usingidclass;


import com.compositekeyexample.embeddableclass.OrderPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(OrderPK.class)
@Table(name = "orders")
public class Order {

    @Id
    private int orderId;

    @Id
    private int productId;

    private String customerName;
}
