import java.util.HashMap;
import java.util.Map;
public class Premi {
    private Map<String, Integer> premi = new HashMap<>();
    private Map<String, String> premiVincite = new HashMap<>();
    public Premi() {
        premi.put("Orsacchiotto", 1200);
        premi.put("Braccialetto", 300);
        premi.put("Portachiavi", 700);

        premiVincite.put("Viaggio in Giappone", "Jackpot");
        premiVincite.put("iPhone", "Champion" );
        premiVincite.put("Nintendo Switch 2", "Medal");


    }

    //riscatta premio in base al punteggio
    public String riscattaPremio(int punteggio) {
        for (Map.Entry<String, Integer> entry : premi.entrySet()) {
            if (punteggio >= entry.getValue()) {
                return "Hai riscattato: " + entry.getKey();
            }
        }
        return "Nessun premio riscattato.";
    }

    //riscatta premio in base alla vincita speciale
    public String riscattaPremio(String vincita) {
        for (Map.Entry<String, String> entry : premiVincite.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(vincita)) {
                return "Hai riscattato: " + entry.getKey();
            }
        }
        return "Nessun premio speciale riscattato.";
    }

}
