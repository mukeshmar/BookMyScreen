package live.mukeshtechlab.bookmyscreen.services;

import live.mukeshtechlab.bookmyscreen.models.Show;
import live.mukeshtechlab.bookmyscreen.models.ShowSeat;
import live.mukeshtechlab.bookmyscreen.models.ShowSeatType;
import live.mukeshtechlab.bookmyscreen.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(Show show, List<ShowSeat> showSeats){
        List<ShowSeatType> showSeatTypesFromDb = showSeatTypeRepository.findAllByShow(show);

        int price = 0;

        for(ShowSeat showSeat : showSeats){
            for(ShowSeatType showSeatType : showSeatTypesFromDb){
                if(showSeat.getSeat().getSeatType().getType().equals(showSeatType.getSeatType().getType())){
                    price += showSeatType.getPrice();
                    break;
                }
            }
        }

        return price;
    }
}
