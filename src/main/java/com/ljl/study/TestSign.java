package com.ljl.study;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestSign {

   public static void main(String[] args) {
       try {
           BufferedImage image = ImageIO.read(new File("d:/1H4A0158.jpg"));
           BufferedImage signImage = ImageIO.read(new File("d:/sign.gif"));
           int width = image.getWidth();
           int height = image.getHeight();
           Graphics graphics = image.getGraphics();
           graphics.drawImage(signImage, width/2, height/2, null);
           graphics.dispose();
           
           ImageIO.write(image, "jpg", new File("d:/ddddd.jpg"));
       } catch (IOException e) {
           e.printStackTrace();
       }
}

}
