package jdbcExample.model.dao;

import jdbcExample.model.entity.User;

public interface UserDao extends DefaultDao<User> {
    User getByName(String name);
}
