package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Bank;
import entity.Card;
import repository.CardRepository;

@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	CardRepository cardRepository;
	
	@Override
	public List<Card> findCardAll(){
		return cardRepository.findAll();
	}

	@Override
	public List<Card> findCardsByBank(Bank bank) {
		return cardRepository.findByBank(bank);
	}
	

	@Override
	public Card getCard(Long id) {
		return cardRepository.findById(id).orElse(null);
	}

	@Override
	public List<Card> findCardsByCustomerId(Long customerId) {
		return cardRepository.findByCustomerId(customerId);
	}

}
