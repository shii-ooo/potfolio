package portfolio;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
public class TopicController {
    
    private final TopicRepository topicRepository;

    public TopicController(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    @GetMapping("/api/topics")
    public List<Map<String , Object>> getTopics() {
        return topicRepository.findAll();
    }
    
}
