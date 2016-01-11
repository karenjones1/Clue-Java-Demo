import Game_Constants.*;
import java.util.*;

/** AI Class is Artifical Intelligence Engine for competitors. Utilizes LinkedList data structures.  */
public class AI extends Player {

	private AIMemory weapon;	//AI Memory of all weapons.
	private AIMemory person;	//AI Memory of all suspects.
	private AIMemory room;		//AI Memory of all locations.

	private Random rand = new Random();

	AI (int num, ArrayList<Card> h, GamePiece p) {

		//Pass to Player.
		super(num,h,p);

		//Instantiate Memories.
		weapon = new AIMemory();
		person = new AIMemory();
		room = new AIMemory();

		//Populate Memories with Card enum.
		for(Card card : Card.values()){
			if(card.getType() == 1)
				weapon.addToFront(card, 1);
			else if(card.getType() == 2)
				room.addToFront(card, 1);
			else
				person.addToFront(card, 1);
		}

		//Remove AI's hand from memory.
		removeStartingCards();
	}

	/** Required Get Methods.  */
	public Card getPersonGuess()  { return person.getAICardGuess(); }
	public Card getWeaponGuess()  { return weapon.getAICardGuess(); }


	/** setDestination randomly assigns new destination to AI based on AI's next location guess.  */
	public void setDestination() {

		Card temp = room.getAICardGuess();
		Rooms randomRoom;

		//Room is not room that AI is in.
		if (temp != (getMovement().getEquivalentRoom()))
			getMovement().setDestination(findEquivalent(temp));

		//Only one room left, and AI is in it.
		else {
			do {
				randomRoom = Rooms.values()[rand.nextInt(9)];
			} while (randomRoom == findEquivalent(temp));

			getMovement().setDestination(randomRoom);
		}
	}

	/** removeStartingCards removes AI's hand from AI Memory.  */
	private void removeStartingCards() {
		ArrayList<Card> a=getHand();
		for (int i=0; i<a.size(); i++ ) {
			if (a.get(i).getType()==1)
				weapon.remove(a.get(i));
			else if (a.get(i).getType()==2)
				room.remove(a.get(i));
			else if (a.get(i).getType()==3)
				person.remove(a.get(i));
		}
	}
	
	/** addWeight adjusts weight of given Cards by 0.8.
	 * @param guess Cards in other player's assumption, to be re-weighted.  */
	public void addWeight(ArrayList<Card> guess) {

		for(int i=0; i<guess.size(); i++) {

			Card card = guess.get(i);

			//Adjust weight for card, given type.
			if (card.getType() == 1 && weapon.contains(card))
				weapon.getNodeOfCard(card).setWeight(weapon.getNodeOfCard(card).getWeight() + 0.8);
			else if (card.getType() == 2 && room.contains(card))
				room.getNodeOfCard(card).setWeight(room.getNodeOfCard(card).getWeight() + 0.8);
			else if (card.getType() == 3 && person.contains(card))
				person.getNodeOfCard(card).setWeight(person.getNodeOfCard(card).getWeight() + 0.8);
		}
	}

	/** findEquivalent takes a room card and returns the equivalent Room eNum.
	 * @param card Card to find room equivalent of.
	 * @return Rooms eNum equal to given card.  */
	private Rooms findEquivalent(Card card){

		for(Rooms rooms : Rooms.values())
			if(card.getName().equals(rooms.getName()))
				return rooms;

		return null;
	}

	/** getNextAction determines AI next move, based off of current position
	 * @param turnStart If it is the beginning of AI turn.
	 * @return Integer representing next action:
	 * 			1: Top of turn. Move AI.
	 * 			2: AI is ready to make an Accusation.
	 * 			3: AI to make Assumption.	*/
	public int getNextAction(boolean turnStart){
		if(!getMovement().isInARoom() && turnStart) {
			return 1;
		}
		else if(getMovement().isInARoom() && turnStart){
			setDestination();
			return 1;
		}
		else if(shouldMakeAccusation())
			return 2;
		else
			return 3;
	}

	/** shouldMakeAccusation() checks if AI has validity in making an accusation, ending the game.
	 *  @return True if all Memories contain one item.  */
	private boolean shouldMakeAccusation(){
		return weapon.size() == 1 && room.size() == 1 && person.size() ==1
				&& (findEquivalent(room.getFrontData()) == getMovement().getLocation());
	}

	/** removeCard removes given Card from Memory.
	 * @param card Card to be removed.  */
	public void removeCard(Card card){
		if (card.getType() == 1 && weapon.contains(card))
			weapon.remove(card);
		else if (card.getType() == 2 && room.contains(card))
			room.remove(card);
		else if (card.getType() == 3 && person.contains(card))
			person.remove(card);
	}

	public String toString() {
		return getName() + ", " + getPlayerNum() + "\nweapons: "+ weapon
				+ "\nrooms: " + room + "\nperson: "+ person;
	}

	public void makeIrrefutable(ArrayList<Card> guess, int turnNum){

		if(turnNum == getPlayerNum() && room.contains(getMovement().getEquivalentRoom())) {
			for (Card card : Card.values())
				if (!guess.contains(card))
					removeCard(card);
		}
		else {
			for (Card card : Card.values())
				if (!guess.contains(card) && card.getType() != 2)
					removeCard(card);
		}

		System.out.println(getName() + ": " + weapon + "\n\t" + room + "\n\t" + person);
	}
}
