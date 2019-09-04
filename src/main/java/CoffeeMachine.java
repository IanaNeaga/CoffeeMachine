public class CoffeeMachine implements AutomaticCoffeeMachine {

    private int beans;
    private int water;
    private int milk;

    public CoffeeMachine(){
        beans=100;
        water=1000;
        milk=1000;
    }

    public Coffee brew(CoffeeType type) {
        if(beans>=type.requiredBeans && water>=type.requiredWater && milk>=type.requiredMilk) {
            beans -= type.requiredBeans;
            water -= type.requiredWater;
            milk -= type.requiredMilk;
            return new Coffee(type);
        }
        else {
            String errorMessage="Not enough ";
            if(beans<type.requiredBeans){
                errorMessage+="beans ";
            }
            if(milk<type.requiredMilk){
                errorMessage+="milk ";
            }
            if(water<type.requiredWater){
                errorMessage+="water ";
            }
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void restock() {
        beans+=100;
        water+=1000;
        milk+=1000;
    }
}
