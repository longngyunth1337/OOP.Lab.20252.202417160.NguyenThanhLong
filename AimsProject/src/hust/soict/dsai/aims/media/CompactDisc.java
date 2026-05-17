package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
    }

    public CompactDisc(String title, String category, String director, float cost, String artist) {
        super(title, category, director, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists: " + track.getTitle());
            return;
        }

        tracks.add(track);
        System.out.println("Track added: " + track.getTitle());
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track does not exist: " + track.getTitle());
            return;
        }

        tracks.remove(track);
        System.out.println("Track removed: " + track.getTitle());
    }

    @Override
    public int getLength() {
        int totalLength = 0;

        for (Track track : tracks) {
            totalLength += track.getLength();
        }

        return totalLength;
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("Cannot play CD: " + getTitle());
            return;
        }

        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());

        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory()
                + " - " + artist + " - " + getDirector()
                + " - " + getLength()
                + ": " + getCost() + " $"
                + "\nTracks: " + tracks;
    }
}