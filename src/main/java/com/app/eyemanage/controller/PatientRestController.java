package com.app.eyemanage.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.eyemanage.model.Response;
import com.app.eyemanage.pojo.PatientDetailsPOJO;
import com.app.eyemanage.service.PatientService;

@RestController
@RequestMapping("/dashboard")
public class PatientRestController {
	
	@Autowired
	PatientService patientService;
	
	private static final Logger logger = Logger.getLogger(PatientRestController.class);
	
	@RequestMapping(value="/patientSearch/patientDelete",method=RequestMethod.POST)
	public Response deletePatient(@RequestBody PatientDetailsPOJO p ) {
		logger.info("Patient Delete Post");
		logger.info("Patient Id : " + p.getPatientId());
		try {
			patientService.delete(p);
			return new Response("Done",p);
		} catch (Exception e) {
			logger.info("Could Not Delete : ", e);
			return new Response("Error",p);
		}
	}
	
}