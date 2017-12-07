package com.example.demo;

import com.example.model.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
	@Autowired
	private UserMapper userMapper;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Scheduled(cron = "0 0 23 * * ?")
	public void tmer(){

     userMapper.updateLogin();

		//LocalDateTime localDateTime=LocalDateTime.now();
		//System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy__MM__dd:HH;mm;ss")));

	}
}
