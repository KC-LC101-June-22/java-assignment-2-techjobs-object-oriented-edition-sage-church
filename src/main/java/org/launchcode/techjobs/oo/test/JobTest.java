package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {

        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Job job = new Job(
            "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {

        Job job1 = new Job(
                "Basketball Coach",
                new Employer("UM"),
                new Location("Moscow"),
                new PositionType("Coach"),
                new CoreCompetency("Thick skin")
        );

        Job job2 = new Job(
                "Basketball Coach",
                new Employer("UM"),
                new Location("Moscow"),
                new PositionType("Coach"),
                new CoreCompetency("Thick skin")
        );

        assertFalse(job1.equals(job2));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        Job job = new Job(
                "Basketball Coach",
                new Employer("UM"),
                new Location("Moscow"),
                new PositionType("Coach"),
                new CoreCompetency("Thick skin")
        );

        String toStringReturnValue = job.toString();
        char firstChar = toStringReturnValue.charAt(0);
        char lastChar = toStringReturnValue.charAt(toStringReturnValue.length() - 1);

        Assert.assertEquals('\n', firstChar);
        Assert.assertEquals('\n', lastChar);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job job = new Job(
                "Basketball Coach",
                new Employer("UM"),
                new Location("Moscow"),
                new PositionType("Coach"),
                new CoreCompetency("Thick skin")
        );

        String properString = "\nID: " + job.getId() + "\nName: Basketball Coach\nEmployer: UM\nLocation: Moscow\nPosition Type: Coach" +
                "\nCore Competency: Thick skin\n";

        assertEquals(properString, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job job = new Job(
                "Basketball Coach",
                new Employer("UM"),
                new Location("Moscow"),
                new PositionType(""),
                new CoreCompetency("Thick skin")
        );

        String properString = "\nID: " + job.getId() + "\nName: Basketball Coach\nEmployer: UM\nLocation: Moscow\nPosition Type: Data not available" +
                "\nCore Competency: Thick skin\n";

        assertEquals(properString, job.toString());
    }

}
