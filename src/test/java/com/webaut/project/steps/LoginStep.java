package com.webaut.project.steps;

import com.webaut.project.core.Environment;
import com.webaut.project.pages.Login;
import cucumber.api.java.en.Given;

public class LoginStep {

    private Login login;

    public LoginStep(Login login) {
        this.login = login;
    }

    @Given("I login as {string}")
    public void iLoginAs(String user) {
        String userName = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", user));
        String password = Environment.getInstance().getValue(String.format("$['credentials']['%s']['password']", user));
        this.login.loginTrello(userName, password);
    }
}
