package MyObjects;

public class Congelator extends AparatFrigorific {
    int tempMin;
    
    public Congelator(int capacitate, String producator, int pret, int tempMin) {
        super(capacitate, producator, pret);
        this.tempMin = tempMin;
    }
    
    @Override
    public void afisare() {
        System.out.println("Congelator > capacitate " + capacitate + " L, producator " + producator + ", pret " + pret + " lei, temperatura minima " + tempMin + " grade Celsius.");
    }
}