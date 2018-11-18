package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.generator.Generator;
import model.parameters.decorationTable.DecorationTable;
import model.parameters.seedTemplate.SeedTemplate;
import parser.DecorationTableParser;
import parser.SeedTemplateParser;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Generateur de code Java pour des series temporelles");
		System.out.println("Veuillez entrer le chemin du fichier json de la table de decoration");
		//String fileDecorationTable = br.readLine();
		String fileDecorationTable = "Documents/FootprintDecorationTable.json";
		System.out.println("Veuillez entrer le chemin du fichier json du seed transducer");
		//String fileSeedTemplate = br.readLine();
		String fileSeedTemplate = "Documents/DecreasingSeedTemplate.json";
		DecorationTable table = DecorationTableParser.parseDecorationTable(fileDecorationTable);
		SeedTemplate seed = SeedTemplateParser.parseSeedTemplate(fileSeedTemplate);
		System.out.println("Lancement de la generation de code");
		Generator generator = new Generator(table,seed);
		generator.seeCodeInConsole();
	
	
	}

}
