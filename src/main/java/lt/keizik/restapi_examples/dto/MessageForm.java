package lt.keizik.restapi_examples.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MessageForm {
    @Schema(description = "New message", example = "My message")
    private String message;
}
