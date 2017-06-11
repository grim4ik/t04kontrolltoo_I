//Harmooniline keskmine

//* Koosta funktsioon, mille sisendiks on kahe kilomeetripikkuse loigu labimise kiirused (km/h), valjundiks nende kahe kilomeetri labimise keskmine kiirus. //tehtud

//* Funktsioonile antakse ette kilomeetripikkuste loikude labimiste keskmised kiirused kogumina (km/h). Valjasta kogu selle tee labimise keskmine kiirus. //tehtud

//* Kilomeetriste loikude labimiste keskmised kiirused loetakse sisse veebiaadressilt, kogu teekonna labimise keskmine kiirus salvestatakse faili. Kui failis juba on soovitud vastus, 
//* siis seda ule ei kirjutata (faili muutmisaeg jaab endiseks).


import java.io.*;
import java.net.URL;
import java.util.*;
import java.lang.*;

public class Kiirus {

    public static void annaKeskmine(double... tempo) {
        double summa = 0;
        for (double item : tempo) {
            summa = summa + (1 / item);
        }
        System.out.printf("Sisestatud vaartuste keskmmine on: %.2f km/h\n", tempo.length / summa);
    }

    public static void keskminineMassiivist(int... kiirused) {
        int total = 0;
        for (int aKiirused : kiirused) {
            total = total + aKiirused;
        }
        System.out.printf("Sisestatud andmete keskmine on: %.1f\n", (float) total / kiirused.length);
    }

    public static String loeVeebist() throws IOException {
        String vastus;
        double total = 0;
        URL url = new URL("http://www.tlu.ee/~jaagup/andmed/muu/pikkused.txt");
        Scanner s = new Scanner(url.openStream());
        String content = s.nextLine();
        String[] array = content.split("\\s+");

        for (String element : array) {
            double helper = Integer.parseInt(element);
            total += 1 / helper;
        }


        vastus = String.valueOf(array.length / total);
        return vastus;
    }

    public static void loeFaili() throws IOException {

        // FAILIST JA VEEBIST LUGEMINE
        Scanner in = new Scanner(new FileReader("vastus.txt"));
        String failiSisu = in.nextLine();
        String veebiSisu = loeVeebist();

        if (failiSisu.equals(veebiSisu)) {
            System.out.println("Faili sisu on nagu peab.");

        } else {
            // KIRJUTAMINE
            PrintWriter writer = new PrintWriter("vastus.txt", "UTF-8");
            writer.println(loeVeebist());
            writer.close();
        }


    }


    public static void main(String args[]) throws IOException {
        annaKeskmine(30, 60, 60, 30);
        keskminineMassiivist(60, 70, 90, 120);
        loeFaili();

    }
}