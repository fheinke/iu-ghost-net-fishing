import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class Overview implements Serializable {
    @Inject
    private GhostnetDAO ghostnetDAO;

    public Overview() {}

    public List<Ghostnet> getGhostnetList() {
        return ghostnetDAO.findAll();
    }

    public String addGhostnet() {
        return "add";
    }
    public String login() {
        return "login";
    }
}
