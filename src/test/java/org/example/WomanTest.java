package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WomanTest {

    private Woman woman;
    private Men menBrad;
    private Men menHugh;

    @BeforeMethod
    public void creatingWoman() {
        woman = new Woman("Angelina", "Jolie", 59);
    }

    public void creatingMenBrad() {
        menBrad = new Men("Brad", "Pitt", 40);
    }

    public void creatingMenHugh() {
        menHugh = new Men("Hugh", "Jackman", 42);
    }


    @Test
    public void newWomanHasNoPartner_test() {
        Assert.assertNull(woman.getPartner());
    }

    @Test
    public void lastNameEqualsMaidenName_test() {
        Assert.assertEquals(woman.getMaidenName(), "Jolie");
    }

    @Test
    public void getterSetterMaidenName_test() {
        woman.setMaidenName("Kris");
        Assert.assertEquals(woman.getMaidenName(), "Kris");
    }

    @Test
    public void getterSetterLastName_test() {
        woman.setLastName("Nancy");
        Assert.assertEquals(woman.getLastName(), "Nancy");
    }

    @Test
    public void isRetiredFalseTest() {
        Assert.assertFalse(woman.isRetired());
    }

    @Test
    public void isRetiredTrueTest() {
        woman.happyBirthday();
        Assert.assertTrue(woman.isRetired());
    }

    @Test
    public void RegisterPartnershipSuccess_test() {
        creatingMenBrad();
        woman.registerPartnership(menBrad);
        Assert.assertNotNull(woman.getPartner());
        Assert.assertEquals(woman.getPartner().getFirstName(), "Brad");
        Assert.assertEquals(woman.getPartner().getLastName(), "Pitt");
    }

    @Test
    public void changeLastNameAfterRegisterPartnershipTest() {
        creatingMenBrad();
        woman.registerPartnership(menBrad);
        Assert.assertEquals(woman.getLastName(), "Pitt");
    }

    @Test
    public void noChangeMaidenNameAfterMarriage_test() {
        creatingMenBrad();
        woman.registerPartnership(menBrad);
        Assert.assertEquals(woman.getMaidenName(), "Jolie");
    }

    @Test
    public void impossibilityToChangeHusbandWithoutDivorce_test() {
        creatingMenBrad();
        creatingMenHugh();
        woman.registerPartnership(menBrad);
        woman.registerPartnership(menHugh);
        Assert.assertEquals(woman.getPartner().getLastName(), "Pitt");
        Assert.assertEquals(woman.getPartner().getFirstName(), "Brad");
    }

    @Test
    public void impossibilityChangeLastNameWithoutDivorce_test() {
        creatingMenBrad();
        creatingMenHugh();
        woman.registerPartnership(menBrad);
        woman.registerPartnership(menHugh);
        Assert.assertEquals(woman.getLastName(), "Pitt");
    }

    @Test
    public void checkingThatPartnerIsChangeForMenAfterMarriageTest() {
        creatingMenBrad();
        woman.registerPartnership(menBrad);
        Assert.assertEquals(menBrad.getPartner().getFirstName(), "Angelina");
        Assert.assertEquals(menBrad.getPartner().getLastName(), "Pitt");
    }

    @Test
    public void setMaidenNameToWomanAfterDeregisterPartnership() {
        creatingMenBrad();
        woman.registerPartnership(menBrad);
        woman.deregisterPartnership();
        Assert.assertEquals(woman.getLastName(), "Jolie");
    }

    @Test
    public void checkPartnerIsNullAfterDeregisterPartnership_test() {
        creatingMenBrad();
        woman.registerPartnership(menBrad);
        woman.deregisterPartnership();
        Assert.assertNull(woman.getPartner());
        Assert.assertNull(menBrad.getPartner());
    }
    @Test
    public void introduce_test() {
      Assert.assertEquals(woman.introduce(), "Nice to meet you");
    }
    @Test
    public void introduceSuper_test() {
        Assert.assertEquals(woman.introduceSuper(), "Nice to meet you");
    }
}
