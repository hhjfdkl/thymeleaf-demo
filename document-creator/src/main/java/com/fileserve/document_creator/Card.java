package com.fileserve.document_creator;

public class Card extends Fragment
{
    private String header;
    private String content;

    public Card(String name, String header, String content) {
        //in this demo, the card names have some pre-built cards saved in the html
        //this is probably a design flaw?? Since normally the pre-set cards would be somewhere in the persistence layer
        //should probably just set the specific fragment name in super constructor
        super(name);
        this.header = header;
        this.content = content;
    }
    public Card(String name) {
        super(name);
    }

    public String getHeader() {
        return header;
    }


    public String getContent() {
        return content;
    }

}
