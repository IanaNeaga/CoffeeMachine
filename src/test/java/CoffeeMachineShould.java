import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CoffeeMachineShould {

    @Test
    public void brewEspressoWhenStockAvailable(){
            CoffeeMachine m=new CoffeeMachine();
            Coffee c=m.brew(CoffeeType.ESPRESSO);
        assertEquals(CoffeeType.ESPRESSO,c.getCoffeeType()/*sigur sa fie espresso*/);
    }

    @Test
    public void brewCappuccinoWhenStockAvailable(){
        CoffeeMachine m=new CoffeeMachine();
        Coffee c=m.brew(CoffeeType.CAPPUCCINO);
        assertEquals(CoffeeType.CAPPUCCINO,c.getCoffeeType()/*sigur sa fie cappuccino*/);
    }

    @Test(expected=IllegalArgumentException.class)
    public void throwExceptionAfterBrewingMultipleEspresso(){
        CoffeeMachine m=new CoffeeMachine();
        for(int i=1;i<=100;i++){
            m.brew(CoffeeType.CAPPUCCINO);
        }
    }

    @Test
    public void brewEspressoWhenNotEnoughStockAfterRestock(){
        CoffeeMachine m=new CoffeeMachine();
        Coffee c=null;
        for(int i=0;i<1000;i++){
            try{
                c=m.brew(CoffeeType.ESPRESSO);
            }catch (IllegalArgumentException ex){
                m.restock();
            }
        }
        assertEquals(CoffeeType.ESPRESSO,c.getCoffeeType());
    }
}
