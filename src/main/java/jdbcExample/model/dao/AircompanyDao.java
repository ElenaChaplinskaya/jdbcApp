package jdbcExample.model.dao;

import jdbcExample.model.entity.Aircompany;

public interface AircompanyDao extends DefaultDao<Aircompany> {

    Aircompany getByName(String name);
}
