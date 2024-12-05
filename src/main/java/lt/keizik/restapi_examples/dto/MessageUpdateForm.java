package lt.keizik.restapi_examples.dto;

import java.util.List;

import lombok.Data;

@Data
public class MessageUpdateForm {
    private List<String> messages;
}
