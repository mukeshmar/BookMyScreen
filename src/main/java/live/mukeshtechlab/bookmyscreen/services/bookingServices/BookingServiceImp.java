package live.mukeshtechlab.bookmyscreen.services.bookingServices;

import live.mukeshtechlab.bookmyscreen.exceptions.ShowNowFoundException;
import live.mukeshtechlab.bookmyscreen.exceptions.UserNotFoundException;
import live.mukeshtechlab.bookmyscreen.models.*;
import live.mukeshtechlab.bookmyscreen.repositories.BookingRepository;
import live.mukeshtechlab.bookmyscreen.repositories.ShowRepository;
import live.mukeshtechlab.bookmyscreen.repositories.ShowSeatRepository;
import live.mukeshtechlab.bookmyscreen.repositories.UserRepository;
import live.mukeshtechlab.bookmyscreen.services.PriceCalculatorService;
import live.mukeshtechlab.bookmyscreen.services.RandomStringGenerationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImp implements BookingService {

    private UserRepository userRepository;
    private BookingRepository bookingRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;

    public BookingServiceImp(
            UserRepository userRepository,
            BookingRepository bookingRepository,
            ShowRepository showRepository,
            ShowSeatRepository showSeatRepository,
            PriceCalculatorService priceCalculatorService
    ){
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNowFoundException {
        /*
        "Implement booking workflow:
        1. Verify user ID existence
        2. Validate show ID existence
        3. Retrieve list of available ShowSeat
        4. Check if all seats are available (not booked)
        5. If available, update seat status to blocked
        6. Create new booking and proceed to payment processing"
         */

        // Get User
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with id: " + userId + " not found!");
        }
        User user = optionalUser.get();

        // Get Show
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new ShowNowFoundException("Show with id: " + showId + " now found!");
        }

        Show show = optionalShow.get();

        // Get ShowSeat
        List<ShowSeat> showSeatsFromDb = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeatsFromDb){
            if(!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("ShowSeat with id: " + showSeat.getId() + " now available");
            }
        }

        // Change the status of ShowSeat
        for(ShowSeat showSeat : showSeatsFromDb){
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
        }

        // Price
        int price = priceCalculatorService.calculatePrice(show, showSeatsFromDb);

        // Crete Booking
        Booking booking = new Booking();
        booking.setBookingReference(RandomStringGenerationService.generateRandomString());
        booking.setUser(user);
        booking.setShowSeats(showSeatsFromDb);
        booking.setStatus(BookingStatus.PENDING);
        booking.setAmount(price);
        return bookingRepository.save(booking);
    }
}
