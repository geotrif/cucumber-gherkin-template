package org.gherkin.background;

import java.util.Map;

public class BlogService {
    private final Map<String, Blog> blogs;

    public BlogService(Map<String, Blog> blogs) {
        this.blogs = blogs;
    }

    public String post(User user, String blogName) {
        Blog target = blogs.get(blogName);
        if (target == null) {
            return "Blog not found.";
        }
        if (user.role == Role.ADMIN) {
            return "Your article was published.";
        }
        if (target.owner != null && target.owner.name.equals(user.name)) {
            return "Your article was published.";
        }
        return "Hey! That's not your blog!";
    }
}
