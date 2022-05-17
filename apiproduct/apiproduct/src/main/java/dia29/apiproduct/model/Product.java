package dia29.apiproduct.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
	private long code;
	private String name;
	private int stock;

    Product(long code){
        this.code = code;
    }
    
}
