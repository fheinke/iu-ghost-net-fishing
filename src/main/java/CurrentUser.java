import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class CurrentUser implements Serializable {
    private boolean isLoggedIn;
    private Person user;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Person getUser() {
        return user;
    }
    public void setUser(Person user) {
        this.user = user;
    }
}
