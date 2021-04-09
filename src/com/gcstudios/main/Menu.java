package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Menu {
	public String[] options = {"New Game", "Load", "Exit"};
	public int currentOption = 0;
	public int maxOption = options.length -1;
	public boolean up,down,enter;
	public boolean pause = false;
	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption <0)
				currentOption = maxOption;
		}
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption)
				currentOption = 0;
		}
		if(enter) {
			enter = false;
			if(options[currentOption] == "New Game"|| options[currentOption] == "Continue") {
				Game.gameState = "NORMAL";
				pause = false;
			}
			else if (options[currentOption] == "Exit") {
				System.exit(1);
			}
		}
	}
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD,36));
		g.drawString(">My Game<", (Game.WIDTH*Game.SCALE) /2-110, (Game.HEIGHT*Game.SCALE) /2-160);
		
		//Menu Options
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD,24));
		if (pause == false)
		g.drawString("New Game", (Game.WIDTH*Game.SCALE) /2- 50, 160);
		else 
			g.drawString("Resume", (Game.WIDTH*Game.SCALE) /2- 50, 160);
		
		g.drawString("Load", (Game.WIDTH*Game.SCALE) /2-50, 200);
		g.drawString("Exit", (Game.WIDTH*Game.SCALE) /2- 50, 240);
		if(options[currentOption] == "New Game") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) /2- 90, 160);
		}
		else if(options[currentOption] == "Load") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) /2-90, 200);
		}
		else if(options[currentOption] == "Exit") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) /2-90, 240);
		}
	}

}
