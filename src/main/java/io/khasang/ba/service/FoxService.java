package io.khasang.ba.service;

import io.khasang.ba.entity.Fox;

import java.util.List;

public interface FoxService {

    /**
     * method for add fox
     *
     * @param fox - new fox for creation
     * @return created fox
     */
    Fox addFox(Fox fox);

    /**
     * method for getting fox by specific id
     *
     * @param id - fox's id
     * @return fox by id
     */
    Fox getFoxById(long id);

    /**
     * method for getting all foxes
     *
     * @return all foxes
     */
    List<Fox> getAllFoxes();

    /**
     * method for update fox
     *
     * @param fox - fox with updated parameters
     * @return updated fox
     */
    Fox updateFox(Fox fox);

    /**
     * method for delete fox by id
     *
     * @param id - fox's id for delete
     * @return deleted fox
     */
    Fox deleteFox(long id);
}
