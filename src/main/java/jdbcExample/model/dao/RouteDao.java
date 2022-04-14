package jdbcExample.model.dao;

import jdbcExample.model.entity.Route;

public interface RouteDao extends DefaultDao<Route> {
    Route getByDeparture(String departure);

    Route getByArrival(String arrival);
}
