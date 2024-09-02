package live.mukeshtechlab.bookmyscreen.dtos.userDtos;


import live.mukeshtechlab.bookmyscreen.dtos.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private String name;
    private ResponseStatus status;
}
