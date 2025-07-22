package com.fileserve.document_creator;

public class Subtopic extends Fragment
{
    private String title;
    private String[] content;

    public Subtopic(String title, String[] content) {
        super("subtopic");
        this.title = title;
        this.content = content;
    }

    public Subtopic()
    {
        super("subtopic");
    }

    public String getTitle() {
        return title;
    }

    public String[] getContent() {
        return content;
    }
}
