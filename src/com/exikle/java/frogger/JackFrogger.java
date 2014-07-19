package com.exikle.java.frogger;

/**
 * Old code for Frogger
 * 
 * @author Dixon D'Cunha
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

@SuppressWarnings("serial")
public class JackFrogger extends Applet implements Runnable {

	private final int START_SCORE = 0;

	private final String PIC_PATH = "FroggerPics/";

	private final int START_ROUND = 1;

	private final int START_LIVES = 3;

	private final int APPLET_WIDTH = 640, APPLET_HEIGHT = 420;

	private final int START_X = 320;

	private final int START_Y = 384;

	private final int THREAD_SLEEP_TIME = 15;

	private int roundNum;

	private int playerLives;

	private int threadSleepTime;

	private int playerScore;

	int flag1 = 0;

	int[] flag2;

	int xSpeed = 0, ySpeed = 0;

	int xFrog = 320, yFrog = 384;

	int car1x = 0, car1XSpeed = 1;

	int car1x2 = -480, car1XSpeed2 = 0;

	int car2x = 100, car2XSpeed = -1;

	int car2x2 = 640, car2XSpeed2 = 0;

	int car3x = 0, car3XSpeed = 2;

	int car3x2 = -480, car3XSpeed2 = 0;

	int car4x = 50, car4XSpeed = -1;

	int car4x2 = 640, car4XSpeed2 = 0;

	int car5x = 50, car5XSpeed = 2;

	int car5x2 = -300, car5XSpeed2 = 0;

	int log96x = 50, log96XSpeed = -1;

	int log96x2 = 640, log96XSpeed2 = 0;

	int log110x = 200, log110XSpeed = -1;

	int log110x2 = 640, log110XSpeed2 = 0;

	int log128x = 10, log128XSpeed = -2;

	int log128x2 = 640, log128XSpeed2 = 0;

	int turtle3x = 0, turtle3XSpeed = 1;

	int turtle3x2 = -864, turtle3XSpeed2 = 0;

	int turtle2x = 100, turtle2XSpeed = 1;

	int turtle2x2 = -544, turtle2XSpeed2 = 0;

	Image frogImg;

	Image bgImg;

	Image[] cars;

	Image log96;

	Image log110;

	Image log128;

	Image turtles3;

	Image turtles2;

	Image frogD;

	Image[] frog;

	private Image dbImage;

	private Graphics dbg;

	public void init() {
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
		roundNum = START_ROUND;
		playerLives = START_LIVES;
		threadSleepTime = THREAD_SLEEP_TIME;
		playerScore = START_SCORE;
		flag2 = new int[5];
		initializeImages();
	}

	private void initializeImages() {
		frogImg = createImage("frogU.png");
		bgImg = createImage("frogboard.png");

		cars = new Image[3];
		for (int x = 0; x < 3; x++) {
			cars[x] = createImage("car" + x + ".png");
		}

		log96 = createImage("log96.png");
		log110 = createImage("log110.png");
		log128 = createImage("log128.png");

		turtles3 = createImage("3turtle.png");
		turtles2 = createImage("2turtles.png");

		frogD = createImage("frogD.png");

		frog = new Image[4];
		frog[0] = createImage("frogU.png");
		frog[1] = createImage("frogD.png");
		frog[2] = createImage("frogL.png");
		frog[3] = createImage("frogR.png");
		

	}

	private Image createImage(String picString) {
		return getImage(getCodeBase(), PIC_PATH + picString);
	}

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while (true) {
			// repaint the applet
			repaint();
			try {
				// Stop thread for 20 milliseconds
				Thread.sleep(threadSleepTime);
			} catch (InterruptedException ex) {
				// do nothing
			}
			// set ThreadPriority to maximum value
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

			moveObjects();

			checkCollision();
			// //////Frog on Logs/Turtles/////////////
			if (yFrog < 190 && yFrog >= 158) {
				if (xFrog + 10 >= turtle3x
						&& xFrog + 10 <= turtle3x + 96
						|| xFrog + 10 >= turtle3x + 192
						&& xFrog + 10 <= turtle3x + 288
						|| xFrog + 10 >= turtle3x + 384
						&& xFrog + 10 <= turtle3x + 480
						|| xFrog + 10 >= turtle3x + 576
						&& xFrog + 10 <= turtle3x + 672
						|| xFrog + 10 >= turtle3x + 768
						&& xFrog + 10 <= turtle3x + 864
						|| xFrog + 24 >= turtle3x
						&& xFrog + 24 <= turtle3x + 96
						|| xFrog + 24 >= turtle3x + 192
						&& xFrog + 24 <= turtle3x + 288
						|| xFrog + 24 >= turtle3x + 384
						&& xFrog + 24 <= turtle3x + 480
						|| xFrog + 24 >= turtle3x + 576
						&& xFrog + 24 <= turtle3x + 672
						|| xFrog + 24 >= turtle3x + 768
						&& xFrog + 24 <= turtle3x + 864) {
					xFrog++;
				} else if (xFrog + 10 >= turtle3x2
						&& xFrog + 10 <= turtle3x2 + 96
						|| xFrog + 10 >= turtle3x2 + 192
						&& xFrog + 10 <= turtle3x2 + 288
						|| xFrog + 10 >= turtle3x2 + 384
						&& xFrog + 10 <= turtle3x2 + 480
						|| xFrog + 10 >= turtle3x2 + 576
						&& xFrog + 10 <= turtle3x2 + 672
						|| xFrog + 10 >= turtle3x2 + 768
						&& xFrog + 10 <= turtle3x2 + 864
						|| xFrog + 24 >= turtle3x2
						&& xFrog + 24 <= turtle3x2 + 96
						|| xFrog + 24 >= turtle3x2 + 192
						&& xFrog + 24 <= turtle3x2 + 288
						|| xFrog + 24 >= turtle3x2 + 384
						&& xFrog + 24 <= turtle3x2 + 480
						|| xFrog + 24 >= turtle3x2 + 576
						&& xFrog + 24 <= turtle3x2 + 672
						|| xFrog + 24 >= turtle3x2 + 768
						&& xFrog + 24 <= turtle3x2 + 864) {
					xFrog++;
				} else {
					collisionOutput();
				}
			}

			if (yFrog < 158 && yFrog >= 126) {
				if (xFrog + 10 >= log96x && xFrog + 10 <= log96x + 96
						|| xFrog + 10 >= log96x + 136
						&& xFrog + 10 <= log96x + 232
						|| xFrog + 10 >= log96x + 272
						&& xFrog + 10 <= log96x + 368
						|| xFrog + 24 >= log96x
						&& xFrog + 24 <= log96x + 96
						|| xFrog + 24 >= log96x + 136
						&& xFrog + 24 <= log96x + 232
						|| xFrog + 24 >= log96x + 272
						&& xFrog + 24 <= log96x + 368) {
					xFrog--;
				} else if (xFrog + 10 >= log96x2
						&& xFrog + 10 <= log96x2 + 96
						|| xFrog + 10 >= log96x2 + 136
						&& xFrog + 10 <= log96x2 + 232
						|| xFrog + 10 >= log96x2 + 272
						&& xFrog + 10 <= log96x2 + 368
						|| xFrog + 24 >= log96x2
						&& xFrog + 24 <= log96x2 + 96
						|| xFrog + 24 >= log96x2 + 136
						&& xFrog + 24 <= log96x2 + 232
						|| xFrog + 24 >= log96x2 + 272
						&& xFrog + 24 <= log96x2 + 368) {
					xFrog--;
				} else {
					collisionOutput();
				}
			}
			if (yFrog < 126 && yFrog >= 94) {
				if (xFrog + 10 >= log128x + 3
						&& xFrog + 10 <= log128x + 189
						|| xFrog + 10 >= log128x + 255
						&& xFrog + 10 <= log128x + 441
						|| xFrog + 10 >= log128x + 507
						&& xFrog + 10 <= log128x + 693
						|| xFrog + 24 >= log128x + 3
						&& xFrog + 24 <= log128x + 189
						|| xFrog + 24 >= log128x + 255
						&& xFrog + 24 <= log128x + 441
						|| xFrog + 24 >= log128x + 507
						&& xFrog + 24 <= log128x + 693) {
					xFrog -= 2;
				} else if (xFrog + 10 >= log128x2 + 3
						&& xFrog + 10 <= log128x2 + 189
						|| xFrog + 10 >= log128x2 + 255
						&& xFrog + 10 <= log128x2 + 441
						|| xFrog + 10 >= log128x2 + 507
						&& xFrog + 10 <= log128x2 + 693
						|| xFrog + 24 >= log128x2 + 3
						&& xFrog + 24 <= log128x2 + 189
						|| xFrog + 24 >= log128x2 + 255
						&& xFrog + 24 <= log128x2 + 441
						|| xFrog + 24 >= log128x2 + 507
						&& xFrog + 24 <= log128x2 + 693) {
					xFrog -= 2;
				} else {
					collisionOutput();
				}
			}
			if (yFrog < 94 && yFrog >= 62) {
				if (xFrog + 10 >= turtle2x + 1
						&& xFrog + 10 <= turtle2x + 64
						|| xFrog + 10 >= turtle2x + 161
						&& xFrog + 10 <= turtle2x + 224
						|| xFrog + 10 >= turtle2x + 321
						&& xFrog + 10 <= turtle2x + 384
						|| xFrog + 10 >= turtle2x + 481
						&& xFrog + 10 <= turtle2x + 544
						|| xFrog + 24 >= turtle2x + 1
						&& xFrog + 24 <= turtle2x + 64
						|| xFrog + 24 >= turtle2x + 161
						&& xFrog + 24 <= turtle2x + 224
						|| xFrog + 24 >= turtle2x + 321
						&& xFrog + 24 <= turtle2x + 384
						|| xFrog + 24 >= turtle2x + 481
						&& xFrog + 24 <= turtle2x + 544) {
					xFrog++;
				} else if (xFrog + 10 >= turtle2x2 + 1
						&& xFrog + 10 <= turtle2x2 + 64
						|| xFrog + 10 >= turtle2x2 + 161
						&& xFrog + 10 <= turtle2x2 + 224
						|| xFrog + 10 >= turtle2x2 + 321
						&& xFrog + 10 <= turtle2x2 + 384
						|| xFrog + 10 >= turtle2x2 + 481
						&& xFrog + 10 <= turtle2x2 + 544
						|| xFrog + 24 >= turtle2x2 + 1
						&& xFrog + 24 <= turtle2x2 + 64
						|| xFrog + 24 >= turtle2x2 + 161
						&& xFrog + 24 <= turtle2x2 + 224
						|| xFrog + 24 >= turtle2x2 + 321
						&& xFrog + 24 <= turtle2x2 + 384
						|| xFrog + 24 >= turtle2x2 + 481
						&& xFrog + 24 <= turtle2x2 + 544) {
					xFrog++;
				} else {
					collisionOutput();
				}
			}
			if (yFrog < 62 && yFrog >= 30) {
				if (xFrog + 10 >= log110x + 2
						&& xFrog + 10 <= log110x + 109
						|| xFrog + 10 >= log110x + 162
						&& xFrog + 10 <= log110x + 269
						|| xFrog + 10 >= log110x + 322
						&& xFrog + 10 <= log110x + 429
						|| xFrog + 10 >= log110x + 482
						&& xFrog + 10 <= log110x + 589
						|| xFrog + 24 >= log110x + 2
						&& xFrog + 24 <= log110x + 109
						|| xFrog + 24 >= log110x + 162
						&& xFrog + 24 <= log110x + 269
						|| xFrog + 24 >= log110x + 322
						&& xFrog + 24 <= log110x + 429
						|| xFrog + 24 >= log110x + 482
						&& xFrog + 24 <= log110x + 589) {
					xFrog--;
				} else if (xFrog + 10 >= log110x2 + 2
						&& xFrog + 10 <= log110x2 + 109
						|| xFrog + 10 >= log110x2 + 162
						&& xFrog + 10 <= log110x2 + 269
						|| xFrog + 10 >= log110x2 + 322
						&& xFrog + 10 <= log110x2 + 429
						|| xFrog + 10 >= log110x2 + 482
						&& xFrog + 10 <= log110x2 + 589
						|| xFrog + 24 >= log110x2 + 2
						&& xFrog + 24 <= log110x2 + 109
						|| xFrog + 24 >= log110x2 + 162
						&& xFrog + 24 <= log110x2 + 269
						|| xFrog + 24 >= log110x2 + 322
						&& xFrog + 24 <= log110x2 + 429
						|| xFrog + 24 >= log110x2 + 482
						&& xFrog + 24 <= log110x2 + 589) {
					xFrog--;
				} else {
					collisionOutput();
				}
			}
			// //////Frog on Lilypads///////
			if (yFrog < 32 && yFrog >= 0) {
				boolean scored = true;
				if (xFrog + 6 > 38 && xFrog + 26 < 88 && flag2[0] == 0) {
					flag1 = 1;
					flag2[0] = 1;
				} else if (xFrog + 4 > 168 && xFrog + 26 < 218
						&& flag2[1] == 0) {
					flag1 = 2;
					flag2[1] = 1;
				} else if (xFrog + 6 > 294 && xFrog + 26 < 344
						&& flag2[2] == 0) {
					flag1 = 3;
					flag2[2] = 1;
				} else if (xFrog + 6 > 421 && xFrog + 26 < 471
						&& flag2[3] == 0) {
					flag1 = 4;
					flag2[3] = 1;
				} else if (xFrog + 6 > 555 && xFrog + 26 < 605
						&& flag2[4] == 0) {
					flag1 = 5;
					flag2[4] = 1;
				} else {
					scored = false;
					collisionOutput();
				}

				if (scored)
					scoreOutput();
			}
			checkIfGameDone();
			resetCollisionObj();
			repaint();
		}
	}

	private void checkIfGameDone() {
		if (playerScore == 5) {
			playerScore = START_SCORE;
			roundNum++;
			if (threadSleepTime >= 6) {
				threadSleepTime = threadSleepTime - 2;
			}
			resetFlag2();
		}
		if (playerLives == 0)
			restartGame();
	}

	private void checkCollision() {
		// ////Frog contact with Traffic////////
		for (int a = 6; a <= 26; a++) {
			if (xFrog + a >= car1x && xFrog + a <= car1x + 40
					|| xFrog + a >= car1x + 220
					&& xFrog + a <= car1x + 250
					|| xFrog + a >= car1x + 440
					&& xFrog + a <= car1x + 480 || xFrog + a >= car1x2
					&& xFrog + a <= car1x2 + 40
					|| xFrog + a >= car1x2 + 220
					&& xFrog + a <= car1x2 + 250
					|| xFrog + a >= car1x2 + 440
					&& xFrog + a <= car1x2 + 480) {
				if (yFrog < 384 && yFrog >= 352) {
					collisionOutput();
				}
			}
			if (xFrog + a >= car2x && xFrog + a <= car2x + 40
					|| xFrog + a >= car2x + 220
					&& xFrog + a <= car2x + 250
					|| xFrog + a >= car2x + 440
					&& xFrog + a <= car2x + 480 || xFrog + a >= car2x2
					&& xFrog + a <= car2x2 + 40
					|| xFrog + a >= car2x2 + 220
					&& xFrog + a <= car2x2 + 250
					|| xFrog + a >= car2x2 + 440
					&& xFrog + a <= car2x2 + 480) {
				if (yFrog < 352 && yFrog >= 320) {
					collisionOutput();
				}
			}
			if (xFrog + a >= car3x && xFrog + a <= car3x + 40
					|| xFrog + a >= car3x + 220
					&& xFrog + a <= car3x + 250
					|| xFrog + a >= car3x + 440
					&& xFrog + a <= car3x + 480 || xFrog + a >= car3x2
					&& xFrog + a <= car3x2 + 40
					|| xFrog + a >= car3x2 + 220
					&& xFrog + a <= car3x2 + 250
					|| xFrog + a >= car3x2 + 440
					&& xFrog + a <= car3x2 + 480) {
				if (yFrog < 320 && yFrog >= 288) {
					collisionOutput();
				}
			}
			if (xFrog + a >= car4x && xFrog + a <= car4x + 40
					|| xFrog + a >= car4x + 220
					&& xFrog + a <= car4x + 250
					|| xFrog + a >= car4x + 440
					&& xFrog + a <= car4x + 480 || xFrog + a >= car4x2
					&& xFrog + a <= car4x2 + 40
					|| xFrog + a >= car4x2 + 220
					&& xFrog + a <= car4x2 + 250
					|| xFrog + a >= car4x2 + 440
					&& xFrog + a <= car4x2 + 480) {
				if (yFrog < 288 && yFrog >= 256) {
					collisionOutput();
				}
			}
			if (xFrog + a >= car5x && xFrog + a <= car5x + 60
					|| xFrog + a >= car5x + 240
					&& xFrog + a <= car5x + 300 || xFrog + a >= car5x2
					&& xFrog + a <= car5x2 + 60
					|| xFrog + a >= car5x2 + 240
					&& xFrog + a <= car5x2 + 300) {
				if (yFrog < 256 && yFrog >= 224) {
					collisionOutput();
				}
			}
		}
	}

	private void moveObjects() {

		car1x += car1XSpeed;
		car1x2 += car1XSpeed2;

		car2x += car2XSpeed;
		car2x2 += car2XSpeed2;

		car3x += car3XSpeed;
		car3x2 += car3XSpeed2;

		car4x += car4XSpeed;
		car4x2 += car4XSpeed2;

		car5x += car5XSpeed;
		car5x2 += car5XSpeed2;

		log96x += log96XSpeed;
		log96x2 += log96XSpeed2;

		log110x += log110XSpeed;
		log110x2 += log110XSpeed2;

		log128x += log128XSpeed;
		log128x2 += log128XSpeed2;

		turtle3x += turtle3XSpeed;
		turtle3x2 += turtle3XSpeed2;

		turtle2x += turtle2XSpeed;
		turtle2x2 += turtle2XSpeed2;
	}

	/**
	 * Creates a double buffered image of the screen and displays it
	 */
	public void update(Graphics g) {
		// initialize buffer
		if (dbImage == null) {
			dbImage = createImage(640, 640);
			dbg = dbImage.getGraphics();
		}
		// clear screen in background
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width,
				this.getSize().height);

		// draw elements in background
		dbg.setColor(getForeground());
		paint(dbg);

		// draw image on the screen
		g.drawImage(dbImage, 0, 0, this);

	}

	public boolean mouseDown(Event e, int x, int y) {
		return true;
	}

	// method to handle key - down events
	public boolean keyDown(Event e, int key) {
		switch (key) {
			case Event.UP:
				frogImg = frog[0];
				ySpeed = -32;
				xSpeed = 0;
				changeCoordinates();
				break;
			case Event.DOWN:
				frogImg = frog[1];
				ySpeed = 32;
				xSpeed = 0;
				changeCoordinates();
				break;
			case Event.LEFT:
				frogImg = frog[2];
				xSpeed = -32;
				ySpeed = 0;
				changeCoordinates();
				break;
			case Event.RIGHT:
				frogImg = frog[3];
				xSpeed = 32;
				ySpeed = 0;
				changeCoordinates();
				break;
		}
		return true;
	}

	private void changeCoordinates() {
		xFrog += xSpeed;
		yFrog += ySpeed;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(bgImg, 0, 0, this);

		drawHud(g);

		g.setColor(Color.GREEN);

		g.drawImage(cars[1], car1x, 357, this);
		g.drawImage(cars[1], car1x2, 357, this);

		g.drawImage(cars[2], car2x, 323, this);
		g.drawImage(cars[2], car2x2, 323, this);

		g.drawImage(cars[1], car3x, 292, this);
		g.drawImage(cars[1], car3x2, 292, this);

		g.drawImage(cars[1], car4x, 259, this);
		g.drawImage(cars[1], car4x2, 259, this);

		g.drawImage(cars[0], car5x, 226, this);
		g.drawImage(cars[0], car5x2, 226, this);

		g.drawImage(log96, log96x, 133, this);
		g.drawImage(log96, log96x2, 133, this);

		g.drawImage(log110, log110x, 36, this);
		g.drawImage(log110, log110x2, 36, this);

		g.drawImage(log128, log128x, 102, this);
		g.drawImage(log128, log128x2, 102, this);

		g.drawImage(turtles3, turtle3x, 164, this);
		g.drawImage(turtles3, turtle3x2, 164, this);

		g.drawImage(turtles2, turtle2x, 68, this);
		g.drawImage(turtles2, turtle2x2, 68, this);

		if (car1x2 >= 300)
			car1XSpeed = 1;
		if (car1x >= 300)
			car1XSpeed2 = 1;

		if (car2x2 <= -100)
			car2XSpeed = -1;
		if (car2x <= -100)
			car2XSpeed2 = -1;

		if (car3x2 >= 300)
			car3XSpeed = 2;
		if (car3x >= 300)
			car3XSpeed2 = 2;

		if (car4x2 <= -100)
			car4XSpeed = -1;
		if (car4x <= -100)
			car4XSpeed2 = -1;

		if (car5x2 >= 300)
			car5XSpeed = 2;
		if (car5x >= 300)
			car5XSpeed2 = 2;

		if (log96x2 <= -70)
			log96XSpeed = -1;
		if (log96x <= -70)
			log96XSpeed2 = -1;

		if (log110x2 <= -150)
			log110XSpeed = -1;
		if (log110x <= -150)
			log110XSpeed2 = -1;

		if (log128x2 <= -190)
			log128XSpeed = -2;
		if (log128x <= -190)
			log128XSpeed2 = -2;

		if (turtle2x2 >= 250)
			turtle2XSpeed = 1;
		if (turtle2x >= 250)
			turtle2XSpeed2 = 1;
		if (turtle3x2 >= 160)
			turtle3XSpeed = 1;
		if (turtle3x >= 160)
			turtle3XSpeed2 = 1;

		drawCompletedFrogs(g);

		if (flag1 == 0) {
			g.drawImage(frogImg, xFrog, yFrog, this);
		}
	}

	private void drawCompletedFrogs(Graphics g) {

		if (flag1 == 1 || flag2[0] == 1) {
			g.drawImage(frogD, 48, 0, this);
			flag1 = 0;
		}

		if (flag1 == 2 || flag2[1] == 1) {
			g.drawImage(frogD, 178, 0, this);
			flag1 = 0;
		}

		if (flag1 == 3 || flag2[2] == 1) {
			g.drawImage(frogD, 306, 0, this);
			flag1 = 0;
		}

		if (flag1 == 4 || flag2[3] == 1) {
			g.drawImage(frogD, 432, 0, this);
			flag1 = 0;
		}

		if (flag1 == 5 || flag2[4] == 1) {
			g.drawImage(frogD, 565, 0, this);
			flag1 = 0;
		}

	}

	private void drawHud(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawString("Round: " + roundNum, 10, 405);
		g.drawString("Lives: " + playerLives, 100, 405);
		g.drawString("Score: " + playerScore, 175, 405);
	}

	private void resetCollisionObj() {
		if (car1x >= 640) {
			car1x = -480;
			car1XSpeed = 0;
		}
		if (car1x2 >= 640) {
			car1x2 = -480;
			car1XSpeed2 = 0;
		}

		if (car2x <= -480) {
			car2x = 640;
			car2XSpeed = 0;
		}
		if (car2x2 <= -480) {
			car2x2 = 640;
			car2XSpeed2 = 0;
		}

		if (car3x >= 640) {
			car3x = -480;
			car3XSpeed = 0;
		}
		if (car3x2 >= 640) {
			car3x2 = -480;
			car3XSpeed2 = 0;
		}

		if (car4x <= -480) {
			car4x = 640;
			car4XSpeed = 0;
		}
		if (car4x2 <= -480) {
			car4x2 = 640;
			car4XSpeed2 = 0;
		}

		if (car5x >= 640) {
			car5x = -300;
			car5XSpeed = 0;
		}
		if (car5x2 >= 640) {
			car5x2 = -300;
			car5XSpeed2 = 0;
		}

		if (log96x <= -368) {
			log96x = 640;
			log96XSpeed = 0;
		}
		if (log96x2 <= -368) {
			log96x2 = 640;
			log96XSpeed2 = 0;
		}

		if (log110x <= -590) {
			log110x = 640;
			log110XSpeed = 0;
		}
		if (log110x2 <= -590) {
			log110x2 = 640;
			log110XSpeed2 = 0;
		}

		if (log128x <= -696) {
			log128x = 640;
			log128XSpeed = 0;
		}
		if (log128x2 <= -696) {
			log128x2 = 640;
			log128XSpeed2 = 0;
		}

		if (turtle3x >= 640) {
			turtle3x = -864;
			turtle3XSpeed = 0;
		}
		if (turtle3x2 >= 640) {
			turtle3x2 = -864;
			turtle3XSpeed2 = 0;
		}

		if (turtle2x >= 640) {
			turtle2x = -544;
			turtle2XSpeed = 0;
		}
		if (turtle2x2 >= 640) {
			turtle2x2 = -544;
			turtle2XSpeed2 = 0;
		}
	}

	private void collisionOutput() {
		System.out.println("DIED");
		playerLives--;
		resetFrog();
	}

	private void scoreOutput() {
		System.out.println("SCORE");
		playerScore += 100;
		resetFrog();
	}

	private void resetFrog() {
		frogImg = frog[0];
		xFrog = START_X;
		yFrog = START_Y;
		repaint();
	}

	private void restartGame() {
		resetFrog();
		resetFlag2();
		threadSleepTime = THREAD_SLEEP_TIME;
		playerScore = START_SCORE;
		playerLives = START_LIVES;
		roundNum = START_ROUND;
	}

	private void resetFlag2() {
		for (int x = 0; x < 5; x++) {
			flag2[x] = 0;
		}
	}
}