import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

// TODO: This used to be an @FacesConverter, but because we need @Inject which does not work this way, it is a managed bean now
@Named
@ApplicationScoped
public class RetrievingPersonConverter implements Converter {
    @Inject
    private PersonDAO personDAO;

    @Override
    public Person getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return personDAO.findById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        return String.valueOf(((Person) value).getId());
    }
}
