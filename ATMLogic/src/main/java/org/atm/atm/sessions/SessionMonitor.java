package org.atm.atm.sessions;

import org.atm.user.menus.InterfacePrompts;

import javax.swing.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SessionMonitor implements UserSession {
	UserCredentials credentials = new UserCredentials();
	private final ScheduledExecutorService scheduleMonitor = Executors.newSingleThreadScheduledExecutor();
	private ScheduledFuture<?> futureStatus;
	InterfacePrompts userPrompt = new InterfacePrompts();
	private Instant lastActivity;

	private boolean sessionInactive,  sessionCancelled, sessionExpired;

	@Override
	public void startSession() {
		activeSession();
		futureStatus = scheduleMonitor.scheduleWithFixedDelay(this::sessionMonitor,50, 50, TimeUnit.MILLISECONDS);
	}

	@Override
	public void activeSession() {

	}

	@Override
	public void sessionMonitor() {
		long timeDifference = ChronoUnit.MILLIS.between(lastActivity,Instant.now());
	}

	@Override
	public void inactiveSession() {
		sessionExpired = false;
		//  long timeDifference = ChronoUnit.MILLIS.between(lastActivity,Instant.ofEpochMilli(50000));
		if (lastActivity == Instant.ofEpochMilli(50000)) {
			sessionInactive = true;
			JOptionPane.showMessageDialog(null, "Do you need more time?");
		}
	}

	@Override
	public void cancelledSession(int menuOption) {



	}

	@Override
	public void sessionEnded() {
		if(!sessionExpired){
			sessionExpired = true;

		}
	}



/* 	@Override
	public void startSession() {
		activeSession();
		futureStatus = scheduleMonitor.scheduleWithFixedDelay(this::sessionMonitor,50, 50, TimeUnit.MILLISECONDS);
	}

	private  void sessionMonitor(){

		long timeDifference = ChronoUnit.MILLIS.between(lastActivity,Instant.now());
	}
	@Override
	public void activeSession() {
		sessionExpired = false;
		lastActivity = Instant.now();
	}

	@Override
	public void inactiveSession() {
		sessionExpired = false;
		//  long timeDifference = ChronoUnit.MILLIS.between(lastActivity,Instant.ofEpochMilli(50000));
		if(lastActivity == Instant.ofEpochMilli(50000)) {
			sessionInactive = true;
			JOptionPane.showMessageDialog(null,"Do you need more time?");
		}
	}

	@Override
	public void cancelledSession() {
		if (sessionCancelled) {
		   display.home
		}
	}

	@Override
	public void sessionEnded() {
		if(!sessionExpired){
			sessionExpired = true;
			JOptionPane.showMessageDialog(null,"Welcome to Midwest ATM");
		}
	} */
}
