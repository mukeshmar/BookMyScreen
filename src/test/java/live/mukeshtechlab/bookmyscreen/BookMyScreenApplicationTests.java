package live.mukeshtechlab.bookmyscreen;

import live.mukeshtechlab.bookmyscreen.controllers.UserController;
import live.mukeshtechlab.bookmyscreen.dtos.userDtos.SignUpRequestDto;
import live.mukeshtechlab.bookmyscreen.dtos.userDtos.SignUpResponseDto;
import live.mukeshtechlab.bookmyscreen.services.RandomStringGenerationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMyScreenApplicationTests {

    @Autowired
    UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    void testUser(){
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
        signUpRequestDto.setName("Mukesh");
        signUpRequestDto.setEmail("ABC@Gamil.com");
        signUpRequestDto.setPassword("ABC123");
        SignUpResponseDto signUpResponseDto = userController.signUp(signUpRequestDto);
        System.out.println(signUpResponseDto.getName());
        System.out.println(signUpResponseDto.getStatus());
    }

    @Test
    void testRandomStringGenerationService(){
        System.out.println(RandomStringGenerationService.generateRandomString());
    }

}
