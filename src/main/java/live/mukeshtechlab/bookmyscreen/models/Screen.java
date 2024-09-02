package live.mukeshtechlab.bookmyscreen.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // Hold collections of basic types (such as strings, integers, or dates)
    private List<Feature> features;
    @OneToMany(mappedBy = "screen")
    private List<Show> shows;
}
