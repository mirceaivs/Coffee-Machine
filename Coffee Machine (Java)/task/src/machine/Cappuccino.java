package machine;

public class Cappuccino implements Coffee {
    final int WATER_ML_NEED = 200;
    final int MILK_ML_NEED = 100;
    final int COFFEE_BEANS_G_NEED = 12;
    final int COST = 6;

    @Override
    public void create() {
        int noCups = 1;
        boolean flag=true;
        for (int i = 0; i < noCups; i++) {
            int waterForCoffees = CoffeeMachine.getWater() / WATER_ML_NEED;
            int coffeeBeansForCoffees = CoffeeMachine.getCoffeeBeans() / COFFEE_BEANS_G_NEED;
            int milkForCoffees = CoffeeMachine.getMilk() / MILK_ML_NEED;

            if(waterForCoffees == 0){
                System.out.println("Sorry, not enough water!");
                flag=false;
                break;
            }
            if(coffeeBeansForCoffees == 0){
                System.out.println("Sorry, not enough coffee beans!");
                flag=false;
                break;
            }
            if(milkForCoffees == 0){
                System.out.println("Sorry, not enough milk!");
                flag=false;
                break;
            }
            if(CoffeeMachine.getDisposableCups() == 0){
                System.out.println("Sorry, not enough disposable cups!");
                flag=false;
                break;
            }
            int maxCups = Math.min(Math.min(Math.min(waterForCoffees, milkForCoffees), CoffeeMachine.getDisposableCups()), coffeeBeansForCoffees);
            if (i <= maxCups) {
                CoffeeMachine.substract("water", WATER_ML_NEED);
                CoffeeMachine.substract("coffeeBeans", COFFEE_BEANS_G_NEED);
                CoffeeMachine.substract("disposableCups", noCups);
                CoffeeMachine.substract("milk", MILK_ML_NEED);
                CoffeeMachine.add("money", COST);
            }
        }
        if(flag){
            System.out.println("I have enough resources, making you a coffee!");
        }

    }
}
