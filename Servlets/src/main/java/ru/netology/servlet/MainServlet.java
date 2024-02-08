package ru.netology.servlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.netology.controller.PostController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
    private PostController controller;
    private static final String GET_METHOD = "GET";
    private static final String POST_METHOD = "POST";
    private static final String DELETE_METHOD = "DELETE";
    private static final String PATH = "/api/posts";
    private static final String PATH_WITH_PARAMETER = "/api/posts/\\d+";
    @Override
    public void init() {

        final var AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext("ru.netology");

        controller = (PostController) AnnotationConfigApplicationContext.getBean("postController");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        // если деплоились в root context, то достаточно этого
        try {
            final var path = req.getRequestURI();
            final var method = req.getMethod();
            // primitive routing
            if (method.equals(GET_METHOD) && path.equals(PATH)) {
                controller.all(resp);
                return;
            }
            if (method.equals(GET_METHOD) && path.matches(PATH_WITH_PARAMETER)) {
                // easy way
                final var id = getId(path);
                controller.getById(id, resp);
                return;
            }
            if (method.equals(POST_METHOD) && path.equals(PATH)) {
                controller.save(req.getReader(), resp);
                return;
            }
            if (method.equals(DELETE_METHOD) && path.matches(PATH_WITH_PARAMETER)) {
                // easy way
                final var id = getId(path);
                controller.removeById(id, resp);
                return;
            }
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    public long getId(String path) {
        int lastIndex = path.lastIndexOf("/");
        String substring = path.substring(lastIndex);
        return Long.parseLong(substring);
    }

}
