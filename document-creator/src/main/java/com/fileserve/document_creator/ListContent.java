package com.fileserve.document_creator;

public class ListContent extends Content
{
    private final boolean isOrdered;
    //This should be able to accept lists or strings, not just strings.
    //Or maybe we should just cut out sublists? Should we really allow nested lists?
    //Also, how would that look in the database layer?
    //Do we really want lists inside of lists inside of lists????
    private final String[] content;

    public ListContent(boolean isOrdered, String[] content) {
        super(isOrdered ? "ordered-list" : "unordered-list");
        this.isOrdered = isOrdered;
        this.content = content;
    }

    public String[] getContent() {
        return content;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
