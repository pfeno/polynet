import com.polytech.business.PublicationService;
import com.polytech.data.InMemoryRepositories;
import com.polytech.data.Story;
import com.polytech.data.StoryRepository;
import com.polytech.rest.PostController;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // instantiate and inject dependencies ...
        StoryRepository storyRepository = new InMemoryRepositories();
        PublicationService publicationService = new PublicationService(storyRepository);
        PostController postController = new PostController(publicationService);

        postController.share("hello Marseille");
        postController.share("hello Paris");
        postController.share("hello London");

        List<Story> feed = publicationService.fetchAll();
        for(Story s: feed) {
            System.out.println(s.toString());
        }
    }
}
