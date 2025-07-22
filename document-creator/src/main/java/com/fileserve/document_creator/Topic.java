package com.fileserve.document_creator;

public class Topic extends Fragment
{
    private String topic;
    private Subtopic[] subtopics = { new Subtopic() };

    public Topic(String topic, Subtopic[] subtopics) {
        super("topic");
        this.topic = topic;
        this.subtopics = subtopics;
    }

    public Topic(String topic)
    {
        super("topic");
        this.topic = topic;
    }

    public Topic() {
        super("topic");
    }

    public String getTopic() {
        return topic;
    }

    public Subtopic[] getSubtopics() {
        return subtopics;
    }
}
