package com.webaut.project;

import com.webaut.project.pages.AddCard;
import com.webaut.project.pages.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddCardTest {

    @Before
    public void setUp() {
        String userName = "X";
        String password = "X";
        Login login = new Login();
        login.loginTrello(userName, password);
    }

    @Test
    public void testAddCard() {
        // Given
        // When
        // Then

        AddCard addCard = new AddCard();
        String listName = "List 1";
        String title = "This is a test";
        String boardName = "testboard";
        addCard.addTitleCard(listName, title, boardName);
        Boolean actual = addCard.isCardVisible(title);
        assertTrue(actual);
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }
}
