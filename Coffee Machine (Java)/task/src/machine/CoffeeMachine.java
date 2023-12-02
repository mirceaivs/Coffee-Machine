package machine;

public class CoffeeMachine {

    private static int waterMl;
    private static int milkMl;
    private static int coffeeBeansG;
    private static int disposableCups;
    private static int money;

    public static int getWater(){
        return waterMl;
    }

    public static int getMilk(){
        return milkMl;
    }

    public static int getCoffeeBeans(){
        return coffeeBeansG;
    }

    public static int getMoney(){
        return money;
    }

    public static int getDisposableCups(){
        return disposableCups;
    }

    public static void setMoney(int value) {
        money = value;
    }

    public CoffeeMachine(){
        waterMl = 400;
        milkMl = 540;
        coffeeBeansG = 120;
        disposableCups = 9;
        money = 550;

    }

    public void start(){
        Menu meniu = new Menu();
        meniu.init();
    }
    public static void add(String toAdd, int value){
        switch (toAdd){
            case "water":
                waterMl+=value;
                break;
            case "milk":
                milkMl+=value;
                break;
            case "coffeeBeans":
                coffeeBeansG+=value;
                break;
            case "disposableCups":
                disposableCups+=value;
                break;
            case "money":
                money+=value;
                break;
            default:
                System.out.println("Invalid ingredient");
        }
    }

    public static void substract(String toAdd, int value){
        switch (toAdd){
            case "water":
                waterMl-=value;
                break;
            case "milk":
                milkMl-=value;
                break;
            case "coffeeBeans":
                coffeeBeansG-=value;
                break;
            case "disposableCups":
                disposableCups-=value;
                break;
            case "money":
                money+=value;
                break;
            default:
                System.out.println("Invalid ingredient");
        }
    }

    public static void main(String[] args) {
    CoffeeMachine coffeeMachine = new CoffeeMachine();
    coffeeMachine.start();
    }
}
