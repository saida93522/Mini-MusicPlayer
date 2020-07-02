import javax.sound.midi.*;
import javax.swing.*;

public class MiniMusicPlayer {
    static JFrame f = new JFrame("My first Music Video");
     static MyDrawPanel2 m1;


    public static void main(String[] args) {
        MiniMusicPlayer mini = new MiniMusicPlayer();
        mini.go();
    }
    public void setUpGui() {
        m1 = new MyDrawPanel2();
        f.getContentPane().add(m1);
        f.setBounds(30,30,300,300);
        f.setVisible(true);
    }


    public void go(){
        setUpGui();


        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // make and open a sequencer
            sequencer.open();

            //add controller event listener
            sequencer.addControllerEventListener(m1,new int[] {127});

            Sequence seq = new Sequence(Sequence.PPQ, 4); // make a sequence and a track
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 5; i < 61; i += 4) {/// make bunch of event to make the notes keep going

                r = (int) ((Math.random() * 50) +1);

                track.add(makeEvent(144,1,r,100,i));
                //insert controllerEvent(127)
                track.add(makeEvent(176,1,127,0,i));

                track.add(makeEvent(128,1,r,100,i +2 ));
                //calling makeEvent()
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);


        } catch (Exception e)   {e.printStackTrace();}
        }


    public MidiEvent makeEvent (int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);

        } catch (Exception e) {
            System.out.println();
        }
        return event;
    }
}
