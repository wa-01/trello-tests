package com.webaut.project;

import com.webaut.project.pages.AddCard;
import com.webaut.project.pages.EditCard;
import com.webaut.project.pages.Login;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EditCardTest {
    @Before
    public void setUp() {
        String userName = "lizzytest";
        String password = "l122y4m4b3l";
        Login login = new Login();
        login.loginTrello(userName, password);

        AddCard addCard = new AddCard();
        String listName = "List 1";
        String title = "This is a test";
        String boardName = "testboard";
        addCard.addTitleCard(listName, title, boardName);
    }

    @Test
    public void testEditCard() {
        // Given
        // When
        // Then

        EditCard editCard = new EditCard();
        String title = "This is a test";
        String description = "This is a description";
        String comment = "This is a comment";
        editCard.editCard(title, description, comment);
    }
}
