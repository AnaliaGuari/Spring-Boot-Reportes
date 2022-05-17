package dia29.apiproduct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dia29.apiproduct.model.BillDetails;
import dia29.apiproduct.repositories.IBillDetailsRepository;

public class BillDetailsService implements IBillDetailsService{

    @Autowired
    private IBillDetailsRepository billDR;

    @Override
    public boolean delete(long id) {
        if(billDR.existsById(id)) {	
			billDR.deleteById(id);
			return true;
		}
		else
			return false;
    }

    @Override
    public Optional<BillDetails> get(long id) {
        return billDR.findById(id);
    }

    @Override
    public List<BillDetails> getAll() {
        return billDR.findAll();
    }

    @Override
    public List<BillDetails> getAllByBillNumber(long billNum) {
        return billDR.findAllByBillNumber(billNum);
    }

    @Override
    public List<BillDetails> getAllByClientId(long id) {
        return billDR.findAllByClientId(id);
    }

    @Override
    public boolean save(BillDetails listBd) {
        if(billDR.existsById(listBd.getId()))
			return false;
		else {
			billDR.save(listBd);
			return true;
		}
    }

    @Override
    public boolean update(BillDetails bd) {
        if(billDR.existsById(bd.getId())) {	
			billDR.save(bd);
			return true;
		}
		else
			return false;
    }
    
}