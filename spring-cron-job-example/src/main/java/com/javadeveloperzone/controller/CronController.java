package com.javadeveloperzone.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CronController {

    @RequestMapping(value = "demo",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    /*
    If a fixed rate execution is desired, simply change the property name specified within the annotation.
    The following would be executed every 5 seconds measured between the successive start times of each invocation.
    */
    @Scheduled(fixedRate=5000)
    public void ScheduledFixedRate(){
        System.out.println("I will execute after evey 5 seconds");
    }

    /*
    For fixed-delay and fixed-rate tasks,
    an initial delay may be specified indicating the number of milliseconds to wait before the first execution of the method.
    */
    @Scheduled(initialDelay=1000, fixedRate=5000)
    public void ScheduledInitialDelay(){
        System.out.println("I will execute after evey 5 seconds but after initial Delay 1 second");
    }

    /*
    If simple periodic scheduling is not expressive enough, then a cron expression may be provided.
    For example, the following will only execute on weekdays.
     */
    @Scheduled(cron="*/5 * * * * MON-FRI")
    public void ScheduledWeekEnd() {
        System.out.println("I will execute should execute on weekdays only");
    }
}