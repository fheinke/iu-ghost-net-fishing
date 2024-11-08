import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class GhostnetController implements Serializable {
    private Ghostnet newGhostnet = new Ghostnet();
    private List<Ghostnet> ghostnetList;
    private final MapModel<Long> ghostnetMapMarkers = new DefaultMapModel<>();

    @Inject
    private GhostnetDAO ghostnetDAO;
    @Inject
    private CurrentUser currentUser;

    // Constructor
    public GhostnetController() {}

    @PostConstruct
    public void init() {
        ghostnetList = ghostnetDAO.findAll();

        for (Ghostnet ghostnet : getGhostnetListNotRetrieved()) {
            ghostnetMapMarkers.addOverlay(new Marker<>(new LatLng(ghostnet.getLatitude(), ghostnet.getLongitude())));
        }
    }

    // Getter / Setter
    public Ghostnet getNewGhostnet() {
        return newGhostnet;
    }
    public void setNewGhostnet(Ghostnet newGhostnet) {
        this.newGhostnet = newGhostnet;
    }

    public MapModel<Long> getGhostnetMapMarkers() {
        return ghostnetMapMarkers;
    }

    // Additional Methods
    public String saveNewGhostnet() {
        newGhostnet.setStatus("Gemeldet");
        ghostnetDAO.save(newGhostnet);
        return "index";
    }

    public List<Ghostnet> getGhostnetListNotRetrieved() {
        List<Ghostnet> ghostnetListNotRetrieved = new ArrayList<>();
        for (Ghostnet ghostnet : ghostnetList) {
            if (!ghostnet.getStatus().equals("Geborgen")) {
                ghostnetListNotRetrieved.add(ghostnet);
            }
        }
        return ghostnetListNotRetrieved;
    }
    public List<Ghostnet> getGhostnetListRetrieved() {
        List<Ghostnet> ghostnetListRetrieved = new ArrayList<>();
        for (Ghostnet ghostnet : ghostnetList) {
            if (ghostnet.getStatus().equals("Geborgen")) {
                ghostnetListRetrieved.add(ghostnet);
            }
        }
        return ghostnetListRetrieved;
    }

    public List<SelectItem> getRetrievingPersonOptions(Ghostnet ghostnet, CurrentUser currentUser) {
        List<SelectItem> options = new ArrayList<>();

        if (ghostnet.getRetrievingPerson() != null) {
            options.add(new SelectItem(ghostnet.getRetrievingPerson(), ghostnet.getRetrievingPerson().getFullName()));

            if (ghostnet.getRetrievingPerson().getId() == currentUser.getUser().getId()) {
                options.add(new SelectItem(null, "Nicht mehr bergen"));
            } else {
                options.add(new SelectItem(currentUser.getUser(), currentUser.getUser().getFullName()));
            }
            return options;
        }

        options.add(new SelectItem(null, "Nicht bergen"));
        options.add(new SelectItem(currentUser.getUser(), currentUser.getUser().getFullName()));
        return options;
    }

    public void editEntryRowEvent(RowEditEvent<Ghostnet> event) {
        ghostnetDAO.update(event.getObject());
        FacesMessage msg = new FacesMessage("Bearbeitung abgeschlossen", String.valueOf(event.getObject().getStatus()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void editEntryRowCancelEvent(RowEditEvent<Ghostnet> event) {
        FacesMessage msg = new FacesMessage("Bearbeitung abgebrochen", String.valueOf(event.getObject().getStatus()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteGhostnet(Ghostnet ghostnet) {
        ghostnetList.remove(ghostnet);
        ghostnetDAO.delete(ghostnet);
        FacesMessage message = new FacesMessage("Eintrag wurde gelöscht", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
