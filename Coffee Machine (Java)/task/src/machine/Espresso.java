package machine;

public class Espresso implements Coffee {
    final int WATER_ML_NEED = 250;
    final int COFFEE_BEANS_G_NEED = 16;
    final int COST = 4;


    @Override
    public void create() {
        int noCups = 1;
        boolean flag=true;
        for(int i=0; i<noCups; i++){
            int waterForCoffees = CoffeeMachine.getWater() / WATER_ML_NEED;
            int coffeeBeansForCoffees = CoffeeMachine.getCoffeeBeans() / COFFEE_BEANS_G_NEED;

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
            if(CoffeeMachine.getDisposableCups() == 0){
                System.out.println("Sorry, not enough disposable cups!");
                flag=false;
                break;
            }
            int maxCups = Math.min(Math.min(waterForCoffees, CoffeeMachine.getDisposableCups()), coffeeBeansForCoffees);
            if(i <= maxCups)
            {
                CoffeeMachine.substract("water", WATER_ML_NEED);
                CoffeeMachine.substract("coffeeBeans", COFFEE_BEANS_G_NEED);
                CoffeeMachine.substract("disposableCups", noCups);
                CoffeeMachine.add("money", COST);
            }
        }
        if(flag){
            System.out.println("I have enough resources, making you a coffee!");
        }

    }
}

