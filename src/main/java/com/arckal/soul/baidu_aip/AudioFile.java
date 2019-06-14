package com.arckal.soul.baidu_aip;

public class AudioFile {
    private String filename;
    private int duration;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "AudioFile{" +
                "filename='" + filename + '\'' +
                ", duration=" + duration +
                '}';
    }
}
