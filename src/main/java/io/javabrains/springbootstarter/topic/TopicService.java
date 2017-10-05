package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	@Autowired
	private TopicRepository topicrepository;

	private List<Topic> topics=new ArrayList<>(Arrays.asList(new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("spring","Spring Framework","Spring Framework Description")));
	
	public List<Topic> getallTopics()
	{
		List<Topic> topic=new ArrayList<>();
		topicrepository.findAll().forEach(topic::add);
		return topic;
	}

public Topic getTopic(String id)
{
	//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	return topicrepository.findOne(id);
}
public void addTopic(Topic topic)
{
	topicrepository.save(topic);
}
public void updateTopic(String id,Topic topic) {
	/*for(int i=0;i<topics.size();i++)
	{
		Topic t=topics.get(i);
		if(t.getId().equals(id))
		{
			topics.set(i,topic);
			return;
		}
	}*/
	topicrepository.save(topic);
}
public void deleteTopic(String id)
{
	/*for(int i=0;i<topics.size();i++)
	{
		Topic t=topics.get(i);
		if(t.getId().equals(id))
		{
			topics.remove(i);
			return;
		}
	}*/
	topicrepository.delete(id);
}
	
}