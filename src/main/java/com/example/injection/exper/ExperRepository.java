package com.example.injection.exper;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExperRepository {
	@Resource
	private Translator getTranslator;
	
	@Autowired
	private List<Expert> expertList;
	
	@Autowired
	private List<Translator> translatorList;
	
	@Autowired
	private Editor editor;
	
	//@Autowired
	//private ExternalCollaborator extCollaborator;

	public String printOccupation() {
		return getTranslator.currentOccupation();
	}
	
	public String printListExpert() {

		String result = "";
		for(Expert ex : expertList) {
			result += ex.currentOccupation() + "\n";
		}
		return result;
	}
	
	public String printAllTranslator() {
		String res = "";
		
		for(Translator tr : translatorList) {
			res += tr.currentOccupation() + "\n";
		}
		return res;
	}
	
	public String printOneEditor() {
		return editor.currentOccupation();
	}
}
