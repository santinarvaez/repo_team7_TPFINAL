package ar.edu.unju.fi.tpfinal.Repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Employee;

public interface IEmployeRepository extends CrudRepository <Employee, Integer>{

}
