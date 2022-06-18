package priv.dotjabber.plot.function;

import lombok.extern.log4j.Log4j2;
import priv.dotjabber.plot.common.Config;
import priv.dotjabber.plot.point.IPoint;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;

@Log4j2
public class ImageWorker extends Thread {
    private boolean running = true;

    private final String threadId;
    private final PlotFunction[] functions;
    private final int width;
    private final int height;
    private final IPoint zeroPoint;
    private final double scale;

    public ImageWorker(PlotFunction[] functions, int width, int height, IPoint zeroPoint, double scale) {
        this.functions = functions;
        this.width = width;
        this.height = height;
        this.zeroPoint = zeroPoint;
        this.scale = scale;
        this.threadId = Config.DATE_FORMAT.format(new Date());
    }

    @Override
    public void run() {
        boolean canContinue = true;
        int cycleNumber = 0;

        while (running && canContinue) {

            // file name
            String fileName = MessageFormat.format(Config.FILE_FORMAT, threadId, cycleNumber);

            // create image with functions state
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
            Arrays.stream(functions).forEach(f -> f.doPlot(image, zeroPoint, scale));

            try {
                ImageIO.write(image, "png", new File(fileName));
                log.info("Created image: " + fileName);

            } catch (IOException e) {
                log.error(e);
            }

            canContinue = Arrays.stream(functions).allMatch(PlotFunction::next);
            cycleNumber++;
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
        running = false;
    }
}
