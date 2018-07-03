package logik;

import java.util.ArrayList;

public class Team {
    private ArrayList<Comtetitor> comtetitorArrayList = new ArrayList<Comtetitor>();

    public void addComprtitor(Comtetitor comtetitor) {
        this.comtetitorArrayList.add(comtetitor);
    }

    public ArrayList<Comtetitor> getComtetitorArrayList() {
        return comtetitorArrayList;
    }
}
