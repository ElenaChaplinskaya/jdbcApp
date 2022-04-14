package jdbcExample.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private int id;
    private int route_id;
    private int order_id;
    private String passport_data;
}
