package magiclamp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MidiSequencer {

	//** O sequenciador */
	private Sequencer sequencer;

	public MidiSequencer ()
	{
		sequencer = null;
	}

	public void playMidi ()
	{
		// Obtains the default Sequencer connected to a default device.
	    // Sequencer sequencer = null;
		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	    // Opens the device, indicating that it should now acquire any
	    // system resources it requires and become operational.
	    try {
			sequencer.open();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // create a stream from a file
	    InputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\PP\\Documents\\GitHub\\lampada\\src\\magiclamp\\Aladdin-(Medley-Of-All-Songs).mid")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Sets the current sequence on which the sequencer operates.
	    // The stream must point to MIDI file data.
	    try {
			sequencer.setSequence(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Starts playback of the MIDI data in the currently loaded sequence.
	    sequencer.start();
		
	}
	
	public void stopSequencer ()
	{
		sequencer.stop();
	}
	
}

