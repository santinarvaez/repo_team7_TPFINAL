package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Oficce;

public interface IOficceService {
	public void addOficce(Oficce oficce);
	public Oficce getOficce();
	public List<Oficce> getAllOficces();
	public Oficce findOficce(Integer id);

}
