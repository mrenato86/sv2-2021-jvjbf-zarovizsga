package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    private final List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return List.copyOf(channels);
    }

    public void readDataFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            br.lines()
                    .skip(1)
                    .map(Channel::new)
                    .forEach(channels::add);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("Invalid file format!", ne);
        }
    }

    public int calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(Channel::getNumberOfVideos)
                .sum();
    }
}
