package pe.sermaluc.register.contract.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorDto {
    private List<String> message;
}
