package buildingmaintenance.service;

import java.util.List;

/**
 * Created by NkosikhonaS on 9/30/2015.
 */
public interface Services<S, ID> {
    public S findById(Long id);

    public S findByName(String name);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public List<S> findAll();
}
