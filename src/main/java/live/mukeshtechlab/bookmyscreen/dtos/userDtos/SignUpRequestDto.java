package live.mukeshtechlab.bookmyscreen.dtos.userDtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    private String name;
    private String email;
    private String password;
}
