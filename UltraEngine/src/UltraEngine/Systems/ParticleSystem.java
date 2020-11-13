package UltraEngine.Systems;
import java.awt.Graphics2D;
import java.util.ArrayList;

import UltraEngine.Particles.Particle;

public class ParticleSystem {

	ArrayList<Particle> particles = new ArrayList<Particle>();
	
	public void update() {
		@SuppressWarnings("unchecked")
		ArrayList<Particle> guh = (ArrayList<Particle>) particles.clone();
		for(Particle p : guh) {
			p.update();
		}
	}
	
	public void draw(Graphics2D g) {
		@SuppressWarnings("unchecked")
		ArrayList<Particle> guh = (ArrayList<Particle>) particles.clone();
		for(Particle p : guh) {
			p.draw(g);
		}
	}
	
	public void addParticle(Particle p) {
		particles.add(p);
	}
	
}
