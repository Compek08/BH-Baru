/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller;

import java.awt.image.*;

import battle.of.hero.View.PlayClassic;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author rakas
 */
public class cIcon {
    AffineTransform at;
//    PlayClassic vClassic = new PlayClassic();
    private int position;
    private double angle;

    public ImageIcon rotateImageIcon(ImageIcon picture, int w, int h, double angle) {
        // FOR YOU ...
//        int w = picture.getIconWidth();
//        int h = picture.getIconHeight();
//at = new AffineTransform();
        int type = BufferedImage.TYPE_INT_RGB;  // other options, see api
        BufferedImage image = new BufferedImage(h, w, type);
        Graphics2D g2 = image.createGraphics();
        double x = (h - w)/2.0;
        double y = (w - h)/2.0;
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        at.rotate(angle, w/2.0, h/2.0);
        g2.drawImage(picture.getImage(), at, null);
        g2.dispose();
        picture = new ImageIcon(image);
 
        return picture;
    }
    
}
