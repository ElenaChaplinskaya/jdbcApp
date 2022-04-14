package jdbcExample.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airplane_route {
    private int id;
    private int airplane_id;
    private int routes_id;
}
