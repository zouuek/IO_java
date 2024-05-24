package org.example;

public class DigitalMovie extends Movie{
    private Integer fileSize;

    public DigitalMovie(String name, String director, String genre, Double price) {
        super(name, director, genre, price);
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
}
