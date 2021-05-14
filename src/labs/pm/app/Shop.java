package labs.pm.app;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.*;
import java.util.*;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import labs.pm.data.*;
import static labs.pm.data.Rating.*;

public class Shop {

    public static void main(String[] args) {
        
        ProductManager pm = ProductManager.getInstance();

        // AtomicInteger clienteCount = new AtomicInteger(0);

        // Callable<String> client = () -> {
        //     String clientId = "Client" + clienteCount.incrementAndGet();
        //     String threadName = Thread.currentThread().getName();
        //     int productId = ThreadLocalRandom.current().nextInt(6)+ 101;
        //     StringBuilder log = new StringBuilder();
        //     log.append(clientId+" " +threadName+"\n-\tstart of log\t-\n"); 

        //     log.append(pm.getDiscounts("es_MX").entrySet().stream().map(entry -> entry.getKey() + "\t" + entry.getValue())
        //                                      .collect(Collectors.joining("\n")));

        //     Product product = pm.reviewProduct(productId, Rating.FOUR_STAR, "Yet another review");

        //     log.append(product !=null ? "\nProduct " + productId + " reviewed\n" : "\nProduct " + productId + " not reviewed\n");
        //     pm.printProductReport(productId, "es_MX", clientId);
        //     log.append(clientId+" generated report for "+productId+" product");
        //     log.append("\n-\tend of log\t-\n");

        //     return log.toString();
        // };

        pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), NOT_RATED);
        //  pm.parseProduct("D,101,Tea,100.99,0,2019-09-19");
        // pm.printProductReport(42);  //Ejemplo que maneja una excepcion
        pm.reviewProduct(42, FOUR_STAR, "Nice hot cup of tea");   //Ejemplo que maneja una excepcion
        // pm.printProductReport(101);
        // pm.parseReview("101,4,Nice hot cup of tea");
        // pm.parseReview("101,2,Rather weak tea");
        // pm.parseReview("101,4,Fine tea");
        // pm.parseReview("101,X, Good tea");
        // pm.parseReview("101,5,Perfect tea");
        // pm.parseReview("101,3,Just add some lemon");


        pm.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), NOT_RATED);
        pm.reviewProduct(102, THREE_STAR, "Coffee was ok");
        pm.reviewProduct(102, ONE_STAR, "Where is the milk");
        pm.reviewProduct(102, FIVE_STAR, "It's perfect with ten spoons of sugar");
        // pm.printProductReport(102);

        // pm.parseProduct("F,103,Cake,3.99,0,2019-09-30");
        pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), NOT_RATED, LocalDate.now().plusDays(2));
        pm.reviewProduct(103, FIVE_STAR, "Very nice cake");
        pm.reviewProduct(103, FOUR_STAR, "It good, but I've expected more chocolate");
        pm.reviewProduct(103, FIVE_STAR, "This cake is perfect");
        // pm.printProductReport(103);

        pm.createProduct(104, "Cookie", BigDecimal.valueOf(2.99), NOT_RATED, LocalDate.now());
        pm.reviewProduct(104, THREE_STAR, "Just another cookie");
        pm.reviewProduct(104, THREE_STAR, "ok");
        // pm.printProductReport(104);
        
        pm.createProduct(105, "Hot Chocolate", BigDecimal.valueOf(2.50), NOT_RATED);
        pm.reviewProduct(105, FOUR_STAR, "Tasty");
        pm.reviewProduct(105, FOUR_STAR, "Not bad at all");
        // pm.printProductReport(105);

        pm.createProduct(106, "Chocolate", BigDecimal.valueOf(2.50), NOT_RATED, LocalDate.now().plusDays(3));
        pm.reviewProduct(106, TWO_STAR, "Too sweet");
        pm.reviewProduct(106, THREE_STAR, "Better than cookie");
        pm.reviewProduct(106, TWO_STAR, "Too bitter");
        pm.reviewProduct(106, ONE_STAR, "I don't get it!");
        pm.printProductReport(106);

        // pm.printProducts( p->p.getPrice().floatValue() < 2,
        //              (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());

        // pm.getDiscounts().forEach((rating, discount)-> System.out.println(rating + '\t' + discount));             
        // pm.printProducts((p1, p2) -> p1.getRating().ordinal() - p2.getRating().ordinal());
    
        Comparator<Product> ratingSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());
        Comparator<Product> nameSorter = (p1, p2) -> p1.getName().compareTo(p2.getName());
        // pm.printProducts(ratingSorter.thenComparing(nameSorter));

        pm.dumpData();
        pm.restoreData();

        // pm.printProductReport(101, "es-MX");
        // pm.printProductReport(102, "fr");



        // List<Callable<String>> clients = Stream.generate( () -> client).limit(5).collect(Collectors.toList());

        // ExecutorService executorService = Executors.newFixedThreadPool(3);

        // try {
        //     List<Future<String>> results = executorService.invokeAll(clients);
        //     executorService.shutdown();
        //     results.stream().forEach(result -> {
        //         try {
        //             System.out.println(result.get());
        //         }
        //         catch(InterruptedException | ExecutionException ex) {
        //             Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error retrieving client log", ex);
        //         }
        //     });
        // }
        // catch (InterruptedException ex) {
        //     Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error invoking clients", ex);
        // }

    }
    
}
