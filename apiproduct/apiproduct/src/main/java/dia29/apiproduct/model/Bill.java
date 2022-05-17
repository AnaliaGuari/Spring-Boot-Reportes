package dia29.apiproduct.model;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name ="bill")
public class Bill {

    private long idBill;

    @ManyToOne
	@JoinColumn(name = "client_id")
    private Clients clients;

    public Bill(long idBill){
        this.idBill = idBill;
    }
    
}
