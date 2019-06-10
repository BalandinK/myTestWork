package com.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
<<<<<<< HEAD
import static org.mockito.Mockito.*;
=======
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
>>>>>>> b67fb18fa0ddde75387ba87f263443502836b924

public class PeopleTestMyBaseSearch {

    @Test
    public void myBaseSearch() {

        PeoplePersistenceService mock = Mockito.mock(PeoplePersistenceService.class);

        Object[] mockValues = {1, "Balandin", "Kirill"};

        when(mock.queryByName("Kirill")).thenReturn(mockValues);

        PeopleService peopleService = new PeopleService(mock);

        People people = peopleService.queryByName("Kirill");

        Assert.assertEquals(people.getTableId(), mockValues[0]);
        Assert.assertEquals(people.getTableSecondName(), mockValues[1]);
        Assert.assertEquals(people.getTableName(), mockValues[2]);

<<<<<<< HEAD
        verify(mock).queryByName("Kirill");
=======

>>>>>>> b67fb18fa0ddde75387ba87f263443502836b924
    }
}