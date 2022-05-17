package dia29.apiproduct.service;

import java.util.List;

import dia29.apiproduct.model.Clients;

public interface IClientsService {

    List<Clients> getAll();
	boolean save(Clients c);
	boolean delete(long id);
	boolean update(Clients c);
}
