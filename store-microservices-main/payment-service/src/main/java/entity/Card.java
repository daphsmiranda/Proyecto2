package entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
@Entity
public class Card implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotEmpty(message = "El número de la tarjeta no puede ser vacío")
    @Size( min = 16 , max = 16, message = "El tamaño del número de tarjeta es 16")
    @Column(name = "number" , unique = true ,length = 16, nullable = false)
	private String number;
    
    @NotEmpty(message = "La tarjeta debe tener un cvv")
    @Size( min = 3 , max = 3, message = "El tamaño del número del cvv es 3")
    @Column(name = "cvv" , unique = true ,length = 3, nullable = false)
    private String cvv;
    
    @NotEmpty(message= "La fecha de expiración no puede ser vacía")
    private Date exp_date;
    
    @Positive(message = "El balance debe ser mayor que cero")
    private Double balance;
    
    @NotNull(message = "El banco no puede ser vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;
    

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Long customerId;  

}
