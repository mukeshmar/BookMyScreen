package live.mukeshtechlab.bookmyscreen.controllers;

import live.mukeshtechlab.bookmyscreen.dtos.BookingDto.BookTicketRequestDto;
import live.mukeshtechlab.bookmyscreen.dtos.BookingDto.BookTicketResponseDto;
import live.mukeshtechlab.bookmyscreen.dtos.ResponseStatus;
import live.mukeshtechlab.bookmyscreen.models.Booking;
import live.mukeshtechlab.bookmyscreen.services.bookingServices.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings/book-ticket")
    public BookTicketResponseDto bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto){
        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
        try{
            Booking booking = bookingService.bookTicket(
                    bookTicketRequestDto.getUserId(),
                    bookTicketRequestDto.getShowId(),
                    bookTicketRequestDto.getShowSeatIds()
            );
            bookTicketResponseDto.setBooking(booking);
            bookTicketResponseDto.setStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            bookTicketResponseDto.setStatus(ResponseStatus.FAILURE);
        }

        return bookTicketResponseDto;
    }

}
