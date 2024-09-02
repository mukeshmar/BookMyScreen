package live.mukeshtechlab.bookmyscreen.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private int amount;
    private String transactionId; // from Payment Gateway
    private Date paymentDate;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode mode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;
}
