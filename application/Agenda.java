package application;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<RendezVous> rendezVousList;

    public Agenda() {
        rendezVousList = new ArrayList<>();
    }

    public void ajouterRendezVous(RendezVous rendezVous) {
        rendezVousList.add(rendezVous);
    }

    public List<RendezVous> getRendezVousList() {
        return rendezVousList;
    }

	}
