package dia29.apiproduct.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dia29.apiproduct.model.Bill;


@Repository
public interface IBillRepository extends JpaRepository<Bill,Long>{
    @Query(value = "select* from bill where bill.bill_number = :billN", nativeQuery = true)
    List<Bill> findAllByBillNumber(@Param("billN")long billId);
}
