package ru.netology.repository;


import org.springframework.stereotype.Repository;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
// Stub
public class PostRepository {

    private final ConcurrentHashMap<Long, Post> posts = new ConcurrentHashMap<>();
    private AtomicLong id = new AtomicLong();

    public List<Post> all() {

        return posts.values().stream()
                .filter(post -> !post.isRemoved())
                .collect(Collectors.toList());

    }

    public Optional<Post> getById(long id) {

        var post = posts.values().stream()
                .filter(value -> value.getId() == id)
                .findFirst();

        if (post.isPresent() && post.get().isRemoved()) {
            throw new NotFoundException();
        } else {
            return post;
        }
    }

    public Post save(Post post) {

        if (post.getId() == 0) {

            long newId = id.incrementAndGet();

            post.setId(newId);
            posts.put(newId, post);

            return post;
        }

        var newId = post.getId();

        var oldPost = posts.values().stream()
                .filter(value -> value.getId() == newId)
                .findFirst();

        if (oldPost.isPresent() && oldPost.get().isRemoved()) {
            throw new NotFoundException();
        } else {
            posts.put(newId, post);
        }

        return post;
    }

    public void removeById(long id) {

        posts.values().stream()
                .filter(p -> p.getId() == id && !p.isRemoved())
                .findFirst()
                .ifPresent(value -> value.setRemoved(true));

    }

}