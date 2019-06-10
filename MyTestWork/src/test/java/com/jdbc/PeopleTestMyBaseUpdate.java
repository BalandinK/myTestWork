package com.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;

import static org.junit.Assert.*;
<<<<<<< HEAD
import static org.mockito.Mockito.*;
=======
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
>>>>>>> b67fb18fa0ddde75387ba87f263443502836b924

public class PeopleTestMyBaseUpdate {

    @Test
    public void myBaseUpdate() {

        PeoplePersistenceService mock = Mockito.mock(PeoplePersistenceService.class);

        Object[] mockValues = {1, "Balandin", "Kirill"};

        when(mock.updateByName("Kirill", "Sazonov")).thenReturn(true);

        PeopleService peopleService = new PeopleService(mock);

<<<<<<< HEAD
        Assert.assertEquals(true, peopleService.updateByName("Kirill", "Sazonov"));

        verify(mock).updateByName("Kirill", "Sazonov");
=======
        Boolean res = peopleService.updateByName("Kirill", "Sazonov");

        Assert.assertEquals(res,mock.updateByName("Kirill", "Sazonov"));
>>>>>>> b67fb18fa0ddde75387ba87f263443502836b924
    }
}