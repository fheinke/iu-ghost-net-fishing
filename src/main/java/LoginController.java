import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class LoginController implements Serializable {
    private Person user = new Person();
    private String name;
    private String surname;

    @Inject
    private PersonDAO personDAO;

    @Inject
    private CurrentUser currentUser;

    // Getter / Setter
    public Person getUser() {
        return user;
    }
    public void setUser(Person user) {
        this.user = user;
    }

    // Custom Methods
    public void postValidateName(ComponentSystemEvent event) throws AbortProcessingException {
        UIInput temp = (UIInput) event.getComponent();
        this.name = (String) temp.getValue();
    }
    public void postValidateSurname(ComponentSystemEvent event) throws AbortProcessingException {
        UIInput temp = (UIInput) event.getComponent();
        this.surname = (String) temp.getValue();
    }

    public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        List<Person> users = personDAO.findAll();

        String tempPhonenumber = value.toString().replaceAll(" ", "");
        Person temp = new Person(this.name, this.surname, tempPhonenumber);

        for (Person p : users) {
            if (p.equals(temp)) {
                currentUser.setLoggedIn(true);
                currentUser.setUser(p);
                return;
            }
        }
        currentUser.setLoggedIn(false);
        currentUser.setUser(null);
        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Anmeldedaten stimmen nicht überein.", null));
    }

    public String login() {
        return "index";
    }

    public String logout() {
        currentUser.setLoggedIn(false);
        currentUser.setUser(null);
        return "index?faces-redirect=true";
    }
}
