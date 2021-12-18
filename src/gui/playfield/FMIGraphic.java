/*
 * Copyright 2010 Aalto University, ComNet
 * Released under GPLv3. See LICENSE.txt for details.
 */
package gui.playfield;

import core.DTNHost;

import java.awt.*;

/**
 * Visualization of a message
 *
 */
public class FMIGraphic extends PlayFieldGraphic {


	public FMIGraphic() {

	}

	@Override
	public void draw(Graphics2D g2) {
		//MAGISTRALE
		g2.setColor(Color.RED);
		g2.drawString("MAGISTRALE",scale(450),scale(450));
		g2.drawRect(scale(350),scale(50),scale(300),scale(800));


		g2.setColor(Color.BLUE);
		g2.drawRect(scale(650),scale(810),scale(25),scale(25));

		//HS
		g2.setColor(Color.GREEN);
		g2.drawString("HS1",scale(570),scale(925));
		g2.drawRect(scale(500),scale(850),scale(150),scale(150));
		g2.drawString("HS2",scale(300),scale(725));
		g2.drawRect(scale(280),scale(695),scale(70),scale(70));
		g2.drawString("HS3",scale(300),scale(545));
		g2.drawRect(scale(280),scale(510),scale(70),scale(70));

		//ROOMS
		g2.setColor(Color.ORANGE);

		g2.drawRect(scale(170),scale(790),scale(30),scale(30));
		g2.drawRect(scale(200),scale(790),scale(30),scale(30));
		g2.drawRect(scale(230),scale(790),scale(30),scale(30));
		g2.drawRect(scale(260),scale(790),scale(30),scale(30));
		g2.drawRect(scale(290),scale(790),scale(30),scale(30));
		g2.drawRect(scale(320),scale(790),scale(30),scale(30));
		g2.drawRect(scale(170),scale(820),scale(30),scale(30));
		g2.drawRect(scale(200),scale(820),scale(30),scale(30));
		g2.drawRect(scale(230),scale(820),scale(30),scale(30));
		g2.drawRect(scale(260),scale(820),scale(30),scale(30));
		g2.drawRect(scale(290),scale(820),scale(30),scale(30));
		g2.drawRect(scale(320),scale(820),scale(30),scale(30));
		g2.drawRect(scale(650),scale(730),scale(30),scale(30));
		g2.drawRect(scale(680),scale(730),scale(30),scale(30));
		g2.drawRect(scale(710),scale(730),scale(30),scale(30));
		g2.drawRect(scale(740),scale(730),scale(30),scale(30));
		g2.drawRect(scale(770),scale(730),scale(30),scale(30));
		g2.drawRect(scale(800),scale(730),scale(30),scale(30));
		g2.drawRect(scale(650),scale(760),scale(30),scale(30));
		g2.drawRect(scale(680),scale(760),scale(30),scale(30));
		g2.drawRect(scale(710),scale(760),scale(30),scale(30));
		g2.drawRect(scale(740),scale(760),scale(30),scale(30));
		g2.drawRect(scale(770),scale(760),scale(30),scale(30));
		g2.drawRect(scale(800),scale(760),scale(30),scale(30));
		g2.drawRect(scale(170),scale(610),scale(30),scale(30));
		g2.drawRect(scale(200),scale(610),scale(30),scale(30));
		g2.drawRect(scale(230),scale(610),scale(30),scale(30));
		g2.drawRect(scale(260),scale(610),scale(30),scale(30));
		g2.drawRect(scale(290),scale(610),scale(30),scale(30));
		g2.drawRect(scale(320),scale(610),scale(30),scale(30));
		g2.drawRect(scale(170),scale(640),scale(30),scale(30));
		g2.drawRect(scale(200),scale(640),scale(30),scale(30));
		g2.drawRect(scale(230),scale(640),scale(30),scale(30));
		g2.drawRect(scale(260),scale(640),scale(30),scale(30));
		g2.drawRect(scale(290),scale(640),scale(30),scale(30));
		g2.drawRect(scale(320),scale(640),scale(30),scale(30));
		g2.drawRect(scale(650),scale(590),scale(30),scale(30));
		g2.drawRect(scale(680),scale(590),scale(30),scale(30));
		g2.drawRect(scale(710),scale(590),scale(30),scale(30));
		g2.drawRect(scale(740),scale(590),scale(30),scale(30));
		g2.drawRect(scale(770),scale(590),scale(30),scale(30));
		g2.drawRect(scale(800),scale(590),scale(30),scale(30));
		g2.drawRect(scale(650),scale(620),scale(30),scale(30));
		g2.drawRect(scale(680),scale(620),scale(30),scale(30));
		g2.drawRect(scale(710),scale(620),scale(30),scale(30));
		g2.drawRect(scale(740),scale(620),scale(30),scale(30));
		g2.drawRect(scale(770),scale(620),scale(30),scale(30));
		g2.drawRect(scale(800),scale(620),scale(30),scale(30));
		g2.drawRect(scale(170),scale(430),scale(30),scale(30));
		g2.drawRect(scale(200),scale(430),scale(30),scale(30));
		g2.drawRect(scale(230),scale(430),scale(30),scale(30));
		g2.drawRect(scale(260),scale(430),scale(30),scale(30));
		g2.drawRect(scale(290),scale(430),scale(30),scale(30));
		g2.drawRect(scale(320),scale(430),scale(30),scale(30));
		g2.drawRect(scale(170),scale(460),scale(30),scale(30));
		g2.drawRect(scale(200),scale(460),scale(30),scale(30));
		g2.drawRect(scale(230),scale(460),scale(30),scale(30));
		g2.drawRect(scale(260),scale(460),scale(30),scale(30));
		g2.drawRect(scale(290),scale(460),scale(30),scale(30));
		g2.drawRect(scale(320),scale(460),scale(30),scale(30));
		g2.drawRect(scale(650),scale(450),scale(30),scale(30));
		g2.drawRect(scale(680),scale(450),scale(30),scale(30));
		g2.drawRect(scale(710),scale(450),scale(30),scale(30));
		g2.drawRect(scale(740),scale(450),scale(30),scale(30));
		g2.drawRect(scale(770),scale(450),scale(30),scale(30));
		g2.drawRect(scale(800),scale(450),scale(30),scale(30));
		g2.drawRect(scale(650),scale(480),scale(30),scale(30));
		g2.drawRect(scale(680),scale(480),scale(30),scale(30));
		g2.drawRect(scale(710),scale(480),scale(30),scale(30));
		g2.drawRect(scale(740),scale(480),scale(30),scale(30));
		g2.drawRect(scale(770),scale(480),scale(30),scale(30));
		g2.drawRect(scale(800),scale(480),scale(30),scale(30));
		g2.drawRect(scale(170),scale(290),scale(30),scale(30));
		g2.drawRect(scale(200),scale(290),scale(30),scale(30));
		g2.drawRect(scale(230),scale(290),scale(30),scale(30));
		g2.drawRect(scale(260),scale(290),scale(30),scale(30));
		g2.drawRect(scale(290),scale(290),scale(30),scale(30));
		g2.drawRect(scale(320),scale(290),scale(30),scale(30));
		g2.drawRect(scale(170),scale(320),scale(30),scale(30));
		g2.drawRect(scale(200),scale(320),scale(30),scale(30));
		g2.drawRect(scale(230),scale(320),scale(30),scale(30));
		g2.drawRect(scale(260),scale(320),scale(30),scale(30));
		g2.drawRect(scale(290),scale(320),scale(30),scale(30));
		g2.drawRect(scale(320),scale(320),scale(30),scale(30));
		g2.drawRect(scale(650),scale(310),scale(30),scale(30));
		g2.drawRect(scale(680),scale(310),scale(30),scale(30));
		g2.drawRect(scale(710),scale(310),scale(30),scale(30));
		g2.drawRect(scale(740),scale(310),scale(30),scale(30));
		g2.drawRect(scale(770),scale(310),scale(30),scale(30));
		g2.drawRect(scale(800),scale(310),scale(30),scale(30));
		g2.drawRect(scale(650),scale(340),scale(30),scale(30));
		g2.drawRect(scale(680),scale(340),scale(30),scale(30));
		g2.drawRect(scale(710),scale(340),scale(30),scale(30));
		g2.drawRect(scale(740),scale(340),scale(30),scale(30));
		g2.drawRect(scale(770),scale(340),scale(30),scale(30));
		g2.drawRect(scale(800),scale(340),scale(30),scale(30));
		g2.drawRect(scale(170),scale(150),scale(30),scale(30));
		g2.drawRect(scale(200),scale(150),scale(30),scale(30));
		g2.drawRect(scale(230),scale(150),scale(30),scale(30));
		g2.drawRect(scale(260),scale(150),scale(30),scale(30));
		g2.drawRect(scale(290),scale(150),scale(30),scale(30));
		g2.drawRect(scale(320),scale(150),scale(30),scale(30));
		g2.drawRect(scale(170),scale(180),scale(30),scale(30));
		g2.drawRect(scale(200),scale(180),scale(30),scale(30));
		g2.drawRect(scale(230),scale(180),scale(30),scale(30));
		g2.drawRect(scale(260),scale(180),scale(30),scale(30));
		g2.drawRect(scale(290),scale(180),scale(30),scale(30));
		g2.drawRect(scale(320),scale(180),scale(30),scale(30));
		g2.drawRect(scale(650),scale(170),scale(30),scale(30));
		g2.drawRect(scale(680),scale(170),scale(30),scale(30));
		g2.drawRect(scale(710),scale(170),scale(30),scale(30));
		g2.drawRect(scale(740),scale(170),scale(30),scale(30));
		g2.drawRect(scale(770),scale(170),scale(30),scale(30));
		g2.drawRect(scale(800),scale(170),scale(30),scale(30));
		g2.drawRect(scale(650),scale(200),scale(30),scale(30));
		g2.drawRect(scale(680),scale(200),scale(30),scale(30));
		g2.drawRect(scale(710),scale(200),scale(30),scale(30));
		g2.drawRect(scale(740),scale(200),scale(30),scale(30));
		g2.drawRect(scale(770),scale(200),scale(30),scale(30));
		g2.drawRect(scale(800),scale(200),scale(30),scale(30));


	}
}
