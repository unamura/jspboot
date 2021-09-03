package com.example.injection.exper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExperConfiguration {

	@Bean
	public Translator getTranslator() {

		return new Translator("Quirino Principe");
	}

	@Bean
	public Expert getAnExpert() {
		return new Translator("Alliata di Villafranca");
	}

	@Bean
	public Writer getWriter() {
		return new Writer("Carla Maria Russo");
	}

	@Bean
	public Translator getSecondTranslator() {
		return new Translator("Paola Frezza Pavese");
	}

	@Bean
	public ExternalCollaborator getOneExternalCollaborator() {
		return new ExternalCollaborator("Tale");
	}

	/*public Editor getEditor() {
		return new Editor();
	}*/
}
