package machine;

public class CoffeeFactory {
        public Coffee getCoffee(String coffeeType){
            switch (coffeeType){
                case "espresso":
                    return new Espresso();
                case "latte":
                    return new Latte();
                case "cappuccino":
                    return new Cappuccino();
                default:
                    return null;
            }
    }
}
