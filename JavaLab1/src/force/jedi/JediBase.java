package force.jedi;

import force.forcebase.ForceUser;

abstract class JediBase extends ForceUser {

    int favouriteForm;


    public int getFavouriteForm() {
        return favouriteForm;
    }

    public void setFavouriteForm(int favouriteForm) {
        this.favouriteForm = favouriteForm;
    }

    abstract public void ForceHeal(ForceUser otherUser);
    abstract public void Meditate();

}
