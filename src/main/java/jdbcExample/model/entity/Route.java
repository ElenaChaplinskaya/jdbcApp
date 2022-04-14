package jdbcExample.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    private int id;
    private int departure_id;
    private int arrival_id;
    private String departure;
    private String arrival;

}
