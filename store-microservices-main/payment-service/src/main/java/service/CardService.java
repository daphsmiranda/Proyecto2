package service;
import java.util.List;

import entity.Bank;
import entity.Card;

public interface CardService {
	
	public List<Card> findCardAll();
	public List<Card> findCardsByBank(Bank bank);
	public List<Card> findCardsByCustomerId(Long customerId);
	
	public Card getCard(Long id);

}
