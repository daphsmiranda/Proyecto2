package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Bank;
import entity.Card;


public interface CardRepository extends JpaRepository<Card,Long> {

		public Card findByNumber(String number);
		public List<Card> findByBank(Bank bank);
		public List<Card> findByCustomerId(Long customerId);
}
