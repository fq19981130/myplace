package src.com.concurrency2.Balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BlkingData {

    private final String fileName;

    private String context;

    private boolean changed;

    public BlkingData(String fileName,String context){
        this.fileName = fileName;
        this.context = context;
        this.changed = true;
    }
    public synchronized void change(String newContext){
        this.context = newContext;
        this.changed = true;
    }
    public synchronized void save() throws IOException {
        if (!changed){
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave() throws IOException {

        System.out.println(Thread.currentThread().getName()+ "calls do save,context = "+context);
        try (Writer writer = new FileWriter(fileName, true);){
            writer.write(context);
            writer.write("\n");
            writer.flush();
        }
    }
}
