package org.atm.atm.sessions;

public interface UserSession {
	void startSession();
	void activeSession();
	void sessionMonitor();
	void inactiveSession();
	void cancelledSession(int menuOption);
	void sessionEnded();
}
