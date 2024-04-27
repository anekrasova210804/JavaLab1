package force.jedi;
import force.forcebase.ForceUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JediKnight extends JediBase {

    public JediKnight(String _name, String _lightsaberColor, int _experience, ArrayList<String> _bodyParts)
    {
        this.name = _name;
        this.lightsaberColor = _lightsaberColor;
        this.experience = _experience;
        this.bodyParts = _bodyParts;
        this.favouriteForm =  ThreadLocalRandom.current().nextInt(1, 7);
    }

    public JediKnight(JediPadawan padawan)
    {
        System.out.println(padawan.getName() + " became a Knight! Congrats! " +padawan.getName() +
                " has cut off a Padawan braid!");
        this.name = padawan.getName();
        this.lightsaberColor = padawan.getLightsaberColor();
        this.experience = padawan.getExperience();
        this.bodyParts = padawan.getBodyParts();
        this.favouriteForm = padawan.getFavouriteForm();
    }

    @Override
    public void listenToTheForce() {
        if (this.name.equals("Anakin Skywalker"))
        {
            System.out.println("The Force said that its son is very handsome!");
        }
        else
        {System.out.println("The Force tells " + this.name + " to drink water!");}
    }

    @Override
    public void Fight(ForceUser otherUser) {
        System.out.println(this.name + " fought " + otherUser.getName() + " with Form " +
                this.favouriteForm +"!");
        otherUser.setHealth(Math.max(otherUser.getHealth() - 8 * this.experience, 0));
    }

    @Override
    public void ForceHeal(ForceUser otherUser) {
        System.out.println(this.name + " healed " + otherUser.getName() + "!");
        otherUser.setHealth(Math.min(otherUser.getHealth() + 8 * this.experience, 100));
    }

    @Override
    public void Meditate() {
        System.out.println(this.name + " spend a good time meditating!");
        this.experience += 3;
    }
}
