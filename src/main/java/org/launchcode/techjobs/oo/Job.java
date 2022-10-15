package org.launchcode.techjobs.oo;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(
        String name,
        Employer employer,
        Location location,
        PositionType positionType,
        CoreCompetency coreCompetency
    ) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {


        String employer = this.employer.getValue();
        String location = this.location.getValue();
        String positionType = this.positionType.getValue();
        String coreCompetency = this.coreCompetency.getValue();

        if (employer.equals("")) {
            employer = "Data not available";
        }
        if (location.equals("")) {
            location = "Data not available";
        }
        if (positionType.equals("")) {
            positionType = "Data not available";
        }
        if (coreCompetency.equals("")) {
            coreCompetency = "Data not available";
        }

        return "\n" + "ID: " + id + "\n" + "Name: " + name + "\n" + "Employer: " + employer + "\n" + "Location: " +
                location + "\n" + "Position Type: " + positionType + "\n" + "Core Competency: " + coreCompetency + "\n";

    }

}
