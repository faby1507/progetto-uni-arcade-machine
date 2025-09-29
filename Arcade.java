import java.util.Random;
import java.util.Scanner;

public class Arcade {
    public static int punteggio;
    protected boolean monetaInserita;
    protected String vincitaSpeciale = null;
    Scanner scanner = new Scanner(System.in);

    protected void incrementaPunteggio(int moneta) {
        if (moneta == 1) {
            punteggio += 100;
        } else if (moneta == 2) {
            punteggio += 200;
        }
    }

    public String getVincitaSpeciale() {
        return vincitaSpeciale;
    }

    public int gioca() {
        System.out.println(3);
        System.out.println(2);
        System.out.println(1);
        return punteggio;
    }

    public class GiocoTris extends Arcade {
        @Override
        public int gioca() {
            monetaInserita = false;
            boolean termina = false;
            while (!monetaInserita && !termina) {
                System.out.println("Gira la ruota e vinci premi!\n");
                System.out.println("Inserisci una moneta (oppure premi 'q' per terminare)\n");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("q")) {
                    termina = true;
                    System.out.println("Hai terminato la partita!");
                    System.out.println("Punteggio finale: " + punteggio);
                    break;
                }
                try {
                    int moneta = Integer.parseInt(input);
                    monetaInserita = true;
                    if (moneta > 2) {
                        throw new MonetaTroppoGrandeException("Hai mai visto monete così grosse?");
                    }
                    incrementaPunteggio(moneta);
                    Random random = new Random();
                    int n1 = random.nextInt(5) + 1;
                    int n2 = random.nextInt(5) + 1;
                    int n3 = random.nextInt(5) + 1;

                    try {
                        System.out.print("[" + n1 + "]");
                        Thread.sleep(2000);

                        System.out.print(" [" + n2 + "]");
                        Thread.sleep(2000);

                        System.out.print(" [" + n3 + "]");
                        Thread.sleep(2000);

                        System.out.println();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (n1 == n2 && n2 == n3) {
                        System.out.println("JACKPOT! Hai fatto TRIS! \n");
                        vincitaSpeciale = "jackpot"; //memorizza la vincita
                    } else {
                        System.out.println("Peccato, ritenta!");
                    }
                    monetaInserita = false;
                } catch (NumberFormatException e) {
                    System.out.println("Inserisci una moneta valida (1 o 2 euro) oppure 'q' per terminare.");
                } catch (MonetaTroppoGrandeException e) {
                    System.out.println(e.getMessage());
                    monetaInserita = false;
                }
            }
            return punteggio;
        }
    }

    public class GiocoRossoNero extends Arcade {
        @Override
        public int gioca() {
            monetaInserita = false;
            boolean termina = false;
            while (!monetaInserita && !termina) {
                System.out.println("Inserisci una moneta (oppure premi 'q' per terminare)");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("q")) {
                    termina = true;
                    System.out.println("Hai terminato la partita!");
                    System.out.println("Punteggio finale: " + punteggio);
                    break;
                }
                try {
                    int moneta = Integer.parseInt(input);
                    monetaInserita = true;
                    if (moneta > 2) {
                        throw new MonetaTroppoGrandeException("Hai mai visto monete così grosse?");
                    }
                    incrementaPunteggio(moneta);

                    Random random = new Random();

                    System.out.print("Scegli un colore (rosso/nero): ");
                    String scelta = scanner.nextLine().toLowerCase();

                    int numero = random.nextInt(37);

                    String colore;
                    if (numero == 0) {
                        colore = "verde";
                    } else {
                        colore = (numero % 2 == 0) ? "nero" : "rosso";
                    }

                    System.out.println("È uscito il numero " + numero + " (" + colore + ")");

                    if (colore.equals(scelta)) {
                        System.out.println("Hai vinto!");
                        vincitaSpeciale = "medal"; // memorizza la vincita
                    } else {
                        System.out.println("Peccato, hai perso...");
                    }
                    monetaInserita = false;
                } catch (NumberFormatException e) {
                    System.out.println("Inserisci una moneta valida (1 o 2 euro) oppure 'q' per terminare.");
                } catch (MonetaTroppoGrandeException e) {
                    System.out.println(e.getMessage());
                    monetaInserita = false;
                }
            }
            return punteggio;
        }
    }

    public class GiocoDadi extends Arcade {
        @Override
        public int gioca() {
            System.out.println("Benvenuto al gioco dei dadi!");
            System.out.println("Regole: 7 o 11 vinci subito, 2/3/12 perdi subito.");

            boolean continua = true;

            while (continua) {
                monetaInserita = false;
                boolean termina = false;
                while (!monetaInserita && !termina) {
                    System.out.print("\nInserisci una moneta per giocare (oppure premi 'q' per terminare): ");
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("q")) {
                        termina = true;
                        continua = false;
                        System.out.println("Hai terminato la partita!");
                        System.out.println("Punteggio finale: " + punteggio);
                        break;
                    }
                    try {
                        int moneta = Integer.parseInt(input);
                        monetaInserita = true;
                        if (moneta > 2) {
                            throw new MonetaTroppoGrandeException("Hai mai visto monete così grosse?");
                        }
                        incrementaPunteggio(moneta);
                    } catch (NumberFormatException e) {
                        System.out.println("Inserisci una moneta valida (1 o 2 euro) oppure 'q' per terminare.");
                    } catch (MonetaTroppoGrandeException e) {
                        System.out.println(e.getMessage());
                        monetaInserita = false;
                    }
                }
                if (termina) break;

                System.out.print("Premi INVIO per lanciare i dadi...");
                scanner.nextLine();

                Random random = new Random();
                int dado1 = random.nextInt(6) + 1;
                int dado2 = random.nextInt(6) + 1;
                int somma = dado1 + dado2;

                System.out.println("Hai tirato: " + dado1 + " + " + dado2 + " = " + somma);

                if (somma == 7 || somma == 11) {
                    System.out.println("Hai vinto!");
                    vincitaSpeciale = "champion"; //memorizza la vincita
                } else if (somma == 2 || somma == 3 || somma == 12) {
                    System.out.println("Hai perso!");
                } else {
                    System.out.println("Niente di speciale, ritenta!");
                }

                System.out.print("Vuoi giocare ancora? (s/n): ");
                String risposta = scanner.nextLine().toLowerCase();
                if (!risposta.equals("s")) {
                    continua = false;
                    System.out.println("Grazie per aver giocato! Punteggio finale: \n" + punteggio);
                }
            }
            return punteggio;
        }
    }
}
