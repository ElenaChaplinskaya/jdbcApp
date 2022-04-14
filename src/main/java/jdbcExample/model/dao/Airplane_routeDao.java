package jdbcExample.model.dao;

import jdbcExample.model.entity.Airplane_route;

public interface Airplane_routeDao extends DefaultDao<Airplane_route> {

    Airplane_route getByAirplane_id(int airplane_id);

    Airplane_route getByRoutes_id(int routes_id);

}
