package jdbcExample.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {

    private int id;
    private int aircompany_id;
    private String model;

}
