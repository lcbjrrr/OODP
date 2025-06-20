package cash;

public class Guy {
    private String name;
    private float cash;
    Guy(String n,float c) {
        this.name=n;
        this.cash=c;
    }
    void takeCash(float v) {
        this.cash=this.cash+v;
    }
    void giveCash(float v) throws InsufficientFundsException {
        if(v<this.cash) {
            this.cash=this.cash-v;
        }else {
            throw new InsufficientFundsException(v);
        }
    }
    public static void main(String[] args) {
        Guy john=new Guy("John",100);
        Guy mary=new Guy("Mary",900);
        float value = 5000;
        try {
            john.giveCash(value);
            mary.takeCash(value);
        } catch (InsufficientFundsException ife){
            System.out.println( "Insufficient Funds of $ "+ife.getAmmount());
        }
        System.out.println(john.getName()+" $ "+john.getCash());
        System.out.println(mary.getName()+" $ "+mary.getCash());
    }
    public float getCash() {
        return cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
