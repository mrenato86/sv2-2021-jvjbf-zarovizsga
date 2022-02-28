package videos;

public class Channel {

    private final String channelName;
    private int subscriptions;
    private int numberOfVideos;

    public Channel(String channelName, int subscriptions, int numberOfVideos) {
        this.channelName = channelName;
        this.subscriptions = subscriptions;
        this.numberOfVideos = numberOfVideos;
    }

    public Channel(String csvLine) {
        String[] parts = csvLine.split(";");
        this.channelName = parts[0];
        this.subscriptions = Integer.parseInt(parts[1]);
        this.numberOfVideos = Integer.parseInt(parts[2]);
    }

    public String getChannelName() {
        return channelName;
    }

    public int getSubscriptions() {
        return subscriptions;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }
}
