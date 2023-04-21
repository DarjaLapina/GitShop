
package shop_lapina_darja;

import entity.Customer;
import entity.Product;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import manager.Customer_manager;
import manager.Product_manager;

public class App {
    private Product[] products;
    private Customer[] customers;
    int history[];

    public App(){
        this.products = new Product[0];
        this.customers = new Customer[0];
        this.history = new int[0];
    }

    public void run(){
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("0. Закончить программу");
            System.out.println(" 1. Добавить продукт ");
            System.out.println(" 2. Список продаваемых продуктов ");
            System.out.println(" 3. Добавить покупателя ");
            System.out.println(" 4. Список покупателей ");
            System.out.println(" 5. Покупка продукта ");
            System.out.println(" 6. Доход магазина ");
            System.out.println(" 7. Добавить денег покупателю ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch(task){
                case 0:
                    System.out.println("0. Завершение программы ");
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. Добавить продукт ");
                    System.out.println();
                    Product_manager product_manager = new Product_manager();
                    this.products = Arrays.copyOf(this.products, this.products.length+1);
                    this.products[this.products.length-1] = product_manager.create_product();
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("2. Список продаваемых продуктов ");
                    System.out.println();
                    for (int i = 0; i<products.length;i++){
                        Product product = products[i];
                        System.out.println();
                        System.out.printf(i+1+ " Название: " + product.getName());
                        System.out.printf(" Цена: "+  product.getPrice());
                        System.out.printf(" Кол-во: "+ product.getQuantity());
                        System.out.println();
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("3. Добавить покупателя ");
                    System.out.println();
                    Customer_manager customer_manager = new Customer_manager();
                    this.customers = Arrays.copyOf(this.customers, this.customers.length+1);
                    this.customers[this.customers.length-1] = customer_manager.create_customer();
                    System.out.println();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("4. Список покупателей ");
                    System.out.println();
                    for (int i = 0; i<customers.length;i++){
                        Customer customer = customers[i];
                        System.out.println(i+1+ " Имя = "+ customer.getFirstname());
                        System.out.println(" Фамилия = "+ customer.getLastname());
                        System.out.println(" Баланс = "+ customer.getMoney());
                        System.out.println();
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("5. Покупка продукта ");
                    System.out.println();
                    for (int i = 0; i<products.length;i++){
                        Product product = products[i];
                        System.out.printf(i+1+" Название   = %s%n", product.getName());
                        System.out.printf(" Цена = %s%n", product.getPrice());
                        System.out.println();
                        System.out.println();
                    }
                    for (int i = 0; i<customers.length;i++){
                        Customer customer = customers[i];
                        System.out.println(i+1+" Имя = "+ customer.getFirstname());
                        System.out.println(" Фамилия = "+ customer.getLastname());
                        System.out.println(" Баланс = "+ customer.getMoney());
                        System.out.println(" Выберите покупателя: ");
                        int num_pokupatel = scanner.nextInt();
                        System.out.println(" Выберите продукт: ");
                        int num_produkt = scanner.nextInt();
                        System.out.println(" Выберите кол-во продукта: ");
                        int quantity_pokupka = scanner.nextInt();
                        int pokupka = customers[num_pokupatel -1].getMoney() - products[num_produkt -1].getPrice();
                        customers[num_produkt -1].setMoney(pokupka);
                        int count_tovar= products[num_produkt-1].getQuantity() - quantity_pokupka;
                        products[num_produkt-1].setQuantity(count_tovar);
                        this.history = Arrays.copyOf(this.history, this.history.length+1);
                        this.history[this.history.length-1] = products[num_produkt -1].getPrice();
                        System.out.println();
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("6. Доход магазина ");
                    System.out.println();
                    int summa = IntStream.of(history).sum();
                    System.out.println(" Доход = "+ summa);
                    System.out.println();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("7. Добавить денег покупателю ");
                    System.out.println();
                    for (int i = 0; i<customers.length;i++){
                        Customer customer = customers[i];
                        System.out.println(i+1+" Имя = "+ customer.getFirstname());
                        System.out.println(" Фамилия "+ customer.getLastname());
                        System.out.println(" Баланс = "+ customer.getMoney());
                    }
                    System.out.println(" Выберите покупателя: ");
                    int pokupatel = scanner.nextInt();
                    System.out.println(" Введите деньги");
                    int money = scanner.nextInt();
                    int moneyadd = customers[pokupatel -1].getMoney() + money;
                    customers[pokupatel -1].setMoney(moneyadd);
                    System.out.println();
                    System.out.println();
                    break;
                    default:
                    System.out.println("Выберите задачу из списка!");
            }
        }while(repeat);
        System.out.println("До свидания!");
    }
}