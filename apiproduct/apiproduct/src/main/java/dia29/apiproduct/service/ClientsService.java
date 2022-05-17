package dia29.apiproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dia29.apiproduct.model.Clients;

import dia29.apiproduct.repositories.IClientsRepository;


public class ClientsService implements IClientsService {

    @Autowired
    private IClientsRepository clientsR;

    @Override
    public boolean delete(long code) {
        if (clientsR.existsById(code)) {
            clientsR.deleteById(code);
            return true;
        } else
            return false;
    }

    @Override
    public List<Clients> getAll() {
        return clientsR.findAll();

    }

    @Override
    public boolean save(Clients p) {
       if(clientsR.existsById(p.getId()))
             return false;
        else{
            clientsR.save(p);
            return true;
        }
    }

    @Override
    public boolean update(Clients bd) {
        if (clientsR.existsById(bd.getId())) {
            clientsR.save(bd);
            return true;
        } else
            return false;
    }

}
