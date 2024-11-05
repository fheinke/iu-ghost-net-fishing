import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class Overview implements Serializable {
    public Overview() {}

    public String addGhostnet() {
        return "add";
    }

    public String login() {
        return "login";
    }
}
