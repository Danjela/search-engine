package com.danjela.model;

import java.util.*;

public class SearchEngine {

    private static SearchEngine searchEngine;

    private Set<Document> documents;

    public static SearchEngine getInstance() {
        if (searchEngine == null) {
            synchronized (SearchEngine.class) {
                if (searchEngine == null) {
                    searchEngine = new SearchEngine();
                }
            }
        }
        return searchEngine;
    }

    private SearchEngine() {
        this.documents = new HashSet<>();
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public void addDocument(Document document) {
        Optional<Document> optionalDocument = documents.stream()
                .filter(doc -> Objects.equals(doc.getId(), document.getId()))
                .findFirst();
        if (optionalDocument.isEmpty()) {
            documents.add(document);
        } else {
            Document existingDocument = optionalDocument.get();
            existingDocument.setTokens(document.getTokens());
        }
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "documents=" + documents +
                '}';
    }
}