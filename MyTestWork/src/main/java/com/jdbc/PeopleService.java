package com.jdbc;

public class PeopleService {

    private final PeoplePersistenceService persistenceService;

    public PeopleService(PeoplePersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    public People queryByName(String name) {
        Object[] values = this.persistenceService.queryByName(name);
        return new People((int)values[0], (String)values[1], (String) values[2]);
    }

    public boolean updateByName(String name, String second_name){
        return this.persistenceService.updateByName(name, second_name);
    }
}
