package MyObjects;

public class AparatFrigorific {
    int capacitate;
    String producator;
    int pret;
    
    public AparatFrigorific(int capacitate, String producator, int pret) {
        this.capacitate = capacitate;
        this.producator = producator;
        this.pret = pret;
    }
    
    public void afisare() {
        System.out.println("Sunt un aparat frigorific.");
    }

    public int getPret() {
        return this.pret;
    }
}