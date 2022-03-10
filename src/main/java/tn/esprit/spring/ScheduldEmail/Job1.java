package tn.esprit.spring.ScheduldEmail;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class Job1 implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
        System.out.println("Job1 --->>> Time is " + new Date());
		
		EmailUtil.sendEmail("nadia.wanness@esprit.tn","Appointment Reminder", "we send you this email to remind you that you have "
				+ "an appointment with Dr salma "
				+ "Please don't reply to this email"); 
		
	}

}
