public enum CoffeeType {
    ESPRESSO(7,150,0),
    CAPPUCCINO(7,200,50),
    CAFFE_LATTE(7,50,150),
    AMERICANO(7,250,0);

    public final int requiredBeans;
    public final int requiredWater;
    public final int requiredMilk;

    CoffeeType(int requiredBeans,int requiredWater,int requiredMilk){
        this.requiredBeans=requiredBeans;
        this.requiredWater=requiredWater;
        this.requiredMilk=requiredMilk;
    }
}
