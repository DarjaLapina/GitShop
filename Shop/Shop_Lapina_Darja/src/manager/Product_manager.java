package manager;

import entity.Product;
import java.util.Scanner;

public class Product_manager {
    private final Scanner scanner;

    public Product_manager(){
        this.scanner = new Scanner(System.in);
    }
    public Product create_product(){
        Product product = new Product();
        System.out.println(" Введите название: ");
        product.setName(scanner.nextLine());
        System.out.println("Введите цену продукта: ");
        product.setPrice(scanner.nextInt());
        System.out.println(" Введите кол-во: ");
        product.setQuantity(scanner.nextInt());
        scanner.nextLine();
        return product;

        }
    }

