package edu.miracosta.cs112.finalproject.finalproject.models;

public class ImageLoadException extends RuntimeException {
    public ImageLoadException(String message)  {
        super("Error! Image not loaded properly. Could not find at path");
    }
}
