package com.fileserve.document_creator;

public class Subtopic extends Fragment
{
    private String title;
    private Content[] content;

    public Subtopic(String title, Content[] content) {
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

    public Content[] getContent() {
        return content;
    }
}
