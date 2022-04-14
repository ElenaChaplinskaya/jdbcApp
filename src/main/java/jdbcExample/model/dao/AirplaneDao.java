package jdbcExample.model.dao;

import jdbcExample.model.entity.Airplane;

public interface AirplaneDao extends DefaultDao<Airplane> {

    Airplane getByModel(String model);
}
