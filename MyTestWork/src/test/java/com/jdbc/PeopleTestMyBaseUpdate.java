package com.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PeopleTestMyBaseUpdate {

    @Test
    public void myBaseUpdate() {

        PeoplePersistenceService mock = Mockito.mock(PeoplePersistenceService.class);

        Object[] mockValues = {1, "Balandin", "Kirill"};

        when(mock.updateByName("Kirill", "Sazonov")).thenReturn(true);

        PeopleService peopleService = new PeopleService(mock);

        Assert.assertEquals(true, peopleService.updateByName("Kirill", "Sazonov"));

        verify(mock).updateByName("Kirill", "Sazonov");
    }
}