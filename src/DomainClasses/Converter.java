/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DomainClasses;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cdc214
 */
public class Converter {
    private String audioFormat;
    private String videoLocation;
    private String audioLocation;
    

    public Converter(){
        audioFormat = "wav";
    }
    public void setAudioFormat(String f){
        audioFormat = f;
    }
    public String getAudioFormat(){
        return audioFormat;
    }
    public void setAudioLocation(String l){
        audioLocation = l;
    }
    public String getAudioLocation(){
        return audioLocation;
    }
    public void setVideoLocation(String l){
        videoLocation = l;
    }
    public String getVideoLocation(){
        return videoLocation;
    }
    public void startConvert(String name){
        Runtime rt = Runtime.getRuntime();
        try {
            /*System.out.println("\"c:\\Program Files\\VideoLAN\\VLC\\vlc.exe\" "
                    + "-I dummy --no-sout-video --sout-audio --no-sout-rtp-sap --no-sout-standard-sap --ttl=1 --sout-keep "
                    + " --sout \"#transcode{acodec=s16l,channels=2}:std{access=file,mux=wav,dst=" + audioLocation + name +"." + audioFormat + "}\" "
                    + "\"" + videoLocation + "\"" + " vlc://quit");*/
            rt.exec("\"c:\\Program Files\\VideoLAN\\VLC\\vlc.exe\" "
                    + "-I dummy --no-sout-video --sout-audio --no-sout-rtp-sap --no-sout-standard-sap --ttl=1 --sout-keep "
                    + " --sout \"#transcode{acodec=s16l,channels=2}:std{access=file,mux=wav,dst=" + audioLocation + name +"." + audioFormat + "}\" "
                    + "\"" + videoLocation + "\"" + " vlc://quit");
            
            
        } catch (IOException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
