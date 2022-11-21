package com.netbiis.wasabibackend.Exceptions;

public class ProductsNotFoundException extends Throwable{
    public ProductsNotFoundException(String message){
        super(message);
    }
}
