import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;

	public GamePanel() {
		game = new Game();
		new Thread(this).start();
	}

	public void update() {
		game.update();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g;
		for (Render r : game.getRenders())
			if (r.transform != null)
				g2D.drawImage(r.image, r.transform, null);
			else
				g.drawImage(r.image, r.x, r.y, null);

		g2D.setColor(Color.BLACK);

		if (!game.started) {
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2D.drawString("Press SPACE to start", 150, 240);
		} else {
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 24));
			g2D.drawString(Integer.toString(game.score), 10, 465);
		}

		if (game.gameover) {
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2D.drawString("Press R to restart", 150, 240);
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				update();
				Thread.sleep(25);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}