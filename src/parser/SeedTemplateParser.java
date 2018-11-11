package parser;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.parameters.seedTemplate.SeedTemplate;

public class SeedTemplateParser {
	public static void main(String[] args){
		ObjectMapper mapper = new ObjectMapper();
		try {
			SeedTemplate seed = mapper.readValue(new File("Documents/DecreasingSeedTemplate.json"), SeedTemplate.class);
			System.out.println(seed);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
