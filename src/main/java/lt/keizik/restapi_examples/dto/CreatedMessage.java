package lt.keizik.restapi_examples.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatedMessage {
    private long id;
    private String response;
}
