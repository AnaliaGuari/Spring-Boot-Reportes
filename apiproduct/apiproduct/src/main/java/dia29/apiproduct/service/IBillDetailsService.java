package dia29.apiproduct.service;

import java.util.List;
import java.util.Optional;

import dia29.apiproduct.model.BillDetails;

public interface IBillDetailsService {
    Optional<BillDetails> get(long id);
	boolean save(BillDetails listBd);
	boolean delete(long id);
	boolean update(BillDetails bd);
	List<BillDetails> getAllByBillNumber(long billNum);
	List<BillDetails> getAllByClientId(long id);
	List<BillDetails> getAll();
}
