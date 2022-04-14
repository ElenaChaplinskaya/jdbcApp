package jdbcExample.model.dao;

import jdbcExample.model.entity.Order;

public interface OrderDao extends DefaultDao<Order> {

    Order getByNumber(int number);

    Order getByOrder_date(String order_date);

    Order getByUser_id(int user_id);

}
