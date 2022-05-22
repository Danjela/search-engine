package com.danjela;

import com.danjela.exception.IndexException;
import com.danjela.model.Document;
import com.danjela.model.SearchEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        SearchEngine searchEngine = SearchEngine.getInstance();

        while (input.hasNext()) {

            String [] command = input.nextLine().split(" ");

            try {
                if (command.length < 3) {
                    throw new IllegalArgumentException ("Command too short");
                }
                String commandName = command[0];

                if (!commandName.equals("index") && !commandName.equals("query")) {
                    throw new IllegalArgumentException ("Command should start with index or query");
                }

                if (commandName.equals("index")) {
                    Integer documentId = Integer.parseInt(command[1]);
                    List<String> tokens = new ArrayList<>(Arrays.asList(command).subList(2, command.length));
                    Document document = new Document(documentId, tokens);
                    searchEngine.addDocument(document);
                    System.out.printf("index ok : %s", documentId);
                    System.out.println(searchEngine.getDocuments());
                }
            } catch (IndexException ie) {
                System.out.printf("index error : %s", ie.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
