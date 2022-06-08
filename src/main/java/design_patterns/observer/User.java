package design_patterns.observer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User
{
    private final String name;
    private final List<User> followers = new ArrayList<>();

    public User(String name)
    {
        this.name = name;
    }

    public void postMessage(String message) {
        System.out.println("Feed for " + this.name + ": " + message);
        notifyObservers(message);
    }

    private void notifyObservers(String message)
    {
        for (User follower : followers) {
            follower.notify(message);
        }
    }

    public void followUser(User userToFollow)
    {
        userToFollow.getFollowers().add(this);
    }

    public void unfollowUser(User userToUnfollow) {
        userToUnfollow.getFollowers().remove(this);
    }

    public void notify(String message) {
        System.out.println("Notification for " + this.name + ": " + message);
    }
}
