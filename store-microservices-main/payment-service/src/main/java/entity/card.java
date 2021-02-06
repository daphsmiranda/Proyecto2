package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class card {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotEmpty(message = "El número de la tarjeta no puede ser vacío")
    @Size( min = 16 , max = 16, message = "El tamaño del número de tarjeta es 16")
    @Column(name = "number" , unique = true ,length = 16, nullable = false)
	private String number;
    
    @NotEmpty(message= "La fecha de expiración no puede ser vacía")
    private Date exp_date;
    

}
