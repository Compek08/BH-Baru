/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.of.hero.Controller;
//import javafx.application.Application;
//import static javafx.application.ConditionalFeature.FXML;

import battle.of.hero.View.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

//import javafx.application.Platform;
//import javafx.beans.InvalidationListener;
//import javafx.beans.Observable;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.ButtonBuilder;
//import javafx.scene.control.Control;
//import javafx.scene.control.Label;
//import javafx.scene.control.LabelBuilder;
//import javafx.scene.control.Slider;
//import javafx.scene.control.SliderBuilder;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.Region;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaPlayer.Status;
//import javafx.scene.media.MediaView;
//import javafx.stage.Stage;
//import javafx.util.Duration;
/**
 *
 * @author rakas
 */
public class Controll {
    Setting set;
    public Controll() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        set = new Setting();
        set.setVisible(true);
        
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                new File("some_file.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
//        set.getBgVol().
        FloatControl gainControl
                = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
        clip.start();
        
        
//        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
//                new File("some_file.wav"));
//        Clip clip = AudioSystem.getClip();
//        clip.open(audioInputStream);
//        FloatControl gainControl
//                = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//        gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
//        clip.start();
    }
//    public int rgbIn = 16711680, rgbOut = 10027008;
//    @FXML Slider volumSlider;

}
