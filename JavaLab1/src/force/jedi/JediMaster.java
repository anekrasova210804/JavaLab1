package force.jedi;
import force.forcebase.ForceUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JediMaster extends JediBase {

    String positionInOrder;

    public JediMaster(String _name, String _lightsaberColor, int _experience, ArrayList<String> _bodyParts)
    {
        this.name = _name;
        this.lightsaberColor = _lightsaberColor;
        this.experience = _experience;
        this.bodyParts = _bodyParts;
        this.favouriteForm = ThreadLocalRandom.current().nextInt(1, 7);
        String[] pos = {"Advisor", "Master of Order", "Temple Guard", "Investigator", "Consular",
                "Chief Librarian", "Seeker"};
        this.positionInOrder = pos[ThreadLocalRandom.current().nextInt(0, 6)];
    }

    public JediMaster(JediKnight knight)
    {
        System.out.println(knight.getName() + " became a Jedi Master! Congrats!");
        this.name = knight.getName();
        this.lightsaberColor = knight.getLightsaberColor();
        this.experience = knight.getExperience();
        this.bodyParts = knight.getBodyParts();
        this.favouriteForm = knight.getFavouriteForm();
        String[] pos = {"Advisor", "Master of Order", "Temple Guard", "Investigator", "Consular",
            "Chief Librarian", "Seeker"};
        this.positionInOrder = pos[ThreadLocalRandom.current().nextInt(0, 6)];
    }


    @Override
    public void listenToTheForce() {
        if (this.name.equals("Anakin Skywalker"))
        {
            System.out.println("The Force said that it's proud of its son for coming so far.");
        }
        else
        {System.out.println("The Force tells " + this.name + " to not forget to sleep sometimes!");}
    }

    @Override
    public void Fight(ForceUser otherUser) {
        System.out.println(this.name + " expertly fought " + otherUser.getName() + " with Form " +
                this.favouriteForm +"!");
        otherUser.setHealth(Math.max(otherUser.getHealth() - 16 * this.experience, 0));
    }

    @Override
    public void ForceHeal(ForceUser otherUser) {
        System.out.println(this.name + " expertly healed " + otherUser.getName() + "!");
        otherUser.setHealth(Math.min(otherUser.getHealth() + 16 * this.experience, 100));
    }

    @Override
    public void Meditate() {
        System.out.println(this.name + " enjoyed meditation!");
        this.experience += 4;
    }

    @Override
    public String toString()
    {
        return (this.name + " with " + this.experience + " experience and "
                + this.health + " health is a " + this.positionInOrder + "!");
    }
}
