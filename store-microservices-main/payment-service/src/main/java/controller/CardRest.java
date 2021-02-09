package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Bank;
import entity.Card;
import lombok.extern.slf4j.Slf4j;
import service.CardService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cards")
public class CardRest {
	
	@Autowired
	CardService cardService;
	
	// -------------------Retrieve All Cards--------------------------------------------
	@GetMapping
	public ResponseEntity<List<Card>> listAllCards(@RequestParam(name= "bankId" , required = false) Long bankId ) {
		List<Card> cards = new ArrayList<>();
		if (bankId == null) {
			cards = cardService.findCardAll();
			if (cards.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			Bank Bank = new Bank();
			Bank.setId(bankId);
			cards = cardService.findCardsByBank(Bank);
			if (cards == null){
				log.error("Cards with Bank id {} not found", bankId);
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.ok(cards);
	}
	
	 // -------------------Retrieve Single Card------------------------------------------
	@GetMapping(value = "/{id}")
	public ResponseEntity<Card> getCard(@PathVariable("id") long id) {
		log.info("Fetching Card with id {}", id);
		Card card = cardService.getCard(id);
		if (card == null) {
			log.error("Card with id {} not found.", id);
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(card);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<Card>> getCardsByCustomerId(@PathVariable("id") long id) {
		List<Card> cards = new ArrayList<>();
		cards = cardService.findCardsByCustomerId(id);
		if (cards == null) {
			log.error("Cards with id {} not found.", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cards);
	}
}
