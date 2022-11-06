package com.smarthack.farmApp.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ScriptProduct {
    String name;
    String quantity;
    Float price;

    public ScriptProduct(String name, Float price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
