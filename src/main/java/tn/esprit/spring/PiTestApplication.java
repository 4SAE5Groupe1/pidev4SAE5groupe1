package tn.esprit.spring;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.repositories.AppointmentRepository;
import tn.esprit.spring.scheduledEmail.Job1;

@SpringBootApplication

public class PiTestApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(PiTestApplication.class, args);
		
		
		
		try {
			JobDetail job1 = JobBuilder.newJob(Job1.class)
					.withIdentity("job1", "group1").build();

			Trigger trigger1 = TriggerBuilder.newTrigger()
					.withIdentity("cronTrigger1", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
					.build();
			
			Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
			scheduler1.start();
			scheduler1.scheduleJob(job1, trigger1);
//fahmik chniya condition ily haba tzidiha bethabet
			/* JobDetail job2 = JobBuilder.newJob(Job2.class)
					.withIdentity("job2", "group2").build();
			
			Trigger trigger2 = TriggerBuilder.newTrigger()
					.withIdentity("cronTrigger2", "group2")
					.withSchedule(CronScheduleBuilder.cronSchedule(new CronExpression("0/45 * * * * ?")))
					.build();
			
			Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
			scheduler2.start();
			scheduler2.scheduleJob(job2, trigger2); */
			
			Thread.sleep(100000);
			
			scheduler1.shutdown();
			//scheduler2.shutdown();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	}


