package pokemon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pokemon.entity.RequestHistory;
import pokemon.repository.RequestHistoryRepository;
import pokemon.service.RequestHistoryService;

@Service
public class RequestHistoryServiceImpl implements RequestHistoryService {
	
	@Autowired
	private RequestHistoryRepository requestHistoryRepository;
	
	@Override
	public void save(RequestHistory requestHistoryData) {
		requestHistoryRepository.save(requestHistoryData);
	}

}
