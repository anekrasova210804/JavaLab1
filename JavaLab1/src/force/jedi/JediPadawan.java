package force.jedi;
import force.forcebase.ForceUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JediPadawan extends JediBase {

    JediBase master;

    public JediPadawan(String _name, String _lightsaberColor, int _experience, ArrayList<String> _bodyParts)
    {
        this.name = _name;
        this.lightsaberColor = _lightsaberColor;
        this.experience = _experience;
        this.bodyParts = _bodyParts;
        this.master = null;
        this.favouriteForm = ThreadLocalRandom.current().nextInt(1, 7);
    }

    public JediPadawan(JediInitiate initiate)
    {
        if (initiate.getLightsaberColor().equals("NONE"))
        {
            System.out.println(initiate.getName() + " doesn't have a lightsaber so the emergency trip to" +
                    "Ilum has been conducted.");
            initiate.pickOutLightsaber();
        }
        System.out.println(initiate.getName() + " became a Padawan! Congrats! " +initiate.getName() +
                " now has a Padawan braid!");
        this.name = initiate.getName();
        this.lightsaberColor = initiate.getLightsaberColor();
        this.experience = initiate.getExperience();
        this.bodyParts = initiate.getBodyParts();
        this.favouriteForm = initiate.getFavouriteForm();
        this.master = null;
    }

    public void assignMaster(JediMaster _master)
    {
        this.master = _master;
    }

    public void assignMaster(JediKnight _master)
    {
        this.master = _master;
    }

    public void trainWithMaster()
    {
        if (this.master == null)
        {
            System.out.println(this.name + " doesn't have a Master to train with!");
        }
        else
        {System.out.println("Master " + this.master.getName() + " trains " + this.name);
        this.experience += 4;}
    }

    @Override
    public void listenToTheForce() {
        if (this.name.equals("Anakin Skywalker"))
        {
            System.out.println("The Force said that its son should get a better haircut.");
        }
        else
        {
            System.out.println("The Force wishes " + this.name + " a good day!");
        }
    }

    @Override
    public void Fight(ForceUser otherUser) {
        System.out.println(this.name + " decided to fight " + otherUser.getName() + " with Form " +
                this.favouriteForm +"!");
        otherUser.setHealth(Math.max(otherUser.getHealth() - 4 * this.experience, 0));
    }

    @Override
    public void ForceHeal(ForceUser otherUser) {
        System.out.println(this.name + " decided to heal " + otherUser.getName() + "!");
        otherUser.setHealth(Math.min(otherUser.getHealth() + 4 * this.experience, 100));
    }

    @Override
    public void Meditate() {
        System.out.println(this.name + " decided to meditate!");
        this.experience += 2;
    }
}
