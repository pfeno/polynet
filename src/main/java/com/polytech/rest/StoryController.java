package com.polytech.rest;

import com.polytech.business.PublicationService;
import com.polytech.data.InMemoryRepositories;
import com.polytech.data.Story;
import com.polytech.data.StoryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/stories")
public class StoryController extends HttpServlet {

    private PublicationService publicationService;

    public StoryController() {
        // instantiate and inject dependencies ...
        StoryRepository storyRepository = new InMemoryRepositories();
        publicationService = new PublicationService(storyRepository);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");
        publicationService.share(new Story(content));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Story> stories = publicationService.fetchAll();
        resp.setContentType("application/json");
        String body = stories.stream()
                .map(story -> story.toString())
                .collect(Collectors.joining(","));

        PrintWriter writer = resp.getWriter();
        writer.println("[" + body + "]");
        // http://localhost:8080/polynet_war/stories?content=Hello
        // http://localhost:8080/polynet_war/stories?content=World
    }
}
