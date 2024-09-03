package live.mukeshtechlab.bookmyscreen.services.bookingServices;

import live.mukeshtechlab.bookmyscreen.exceptions.ShowNowFoundException;
import live.mukeshtechlab.bookmyscreen.exceptions.UserNotFoundException;
import live.mukeshtechlab.bookmyscreen.models.Booking;

import java.util.List;

public interface BookingService {
    Booking bookTicket(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNowFoundException;
}
