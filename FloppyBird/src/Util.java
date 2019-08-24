import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Util {

	private static HashMap<String, Image> cache = new HashMap<>();

	public static Image loadImage(String path) {
		Image image = null;

		if (cache.containsKey(path)) {
			return cache.get(path);
		}

		try {
			image = ImageIO.read(new File(path));

			if (!cache.containsKey(path)) {
				cache.put(path, image);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}
}
