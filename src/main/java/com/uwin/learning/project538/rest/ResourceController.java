package com.uwin.learning.project538.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uwin.learning.project538.model.Resource;

@RestController
@RequestMapping("/results")
public class ResourceController {
	@RequestMapping(path="", method =RequestMethod.GET)
	public List<Resource> getResourceList(){
		Resource r1 = new Resource(1, "t1", "c1");
		Resource r2 = new Resource(2,"t2", "c2");
		List<Resource> rList = new ArrayList<>();	
		rList.add(r1);
		rList.add(r2);
		
		return rList;
	}

}
