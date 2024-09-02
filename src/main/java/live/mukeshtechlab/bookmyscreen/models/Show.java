package live.mukeshtechlab.bookmyscreen.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private Date statTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;
}
