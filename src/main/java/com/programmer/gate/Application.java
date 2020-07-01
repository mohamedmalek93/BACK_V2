package com.programmer.gate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.programmer.gate.model.Scenario;
import com.programmer.gate.repository.ScenarioRepository;
import com.programmer.gate.service.TestService;
@SpringBootApplication
public class Application implements CommandLineRunner {
	 @Autowired
	    TestService Service ;
	 ScenarioRepository a;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Service.test();
		//Scenario sc=Service.extracrsc("C:\\Users\\mmtizao\\Desktop\\new 7.txt");
	//	System.out.println("voila le scenario"+sc);
	  //Service.addscenario(sc);
		String current_proj_path="C:\\Users\\mohamed malek\\Desktop\\screens";
	    String projects_build="D:\\devenv\\jenkins\\.jenkins\\jobs\\LSPRH-EXECUTOR-DEVELOP";
		//System.out.println(Service.findjSON(current_proj_path+"................."));
		Service.alimenter_current(current_proj_path);
	//Service.alimenter(projects_build);
	    System.out.println("dooooooooooooooooooooone");
	    
	    
	}
	
	
}