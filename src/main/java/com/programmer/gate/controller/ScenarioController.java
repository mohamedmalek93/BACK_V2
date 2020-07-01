package com.programmer.gate.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.gate.model.Incident;
import com.programmer.gate.model.Scenario;
import com.programmer.gate.model.Step;
import com.programmer.gate.model.Product;
import com.programmer.gate.repository.IncidentRepository;
import com.programmer.gate.repository.StepRepository;
import com.programmer.gate.repository.USRepository;
import com.programmer.gate.service.TestServiceImp;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/scenarios" })
public class ScenarioController {
	
		
		@Autowired
		TestServiceImp etService;
		@Autowired
		private IncidentRepository Repo;
		@Autowired
		private USRepository Repos;
		
		@Autowired
		private StepRepository  Repostep;
		

		

		@GetMapping(produces = "application/json")
		public List<Scenario> allEtudiants() {
			// model.addAttribute("allDocs", docService.getAllDocuments());
			return etService.getAllScenarios();
		}
		@GetMapping("/errors")
	    public List<Scenario> getAllStagiaires() {
	        return etService.todayErrors();
	    }
		@GetMapping("/unqualif")
		public List<Scenario> allunqua() {
			return etService.unqualified();
		}
		@GetMapping("/previous")
	    public List<Scenario> getprevious() {
	        return etService.errorprev();
	    }
		@GetMapping("/true")
	    public List<Scenario> truepos() {
	        return etService.truepos();
	    }
		@GetMapping("/false")
	    public List<Scenario> falsepos() {
	        return etService.truepos();
	    }
		@GetMapping("/appupd")
	    public List<Scenario> upd() {
	        return etService.appupdate();
	    }
		
		 @PutMapping("/comment/{id}")
		    public ResponseEntity<Incident> updateComm(@PathVariable(value = "id") Long incidentId,
		         @Valid @RequestBody Incident inc) {
		        Incident incident = Repo.findById(incidentId).orElse(null);
		        incident.setComment(inc.getComment());
		        
		        final Incident updatedinc = Repo.save(incident);
		        return ResponseEntity.ok(updatedinc);
		    }
		 @PutMapping("/qual/{id}")
		    public ResponseEntity<Incident> updatequalif(@PathVariable(value = "id") Long incidentId,
		         @Valid @RequestBody String inc) {
		        Incident incident = Repo.findById(incidentId).orElse(null);
		        incident.setQualif(inc);
		        
		        final Incident updatedinc = Repo.save(incident);
		        return ResponseEntity.ok(updatedinc);
		    }
		 @PutMapping("/pend/{id}")
		    public ResponseEntity<Incident> updatePen(@PathVariable(value = "id") Long incidentId,
		         @Valid @RequestBody Incident inc) {
		        Incident incident = Repo.findById(incidentId).orElse(null);
		       Scenario a= inc.getStep().getScenario();
		       a.setPending();
		       
		        incident.getStep().setScenario(a);
		        
		        final Incident updatedinc = Repo.save(incident);
		        return ResponseEntity.ok(updatedinc);
		 }
		 
		 @GetMapping("/prod")
			public List<Product> prod() {
			 
				return   (List<Product>) Repos.findAll();
			}
		 @GetMapping(
				  value = "/get-image/{path}",
				  produces = MediaType.IMAGE_JPEG_VALUE
				)
				public @ResponseBody byte[] getImage(@PathVariable(value = "path")String path) throws IOException {
			 //Step incident = Repostep.findById(id).orElse(null);
			//String img=incident.getStep().getScreenshots().get(num);
			 String loc=etService.imgpath(path);
			 Path imagePath =Paths.get(loc);
				    return Files.readAllBytes(imagePath);
				}
		 @GetMapping("/bydate")
		    public List<Scenario> getScriptsdate(Date date) {
			List <Scenario> result=new ArrayList<>();
			List<Scenario> all=etService.getAllScenarios();
			for(Scenario sc :all) {
			if(sc.getDate_sc().getTime()==date.getTime())
			 result.add(sc);
		        
		    }
			return result;

}
		 @GetMapping("/success")
		    public List<Scenario> succ() {
		        return etService.success();
		    }
}