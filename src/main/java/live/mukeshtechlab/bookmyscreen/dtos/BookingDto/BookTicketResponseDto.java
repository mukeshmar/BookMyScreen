package live.mukeshtechlab.bookmyscreen.dtos.BookingDto;

import live.mukeshtechlab.bookmyscreen.dtos.ResponseStatus;
import live.mukeshtechlab.bookmyscreen.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private Booking booking;
    private ResponseStatus status;
}
