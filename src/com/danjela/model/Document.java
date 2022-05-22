package com.danjela.model;

import com.danjela.exception.IndexException;
import com.danjela.util.TokenUtil;

import java.util.List;

public class Document {

    private Integer id;
    private List<String> tokens;

    public Document(Integer id, List<String> tokens) throws IllegalArgumentException {

        if (id < 0) {
            throw new IndexException("Id must be greater than 0!");
        }

        if (tokens.isEmpty()) {
            throw new IndexException("A document should contain an arbitrary number of tokens greater than zero");
        }

        for (String token : tokens) {
            if (!TokenUtil.isAlphanumeric(token)) {
                throw new IndexException(
                        String.format("Token [%s] must contain only alphanumeric characters!", token));
            }
        }

        this.id = id;
        this.tokens = tokens;
    }

    public Integer getId() {
        return id;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", tokens=" + tokens +
                '}';
    }
}
