import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class GhostnetListController implements Serializable {
    private GhostnetList ghostnet;

    public GhostnetListController() {}

    public GhostnetList getGhostnet() {
        return ghostnet;
    }
    public void setGhostnet(GhostnetList ghostnet) {
        this.ghostnet = ghostnet;
    }

    public String startEdit() {
        return "edit";
    }

    public String stopEdit() {
        return "index";
    }
}
