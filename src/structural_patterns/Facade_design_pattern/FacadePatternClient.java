package structural_patterns.Facade_design_pattern;

interface MobileShop {
     void modelNo();
     void price();
}

class Iphone implements MobileShop {
    @Override
    public void modelNo() {
        System.out.println(" Iphone 6 ");
    }
    @Override
    public void price() {
        System.out.println(" Rs 65000.00 ");
    }
}

class Samsung implements MobileShop {
    @Override
    public void modelNo() {
        System.out.println(" Samsung galaxy tab 3 ");
    }
    @Override
    public void price() {
        System.out.println(" Rs 45000.00 ");
    }
}

 class ShopKeeper {
    private MobileShop iphone;
    private MobileShop samsung;


    public ShopKeeper(){
        iphone= new Iphone();
        samsung=new Samsung();

    }
    public void iphoneSale(){
        iphone.modelNo();
        iphone.price();
    }
    public void samsungSale(){
        samsung.modelNo();
        samsung.price();
    }

}



public class FacadePatternClient {
    public static void main(String[] args) {

        ShopKeeper shopKeeper = new ShopKeeper();

        shopKeeper.iphoneSale();
        shopKeeper.samsungSale();

    }
}
