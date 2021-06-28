package ar.edu.unju.fi.tpfinal.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Oficce;
import ar.edu.unju.fi.tpfinal.repository.IOficceRepository;
import ar.edu.unju.fi.tpfinal.service.IOficceService;


@Service("oficceMySql")
public class OficceMySqlImp implements IOficceService {
	
	@Autowired
	private Oficce oficce;
	
	@Autowired
	private IOficceRepository oficceRepository;

	@Override
	public void addOficce(Oficce oficce) {
		oficceRepository.save(oficce);
	}

	@Override
	public Oficce getOficce() {
		return oficce;
	}

	@Override
	public List<Oficce> getAllOficces() {
		List <Oficce> oficces = (List<Oficce>) oficceRepository.findAll();
		return oficces;
	}

	@Override
	public Oficce findOficce(Integer id) {
		return oficceRepository.findById(id).orElse(null);
	}

}
