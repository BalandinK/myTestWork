package com.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

        verify(mock).queryByName("Kirill");
    }
}