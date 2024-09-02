package live.mukeshtechlab.bookmyscreen.controllers;

import jakarta.websocket.server.PathParam;
import live.mukeshtechlab.bookmyscreen.dtos.ResponseStatus;
import live.mukeshtechlab.bookmyscreen.dtos.userDtos.SignUpRequestDto;
import live.mukeshtechlab.bookmyscreen.dtos.userDtos.SignUpResponseDto;
import live.mukeshtechlab.bookmyscreen.exceptions.UserAlreadyExistException;
import live.mukeshtechlab.bookmyscreen.models.User;
import live.mukeshtechlab.bookmyscreen.services.userServices.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users/signup")
    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try{
            User user = userService.signUp(
                    signUpRequestDto.getName(),
                    signUpRequestDto.getEmail(),
                    signUpRequestDto.getPassword()
            );
            signUpResponseDto.setName(user.getName());
            signUpResponseDto.setStatus(ResponseStatus.SUCCESS);
        }
        catch(UserAlreadyExistException e){
            System.out.println(e.getMessage());
            signUpResponseDto.setName(signUpRequestDto.getName());
            signUpResponseDto.setStatus(ResponseStatus.FAILURE);
        }
        return signUpResponseDto;
    }
}
