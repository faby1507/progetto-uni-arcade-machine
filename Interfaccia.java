import java.util.Scanner;

public class Interfaccia {

    public String nomeGiocatore;
    Scanner scanner = new Scanner(System.in);

    public void setNomeGiocatore(String nomeGiocatore) {
        System.out.println("Inserisci nome giocatore:\n");
        this.nomeGiocatore = scanner.nextLine();
    }

    public int selezionaGioco() {
        System.out.println("Seleziona il gioco e vinci premi! \n");
        System.out.println("1- Tris \n2- Rosso/Nero \n3- Dadi");
        int scelta = scanner.nextInt();
        int punteggio = 0;

        switch (scelta) {
            case 1: {
                Arcade a1 = new Arcade();
                Arcade.GiocoTris gioco1 = a1.new GiocoTris();
                punteggio = gioco1.gioca();
                break;
            }
            case 2: {
                Arcade a2 = new Arcade();
                Arcade.GiocoRossoNero gioco2 = a2.new GiocoRossoNero();
                punteggio = gioco2.gioca();
                break;
            }
            case 3: {
                Arcade a3 = new Arcade();
                Arcade.GiocoDadi gioco3 = a3.new GiocoDadi();
                punteggio = gioco3.gioca();
                break;
            }
            default:
                System.out.println("Scelta non valida.");
        }

        return punteggio;
    }
}

