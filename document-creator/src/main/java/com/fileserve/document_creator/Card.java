package com.fileserve.document_creator;

public class Card
{
    private String name;
    private String header;
    private String content;

    public Card(String name, String header, String content) {
        this.name = name;
        this.header = header;
        this.content = content;
    }
    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
