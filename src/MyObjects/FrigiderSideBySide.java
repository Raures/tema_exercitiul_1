package MyObjects;
import MyObjects.Frigider;

public class FrigiderSideBySide extends Frigider {
    String culoare;
    
    public FrigiderSideBySide(int capacitate, String producator, int pret, int rafturi, String culoare) {
        super(capacitate, producator, pret, rafturi);
        this.culoare = culoare;
    }  
    
    @Override
    public void afisare() {
        System.out.println("FrigiderSideBySide > capacitate " + capacitate + " L, producator " + producator + ", pret " + pret + " lei, culoare " + culoare + ".");
    }
}