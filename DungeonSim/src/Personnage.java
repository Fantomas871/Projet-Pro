public abstract class Personnage {
    protected int pv;
    protected int degat;
    protected int defence;
    //protected StatePersonnage etatPersonnage;

    protected perdreVid(int nb){
        this.pv -= nb;
    }




    //getter
    public int getPv() {
        return pv;
    }

    public int getDegat() {
        return degat;
    }

    public int getDefence() {
        return defence;
    }

    //setter
    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}