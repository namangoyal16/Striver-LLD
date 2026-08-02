package creationDesignPatterns.singletonPattern;

public class withEagerLoading {
    private static final withEagerLoading instance = new  withEagerLoading();

    private withEagerLoading(){}

    public withEagerLoading getInstance(){
        return instance;
    }
}
