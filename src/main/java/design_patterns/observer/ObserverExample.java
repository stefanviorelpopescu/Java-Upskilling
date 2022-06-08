package design_patterns.observer;

public class ObserverExample
{
    public static void main(String[] args)
    {
        User ion = new User("Ion");
        User maria = new User("Maria");
        User gigel = new User("Gigel");

        ion.followUser(maria);
        gigel.followUser(maria);

        ion.postMessage("Salutare");
        maria.postMessage("plec la mare");
        gigel.postMessage("covfefe");

        ion.unfollowUser(maria);
        maria.postMessage("am venit de la mare");

    }
}
