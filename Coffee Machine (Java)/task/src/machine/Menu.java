package machine;
import java.util.Scanner;

interface iMenu{
    void exit();
    void buy();
    void take();
    void fill();
    void init();
    void remaining();

}

public class Menu implements iMenu {

    private static final Scanner scanner = new Scanner(System.in);


    @Override
    public void buy(){
        CoffeeFactory cafea = new CoffeeFactory();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();
        switch (choice){
            case "1":
                cafea.getCoffee("espresso").create();
                init();
                break;
            case "2":
                cafea.getCoffee("latte").create();
                init();
                break;
            case "3":
                cafea.getCoffee("cappuccino").create();
                init();
                break;
            default:
                init();
        }
    }
    @Override
    public void remaining(){
        System.out.println("\nThe coffee machine has:\n"
                + CoffeeMachine.getWater() +" ml of water\n"
                + CoffeeMachine.getMilk() +" ml of milk\n"
                + CoffeeMachine.getCoffeeBeans() +" g of coffee beans\n"
                + CoffeeMachine.getDisposableCups() +" disposable cups\n"
                + "$"+CoffeeMachine.getMoney() +" of money"
        );
        init();
    }
    @Override
    public void init(){
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String choice = scanner.next();
        switch(choice){
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "exit":
                exit();
                break;
            case "remaining":
                remaining();
                break;
            default:
                init();
        }
    }
    @Override
    public void exit(){
        System.exit(0);
    }

    @Override
    public void take(){
        System.out.println("I gave you $"+ CoffeeMachine.getMoney());
        CoffeeMachine.setMoney(0);
        init();
    }
    @Override
    public void fill(){
        System.out.println("Write how many ml of water you want to add:");
        int waterAdd = scanner.nextInt();
        CoffeeMachine.add("water", waterAdd);
        System.out.println("Write how many ml of milk you want to add:");
        int milkAdd = scanner.nextInt();
        CoffeeMachine.add("milk", milkAdd);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeAdd = scanner.nextInt();
        CoffeeMachine.add("coffeeBeans", coffeeAdd);
        System.out.println("Write how many disposable cups you want to add:");
        int cupsAdd = scanner.nextInt();
        CoffeeMachine.add("disposableCups", cupsAdd);
        init();
    }
}
