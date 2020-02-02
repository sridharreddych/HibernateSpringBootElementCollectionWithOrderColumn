package com.bookstore;

import com.bookstore.service.ShoppingCartService;
import com.bookstore.entity.ShoppingCart;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final ShoppingCartService shoppingCartService;

    public MainApplication(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
                         
            System.out.println("\nAdd one book at the beginning of the current cart ...");
            shoppingCartService.addToTheBeginning();
            
            System.out.println("\nAdd one book at the end of the current cart ...");
            shoppingCartService.addToTheEnd();
            
            System.out.println("\nAdd one book in the middle of the current cart ...");
            shoppingCartService.addInTheMiddle();
            
            System.out.println("\nRemove first book from the cart ...");
            shoppingCartService.removeFirst();
            
            System.out.println("\nRemove last book from the cart ...");
            shoppingCartService.removeLast();
            
            System.out.println("\nRemove middle book from the cart ...");
            shoppingCartService.removeMiddle();
            
        };
    }
}
/*
*How @ElementCollection With @OrderColumn Works

Description: This application reveals the performance penalties of using @ElementCollection. In this case, with @OrderColumn. But, as you can see in this application (in comparison with item 33), by adding @OrderColumn can mitigate some performance penalties when operations takes place near the collection tail (e.g., add/remove at/from the end of the collection). Mainly, all elements situated before the adding/removing entry are left untouched, so the performance penalty can be ignored if we affect rows close to the collection tail.

Key points:

an @ElementCollection doesn't have a primary key
an @ElementCollection is mapped in a separate table
prefer @ElementCollection with @OrderColumn when you have a lot of inserts and deletes near the collection tail
the more elements are inserted/removed from the beginning of the collection the greater the performance penalty will be
Output example:
*
*/