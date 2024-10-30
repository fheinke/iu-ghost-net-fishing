import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class GhostnetList implements Serializable {
    private static GhostnetList instance = new GhostnetList(); // TODO: Wieso wird eine Instanz erzeugt?
    private List<Ghostnet> ghostnets = new ArrayList<>();

    public GhostnetList() {
        ghostnets.add(new Ghostnet(8.123, 49.123, 20, "Gemeldet"));
        ghostnets.add(new Ghostnet(40.1233, 6.123, 200, "Verschollen"));
    }

    public static GhostnetList getInstance() {
        return instance;
    }

    public List<Ghostnet> getGhostnets() {
        return ghostnets;
    }
    public void setGhostnets(List<Ghostnet> ghostnets) {
        this.ghostnets = ghostnets;
    }
}
