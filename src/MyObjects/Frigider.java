package MyObjects;

public class Frigider extends AparatFrigorific {
    int rafturi;
    
    public Frigider(int capacitate, String producator, int pret, int rafturi) {
        super(capacitate, producator, pret);
        this.rafturi = rafturi;
    }
    
    @Override
    public void afisare() {
        System.out.println("Frigider > capacitate " + capacitate + " L, producator " + producator + ", pret " + pret + " lei, rafturi " + rafturi + ".");
    }
}