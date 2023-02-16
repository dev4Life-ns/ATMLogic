package org.atm.card_reader;

public interface CardReaderState {

	void CARD_INSERTED();//should wait for user to insert card then retrieve data from magnetic strip then notifies
	// user session in conjunction with user display.
	void READ_CARD_ERROR(); //if substantial damage is done to magnetic strip and data appears corrupted throws error
	// then calls card reader to eject card via eject_card method.
	void RETAIN_CARD(); //system keeps card when user exceeds pin entry limit or if card remains in card reader after
	//session has closed within 15 seconds. For security purposes.
	void EJECT_CARD(); //releases card after completed transaction or in cases of card reading errors.
}
