package dia29.apiproduct.service;

import java.util.*;

import dia29.apiproduct.model.Bill;

public interface IBillService {
    
	List<Bill> getAll();
	Optional<Bill> get(long billNum);
	boolean save(Bill bill);
	boolean delete(long billNum);
	boolean update(Bill bill);
	List<Bill> getAllByBillNumber(long billNum);
}
