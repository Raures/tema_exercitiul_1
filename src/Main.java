import MyObjects.AparatFrigorific;
import MyObjects.Congelator;
import MyObjects.Frigider;
import MyObjects.FrigiderSideBySide;
import MyObjects.LadaFrigorifica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
Clasa Aparat Frigorific (cu atributul capacitate, producător si preț) din care se derivă frigider (cu atributul rafturi)
şi congelator (cu atributul tempMin). Din frigider se derivă frigider side by side(cu atributul culoare) şi din congelator, ladă frigorifică(cu atributul putere).
Creează o listă de aparate frigorifice ( cu cel puțin un obiect din fiecare clasă derivată) şi afişează informațiile despre
ele (se va scrie o funcție de afișare virtuală în clasa mamă și va fi implementată în fiecare clasă derivată)
· 1. Afișează numărul de lăzi frigorifice şi frigidere din şir.
· 2. Afișează prețul mediu al aparatelor frigorifice
· 3. Afișează capacitatea medie a fiecărui tip de aparat frigorific
· 4. Afișează aparatele frigorifice a căror preţ se încadrează într-un interval citit de la tastatură
· 5. Afișează numărul de lăzi frigorifice cu puterea mai mare de 95W
 */

public class Main {
    public static void main(String args[]) {

        int n = 4; // numar de aparate din fiecare clasa
        int nr_lazi_frigorifice = 0;
        int nr_frigidere = 0;
        int pret_mediu = 0;
        int interval_pret_minim = 0;
        int interval_pret_maxim = 0;
        int w_95 = 0; // numarul de lazi frigorifice cu puterea > 95W
        List<AparatFrigorific> aparate = new ArrayList<>();
        Random randy = new Random();
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= n; i++) {
            aparate.add(new Congelator(randy.nextInt(40, 60), "I Scream", randy.nextInt(800, 1100), randy.nextInt(-2, 0)));
            aparate.add(new Frigider(randy.nextInt(40, 80), "ARRRctic", randy.nextInt(1500, 2000), i + 2));
            aparate.add(new FrigiderSideBySide(randy.nextInt(40, 80), "Frigidere Gri", randy.nextInt(1500, 2000), i + 3, "Gri"));
            aparate.add(new LadaFrigorifica(randy.nextInt(120, 250), "Lada del Rey", randy.nextInt(2300, 3000), i + 2, randy.nextInt(80, 105)));
        }

        System.out.println("Toate aparatele frigorifice: ");

        for(var z : aparate) {
            z.afisare();
        }

        for(var z : aparate) {
            if(z instanceof LadaFrigorifica) {
                nr_lazi_frigorifice++;
            }
            if(z instanceof Frigider && !(z instanceof FrigiderSideBySide)) {
                nr_frigidere++;
            }
        }

        System.out.println("\nNumarul de lazi frigorifice: " + nr_lazi_frigorifice + ";");
        System.out.println("Numarul de frigidere: " + nr_frigidere + ".");

        for(var z : aparate) {
            if(z instanceof Congelator && !(z instanceof LadaFrigorifica)) {
                pret_mediu += ((Congelator) z).getPret();
            }
            if(z instanceof Frigider && !(z instanceof FrigiderSideBySide)) {
                pret_mediu += ((Frigider) z).getPret();
            }
            if(z instanceof FrigiderSideBySide) {
                pret_mediu += ((FrigiderSideBySide) z).getPret();
            }
            if(z instanceof LadaFrigorifica) {
                pret_mediu += ((LadaFrigorifica) z).getPret();
            }
        }

        System.out.println("\nPretul mediu al aparatelor frigorifice este de " + 1.0 * pret_mediu/n + " lei.");

        System.out.println("\n(Interval recomandat: 800 - 3000 lei.)");
        System.out.println("Introduceti pretul minim: ");
        interval_pret_minim = sc.nextInt();
        System.out.println("Introduceti pretul maxim: ");
        interval_pret_maxim = sc.nextInt();
        System.out.println("Aparatele frigorifice care se incadreaza in intervalul de pret " + interval_pret_minim + " - " + interval_pret_maxim + " lei:");

        for(var z : aparate) {
            if(z instanceof Congelator && !(z instanceof LadaFrigorifica) && ((Congelator) z).getPret() > interval_pret_minim && ((Congelator) z).getPret() < interval_pret_maxim) {
                ((Congelator) z).afisare();
            }
            if(z instanceof Frigider && !(z instanceof FrigiderSideBySide) && ((Frigider) z).getPret() > interval_pret_minim && ((Frigider) z).getPret() < interval_pret_maxim) {
                ((Frigider) z).afisare();
            }
            if(z instanceof FrigiderSideBySide && ((FrigiderSideBySide) z).getPret() > interval_pret_minim && ((FrigiderSideBySide) z).getPret() < interval_pret_maxim) {
                ((FrigiderSideBySide) z).afisare();
            }
            if(z instanceof LadaFrigorifica && ((LadaFrigorifica) z).getPret() > interval_pret_minim && ((LadaFrigorifica) z).getPret() < interval_pret_maxim) {
                ((LadaFrigorifica) z).afisare();
            }
        }

        for(var z : aparate) {
            if(z instanceof LadaFrigorifica && ((LadaFrigorifica) z).getPutere() > 95) {
                w_95++;
            }
        }

        System.out.println("\nExista " + w_95 + " lazi frigorifice care au puterea mai mare de 95W.");

    }
}
