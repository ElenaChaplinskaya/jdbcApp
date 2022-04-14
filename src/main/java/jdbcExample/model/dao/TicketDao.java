package jdbcExample.model.dao;

import jdbcExample.model.entity.Ticket;

public interface TicketDao extends DefaultDao<Ticket> {

    Ticket getByRoute_id(int route_id);

    Ticket getByOrder_id(int order_id);

    Ticket getByPassport_data(String passport_data);
}
