package dia29.apiproduct.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dia29.apiproduct.model.BillDetails;

@Repository
public interface IBillDetailsRepository extends JpaRepository<BillDetails,Long>{
    
    @Query(value = "select * from bill_details where bill_details.bill_id = :billId", nativeQuery = true)
    List<BillDetails> findAllById(@Param("billId")long billId);

    @Query(value = "select * from bill_details where bill_details.client_id = :clientId", nativeQuery = true)
    List<BillDetails> findAllByClientId(@Param("clientId")long id);

    @Query(value = "select * from bill_details where bill_details.bill_number = :billN", nativeQuery = true)
	List<BillDetails> findAllByBillNumber(@Param("billN")long billNum);
    
}
