package live.mukeshtechlab.bookmyscreen.dtos.BookingDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private Long userId;
    private Long showId;
    List<Long> showSeatIds;
}
