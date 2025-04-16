package finki.ukim.mk.emt.model.CreateDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppUserDTO {
    private String username;
    private String password;
    private String role;
}
