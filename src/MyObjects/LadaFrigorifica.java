package MyObjects;

public class LadaFrigorifica extends Congelator {
    int putere;
    
    public LadaFrigorifica(int capacitate, String producator, int pret, int tempMin, int putere) {
        super(capacitate, producator, pret, tempMin);
        this.putere = putere;
    }
    
    @Override
    public void afisare() {
        System.out.println("Lada Frigorifica > capacitate " + capacitate + " L, producator " + producator + ", pret " + pret + " lei, temperatura minima " + tempMin + " grade Celsius, putere " + putere + "W.");
    }

    public int getPutere() {
        return this.putere;
    }
}