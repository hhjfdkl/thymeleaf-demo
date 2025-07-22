package com.fileserve.document_creator;

public class ParagraphContent extends Content
{
    private String content;

    public ParagraphContent(String content) {
        super("paragraph");
        this.content = content;
    }

    public ParagraphContent() {
        super("paragraph");
    }

    public String getContent() {
        return content;
    }
}
