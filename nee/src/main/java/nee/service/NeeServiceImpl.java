package nee.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nee.dao.RequestDao;
import nee.model.Request;
//import nee.repository.NeeRepository;

@Service("neeService")
@Transactional
public class NeeServiceImpl implements NeeService {
	
	@Autowired
	RequestDao requestDao;

	
	public void addRequest(Request request) {
		 System.out.println("you are in nee service-->"+request);
		// neeRepository.save(request);
		 requestDao.save(request);
	}

}
