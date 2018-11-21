package main;

import java.io.IOException;

import model.generator.Generator;
import model.parameters.decorationTable.DecorationTable;
import model.parameters.seedTemplate.SeedTemplate;
import parser.DecorationTableParser;
import parser.SeedTemplateParser;

public class GeneratorMain {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Generateur de code Java pour des series temporelles");
		//System.out.println("Veuillez entrer le chemin du fichier json de la table de decoration");
		//String fileDecorationTable = br.readLine();
		String fileDecorationTable = "DecorationTables/FeatureDecorationTable.json";
		//System.out.println("Veuillez entrer le chemin du fichier json du seed transducer");
		//String fileSeedTemplate = br.readLine();
		String fileSeedTemplate = "SeedTemplates/DecreasingSeedTemplate.json";
		
		DecorationTable table = DecorationTableParser.parseDecorationTable(fileDecorationTable);
		SeedTemplate seed = SeedTemplateParser.parseSeedTemplate(fileSeedTemplate);
		
		System.out.println("Lancement de la generation de code");
		Generator generator = new Generator(table,seed);
		generator.seeCodeInConsole();
		generator.saveCodeInFile("src/test/"+table.getName().toUpperCase()+"_"+seed.getName().toUpperCase()+".java");
	}
}
