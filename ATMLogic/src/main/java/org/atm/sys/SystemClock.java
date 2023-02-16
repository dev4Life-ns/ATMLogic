package org.atm.sys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemClock {
   private  Date currentDate;
   private 	SimpleDateFormat timeFormat;

   //------ accessors  and mutators-----------
	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public SimpleDateFormat getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(SimpleDateFormat timeFormat) {
		this.timeFormat = timeFormat;
	}

	//--- display clock method --------------------------
	public String displaySystemDateAndTime() {
		timeFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
		currentDate = new Date();
		return timeFormat.format(currentDate);
	}
}
