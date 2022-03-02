package tn.esprit.spring.entites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PayementPaypal {
    private double price;
    private String currency;
    private String method;
private String intent ;
    private String description;
}
