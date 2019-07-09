import com.webaut.project.pages.Login;
import cucumber.api.java.en.Given;

public class LoginStep {
    @Given("I login as {string} user with password {string}")
    public void iLoginAsUserWithPassword(String userName, String password) {
        Login loginPage = new Login();
        loginPage.loginTrello(userName, password);
    }
}
