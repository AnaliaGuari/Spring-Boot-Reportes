package dia29.apiproduct.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import dia29.apiproduct.model.Bill;
import dia29.apiproduct.repositories.IBillRepository;

public class BillService implements IBillService {
	
	@Autowired
	private IBillRepository bR;
	
	@Override
	public List<Bill> getAllByBillNumber(long billNum) {
		return bR.findAllByBillNumber(billNum);
	}
	
	@Override
	public List<Bill> getAll() {
		return bR.findAll();
	}

	@Override
	public Optional<Bill> get(long billNum) {
		return bR.findById(billNum);
	}

	@Override
	public boolean save(Bill bill) {
		if(bR.existsById(bill.getIdBill()))
			return false;
		else {
			bR.save(bill);
			return true;
		}
	}

	@Override
	public boolean delete(long id) {
		if(bR.existsById(id)) {	
			bR.deleteById(id);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean update(Bill bill) {
		if(bR.existsById(bill.getIdBill())) {	
			bR.save(bill);
			return true;
		}
		else
			return false;
	}
}