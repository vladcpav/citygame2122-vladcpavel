package levels;

import characters.Enemy;
import objects.Tree;
import powerups.Plant;
import scenes.Game;
import objects.Floor;
import org.jbox2d.common.Vec2;
import powerups.Ammo;
import powerups.Powerup;

import java.util.Random;

public class Level3 extends Level {

    public Level3(Game game) {

        super(game, "resources/backgrounds/background-sky.png");

        // PLayer positioning

        this.player.setPosition(new Vec2(0, 8));

        // Ground

        Floor ground = new Floor(this, 200, 12);
        ground.setPosition(new Vec2(0, 0));

        // Trees

        Random ran = new Random();

        for (int i = 0; i < 8; i++) {
            Tree tree = new Tree(this);
            tree.setPosition(new Vec2(ran.nextFloat(80) - 20, 12));
        }

        // Enemies

        for (int i = 0; i < 10; i++) {
            Enemy enemy = new Enemy(this);
            enemy.setPosition(new Vec2(ran.nextFloat(60) + 30, 8));
        }

        // Power up

        for (int i = 0; i < 3; i++) {
            int powerUpId = ran.nextInt(2);

            Powerup powerup;
            if (powerUpId == 0) {
                powerup = new Ammo(this);
            }
            else {
                powerup = new Plant(this);
            }

            powerup.setPosition(new Vec2(ran.nextFloat(40) + 40, 8));
        }

        // Setup portal

        this.portal.setPosition(new Vec2(100, 8));

    }
}
