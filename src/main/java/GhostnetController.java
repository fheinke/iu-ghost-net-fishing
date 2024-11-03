import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class GhostnetController implements Serializable {
    private Ghostnet newGhostnet = new Ghostnet();

    @Inject
    private GhostnetDAO ghostnetDAO;

    // Constructor
    public GhostnetController() {}

    // Getter / Setter
    public Ghostnet getNewGhostnet() {
        return newGhostnet;
    }
    public void setNewGhostnet(Ghostnet newGhostnet) {
        this.newGhostnet = newGhostnet;
    }

    // Additional Methods
    public String cancel() {
        return "index";
    }

    public String saveNewGhostnet() {
        newGhostnet.setStatus("Gemeldet");
        ghostnetDAO.save(newGhostnet);
        return "index";
    }
}
